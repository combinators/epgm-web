package dao
import com.google.gson.Gson
import com.microsoft.azure.documentdb.{Document, DocumentClient}
import constants.WHOConstants

import scala.collection.JavaConverters._
import dao.DBConfigFactory._
import model.entites.masterdata.MasterChildData
import services.GmrResourceUpdated



/**
  * Created by kirankumarbs on 14/2/17.
  */

trait   Database[T]{
  def dashboardData(filters: Option[Map[String, String]]= None): Either[List[String], Map[String, String]]
  def gmrData(code: String, dt: String): List[GmrResourceUpdated]
  def insertMasterChildData(mcd: MasterChildData): String
}

case class DocumentDB(client: DocumentClient) extends Database[DocumentDB] {
  override def dashboardData(filters: Option[Map[String, String]]= None): Either[List[String], Map[String, String]] = {

    def filterCondition(table: String) = filters.get.toList.map((f) => table+"."+f._1+" = \""+f._2+"\"").mkString(" and ")
    val query = s"SELECT * FROM tyrion where ${filterCondition("tyrion")}"

    val result = client.queryDocuments(s"dbs/$databaseId/colls/$collectionId",
      query,null)
      .getQueryIterable.asScala.toList match {
      case Nil => Left(List("No Weighment is Done For Month "+filters.get("currentmonth")))
      case xs => Right(xs.maxBy(d => (d.get("currentyear") + d.get("currentmonth").toString).toInt))
    }

    result match {
      case Left(l) => Left(l)
      case Right(r) => Right(r.getHashMap.asScala.map(x => (x._1,x._2.toString)).toMap)
    }
  }

  override def gmrData(code: String, dt: String): List[GmrResourceUpdated] = {
    val result = client.queryDocuments(s"dbs/$databaseId/colls/$collectionId",
      "SELECT * FROM tyrion where tyrion.doctype = \""+dt+"\" and  tyrion.aanganwadicode= \""+code+"\" order by tyrion.childcode asc",null)
      .getQueryIterable.asScala.toList

    val resultGroupedByChild =
      result.map(d =>
        GmrResourceUpdated(d.get("childcode").toString,
          d.get("name").toString,
          d.get("fathername").toString,
          d.get("sex").toString,
          d.get("dayofbirth").toString +"-"+d.get("monthofbirth").toString +"-"+d.get("yearofbirth").toString,
          d.get("category").toString,
          d.get("year").toString +d.get("month").toString +d.get("day").toString+d.get("hours").toString+d.get("minutes").toString,
          d.get("weight").toString,
          WHOConstants(d.get("whounderweight").toString)))

    resultGroupedByChild match {
      case Nil => List()
      case xs => xs
    }
  }

  override def insertMasterChildData(mcd: MasterChildData): String = {
    val entityJson: String = new Gson().toJson(mcd)
    val entityDocument: Document = new Document(entityJson)

    val dResource = client.createDocument(s"dbs/$databaseId/colls/$collectionId",
      entityDocument, null,false).getResource()

    "Master Child "+mcd.childcode+" is inserted into database"
  }
}

case class DocumentDBMock() extends Database[DocumentDBMock] {
  override def dashboardData(filters: Option[Map[String, String]]= None): Either[List[String], Map[String, String]] = {
    Right(Map("doctype" -> "dashboard",
      "code" -> "27",
      "totalcount" -> "10000",
      "suwcount" -> "2000",
      "muwcount" -> "4000",
      "normalcount" -> "4000",
      "malecount" -> "4700",
      "femalecount" -> "1300",
      "zerotoonecount" -> "400",
      "onetotwocount" -> "800",
      "twotothreecount" -> "1600",
      "threetofourcount" -> "1600",
      "fourtofivecount" -> "1200",
      "fivetosixcount" -> "1000",
      "januarycount" -> "1000",
      "februarycount" -> "600",
      "marchcount" -> "300",
      "aprilcount" -> "50",
      "maycount" -> "45",
      "junecount" -> "700",
      "julycount" -> "900",
      "augustcount" -> "950",
      "septembercount" -> "300",
      "octobercount" -> "400",
      "novembercount" -> "400",
      "decembercount" -> "355",
      "currentmonth" -> "02",
      "currentyear" -> "17"))  }

  override def gmrData(code: String, dt: String): List[GmrResourceUpdated] = List()

  override def insertMasterChildData(mcd: MasterChildData): String = "master child record is inserted"
}

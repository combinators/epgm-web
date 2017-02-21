package dao
import com.microsoft.azure.documentdb.DocumentClient
import scala.collection.JavaConverters._
import dao.DBConfigFactory._



/**
  * Created by kirankumarbs on 14/2/17.
  */

trait   Database[T]{
  def data(code: String, dt: String): Map[String, String]
  //def set(code: String, values: util.Map[String, String])
}

case class DocumentDB(client: DocumentClient) extends Database[DocumentDB] {
  override def data(code: String, dt: String): Map[String, String] = {
    println()
    val result = client.queryDocuments(s"dbs/$getDATABASE_ID/colls/$getCOLLECTION_ID",
      "SELECT * FROM tyrion where tyrion.doctype = \""+dt+"\" and tyrion.code = \""+code+"\"",null)
      .getQueryIterable.asScala
      result.head.getHashMap.asScala.map(x => (x._1,x._2.toString)).toMap

  }
}

case class DocumentDBMock() extends Database[DocumentDBMock] {
  override def data(code: String, dt: String): Map[String, String] = {
    Map("doctype" -> "dashboard",
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
      "currentyear" -> "17")  }

}

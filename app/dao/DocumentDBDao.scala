package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, Document, DocumentClient}
import services.{ConsolidatedStateResource, GmrResource}
import scala.collection.JavaConverters._

/**
  * Created by chocoklate on 5/2/17.
  */
class DocumentDBDao {

  val HOST = "https://epgm.documents.azure.com:443/";
  val MASTER_KEY = "JzmoDSMDC7BoTPzkA0QdeEyI4WJJSGDyaSH83n8yqckxkRRjHW8U8xJbJq7ivYEXaaGNzaIzvSUQg2tRZ06xfA==";
  val DATABASE_ID = "epgm-db"
  val COLLECTION_ID = "log_data"
  val documentClient = new DocumentClient(HOST,
    MASTER_KEY, ConnectionPolicy.GetDefault(),
    ConsistencyLevel.Session)

  def getConsolidatedStateLevel(stateCode: String):List[ConsolidatedStateResource] = {

    val weightGrouped  = documentClient.queryDocuments(
      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
      "SELECT * FROM myCollection where STARTSWITH(myCollection.aanganwadicode,\""+stateCode+"\")" +
        "and myCollection.whounderweight IN (\"0\",\"1\",\"2\",\"3\")",
      null).getQueryIterable().asScala.groupBy(w => w.get("whounderweight")).map(x => (x._1,x._2.size))

    ConsolidatedStateResource(
      weightGrouped.toList.map(x=>x._2).sum,
      weightGrouped.get("2").getOrElse(0),
      weightGrouped.get("1").getOrElse(0),
      weightGrouped.get("0").getOrElse(0)) :: Nil
  }

  def getGrowthMonitoringReport(aanganwadiCode:String):List[GmrResource] = {
    GmrResource(
      1,"GANESH", "A KHADE", "M", "08/24/2014","OBC",
      List("08/13/2016","07/08/2016","06/10/2016"),
      List(14.140,13.975,13.745), List("SUW","MUW","MUW"),List(0.759,1.025,1.045)) :: Nil
  }

}

object DbRun{
  def main(args: Array[String]): Unit = {
    println("==========="+new DocumentDBDao().getConsolidatedStateLevel("27"))
  }
}

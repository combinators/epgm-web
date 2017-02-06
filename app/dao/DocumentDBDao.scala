package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, Document, DocumentClient}
import services.{ConsolidatedStateResource, GmrResource}

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


    val total  = documentClient.queryDocuments(
      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
      "SELECT * FROM myCollection where STARTSWITH(myCollection.aanganwadicode,\""+stateCode+"\")",
      null).getQueryIterable().toList.size();

    val under  = documentClient.queryDocuments(
      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
      "SELECT * FROM myCollection where STARTSWITH(myCollection.aanganwadicode,\""+stateCode+"\")" +
        "and myCollection.whounderweight = \"2\"",
      null).getQueryIterable().toList.size();

    val moderate  = documentClient.queryDocuments(
      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
      "SELECT * FROM myCollection where STARTSWITH(myCollection.aanganwadicode,\""+stateCode+"\")" +
        "and myCollection.whounderweight = \"1\"",
      null).getQueryIterable().toList.size();

    val normal  = documentClient.queryDocuments(
      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
      "SELECT * FROM myCollection where STARTSWITH(myCollection.aanganwadicode,\""+stateCode+"\")" +
        "and myCollection.whounderweight = \"0\"",
      null).getQueryIterable().toList.size();


    ConsolidatedStateResource(total, under, moderate, normal) :: Nil
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
    println("==========="+new DocumentDBDao().getConsolidatedStateLevel("52"))
  }
}

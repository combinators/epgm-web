package dao

import dao.DBConfigFactory.documentClient
import dao.DBConfigFactory._

import scala.collection.JavaConverters._
/**
  * Created by kirankumarbs on 12/2/17.
  */
object WHOIndexData{

  def getAllStateData() = get(" ")
  def getSpecificStateData(sCode: String) = get(" STARTSWITH(myCollection.aanganwadicode,\""+sCode+"\") and ")

  private def get(s: String): Map[AnyRef, Int] = {
    documentClient.queryDocuments(
      "dbs/" + databaseId + "/colls/" + collectionId,
      "SELECT * FROM myCollection where"+s+
        "myCollection.whounderweight IN (\"0\",\"1\",\"2\",\"3\")",
      null).getQueryIterable().asScala.groupBy(w => w.get("whounderweight"))
      .map(x => (x._1,x._2.size))


  }

}


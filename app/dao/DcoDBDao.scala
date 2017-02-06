package dao


import com.google.gson.Gson
import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, Document, DocumentClient}
/**
  * Created by chocoklate on 6/2/17.
  */

case class SomePojo(childcode:String,weight:String,height:String,bmi:String,whounderweight:String,
                    iap:String,day:String,month:String,year:String,wasting:String,
                    stunting:String,minutes:String,hours:String,aanganwadicode:String)
object DcoDBDao {

  def main(args: Array[String]): Unit = {

    val HOST = "https://epgm.documents.azure.com:443/";
    val MASTER_KEY = "JzmoDSMDC7BoTPzkA0QdeEyI4WJJSGDyaSH83n8yqckxkRRjHW8U8xJbJq7ivYEXaaGNzaIzvSUQg2tRZ06xfA==";
    val DATABASE_ID = "epgm-db"
    val COLLECTION_ID = "log_data"

    val documentClient = new DocumentClient(HOST,
      MASTER_KEY, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)

    /* val results = documentClient.queryDocuments(
       "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
       "SELECT * FROM logdata WHERE myCollection.email = 'allen [at] contoso.com'",
       null).getQueryIterable().toList();*/

    var lisaPojo = SomePojo("010","015263","0168","0021","0",
      "0","12","01","17","1",
      "0","34","10","52005050307");
    var somePojoJson = new Gson().toJson(lisaPojo);
    var lisaDocument = new Document(somePojoJson);

//    var lisaD = documentClient.createDocument(
//      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, lisaDocument, null, false)
//      .getResource();
//    println("----------> "+lisaD)

              val results  = documentClient
                .queryDocuments(
                  "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
                  "SELECT * FROM myCollection",
                  null).getQueryIterable().toList;
//        println("----------> "+documentClient.getDatabaseAccount.getCollection("log_data").toString)

    var someDoc = documentClient.deleteDocument(results.get(0).getSelfLink,null)
    println("............"+someDoc)
    val results1  = documentClient
      .queryDocuments(
        "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
        "SELECT * FROM myCollection",
        null).getQueryIterable().toList;

    println("=============>"+results1)

  }

}
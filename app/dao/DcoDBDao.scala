
package dao


import com.google.gson.Gson
import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, Document, DocumentClient}
/**
  * Created by chocoklate on 6/2/17.
  */

case class SomePojo(childcode:String,weight:String,height:String,bmi:String,whounderweight:String,
                    iap:String,day:String,month:String,year:String,wasting:String,
                    stunting:String,hours:String,minutes:String,aanganwadicode:String)
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

//    var lisaPojo = SomePojo("29","11.77","0","3"," MUW"," NOR","8","2","2016","","","12","00","27509010101");
//    var somePojoJson = new Gson().toJson(lisaPojo);
//    var lisaDocument = new Document(somePojoJson);
//
//    var lisaD = documentClient.createDocument(
//      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, lisaDocument, null, false)
//      .getResource();
//    println("----------> "+lisaD)
//    lisaPojo = SomePojo("30","11.705","0","3"," MUW"," NOR","3","11","2015","","","12","00","27509010101");
//    somePojoJson = new Gson().toJson(lisaPojo);
//    lisaDocument = new Document(somePojoJson);
//    lisaD = documentClient.createDocument("dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, lisaDocument,null,false).getResource();
//    println("----------> "+lisaD)

              val results  = documentClient
                .queryDocuments(
                  "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
                  "SELECT * FROM myCollection where myCollection.whounderweight=\"   \"",
                  null).getQueryIterable().toList;
    println("----------------> results.size : "+ results.size)
//    println("----------------> results : "+ results)

    for(i <- 0 to results.size()-1){
      results.get(i).set("whounderweight","5")
      var results1 = documentClient.replaceDocument(results.get(i),null ).getResource
    }

    val results2  = documentClient
      .queryDocuments(
        "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
        "SELECT * FROM myCollection where myCollection.whounderweight=\"5\"",
        null).getQueryIterable().toList;

        println("----------> "+results2.size())


  }

}
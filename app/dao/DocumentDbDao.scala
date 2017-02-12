package dao

import com.google.gson.Gson
import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, Document, DocumentClient}
/**
  * Created by kirankumarbs on 5/2/17.
  */
object  DocumentDbDao {

  def main(args: Array[String]): Unit = {
     val HOST = "https://epgm.documents.azure.com:443/";
     val MASTER_KEY = "JzmoDSMDC7BoTPzkA0QdeEyI4WJJSGDyaSH83n8yqckxkRRjHW8U8xJbJq7ivYEXaaGNzaIzvSUQg2tRZ06xfA==";
     val DATABASE_ID = "epgm-db"
     val COLLECTION_ID = "aanganwadi"

    val documentClient = new DocumentClient(HOST,
      MASTER_KEY, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)

    /* val results = documentClient.queryDocuments(
       "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
       "SELECT * FROM logdata WHERE myCollection.email = 'allen [at] contoso.com'",
       null).getQueryIterable().toList();*/

    /*val lisaPojo = SomePojo("27","Maharashtra","27");
    val somePojoJson = new Gson().toJson(lisaPojo);
    val lisaDocument = new Document(somePojoJson);*/

    // Create the 2nd document.
//    val lisaD = documentClient.createDocument(
//      "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, lisaDocument, null, false)
//      .getResource();

//    val results  = documentClient
//      .queryDocuments(
//        "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
//        "SELECT * FROM myCollection",
//        null).getQueryIterable().toList();
//    println("----------> "+results)
//
//    for(a  <- 0 to results.size()-1 )
//    documentClient.deleteDocument(results.get(a).getSelfLink(), null);
//
//    val results1  = documentClient
//      .queryDocuments(
//        "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
//        "SELECT * FROM myCollection",
//        null).getQueryIterable().toList();
//    println("results1"+results1)


  }

}

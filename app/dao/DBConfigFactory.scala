package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, DocumentClient}

/**
  * Created by kirankumarbs on 12/2/17.
  */
object DBConfigFactory{
    def getHOST = "https://epgmdb.documents.azure.com:443/";
    //
    def masterKey = "TjNTMzB9lFaC6bIpu8kyTzrDGuQYjokMQhAVxEw9bAvoibuzCKnxW7RhYkBlWGkaq4b707Q63ldy0PIHhnyKng==";
    def databaseId = "thewall"
    def collectionId = "tyrion"
    def documentClient = new DocumentClient(getHOST,
      masterKey, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)
}

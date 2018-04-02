package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, DocumentClient}

/**
  * Created by kirankumarbs on 12/2/17.
  */
object DBConfigFactory{
    def getHOST = "https://epgm.documents.azure.com:443/";
    //
    def masterKey = "KY0qwksz9NUPbfHW2j7XdKmHn5cmR3Iu2dAQPYstWEdhcTxxNY9C08qcWGVQXmoO9nQRnxPnq7DAoY8Ep6XZiA==";
    def databaseId = "thewall"
    def collectionId = "tyrion"
    def documentClient = new DocumentClient(getHOST,
      masterKey, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)
}

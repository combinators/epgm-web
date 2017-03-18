package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, DocumentClient}

/**
  * Created by kirankumarbs on 12/2/17.
  */
object DBConfigFactory{
    def getHOST = "https://epgm.documents.azure.com:443/";
    //
    def getMASTER_KEY = "0r8CYYVlo87KvsDjCipWlZtEBXWa2u2qEQWjTtd1ab0B2psDKHO6sceXsFgxKWiTZ1nUObIBknN3u2WnrWE4ig==";
    def getDATABASE_ID = "thewall"
    def getCOLLECTION_ID = "tyrion"
    def getDocumentClient = new DocumentClient(getHOST,
      getMASTER_KEY, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)
}

package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, DocumentClient}

/**
  * Created by kirankumarbs on 12/2/17.
  */
object DBFactory{
    def getHOST = "";
    def getMASTER_KEY = "";
    def getDATABASE_ID = ""
    def getCOLLECTION_ID = ""
    def getDocumentClient = new DocumentClient(getHOST,
      getMASTER_KEY, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)
}

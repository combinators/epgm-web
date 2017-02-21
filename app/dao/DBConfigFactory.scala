package dao

import com.microsoft.azure.documentdb.{ConnectionPolicy, ConsistencyLevel, DocumentClient}

/**
  * Created by kirankumarbs on 12/2/17.
  */
object DBConfigFactory{
    def getHOST = "https://epgm.documents.azure.com:443/";
    def getMASTER_KEY = "SlhyMCNEuU55HklqqibVpNAqi58tN5ZcBjYznR2SLUxNOsjNaEH7JT3kLsaB6K9mRFMtTrl10bx3oJYm9DfsAA==";
    def getDATABASE_ID = "thewall"
    def getCOLLECTION_ID = "tyrion"
    def getDocumentClient = new DocumentClient(getHOST,
      getMASTER_KEY, ConnectionPolicy.GetDefault(),
      ConsistencyLevel.Session)
}

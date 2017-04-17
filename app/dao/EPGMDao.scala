package dao

import model.entites.masterdata.MasterChildData
import model.entites.masterdata.MasterChildData.Messages
import services.GmrResourceUpdated

/**
  * Created by kirankumarbs on 14/2/17.
  */

trait EPGMDaoInterface{

  def dashboardData(code: String, docType: String): Map[String, String]
  def gmrData(code: String, docType: String): List[GmrResourceUpdated]
  def insertMasterChildData(masterChildData: MasterChildData): String
}

object EPGMDaoInterface{
  type DB = DocumentDB
  def apply(): EPGMDaoInterface = EPGMDao[DB]()
}

private case class EPGMDao[T]()(implicit db: Database[T]) extends EPGMDaoInterface{
  def dashboardData(code: String, docType: String)   = db.dashboardData(code, docType)
  override def gmrData(code: String, docType: String): List[GmrResourceUpdated] = db.gmrData(code, docType)
  override def insertMasterChildData(masterChildData: MasterChildData): String = {
    db.insertMasterChildData(masterChildData)
  }
}

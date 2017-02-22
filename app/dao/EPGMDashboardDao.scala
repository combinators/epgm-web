package dao

import services.GmrResourceUpdated

/**
  * Created by kirankumarbs on 14/2/17.
  */

trait EPGMDaoInterface{
  def dashboardData: Map[String, String]
  def gmrData: List[GmrResourceUpdated]
}

object EPGMDaoInterface{
  type DB = DocumentDB
  def apply(code: String, docType: String): EPGMDaoInterface = EPGMDao[DB](code, docType)
}

private case class EPGMDao[T](code: String, docType: String)(implicit db: Database[T]) extends EPGMDaoInterface{
  def dashboardData   = db.dashboardData(code, docType)

  override def gmrData: List[GmrResourceUpdated] = db.gmrData(code, docType)
}

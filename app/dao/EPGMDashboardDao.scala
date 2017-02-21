package dao

/**
  * Created by kirankumarbs on 14/2/17.
  */

trait EPGMDashboardDaoInterface{
  def data: Map[String, String]
}

object EPGMDashboardDaoInterface{
  type DB = DocumentDB
  def apply(code: String, docType: String): EPGMDashboardDaoInterface = EPGMDashboardDao[DB](code, docType)
}

case class EPGMDashboardDao[T](code: String, docType: String)(implicit db: Database[T]) extends EPGMDashboardDaoInterface{
  def data   = db.data(code, docType)
}

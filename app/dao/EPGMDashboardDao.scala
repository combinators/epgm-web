package dao

/**
  * Created by kirankumarbs on 14/2/17.
  */

trait EPGMDashboardDaoInterface{
  def data: Map[String, String]
}

object EPGMDashboardDaoInterface{
  def apply(code: String): EPGMDashboardDaoInterface = EPGMDashboardDao[JedisDB](code)
}

case class EPGMDashboardDao[T](code: String)(implicit db: Database[T]) extends EPGMDashboardDaoInterface{
  def data   = db.data(code)
}

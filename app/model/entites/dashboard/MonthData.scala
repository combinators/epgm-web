package model.entites.dashboard

import dao.EPGMDashboardDaoInterface
import play.api.libs.json.Json

/**
  * Created by kirankumarbs on 17/2/17.
  */
/**
  * Month Wise Data from January to December. Data is sum of SUW + MUW
  */
case class MonthData(labels: List[String], datasets: List[Datasets])
object MonthData{
  def apply(sCode: String): MonthData =
  {
    val md = EPGMDashboardDaoInterface("monthwise"+sCode).data
    val mConst = Map("01" -> "Jan","02" -> "Feb","03" -> "Mar","04" -> "Apr","05" -> "May","06" -> "Jun","07" -> "Jul","08" -> "Aug","09" -> "Sep","10" -> "Oct",
      "11" -> "Nov","12" -> "Dec")
    val currDt = md.get("currentmonth").getOrElse("01")

    //val currYr = md.get("currentyear").get
    val mDataRaw = List("01" -> md.get("januarycount").get, "02" -> md.get("februarycount").get,"03" -> md.get("marchcount").get, "04" -> md.get("aprilcount").get,
      "05" -> md.get("maycount").get, "06" -> md.get("junecount").get, "07" -> md.get("julycount").get, "08" -> md.get("augustcount").get, "09" -> md.get("septembercount").get,
      "10" -> md.get("octobercount").get,"11" -> md.get("novembercount").get, "12" -> md.get("decembercount").get)

    def prepareMonthData(raw: List[(String, String)]): List[(String, String)] = {
      def loop(raw: List[(String, String)], acc: List[(String, String)]): List[(String, String)] = raw match {
        case (x, o)::xs if(x == currDt)      =>  {xs ++ acc ++ List((currDt, o))}
        case x::xs                =>  {loop(xs, acc ++ List(x))}
      }
      loop(raw,List[(String, String)]())
    }

    val combinedData = prepareMonthData(mDataRaw).unzip

    MonthData(combinedData._1.map(x => mConst.get(x).get),
      Datasets("rgba(151,187,205,0.5)", "rgba(151,187,205,1)", combinedData._2.map(_.toInt)) :: Nil)
  }

  def apply(md: MonthData) =
    Json.obj(
      "labels" -> md.labels,
      "datasets" -> Datasets(md.datasets))
}
case class Datasets(fillColor: String, strokeColor: String, data: List[Int])
object Datasets{
  def apply(ds: List[Datasets]) =
    ds.map(d => Json.obj("fillColor" -> d.fillColor, "strokeColor" -> d.strokeColor, "data" -> d.data))
}

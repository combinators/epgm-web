package model.entites.dashboard

import play.api.libs.json.Json

/**
  * Created by kirankumarbs on 17/2/17.
  */
/**
  * Month Wise Data from January to December. Data is sum of SUW + MUW
  */
case class MonthData(labels: List[String], datasets: List[Datasets])
object MonthData{
  def apply(md: Map[String, String]): MonthData =
  {

    val mConst = Map("01" -> "Jan","02" -> "Feb","03" -> "Mar","04" -> "Apr","05" -> "May","06" -> "Jun","07" -> "Jul","08" -> "Aug","09" -> "Sep","10" -> "Oct",
      "11" -> "Nov","12" -> "Dec")
    val currDt = md.get("currentmonth").getOrElse("01")

    val mDataRaw: List[(String, String)] = List("01" -> md.get("januarycount").getOrElse("0"), "02" -> md.get("februarycount").getOrElse("0"),"03" -> md.get("marchcount").getOrElse("0"), "04" -> md.get("aprilcount").getOrElse("0"),
      "05" -> md.get("maycount").getOrElse("0"), "06" -> md.get("junecount").getOrElse("0"), "07" -> md.get("julycount").getOrElse("0"), "08" -> md.get("augustcount").getOrElse("0"), "09" -> md.get("septembercount").getOrElse("0"),
      "10" -> md.get("octobercount").getOrElse("0"),"11" -> md.get("novembercount").getOrElse("0"), "12" -> md.get("decembercount").getOrElse("0"))

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

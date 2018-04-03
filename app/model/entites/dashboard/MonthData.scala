package model.entites.dashboard

import play.api.libs.json.Json

/**
  * Created by kirankumarbs on 17/2/17.
  */
/**
  * Month Wise Data from January to December. Data is sum of SUW + MUW
  */
case class MonthData(name: String, value: Int)
object MonthData{
  def apply(md: Map[String, String]): List[MonthData] =
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

    val combinedData = prepareMonthData(mDataRaw)

    combinedData.map(d => MonthData(mConst.get(d._1).get, d._2.toInt))


  }

  def apply(md: List[MonthData]) =
    md.map(m => Json.obj(
      "name" -> m.name,
      "value" -> m.value))
}

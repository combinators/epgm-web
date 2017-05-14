package model.entites.dashboard

import play.api.libs.json.Json

/**
  * Created by kirankumarbs on 14/5/17.
  */
case class LastModified(month: String, year: String){
  override def toString: String = month+", "+year
}

object LastModified{
  def apply(data: Map[String, String]): LastModified =
    LastModified(months(data("currentmonth").toInt), s"20${data("currentyear")}")

  private val months: Map[Int, String] = Map(
    1 -> "JANUARY",
    2 -> "FEBRUARY",
    3 -> "MARCH",
    4 -> "APRIL",
    5 -> "MAY",
    6 -> "JUNE",
    7 -> "JULY",
    8 -> "AUGUST",
    9 -> "SEPTEMBER",
    10 -> "OCTOBER",
    11 -> "NOVEMBER",
    12 -> "DECEMBER"
  )

}

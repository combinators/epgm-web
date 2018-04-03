package model.entites.dashboard

import play.api.libs.json.Json

/**
  * Age wise data. Ex:- 0-1 year, 1-2 years ... 5-6 years ..... 13-14years
  */

case class AgeData(name: String, value: Int)

object AgeData {
  def apply(ad: Map[String, String]): List[AgeData] =
    {
      println("check check check -- ", ad)
        AgeData("0Y-1Y", ad.get("zerotoonecount").getOrElse("0").toInt) ::
        AgeData("1Y-3Y", ad.get("onetotwocount").getOrElse("0").toInt + ad.get("twotothreecount").getOrElse("0").toInt) ::
        AgeData("3Y-5Y", ad.get("threetofourcount").getOrElse("0").toInt + ad.get("fourtofivecount").getOrElse("0").toInt) ::
        AgeData("5Y-6Y", ad.get("fivetosixcount").getOrElse("0").toInt) :: Nil
    }
  def apply(ads: List[AgeData]) = ads.map(ad => Json.obj("name" -> ad.name,"value" -> ad.value))
}
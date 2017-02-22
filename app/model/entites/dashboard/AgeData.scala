package model.entites.dashboard

import play.api.libs.json.Json

/**
  * Age wise data. Ex:- 0-1 year, 1-2 years ... 5-6 years ..... 13-14years
  */

case class AgeData(value: Int, color: String)

object AgeData {
  def apply(ad: Map[String, String]): List[AgeData] =
    {
        AgeData(ad.get("zerotoonecount").getOrElse("0").toInt,  "#a1887f") ::
        AgeData(ad.get("onetotwocount").getOrElse("0").toInt,   "#bb8fce") ::
        AgeData(ad.get("twotothreecount").getOrElse("0").toInt, "#ccd1d1") ::
        AgeData(ad.get("threetofourcount").getOrElse("0").toInt,"#f7dc6f") :: Nil
    }
  def apply(ads: List[AgeData]) = ads.map(ad => Json.obj("value" -> ad.value, "color" -> ad.color))
}
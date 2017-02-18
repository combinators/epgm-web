package model.entites.dashboard

import dao.EPGMDashboardDaoInterface
import play.api.libs.json.Json

/**
  * Age wise data. Ex:- 0-1 year, 1-2 years ... 5-6 years ..... 13-14years
  */

case class AgeData(value: Int, color: String)

object AgeData {
  def apply(sCode: String): List[AgeData] =
    {
      val ad = EPGMDashboardDaoInterface("agewise"+sCode).data

      AgeData(ad.get("zerotoonecount").getOrElse("0").toInt, "#ff3333") ::
        AgeData(ad.get("onetotwocount").getOrElse("0").toInt, "#ffaa00") ::
        AgeData(ad.get("twotothreecount").getOrElse("0").toInt, "#d2a679") ::
        AgeData(ad.get("threetofourcount").getOrElse("0").toInt, "#99ff33") ::
        AgeData(ad.get("fourtofivecount").getOrElse("0").toInt, "#8cd9b3") ::
        AgeData(ad.get("fivetosixcount").getOrElse("0").toInt, "#0080ff") ::  Nil
    }
  def apply(ads: List[AgeData]) = ads.map(ad => Json.obj("value" -> ad.value, "color" -> ad.color))
}
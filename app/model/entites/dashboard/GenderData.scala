package model.entites.dashboard

import dao.EPGMDaoInterface$
import play.api.libs.json.Json

/**
  * Count Based on Gender. Count is sum of SUW + MUW
  * Male and Female Count
  */
case class GenderData(value: Int, color: String)

object GenderData {
  def apply(gd: Map[String, String]): List[GenderData] = {
    //val gd = EPGMDashboardDaoInterface("genderwise"+sCode).data
    val male = gd.get("malecount").getOrElse("0").toInt
    val female = gd.get("femalecount").getOrElse("0").toInt
    GenderData(male, "#ccd1d1") :: GenderData(female, "#566573") :: Nil
  }
  def apply(gds: List[GenderData]) = gds.map(gd => Json.obj("value" -> gd.value, "color" -> gd.color))
}
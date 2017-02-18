package model.entites.dashboard

import dao.EPGMDashboardDaoInterface
import play.api.libs.json.Json

/**
  * Count Based on Gender. Count is sum of SUW + MUW
  * Male and Female Count
  */
case class GenderData(value: Int, color: String)

object GenderData {
  def apply(sCode: String): List[GenderData] = {
    val gd = EPGMDashboardDaoInterface("genderwise"+sCode).data
    val male = gd.get("malecount").getOrElse("0").toInt
    val female = gd.get("femalecount").getOrElse("0").toInt
    GenderData(male, "#9D9B7F") :: GenderData(female, "#4D5360") :: Nil
  }
  def apply(gds: List[GenderData]) = gds.map(gd => Json.obj("value" -> gd.value, "color" -> gd.color))
}
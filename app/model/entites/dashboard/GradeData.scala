package model.entites.dashboard

import dao.EPGMDaoInterface$
import play.api.libs.json.Json

/**
  * Count based on WHO underweight. Count is sum of SUW + MUW
  * Total Beneficiaries Weighed, Severely Underweight Beneficiaries, Moderately Underweight Beneficiaries, Normal Beneficiaries
  */
case class GradeData(total: Int, severe: Int, moderate: Int, normal: Int)

object GradeData {
  def apply(gd: Map[String, String]): GradeData = {
    //val gd = EPGMDashboardDaoInterface("gradewise"+code).data

    GradeData(gd.get("totalcount").getOrElse("0").toInt
      ,gd.get("suwcount").getOrElse("0").toInt
      ,gd.get("muwcount").getOrElse("0").toInt
      ,gd.get("normalcount").getOrElse("0").toInt
    )
  }
  def apply(gd: GradeData) = Json.obj("total"  -> gd.total, "severe"  -> gd.severe, "moderate"  -> gd.moderate, "normal"  -> gd.normal)
}
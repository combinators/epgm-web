package model.entites

import play.api.libs.json._

/**
  * Created by kirankumarbs on 13/2/17.
  */

/**
  * Dashboard Initial data in different forms like
  * Data Grade Wise
  * Data Gender wise
  * Data Age Wise
  * Data Month wise
  */
case class EPGMDashbordData(gradeData: GradeData,
                            genderData: List[GenderData],
                            ageData: List[AgeData],
                            monthData: MonthData
                           )
object EPGMDashbordData{
  def apply(sCode: String): EPGMDashbordData = EPGMDashbordData(GradeData(sCode), GenderData(sCode), AgeData(sCode), MonthData(sCode))

  implicit val epgmDashboardDataWrites = new Writes[EPGMDashbordData] {
    override def writes(epgmDD: EPGMDashbordData): JsValue = {
      Json.obj(
        "grade_data"  -> GradeData(epgmDD.gradeData),
        "gender_data"  -> GenderData(epgmDD.genderData),
        "age_data"  -> AgeData(epgmDD.ageData),
        "month_data"  -> MonthData(epgmDD.monthData)
      )
    }
  }
}

/**
  * Count based on WHO underweight. Count is sum of SUW + MUW
  * Total Beneficiaries Weighed, Severely Underweight Beneficiaries, Moderately Underweight Beneficiaries, Normal Beneficiaries
  */
case class GradeData(total: Int, severe: Int, moderate: Int, normal: Int)
object GradeData{
  def apply(sCode: String): GradeData = GradeData(100,25,25,50)
  def apply(gd: GradeData) = Json.obj("total"  -> gd.total, "severe"  -> gd.severe, "moderate"  -> gd.moderate, "normal"  -> gd.normal)
}

/**
  * Count Based on Gender. Count is sum of SUW + MUW
  * Male and Female Count
  */
case class GenderData(value: Int, color: String)
object GenderData{
  def apply(sCode: String): List[GenderData] = GenderData(30, "#9D9B7F") :: GenderData(120, "#4D5360") :: Nil
  def apply(gds: List[GenderData]) = gds.map(gd => Json.obj("value" -> gd.value, "color" -> gd.color))
}

/**
  * Month Wise Data from January to December. Data is sum of SUW + MUW
  */
case class MonthData(labels: List[String], datasets: List[Datasets])
object MonthData{
  def apply(sCode: String): MonthData =
    MonthData(List("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"),
      Datasets("rgba(151,187,205,0.5)", "rgba(151,187,205,1)", List(100,80,60,55,40,35,30,25,20,15,15,5)) :: Nil)
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
/**
  * Age wise data. Ex:- 0-1 year, 1-2 years ... 5-6 years ..... 13-14years
  */

case class AgeData(value: Int, color: String)
object AgeData{
  def apply(sCode: String): List[AgeData] =
    AgeData(10, "#ff3333") :: AgeData(40, "#ffaa00") :: AgeData(60, "#d2a679") :: AgeData(20, "#99ff33") :: AgeData(10, "#8cd9b3") ::
      AgeData(5, "#0080ff") ::  Nil
  def apply(ads: List[AgeData]) = ads.map(ad => Json.obj("value" -> ad.value, "color" -> ad.color))
}


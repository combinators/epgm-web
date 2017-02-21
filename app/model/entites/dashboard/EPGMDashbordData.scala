package model.entites.dashboard

import dao.EPGMDashboardDaoInterface
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
  def apply(sCode: String, docType: String): EPGMDashbordData ={
    val md = EPGMDashboardDaoInterface(sCode,docType).data
    println(md)
    EPGMDashbordData(GradeData(md), GenderData(md), AgeData(md), MonthData(md))

  }
  /**
    * Converting from Entity to Json while service returning response
    */
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












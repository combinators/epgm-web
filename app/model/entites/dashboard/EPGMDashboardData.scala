package model.entites.dashboard

import dao._
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
case class EPGMDashboardData(gradeData: GradeData,
                             genderData: List[GenderData],
                             ageData: List[AgeData],
                             monthData: MonthData,
                             lastModified: String
                           )


object EPGMDashboardData{
  def apply(filters: Option[Map[String, String]]=None): Either[List[String],EPGMDashboardData] ={
    EPGMDaoInterface().dashboardData(filters) match {
      case Left(l) => Left(l)
      case Right(r) => Right(createEpgmDashboardData(r))
    }
  }

private def createEpgmDashboardData(md: Map[String, String]): EPGMDashboardData =
    EPGMDashboardData(GradeData(md), GenderData(md), AgeData(md), MonthData(md),LastModified(md).toString)

  /**
    * Converting from Entity to Json while service returning response
    */
  implicit val epgmDashboardDataWrites = new Writes[EPGMDashboardData] {
    override def writes(epgmDD: EPGMDashboardData): JsValue = {
      Json.obj(
        "grade_data"  -> GradeData(epgmDD.gradeData),
        "gender_data"  -> GenderData(epgmDD.genderData),
        "age_data"  -> AgeData(epgmDD.ageData),
        "month_data"  -> MonthData(epgmDD.monthData),
        "lastmodified" -> epgmDD.lastModified
      )
    }
  }
}












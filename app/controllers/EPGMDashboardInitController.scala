package controllers

import model.ResourceRouter
import play.api.libs.json.Json
import play.api.mvc._

/**
  * Created by kirankumarbs on 14/2/17.
  */
class EPGMDashboardInitController extends Controller{

    def get(code: String, docType: String) = Action {
      val filters: Option[Map[String, String]]= Option(Map("code" -> code, "doctype" -> docType))
      response(code, docType, filters)
    }

  def getMonthSpecific(code: String, docType: String, currentmonth: String) = Action {
    val filters: Option[Map[String, String]]=
      Option(Map("code" -> code, "doctype" -> docType, "currentmonth" -> currentmonth))

    response(code, docType,filters)
  }

  private def response(code: String, docType: String, filters: Option[Map[String, String]]) = {
    ResourceRouter.epgmDashboardData(filters) match {
      case Left(l) => Ok(Json.toJson(l))
      case Right(r) => Ok(Json.toJson(r))
    }
  }



}

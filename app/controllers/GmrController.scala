package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.GmrHandler

/**
  * Created by kirankumarbs on 5/2/17.
  */
class GmrController extends Controller{

  def getGrowthMonitoringReport(code: String) = Action(Ok(Json.toJson(new GmrHandler().create)))

}

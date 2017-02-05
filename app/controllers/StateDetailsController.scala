package controllers

import javax.inject.Singleton

import play.api.libs.json.Json
import play.api.mvc._
import services.ConsolidatedStateLevelHandler



/**
  * Created by kirankumarbs on 3/2/17.
  */
@Singleton
class StateDetailsController extends Controller{

  def getStateData(sCode: String) = Action { Ok(Json.toJson(new ConsolidatedStateLevelHandler().create(sCode))) }

}

package controllers

import javax.inject.Singleton

import model.ResourceFactory
import play.api.libs.json.Json
import play.api.mvc._


/**
  * Created by kirankumarbs on 3/2/17.
  */
@Singleton
class StateDetailsController extends Controller{
  def getSpecificStateData(sCode: String) =
    Action { Ok(Json.toJson(ResourceFactory().getSpecificStateDetails(sCode))) }
  def getAllStatesData() =
    Action { Ok(Json.toJson(ResourceFactory().getAllStateDetails())) }
}

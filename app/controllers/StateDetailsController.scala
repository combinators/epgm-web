package controllers

import javax.inject.Singleton

import model.ResourceRouter
import play.api.libs.json.Json
import play.api.mvc._


/**
  * Created by kirankumarbs on 3/2/17.
  */
@Singleton
class StateDetailsController extends Controller {
  def getSpecificStateData(sCode: String, docType: String = "dashboard") = Action {
    ResourceRouter.getSpecificStateDetails(sCode, docType) match {
      case Left(l) => Ok(Json.toJson(l))
      case Right(r) => Ok(Json.toJson(r))
    }
  }

  def getAllStatesData() = Action {
    ResourceRouter.getAllStateDetails() match {
      case Left(l) => Ok(Json.toJson(l))
      case Right(r) => Ok(Json.toJson(r))
    }
  }
}

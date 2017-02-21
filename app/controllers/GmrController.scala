package controllers


import model.ResourceFactory
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by kirankumarbs on 5/2/17.
  */
class GmrController extends Controller{

  def getGMR(awCode: String) = Action(Ok(Json.toJson(ResourceFactory().getGMRDetails(awCode))))

}

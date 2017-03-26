package controllers

import model.ResourceFactory
import play.api.libs.json.Json
import play.api.mvc._

/**
  * Created by kirankumarbs on 14/2/17.
  */
class EPGMDashboardInitController extends Controller{


    def get(sCode: String,docType: String) = Action {
      Ok(Json.toJson(ResourceFactory().epgmDashboardData(sCode, docType)))
    }

}

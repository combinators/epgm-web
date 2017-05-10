package controllers


import javax.inject.Inject

import model.ResourceRouter
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by kirankumarbs on 5/2/17.
  */
class GmrController @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport{

  def getGMR(stateCode:String, awCode: String) = Action(Ok(Json.toJson(ResourceRouter.getGMRDetails(stateCode, awCode))))
  def getGMRUpdated(stateCode:String, awCode: String) = Action(Ok(Json.toJson(ResourceRouter.getGMRDetailsUpdated(stateCode, awCode))))

  def displayGMR =  Action {
    Ok(views.html.gmr("ICDS"))
  }

}

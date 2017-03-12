package controllers


import javax.inject.Inject

import model.ResourceFactory
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by kirankumarbs on 5/2/17.
  */
class GmrController @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport{

  def getGMR(awCode: String) = Action(Ok(Json.toJson(ResourceFactory().getGMRDetails(awCode))))
  def getGMRUpdated(awCode: String) = Action(Ok(Json.toJson(ResourceFactory().getGMRDetailsUpdated(awCode))))

  def displayGMR =  Action {
    Ok(views.html.gmr("ICDS"))
  }

}

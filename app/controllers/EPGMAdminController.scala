package controllers

import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

/**
  * Created by kirankumarbs on 15/4/17.
  */
class EPGMAdminController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def saveMasterChildData = Action { request =>
    Ok("ok")
  }


  def displayAdminPage = Action {
    Ok(views.html.admin("ICDS"))
  }

}

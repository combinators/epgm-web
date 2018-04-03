package controllers

import javax.inject.Inject

import dao.EPGMDaoInterface
import model.entites.masterdata.{MasterChildData, MasterChildRawData}
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import JsonToModelConverter._

/**
  * Created by kirankumarbs on 15/4/17.
  */
class EPGMAdminController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport{

  def saveMasterChildData = Action { request =>
/*    val json = request.body.asJson.get
    println("====############"+json)
    val masterChildRawData: JsResult[MasterChildRawData] = json.validate[MasterChildRawData]
    val masterChildData: Either[List[String],MasterChildData] = MasterChildData(masterChildRawData.get)
    val result: List[String] = masterChildData match {
      case Left(msgs) => msgs
      case Right(mcd) => List(EPGMDaoInterface().insertMasterChildData(mcd))
    }*/
    Ok("ok")
  }


  def displayAdminPage = Action{
    Ok(views.html.admin("ICDS"))
  }

}

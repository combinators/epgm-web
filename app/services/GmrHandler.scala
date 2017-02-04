package services

import play.api.libs.json.{JsValue, Json, Writes}

/**
  * Created by kirankumarbs on 5/2/17.
  */

case class GmrResource
  (code:Int,
   name:String,
   surname:String,
   gender:String,
   dob:String,
   cclass:String,
   logDates:List[String],
   weights:List[Double],
   whoGrades:List[String],
   weightsToBeAdded:List[Double]
  )

object GmrResource {

  implicit val implicitWrites = new Writes[GmrResource] {
    override def writes(gmr: GmrResource): JsValue = {
      Json.obj(
      "code" -> gmr.code,
      "name" -> gmr.name,
      "surname" -> gmr.surname,
      "gender" -> gmr.gender,
      "dob" -> gmr.dob,
      "class" -> gmr.cclass,
      "logDates" -> gmr.logDates,
      "weights" ->  gmr.weights,
      "whoGrades" ->  gmr.whoGrades,
      "weightsToBeAdded" ->  gmr.weightsToBeAdded)
    }
  }

}

class GmrHandler {

  def create: List[GmrResource] = {
    createGmrResource()
  }

  private def createGmrResource(): List[GmrResource] = {
    GmrResource(
      1,"GANESH", "A KHADE", "M", "08/24/2014","OBC",
      List("08/13/2016","07/08/2016","06/10/2016"),
      List(14.140,13.975,13.745), List("SUW","MUW","MUW"),List(0.759,1.025,1.045)) :: Nil
  }
}

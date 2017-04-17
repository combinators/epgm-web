package services

import constants.WHOConstants
import dao._
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
   whoGrades:List[WHOConstants.WHO]
  )

case class GmrResourceData(data: List[GmrResourceUpdated])

object GmrResourceData{
  implicit val implicitWritesGMRData = new Writes[GmrResourceData] {
    override def writes(gmr: GmrResourceData): JsValue = {
      Json.obj(
        "data" -> GmrResourceUpdated(gmr.data))
    }
  }
}

case class GmrResourceUpdated
(code:String,
 name:String,
 surname:String,
 gender:String,
 dob:String,
 cclass:String,
 logDates:String,
 weights:String,
 whoGrades: WHOConstants.WHO
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
      "whoGrades" ->  gmr.whoGrades.map(w => w.toString))
    }
  }

}

object GmrResourceUpdated {

  def apply(data: List[GmrResourceUpdated]) = data.map(gmr => Json.obj(
    "code" -> gmr.code,
    "name" -> gmr.name,
    "surname" -> gmr.surname,
    "gender" -> gmr.gender,
    "dob" -> gmr.dob,
    "class" -> gmr.cclass,
    "logDates" -> gmr.logDates,
    "weights" ->  gmr.weights,
    "whoGrades" ->  gmr.whoGrades.toString))


  implicit val implicitWritesGMRUpdated = new Writes[GmrResourceUpdated] {
    override def writes(gmr: GmrResourceUpdated): JsValue = {
      Json.obj(
        "code" -> gmr.code,
        "name" -> gmr.name,
        "surname" -> gmr.surname,
        "gender" -> gmr.gender,
        "dob" -> gmr.dob,
        "class" -> gmr.cclass,
        "logDates" -> gmr.logDates,
        "weights" ->  gmr.weights,
        "whoGrades" ->  gmr.whoGrades.toString)
    }
  }
}

class GmrHandler {

  def create(awCode: String): List[GmrResource] = {
    createGmrResource(awCode)
  }

  def createGMR(awCode: String): GmrResourceData = {
    GmrResourceData(createGmrResourceUpdated(awCode))
  }

  private def createGmrResourceUpdated(awCode: String): List[GmrResourceUpdated] = {
    val gmrData = EPGMDaoInterface().gmrData(awCode, "log")
    gmrDataarrangedByWHO(gmrData)
      .map(g =>
        GmrResourceUpdated(
          g.code,
          g.name,
          g.surname,
          g.gender,
          g.dob,
          g.cclass,
          g.logDates.substring(4,6)+"-"+g.logDates.substring(2,4)+"-"+g.logDates.substring(0,2)
            +" "+g.logDates.substring(6,8)+":"+g.logDates.substring(8,10)+":00",
          (g.weights.toFloat / 1000).toString,
          g.whoGrades
        ))

  }

  private def gmrDataarrangedByWHO(data: List[GmrResourceUpdated]) = {
      val gmrSorted = data.groupBy(g => g.code).map(lg => (lg._1,lg._2.sortWith((g1, g2) => g1.logDates.toInt > g2.logDates.toInt))).toList

      def prepare(data: List[(String, List[GmrResourceUpdated])], acc: List[GmrResourceUpdated]): List[GmrResourceUpdated] = data match {
        case Nil => acc
        case x::xs if(x._2.head.whoGrades.toInt > 0) => prepare(xs, acc ++ x._2.take(4))
        case x::xs => prepare(xs, acc ++ x._2.take(1))
      }

    prepare(gmrSorted, List[GmrResourceUpdated]())

  }

  private def getGmeResourceUpdatedMock() = {
    /*
    GmrResourceUpdated(
      1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
      "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") ::
      GmrResourceUpdated(
        1,"GANESH", "A KHADE", "M", "08/24/2014","OBC", "06/10/2016",
        "13.745", "MUW","1.045") :: Nil
*/
  }

  private def createGmrResource(awCode: String): List[GmrResource] = {

    /*GmrResource(
      1,"GANESH", "A KHADE", "M", "08/24/2014","OBC",
      List("08/13/2016","07/08/2016","06/10/2016"),
      List(14.140,13.975,13.745), List("SUW","MUW","MUW")) :: Nil*/

    val gmrData = createGmrResourceUpdated(awCode)

    gmrData.groupBy(g => g.code).map(gu =>
      GmrResource(
        gu._2.head.code.toInt,
        gu._2.head.name,
        gu._2.head.surname,
        gu._2.head.gender,
        gu._2.head.dob,
        gu._2.head.cclass,
        gu._2.map(gr => gr.logDates),
        gu._2.map(gr => gr.weights.toDouble),
        gu._2.map(gr => gr.whoGrades)
      )
    ).toList

  }
}

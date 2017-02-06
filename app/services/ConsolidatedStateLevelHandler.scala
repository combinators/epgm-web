package services

import javax.inject.Inject

import dao.DocumentDBDao
import play.api.libs.json._

/**
  * Created by kirankumarbs on 5/2/17.
  */

/**
  * DTO for displaying Consolidated State Level Information
  */
case class ConsolidatedStateResource
  (beneficieriesWeighed:Long,
   severlyUnderWeightBenefeciaries:Long,
   moderatelyUnderWeightBenefeciaries:Long,
   normalBenefeciaries:Long)

object ConsolidatedStateResource{
  /**
    * Mapping to write a PostResource out as a JSON value.
    */
  implicit val implicitWrites = new Writes[ConsolidatedStateResource] {
    override def writes(csr: ConsolidatedStateResource): JsValue = {
      Json.obj(
        "totalBenefeciariesWeighed" -> csr.beneficieriesWeighed,
        "numberOfSeverlyUnderWeightBenefeciaries" -> csr.severlyUnderWeightBenefeciaries,
        "numberOfModeratelyUnderWeightBenefeciaries" -> csr.moderatelyUnderWeightBenefeciaries,
        "numberOfNormalBenefeciaries" -> csr.normalBenefeciaries
      )
    }
  }
}

class ConsolidatedStateLevelHandler () {

  def create(sCode: String): List[ConsolidatedStateResource] = {
    createConsolidatedStateResource(sCode)
  }

  private def createConsolidatedStateResource(sCode: String): List[ConsolidatedStateResource] = {
    new DocumentDBDao().getConsolidatedStateLevel(sCode)
  }

}

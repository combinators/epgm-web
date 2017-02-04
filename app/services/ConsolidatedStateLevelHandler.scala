package services

import javax.inject.Inject

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

  def create: List[ConsolidatedStateResource] = {
    createConsolidatedStateResource()
  }

  private def createConsolidatedStateResource(): List[ConsolidatedStateResource] = {
    ConsolidatedStateResource(150000, 30000, 45000, 75000) :: Nil
  }

}

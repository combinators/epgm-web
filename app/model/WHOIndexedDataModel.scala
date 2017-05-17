package model

import dao.DocumentDBDao
import model.entites.ConsolidatedStateResource
import model.entites.dashboard.EPGMDashboardData


/**
  * Created by kirankumarbs on 5/2/17.
  */





class WHOIndexedDataModel() {

  def create(sCode: Option[String], docType: String): Either[List[String],List[ConsolidatedStateResource]] =
    createConsolidatedStateResource(sCode, docType)

  private def createConsolidatedStateResource(sCode: Option[String], docType: String): Either[List[String],List[ConsolidatedStateResource]] = {

    val ePGMDashboardInitData =
      EPGMDashboardData(Option(Map("code" -> sCode.get, "doctype" -> docType)))

    ePGMDashboardInitData match {
      case Left(l) => Left(l)
      case Right(r) => Right(createConsolidatedResource(r))
    }
  }

  def createConsolidatedResource(ePGMDashboardInitData: EPGMDashboardData) = {
    val gd = ePGMDashboardInitData.gradeData
    val lastModified = ePGMDashboardInitData.lastModified

    ConsolidatedStateResource(
      gd.total,
      gd.severe,
      gd.moderate,
      gd.normal,
      lastModified) :: Nil
  }

}

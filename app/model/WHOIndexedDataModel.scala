package model

import dao.DocumentDBDao
import model.entites.ConsolidatedStateResource
import model.entites.dashboard.EPGMDashbordData


/**
  * Created by kirankumarbs on 5/2/17.
  */





class WHOIndexedDataModel() {

  def create(sCode: Option[String], docType: String): List[ConsolidatedStateResource] =
    createConsolidatedStateResource(sCode, docType)

  private def createConsolidatedStateResource(sCode: Option[String], docType: String): List[ConsolidatedStateResource] = {

    val ePGMDashboardInitData = EPGMDashbordData(sCode.get, docType)
    val gd = ePGMDashboardInitData.gradeData

    ConsolidatedStateResource(
      gd.total,
      gd.severe,
      gd.moderate,
      gd.normal) :: Nil

    //ConsolidatedStateResource(100,0,0,100) :: Nil
  }

}

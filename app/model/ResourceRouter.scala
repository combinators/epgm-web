package model

import dao.EPGMDaoInterface
import model.entites.ConsolidatedStateResource
import model.entites.dashboard.EPGMDashboardData
import model.entites.masterdata.MasterChildData
import services.{GmrHandler, GmrResource, GmrResourceData, GmrResourceUpdated}


/**
  * Created by kirankumarbs on 11/2/17.
  */

case object ResourceRouter {

  def epgmDashboardData(filters: Option[Map[String, String]]=None): Either[List[String], EPGMDashboardData] =
    EPGMDashboardData(filters)


  def getSpecificStateDetails(sCode: String, docType: String): Either[List[String], ConsolidatedStateResource]  = {
    new WHOIndexedDataModel().create(Some(sCode), docType) match {
      case Left(l) => Left(l)
      case Right(r) => Right(r.head)
    }
  }
  def getAllStateDetails(): Either[List[String], List[ConsolidatedStateResource]]  = {
    new WHOIndexedDataModel().create(None,"dashboard")
  }

  def getGMRDetailsUpdated(awCode: String):GmrResourceData = new GmrHandler().createGMR(awCode)
  def getGMRDetails(awCode: String):List[GmrResource] = new GmrHandler().create(awCode)


  def insertAdminDataIntoDB(masterChildData: MasterChildData) = EPGMDaoInterface().insertMasterChildData(masterChildData)
}

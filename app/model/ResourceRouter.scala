package model

import dao.EPGMDaoInterface
import model.entites.ConsolidatedStateResource
import model.entites.dashboard.EPGMDashbordData
import model.entites.masterdata.MasterChildData
import services.{GmrHandler, GmrResource, GmrResourceData, GmrResourceUpdated}


/**
  * Created by kirankumarbs on 11/2/17.
  */

case object ResourceRouter {

  def epgmDashboardData(sCode: String, docType: String): EPGMDashbordData = EPGMDashbordData(sCode, docType)


  def getSpecificStateDetails(sCode: String, docType: String):ConsolidatedStateResource  = {
    new WHOIndexedDataModel().create(Some(sCode), docType).head
  }
  def getAllStateDetails():ConsolidatedStateResource  = {
    new WHOIndexedDataModel().create(None,"dashboard").head
  }

  def getGMRDetailsUpdated(awCode: String):GmrResourceData = new GmrHandler().createGMR(awCode)
  def getGMRDetails(awCode: String):List[GmrResource] = new GmrHandler().create(awCode)


  def insertAdminDataIntoDB(masterChildData: MasterChildData) = EPGMDaoInterface().insertMasterChildData(masterChildData)
}

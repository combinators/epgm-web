package model

import model.entites.ConsolidatedStateResource
import model.entites.dashboard.EPGMDashbordData
import services._

/**
  * Created by kirankumarbs on 11/2/17.
  */

case class ResourceFactory() {
  def epgmDashboardData(sCode: String): EPGMDashbordData = EPGMDashbordData(sCode)


  def getSpecificStateDetails(sCode: String):ConsolidatedStateResource  = {
    new WHOIndexedDataModel().create(Some(sCode)).head
  }
  def getAllStateDetails():ConsolidatedStateResource  = {
    new WHOIndexedDataModel().create(None).head
  }

  def getGMRDetails(awCode: String):List[GmrResource] = new GmrHandler().create(awCode)


}

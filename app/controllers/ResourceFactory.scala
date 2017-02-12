package controllers

import services._

/**
  * Created by kirankumarbs on 11/2/17.
  */

case class ResourceFactory() {

  def getConsolidatedStateDetails(sCode: String):ConsolidatedStateResource  = {
    new ConsolidatedStateLevelHandler().create(sCode).head
  }

}

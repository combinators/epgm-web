package com.combinators.epgmweb.controller

import controllers.EPGMDashboardInitController
import org.junit.Test

/**
  * Created by kirankumarbs on 15/2/17.
  */
class EPGMDashboardInitControllerTest {

  @Test
  def itShouldGetEPGMDashboardInitData(): Unit ={
    println(new EPGMDashboardInitController().get("27"))
  }

}

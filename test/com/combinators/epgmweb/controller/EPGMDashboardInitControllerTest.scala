package com.combinators.epgmweb.controller

import controllers.EPGMDashboardInitController
import org.junit.Test
import org.scalatest.Matchers._
import play.api.mvc.{Action, AnyContent}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by kirankumarbs on 15/2/17.
  */
class EPGMDashboardInitControllerTest{

  @Test
  def itShouldGetEPGMDashboardInitData(): Unit ={
    //given
    //when
    val result: Action[AnyContent] = new EPGMDashboardInitController().get("27","dashboard")
    //result.parser.validate(_.)
    //then

  }

}

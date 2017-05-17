package com.combinators.epgmweb.controller

import controllers.{EPGMAdminController, EPGMDashboardInitController}
import model.entites.dashboard.EPGMDashboardData
import org.junit.Test
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import play.api.i18n.MessagesApi
import play.api.mvc.{Action, AnyContent, Result}
import org.scalatest.Matchers._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

/**
  * Created by kirankumarbs on 15/2/17.
  */
class EPGMDashboardInitControllerTest {

  @Test
  def itShouldGetEPGMDashboardInitData(): Unit ={
    //given
    //when
    val result = new EPGMDashboardInitController().get("27","dashboard")
    //result.parser.validate(_.)
    //then

  }

  @Test
  def itShouldGiveDashboardDataForSpecificMonth(): Unit ={
    //given
    val request = FakeRequest(POST,"/epgm/dashboard/27")
    //when
    val result: Future[Result] =
      new EPGMDashboardInitController().getMonthSpecific("27","dashboard", "02").apply(request)
    //then
    println(contentAsJson(result))
    result.foreach(r => {
      r.header.status shouldEqual(200)
    })

  }

}

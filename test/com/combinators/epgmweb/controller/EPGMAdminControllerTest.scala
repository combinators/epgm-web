package com.combinators.epgmweb.controller

import controllers.EPGMAdminController
import org.junit.{Ignore, Test}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import play.api.i18n.MessagesApi
import play.api.mvc.Result
import org.scalatest.Matchers._

import scala.concurrent.Future

/**
  * Created by kirankumarbs on 15/4/17.
  */

class EPGMAdminControllerTest {

  @Ignore
  @Test
  def testSaveMasterChildData(): Unit ={
    //given
    val app = new GuiceApplicationBuilder()
    val messagesApi = app.injector().instanceOf[MessagesApi]
    val requestJson = """{"aanganwadiCode":"27511010507", "code":"105", "dob":"010417","gender":"M","name":"OMPRAKASH","father":"KALYANKAR"}"""
    val request = FakeRequest(POST,"/epgm/admin/childrecord").withJsonBody(Json.parse(requestJson))
    val expected = "Master Child 105 is inserted into database"
    //when
    val result: Future[Result] = new EPGMAdminController(messagesApi).saveMasterChildData.apply(request)
    //then
    contentAsJson(result).validate[List[String]].get.contains(expected) should equal(true)
  }

}

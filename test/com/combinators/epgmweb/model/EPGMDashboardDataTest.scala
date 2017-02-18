package com.combinators.epgmweb.model

import model.entites._
import model.entites.dashboard._
import org.junit.Test
import org.scalatest.Matchers._

/**
  * Created by kirankumarbs on 14/2/17.
  */
class EPGMDashboardDataTest {

  @Test
  def itShouldGiveGradeDataForState(): Unit ={
    //given
    val sCode = "27"
    /*val expected =
      EPGMDashbordData(GradeData(100,20,20,60),List(GenderData(30,"#9D9B7F"),
      GenderData(120,"#4D5360")),List(AgeData(10,"#ff3333"), AgeData(40,"#ffaa00"), AgeData(60,"#d2a679"),
      AgeData(20,"#99ff33"), AgeData(10,"#8cd9b3"), AgeData(5,"#0080ff")),
      MonthData(List("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"),
        List(Datasets("rgba(151,187,205,0.5)",
          "rgba(151,187,205,1)",List(100, 80, 60, 55, 40, 35, 30, 25, 20, 15, 15, 5)))))*/
    //when
    val actual = EPGMDashbordData(sCode)
    println(actual)
    //then
    //actual shouldBe expected
  }

  @Test
  def itShouldGiveGradeDataForState1(): Unit ={
    //given
    val sCode = "27"
    val expected = GradeData(101,20,21,60)
    //when
    val actual = GradeData(sCode)
    //then
    actual shouldBe expected
  }
  @Test
  def itShouldGiveMonthDataForState(): Unit ={
    //given
    val sCode = "27"
    //val expected =
    //when
    val actual = MonthData(sCode)
    println(actual)
    //then
    //actual shouldBe expected
  }

  @Test
  def itShouldGiveAgeDataForState(): Unit ={
    //given
    val sCode = "27"
    //val expected =
    //when
    val actual = AgeData(sCode)
    println(actual)
    //then
    //actual shouldBe expected
  }

  @Test
  def itShouldGiveGenderDataForState(): Unit ={
    //given
    val sCode = "27"
    //val expected =
    //when
    val actual = GenderData(sCode)
    println(actual)
    //then
    //actual shouldBe expected
  }
}

package dao

import java.util

import redis.clients.jedis.Jedis

import scala.collection.JavaConverters._

/**
  * Created by kirankumarbs on 14/2/17.
  */

trait Database[T]{
  def data(code: String): Map[String, String]
  def set(code: String, values: util.Map[String, String])
}


case class JedisDB(client: Jedis) extends Database[JedisDB] {
  override def data(code: String): Map[String, String] = {
    val result = client.hgetAll(code).asScala.toMap

    result
  }
  override def set(code: String, values: util.Map[String, String]): Unit = client.hmset(code, values)
}



case class JedisDBMock() extends Database[JedisDBMock] {
  private var db: Map[String, util.Map[String, String]] = Map[String, util.Map[String, String]]()

  override def data(code: String): Map[String, String] = code match {
    case "gradewise27"  => Map("suwcount" -> "20", "muwcount" -> "20", "normalcount" -> "60", "totalcount" -> "100")
    case "gradewise52"  => Map("suwcount" -> "15", "muwcount" -> "35", "normalcount" -> "30", "totalcount" -> "80")
    case "genderwise27" => Map("malecount" -> "64", "femalecount" -> "36")
    case "genderwise52" => Map("malecount" -> "24", "femalecount" -> "36")
    case "agewise27"    => Map("zerotoonecount" -> "12", "onetotwocount" -> "14","twotothreecount" -> "08", "threetofourcount" -> "22",
                                "fourtofivecount" -> "27", "fivetosixcount" -> "5")
    case "agewise52"    => Map("zerotoonecount" -> "4", "onetotwocount" -> "12","twotothreecount" -> "6", "threetofourcount" -> "16",
                                "fourtofivecount" -> "13", "fivetosixcount" -> "50")
    case "monthwise27"  => Map("januarycount" -> "11", "februarycount" -> "22","marchcount" -> "33", "aprilcount" -> "44",
                              "maycount" -> "55", "junecount" -> "44", "julycount" -> "33", "augustcount" -> "22", "septembercount" -> "11", "octobercount" -> "7",
                               "novembercount" -> "5", "decembercount" -> "1", "currentmonth" -> "02", "currentyear" -> "2016")
    case "monthwise52"  => Map("januarycount" -> "20", "februarycount" -> "20","marchcount" -> "60", "aprilcount" -> "100",
                             "maycount" -> "20", "junecount" -> "20", "julycount" -> "60", "augustcount" -> "60", "septembercount" -> "100", "octobercount" -> "20",
                              "novembercount" -> "50", "decembercount" -> "50", "currentmonth" -> "02", "currentyear" -> "2016")
  }
  override def set(code: String, values: util.Map[String, String]): Unit = db = db.updated(code, values)
}

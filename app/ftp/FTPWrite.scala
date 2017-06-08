package ftp

import java.net.InetAddress

import akka.stream.IOResult
import akka.stream.alpakka.ftp.FtpCredentials.AnonFtpCredentials
import akka.stream.alpakka.ftp.RemoteFileSettings._
import akka.stream.alpakka.ftp.scaladsl.Ftp
import akka.stream.scaladsl.{Sink, Source}
import akka.util.ByteString

import scala.concurrent.Future

/**
  * Created by kirankumarbs on 3/6/17.
  */
object FTPWrite extends App{

  val settings = FtpSettings(
    InetAddress.getByName("ftp.epgm.in"),
    21,
    AnonFtpCredentials,
    binary = true,
    passiveMode = true
  )

  val sink: Sink[ByteString, Future[IOResult]] = Ftp.toPath("/EPGM/A27511010209/LOGDATA.TXT", settings, true)

  ByteString("sss".getBytes)
  Source(Array("funny").toVector).runForeach(println)



}

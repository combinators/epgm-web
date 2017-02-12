package controllers

import javax.inject._

import play.api._
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.duration._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() (ws: WSClient)extends Controller {

/*
  val request: WSRequest        = ws.url("http://epgm-web.cloudapp.net:8080/epgm/consolidatedstatelevel/27")
  val complexRequest: WSRequest =
    request.withHeaders("Accept" -> "application/json")
        .withRequestTimeout(100000.millis)
  val futureResponse: Future[WSResponse] = complexRequest.get()
*/

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */


  def index = Action {
    Ok(views.html.index("EPGM Dashboard",ResourceFactory()))
  }

}

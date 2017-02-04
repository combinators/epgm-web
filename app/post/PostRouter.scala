package post

import controllers.GmrController
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by kirankumarbs on 5/2/17.
  */
class PostRouter extends SimpleRouter{
  override def routes: Routes = {
    case GET(p"/$code") => new GmrController().getGrowthMonitoringReport(code)
  }
}

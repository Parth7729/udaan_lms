import com.softwaremill.macwire.wire
import controllers.AssetsComponents
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.db.{DBComponents, HikariCPComponents}
import play.api.db.evolutions.EvolutionsComponents
import play.api.i18n.I18nComponents
import play.api.routing.Router
import router.Routes
import scalikejdbc.config.DBs

import scala.concurrent.{ExecutionContext, Future}


class AppComponents(context: Context) extends BuiltInComponentsFromContext(context = context)
  with MainController_DI
  with AssetsComponents
  with I18nComponents
  with play.filters.HttpFiltersComponents
  with EvolutionsComponents
  with DBComponents
  with HikariCPComponents {


  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }

  implicit lazy val playDefaultExecutionContext: ExecutionContext = controllerComponents.executionContext

  applicationLifecycle.addStopHook { () =>
    DBs.closeAll()
    Future.successful(())
  }

  val onStart = {

    DBs.setupAll()

    applicationEvolutions
  }

}
import controllers.MainController
import play.api.mvc.ControllerComponents

trait MainController_DI {

  val controllerComponents: ControllerComponents

  lazy val mainController = new MainController(
    controllerComponents = controllerComponents
  )

}
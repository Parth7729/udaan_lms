import play.api.mvc.ControllerComponents
import restaurants.RestaurantsController

trait MainController_DI {

  val controllerComponents: ControllerComponents

  lazy val mainController = new RestaurantsController(
    controllerComponents = controllerComponents
  )

}
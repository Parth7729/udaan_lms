import play.api.mvc.ControllerComponents
import restaurants.{RestaurantsController, RestaurantsDAO, RestaurantsService}

trait RestaurantsDAO_DI {

  lazy val restaurantsDAO = new RestaurantsDAO

}

trait RestaurantsService_DI {

  val restaurantsDAO: RestaurantsDAO

  lazy val restaurantsService = new RestaurantsService(
    restaurantsDAO = restaurantsDAO
  )

}

trait RestaurantsController_DI {

  val controllerComponents: ControllerComponents
  val restaurantsService: RestaurantsService

  lazy val mainController = new RestaurantsController(
    controllerComponents = controllerComponents,
    restaurantsService = restaurantsService
  )

}
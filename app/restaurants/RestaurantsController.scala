package restaurants

import play.api.libs.json.{JsError, JsSuccess, JsValue}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import restaurants.models.CreateRestaurantForm

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


class RestaurantsController(
                             protected val controllerComponents: ControllerComponents,
                             restaurantsService: RestaurantsService
                           ) extends BaseController {

  private implicit val ec: ExecutionContext = controllerComponents.executionContext

  def index(): Action[AnyContent] = Action { implicit request =>
    println(s"${request.uri}")
    Ok("works!")
  }

  def saveRestaurant(): Action[JsValue] = Action.async(parse.json) { implicit request => Future {

    request.body.validate[CreateRestaurantForm] match {

      case JsError(error) => BadRequest(error.toString())

      case JsSuccess(createRestaurantForm: CreateRestaurantForm, _) =>

        restaurantsService.saveRestaurant(
          createRestaurantForm = createRestaurantForm
        ) match {

          case Failure(exception) => InternalServerError(exception.getMessage)

          case Success(restaurantId) => Ok(restaurantId.toString)

        }

    }

  }}

}
package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext


class MainController(
                      protected val controllerComponents: ControllerComponents
                    ) extends BaseController {

  private implicit val ec: ExecutionContext = controllerComponents.executionContext

  def index(): Action[AnyContent] = Action { implicit request =>
    println(s"${request.uri}")
    Ok("works!")
  }


}
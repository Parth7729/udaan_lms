package restaurants.models

import play.api.libs.json.{Format, Json}

case class CreateRestaurantForm(
                                 name: String,
                                 email: Option[String],
                                 address: Option[String],
                                 city: Option[String],
                                 state: Option[String],
                                 zip: Option[String],
                                 phone: Option[String]
                               )

object CreateRestaurantForm {
  implicit val format: Format[CreateRestaurantForm] = Json.format[CreateRestaurantForm]
}

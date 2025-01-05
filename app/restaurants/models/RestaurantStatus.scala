package restaurants.models

sealed trait RestaurantStatus

object RestaurantStatus {

  val active = "active"
  val inactive = "inactive"
  val blacklisted = "blacklisted"

  case object Active extends RestaurantStatus {

    override def toString: String = active
  }

  case object Inactive extends RestaurantStatus {

    override def toString: String = inactive
  }

  case object Blacklisted extends RestaurantStatus {

    override def toString: String = blacklisted
  }

}

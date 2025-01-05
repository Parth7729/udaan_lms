package restaurants

import restaurants.models.CreateRestaurantForm

class RestaurantsService(
                        restaurantsDAO: RestaurantsDAO
                        ) {

  def saveRestaurant(
                      createRestaurantForm: CreateRestaurantForm
                    ) = {

    restaurantsDAO.saveRestaurant(
      createRestaurantForm = createRestaurantForm
    )

  }

}

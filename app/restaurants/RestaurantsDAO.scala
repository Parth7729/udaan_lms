package restaurants

import resources.AppConfig
import restaurants.models.{CreateRestaurantForm, RestaurantStatus}
import scalikejdbc.{DB, scalikejdbcSQLInterpolationImplicitDef}

import scala.util.Try

class RestaurantsDAO {

  def saveRestaurant(
                      createRestaurantForm: CreateRestaurantForm
                    ): Try[Option[Long]] = Try {

    DB.autoCommit { implicit session =>

      sql"""
           INSERT INTO restaurants(
             name,
             email,
             phone,

             address,
             city,
             state,
             zip,

             status,
             max_call_per_week

           )
           VALUES (
             ${createRestaurantForm.name},
             ${createRestaurantForm.email},
             ${createRestaurantForm.phone},

             ${createRestaurantForm.address},
             ${createRestaurantForm.city},
             ${createRestaurantForm.state},
             ${createRestaurantForm.zip},

            -- default status is 'active'
             ${RestaurantStatus.Active.toString},
             ${AppConfig.max_calls_per_week}
           )

           RETURNING id;
         """
        .map(rs => rs.long("id"))
        .single()
        .apply()

    }

  }

}

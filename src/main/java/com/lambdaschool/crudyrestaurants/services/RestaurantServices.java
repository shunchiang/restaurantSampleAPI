package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import views.MenuCounts;

import java.util.List;

/**
 * The Service that works with the Restaurant Model.
 */
public interface RestaurantServices
{
    List<Restaurant> findAllRestaurants();

    Restaurant findRestaurantById(long id);

    Restaurant findRestaurantByName(String name);

    List<Restaurant> findByKeyword(String subname);

    List<MenuCounts> countMenusByRestaurant();

    List<Restaurant> findAllRestaurantByDish(String dish);
    /**
     * Given a complete restaurant object, saves that restaurant object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     *
     * @param restaurant the restaurant object to be saved
     * @return the saved restaurant object including any automatically generated fields
     */

    Restaurant save(Restaurant restaurant);

}

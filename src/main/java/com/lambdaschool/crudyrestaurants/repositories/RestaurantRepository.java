package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import views.MenuCounts;

import java.util.List;

/**
 * The CRUD Repository connecting Restaurant to the rest of the application.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);

    List<Restaurant> findByNameContainingIgnoringCase(String subname);

    @Query(value="SELECT r.name name, count(m.menuid) countmenus " +
            "FROM restaurants r LEFT JOIN menus m " +
            "ON r.restaurantid = m.restaurantid " +
            "GROUP BY r.name " +
            "ORDER BY countmenus DESC",nativeQuery = true)
    List<MenuCounts> findMenuCounts();

    List<Restaurant> findByMenus_dishContainingIgnoringCase(String dish);

}
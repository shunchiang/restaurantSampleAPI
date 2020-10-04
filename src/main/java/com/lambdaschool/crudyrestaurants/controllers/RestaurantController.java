package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import views.MenuCounts;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantServices restaurantServices;
    // http://localhost2020/restaurants/restaurants list all restaurants
    @GetMapping(value = "/restaurant",produces={"application/json"})
    public ResponseEntity<?> listAllRestaurants(){
        List<Restaurant> myList = restaurantServices.findAllRestaurants();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    // http://localhost2020/restaurants/restaurants/10 find specific restaurant by Key
    @GetMapping(value="/restaurant/{restaurantId}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantById(@PathVariable long restaurantId){
        Restaurant r = restaurantServices.findRestaurantById(restaurantId);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }
    // http://localhost2020/restaurants/exactname/{name} find specific restaurant by keyword
    @GetMapping(value="/name/{restaurantName}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantByName(@PathVariable String restaurantName){
        Restaurant r = restaurantServices.findRestaurantByName(restaurantName);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }

    // http://localhost2020/restaurants/likename/{name} find specific restaurant by keyword
    @GetMapping(value="/keyword/{subname}", produces = {"application/json"})
    public ResponseEntity<?> findRestaurantByKeyword(@PathVariable String subname){
        List<Restaurant>rtnList = restaurantServices.findByKeyword(subname);
                return new ResponseEntity<>(rtnList,HttpStatus.OK);
    }

    // http://localhost2020/restaurants/menucounts return menu count of restaurants
    @GetMapping(value="/menucounts", produces = {"application/json"})
    public ResponseEntity<?> listRestaurantMenuCounts(){
        List<MenuCounts>rtnList = restaurantServices.countMenusByRestaurant();
        return new ResponseEntity<>(rtnList,HttpStatus.OK);
    };


    // http://localhost2020/restaurants/likedish/{foodKeyWord} find restaurant with menu item key names
    @GetMapping(path="/likedish/{dish}", produces = "application/json")
    public ResponseEntity<?> findRestaurantByDish(@PathVariable String dish){
        List<Restaurant>rtnList=restaurantServices.findAllRestaurantByDish(dish);
        return new ResponseEntity<>(rtnList,HttpStatus.OK);
    }


}

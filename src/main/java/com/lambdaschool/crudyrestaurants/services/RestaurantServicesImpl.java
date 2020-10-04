package com.lambdaschool.crudyrestaurants.services;

/*
 * Note: "Unless there's some extra information that isn't clear from the interface description (there rarely is), the implementation documentation should then simply link to the interface method."
 * Taken from https://stackoverflow.com/questions/11671989/best-practice-for-javadocs-interface-implementation-or-both?lq=1
 */

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the RestaurantServices Interface.
 */
@Transactional
@Service(value = "restaurantService")
public class RestaurantServicesImpl
        implements RestaurantServices
{
    /**
     * Connects this service to the Restaurant Table.
     */
    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining((list::add));
        return list;
    }

    @Override
    public Restaurant findRestaurantById(long id) {
        return restrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("restaurant "+id+" not found"));
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        Restaurant restaurant = restrepos.findByName(name);
        if(restaurant==null){
            throw new EntityNotFoundException("Restaurant "+ name + " not found");
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> findByKeyword(String subname) {
        List<Restaurant> list = restrepos.findByNameContainingIgnoringCase(subname);
        return list;
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restrepos.save(restaurant);
    }
}

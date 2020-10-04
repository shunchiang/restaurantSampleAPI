package com.lambdaschool.crudyrestaurants.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The entity allowing interaction with the menus table.
 */
@Entity
@Table(name = "menus")
public class Menu
{
    /**
     * The primary key number (long) of the menus table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    /**
     * The name (String) of the menu's dish.
     */
    @Column(nullable = false)
    private String dish;

    /**
     * The price (double) of the menu's item.
     */
    private double price;

    /**
     * A foreign key to the restaurants table.
     * Forms a Many-To-One relation with the restaurants table. Many menus to one restaurant.
     * Contains an object pointer to the full restaurant object.
     */
    @ManyToOne
    @JoinColumn(name = "restaurantid",
            nullable = false)
    private Restaurant restaurant;

    /**
     * Default constructor used primarily by the JPA.
     */
    public Menu()
    {
    }

    /**
     * Given the params, creates a new menu object.
     * <p>
     * menuid is autogenerated.
     *
     * @param dish       The name (String) of the menu item. Cannot be null.
     * @param price      The cost (Double) of the menu item.
     * @param restaurant The full restaurant object to which the menu item is assigned.
     */
    public Menu(
            String dish,
            double price,
            Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    /**
     * Getter for menuid.
     *
     * @return The primary key number (long) of the menus table.
     */
    public long getMenuid()
    {
        return menuid;
    }

    /**
     * Setter for menuid - used primarily when seeding data.
     *
     * @param menuid The new primary key (long) number of the menus table.
     */
    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    /**
     * Getter for dish.
     *
     * @return The name (String) of the menu's dish.
     */
    public String getDish()
    {
        return dish;
    }

    /**
     * Setter for dish.
     *
     * @param dish The new name (String) of the menu's dish.
     */
    public void setDish(String dish)
    {
        this.dish = dish;
    }

    /**
     * Getter for price.
     *
     * @return The cost (double) of the menu item.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Setter for price.
     *
     * @param price The new price (double) of the menu item.
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Setter for Restaurant.
     *
     * @return The Restaurant object associated with this menu.
     */
    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    /**
     * Change the restaurant associated with this menu.
     *
     * @param restaurant The new restaurant for this menu.
     */
    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Menus {
    private ArrayList<FoodItem> firstClassMenu = new ArrayList<>();
    private ArrayList<FoodItem> economyMenu = new ArrayList<>();
    
    public Menus(ArrayList<FoodItem> firstClassMenu, ArrayList<FoodItem> economyMenu)
    {
        this.firstClassMenu = firstClassMenu;
        this.economyMenu = economyMenu;
    }

    public ArrayList<FoodItem> getFirstClassMenu() {
        return firstClassMenu;
    }

    public ArrayList<FoodItem> getEconomyMenu() {
        return economyMenu;
    }
    
    
}

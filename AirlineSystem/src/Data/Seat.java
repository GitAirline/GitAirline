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
public class Seat {
    protected String seatNo;
    protected Person pessanger;
    protected ArrayList<FoodItem> selectedFood;
    protected double price;
    
    public Seat(String seatNo, Person pessanger, ArrayList<FoodItem> food, double price)
    {
        this.seatNo = seatNo;
        this.pessanger = pessanger;
        this.selectedFood = food;
        this.price = price;
    }
    
    public Seat(String seatNo, double price)
    {
        this.seatNo = seatNo;
        this.price = price;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public Person getPessanger() {
        return pessanger;
    }
    
    public void setPessanger(Person pessanger) {
        this.pessanger = pessanger;
    }

    public ArrayList<FoodItem> getSelectedFood() {
        return selectedFood;
    }
}

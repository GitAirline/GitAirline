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
public class Seat implements SeatInterface {
    private String seatNo;
    private Person pessanger;
    private ArrayList<FoodItem> selectedFood;
    private double price;
    
    private SeatStatus status;
    
    public Seat(String seatNo, Person pessanger, ArrayList<FoodItem> food)
    {
        this.seatNo = seatNo;
        this.pessanger = pessanger;
        this.selectedFood = food;
        this.status = SeatStatus.OCCUPIED;
    }
    
    public Seat(String seatNo, double price)
    {
        this.seatNo = seatNo;
        this.price = price;
        this.selectedFood = new ArrayList<>(0);
        this.status = SeatStatus.FREE;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public Person getPessanger() {
        return pessanger;
    }
    
    public void setPessanger(Person pessanger) {
        System.out.println("In setPessanger " + pessanger.getFirstName());
        this.pessanger = pessanger;
        System.out.println(this.pessanger.getFirstName());
    }

    public ArrayList<FoodItem> getSelectedFood() {
        return selectedFood;
    }
    
    public void setSelectedFood(ArrayList<FoodItem> food) {
        selectedFood = food;
    }
    
    public SeatStatus getStatus()
    {
        return status;
    }
    
    public void setStatus(SeatStatus status)
    {
        this.status = status;
    }
    
    public double getPrice()
    {
        // implement to get price including seat and foor items
        return price;
    }
}

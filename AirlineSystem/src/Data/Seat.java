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
    
    public enum SeatStatus { FREE, OCCUPIED };
    protected SeatStatus status;
    
    public Seat(String seatNo, Person pessanger, ArrayList<FoodItem> food, double price)
    {
        this.seatNo = seatNo;
        this.pessanger = pessanger;
        this.selectedFood = food;
        this.price = price;
        this.status = SeatStatus.OCCUPIED;
    }
    
    public Seat(String seatNo, double price)
    {
        this.seatNo = seatNo;
        this.price = price;
        this.selectedFood = new ArrayList<>();
        this.status = SeatStatus.FREE;
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
    
    public SeatStatus getStatus()
    {
        return status;
    }
    
    public void setStatus(SeatStatus status)
    {
        this.status = status;
    }
}

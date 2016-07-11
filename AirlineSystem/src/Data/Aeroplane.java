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
public class Aeroplane {
    private int noEconomySeats = 5;
    private int noFirstClassSeats = 5;
    
    protected ArrayList<Seat> economySeats = new ArrayList<>(noEconomySeats);
    protected ArrayList<Seat> firstClassSeats = new ArrayList<>(noFirstClassSeats);
    protected Menus menu;
    protected FlightStatus flightStatus;
    protected String flightNo;
    
    
    public Aeroplane()
    {
        createSeats();
        createMenus();
    }
    
    public FlightStatus getFilghtStatus()
    {
        return this.flightStatus;
    }
    
    // This will create seat arraylist with seatNos and price only. 
    // For booking these seat nos will be listed and as per selected seat 
    // pessanger and food item is selected and added through reserveSeat
    protected void createSeats()
    {
        
    }
    
    protected void createMenus()
    {
        
    }
    
    protected void reserveSeat(String seatNo, Person person, ArrayList<FoodItem> food)
    {
        
    }
    
    public long getPrice(String seatNo)
    {
        long price = 0;
        // go through seat type and menu items to get final price
        return price;
    }
    
    public long getPrice()
    {
        // go through all seats and return collected rpice
        return 0;
    }
    
    public ArrayList<String> showAvailableEconomySeats()
    {
        ArrayList<String> seatNos = null;
        // get available seats;
        return seatNos;
    }
    
    public ArrayList<String> showAvailableFirstClassSeats()
    {
        ArrayList<String> seatNos = null;
        // get available seats;
        return seatNos;
    }
    
    public void changeStatus(FlightStatus newStatus)
    {
        
    }
}

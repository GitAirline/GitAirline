/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @author User
 */
public class Aeroplane implements AeroplaneInterface{
    private int noEconomySeats = 5;
    private int noFirstClassSeats = 5;
    
    private ArrayList<Seat> economySeats = new ArrayList<>(noEconomySeats);
    private ArrayList<Seat> firstClassSeats = new ArrayList<>(noFirstClassSeats);
    private Menus menu;
    private FlightStatus flightStatus;
    private String flightNo;
    
    public Aeroplane(String flightNo, Menus menu)
    {
        this(flightNo, menu, 5, 5);
    }
    
    public Aeroplane(String flightNo, Menus menu, int noEconomySeats, int noFirstClassSeats)
    {
        this.flightNo = flightNo;
        this.noEconomySeats = noEconomySeats;
        this.noFirstClassSeats = noFirstClassSeats;
        this.menu = menu;
        this.flightStatus = FlightStatus.READY;
        createSeats();
        //createMenus();
    }
    
    public FlightStatus getFilghtStatus()
    {
        return this.flightStatus;
    }
    
    public String getFlightNo()
    {
        return flightNo;
    }
    
    // This will create seat arraylist with seatNos and price only. 
    // For booking these seat nos will be listed and as per selected seat 
    // pessanger and food item is selected and added through reserveSeat
    protected void createSeats()
    {
        Seat seat;
        String seatNo = "E";
        for(int i = 1; i <= noEconomySeats; ++ i)
        {
            seat = new Seat(seatNo+i, 5000);
            economySeats.add(seat);
        }
        
        seatNo = "B";
        for(int i = 1; i <= noEconomySeats; ++ i)
        {
            seat = new Seat(seatNo+i, 5000);
            firstClassSeats.add(seat);
        }
    }
    
    protected void createMenus()
    {
        
    }
    
    public boolean reserveSeat(String seatNo, Person person, ArrayList<FoodItem> food)
    {
        BiFunction<Seat, String, Boolean> reserve = (original, another) -> {
          boolean res = false;
          if(original.getSeatNo().equals(another))
          {
              original.setPessanger(person);
             
              original.setStatus(SeatStatus.OCCUPIED);
              res = true;
          }
          return res;
        };
        //boolean result = false;
        for(Seat original : economySeats)
        {
            if(reserve.apply(original, seatNo))
            {
                return true;
            }
        }
        
        for(Seat original : firstClassSeats)
        {
            if(reserve.apply(original, seatNo))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public double getPrice(String seatNo)
    {
        long price = 0;
        // go through seat type and menu items to get final price
        return price;
    }
    
    public double getPrice()
    {
        // go through all seats and return collected rpice
        return 0;
    }
    
    public List<? extends SeatInterface> getEconomySeats()
    {
        return economySeats;
    }
    
    public List<? extends SeatInterface> getFirstClassSeats()
    {
        return firstClassSeats;
    }
    
    public void changeStatus(FlightStatus newStatus)
    {
        
    }
    
    public boolean checkThresholdToFly()
    {
        // check minimum no of seats to fill to fly the flight
        return false;
    }
    
    public boolean isReady()
    {
        return flightStatus == FlightStatus.READY;
    }
}

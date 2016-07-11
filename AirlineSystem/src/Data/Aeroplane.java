/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.function.BiFunction;

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
    
    public boolean reserveSeat(Seat seat)
    {
        BiFunction<Seat, Seat, Boolean> reserve = (original, another) -> {
          boolean res = false;
          if(original.getSeatNo().equals(another.getSeatNo()))
          {
              original = another;
              original.setStatus(Seat.SeatStatus.OCCUPIED);
              res = true;
          }
          return res;
        };
        //boolean result = false;
        for(Seat original : economySeats)
        {
            if(reserve.apply(original, seat))
            {
                return true;
            }
        }
        
        for(Seat original : firstClassSeats)
        {
            if(reserve.apply(original, seat))
            {
                return true;
            }
        }
        
        return false;
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
        ArrayList<String> seatNos = new ArrayList<>();
        // get available seats;
        for(Seat seat : economySeats)
        {
            if(seat.getStatus() == Seat.SeatStatus.FREE)
                seatNos.add(seat.getSeatNo());
        }
        return seatNos;
    }
    
    public ArrayList<String> showAvailableFirstClassSeats()
    {
        ArrayList<String> seatNos = new ArrayList<>();
        // get available seats;
        for(Seat seat : firstClassSeats)
        {
            if(seat.getStatus() == Seat.SeatStatus.FREE)
                seatNos.add(seat.getSeatNo());
        }
        return seatNos;
    }
    
    public void changeStatus(FlightStatus newStatus)
    {
        
    }
    
    public boolean checkThresholdToFly()
    {
        // check minimum no of seats to fill to fly the flight
        return false;
    }
}

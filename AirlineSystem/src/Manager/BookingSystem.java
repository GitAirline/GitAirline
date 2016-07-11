/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.Aeroplane;
import Data.FlightStatus;
import Data.FoodItem;
import Data.Menus;
import Data.Seat;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BookingSystem {
    protected ArrayList<Aeroplane> aeroplanes = new ArrayList<>();
    protected String flightSuffix = "GA";
    protected int flightPrefix = 1;
    
    public void addAeroplane()
    {
        Menus menu = createMenu();
        String flightNo = flightSuffix + flightPrefix++;
        
        aeroplanes.add(new Aeroplane(flightNo, menu));
    }
    
    protected Menus createMenu()
    {
        
        FoodItem eat = new FoodItem("Nuts", "", "", 25, FoodItem.MENUCLASS.ECONOMI);
        FoodItem drink = new FoodItem("Soft Drink", "", "", 25, FoodItem.MENUCLASS.ECONOMI);
        ArrayList<FoodItem> eMenu = new ArrayList<>();
        eMenu.add(eat);
        eMenu.add(drink);
        
        eat = new FoodItem("Nuts", "", "", 50, FoodItem.MENUCLASS.FIRST);
        drink = new FoodItem("Soft Drink", "", "", 75, FoodItem.MENUCLASS.FIRST);
        
        ArrayList<FoodItem> bMenu = new ArrayList<>();
        bMenu.add(eat);
        bMenu.add(drink);
        
        Menus menu = new Menus(bMenu, eMenu);
        
        return menu;
    }
    
    public boolean removeAeroplane(String flightNo)
    {
        return false;
    }
    
    public ArrayList<String> getReadyFlights()
    {
        ArrayList<String> result = null;
        // get all glifht nos with ready status
        return result;
    }
    
    public ArrayList<String> showAvailableEconomySeats(String flightNo)
    {
        ArrayList<String> seats = null;
        // get aeroplane from list and call showAvailableEconomySeats for that aeroplane
        //for(Seat seat : )
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(aeroplane.getFlightNo().equals(flightNo))
            {
                seats = aeroplane.showAvailableEconomySeats();
                break;
            }
        }
        return seats;
    }
    
    public ArrayList<String> showAvailableFirstClassSeats(String flightNo)
    {
        ArrayList<String> seats = null;
        // get aeroplane from list and call showAvailableFirstClassSeats for that aeroplane
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(aeroplane.getFlightNo().equals(flightNo))
            {
                seats = aeroplane.showAvailableFirstClassSeats();
                break;
            }
        }
        return seats;
    }
    
    public boolean reserveFlight(String flightNo, Seat seat)
    {
        boolean status = false;
        // For selected flight call reserveSeat
        // if minimum criteria to fly is true, fly the flight
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(aeroplane.getFlightNo().equals(flightNo))
            {
                status = aeroplane.reserveSeat(seat);
                break;
            }
        }
        return false;
    }
    
    public Menus getMenu(String flightNo)
    {
        Menus menu = null;
        // return menu for selected flight
        return menu;
    }
    
    public void changeFlightStatus(String flightNo, FlightStatus status)
    {
        // change flight status for selected flight
    }
    
    public void flyFlight(String flightNo)
    {
        // change the status and fly the flight
        // here will start new thread
    }
}

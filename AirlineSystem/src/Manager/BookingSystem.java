/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.Aeroplane;
import Data.FlightStatus;
import Data.Menus;
import Data.Seat;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BookingSystem {
    protected ArrayList<Aeroplane> aeroplanes = new ArrayList<>();
    
    public void addAeroplane()
    {
        
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
        return seats;
    }
    
    public ArrayList<String> showAvailableFirstClassSeats(String flightNo)
    {
        ArrayList<String> seats = null;
        // get aeroplane from list and call showAvailableFirstClassSeats for that aeroplane
        return seats;
    }
    
    public boolean reserveFlight(String flightNo, Seat seat)
    {
        // For selected flight call reserveSeat
        // if minimum criteria to fly is true, fly the flight
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

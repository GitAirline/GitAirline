/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.FoodItem;
import Data.Menus;
import Data.Person;
import Data.Seat;
import Data.SeatInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public interface ManagerInterface {
    ArrayList<String> getReadyFlights();
    List<? extends SeatInterface> getFirstClassSeats(String flightNo);
    List<? extends SeatInterface> getEconomySeats(String flightNo);
    boolean removeAeroplane(String flightNo);
    void addAeroplane();
    void addAeroplane(Menus menu);
    public boolean reserveFlight(String flightNo, String seatNo, Person person, ArrayList<FoodItem> food);
    public boolean isFlightReady(String flightNo);
}

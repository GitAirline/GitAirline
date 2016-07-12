/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.AeroplaneInterface;
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
public class BookingSystemManager implements ManagerInterface {

    BookingSystem bookingSystem = new BookingSystem();
    @Override
    public ArrayList<String> getReadyFlights() {
        List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
        ArrayList<String> readyFlights = new ArrayList<>();
        for(AeroplaneInterface ai : list)
        {
            if(ai.isReady()) {
                readyFlights.add(ai.getFlightNo());
            }
        }
        return readyFlights;
    }

    @Override
    public boolean removeAeroplane(String flightNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAeroplane() {
        bookingSystem.addAeroplane();
    }

    @Override
    public void addAeroplane(Menus menu) {
        bookingSystem.addAeroplane(menu);
    }

    @Override
    public List<? extends SeatInterface> getFirstClassSeats(String flightNo) {
       List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
       for(AeroplaneInterface ai : list)
        {
            if(ai.getFlightNo().equals(flightNo)) {
                return ai.getFirstClassSeats();
            }
        }
       // should throw exception
       return null;
    }

    @Override
    public List<? extends SeatInterface> getEconomySeats(String flightNo) {
       List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
       for(AeroplaneInterface ai : list)
        {
            if(ai.getFlightNo().equals(flightNo)) {
                return ai.getEconomySeats();
            }
        }
       // should throw exception
       return null;
    }

    @Override
    public boolean reserveFlight(String flightNo, String seatNo, Person person, ArrayList<FoodItem> food) {
        return bookingSystem.reserveFlight(flightNo, seatNo, person, food);
    }
    
}

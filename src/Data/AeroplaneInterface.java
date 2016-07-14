/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public interface AeroplaneInterface {
    String getFlightNo();
    double getPrice(String seatNo);    
    double getPrice();
    ArrayList<Seat> getEconomySeats();
    //List<? extends SeatInterface> getFirstClassSeats();
    ArrayList<Seat> getFirstClassSeats();
    boolean isReady();
    
}

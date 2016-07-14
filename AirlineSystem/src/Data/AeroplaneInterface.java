/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;

/**
 *
 * @author User
 */
public interface AeroplaneInterface {
    String getFlightNo();
    double getPrice(String seatNo);
    double getPrice();
    List<? extends SeatInterface> getEconomySeats();
    List<? extends SeatInterface> getFirstClassSeats();
    boolean isReady();
    Menus getMenu();
    boolean isReadyToFly();
    FlightStatus getFilghtStatus();
}

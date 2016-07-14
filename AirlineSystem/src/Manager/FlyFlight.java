/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.FlightStatus;

/**
 *
 * @author User
 */
public class FlyFlight implements Runnable{

    BookingSystem bookingSystem;
    String flightNo;
    
    public FlyFlight(BookingSystem bookingSystem, String flightNo)
    {
        this.bookingSystem = bookingSystem;
        this.flightNo = flightNo;
    }
    
    @Override
    public void run() {
        
        System.out.println("Flight " + flightNo + " is getting ready to takeoff.");
        bookingSystem.changeFlightStatus(flightNo, FlightStatus.TAKEOFF);

        System.out.println("Flight " + flightNo + " is flying.");
        bookingSystem.changeFlightStatus(flightNo, FlightStatus.FLYING);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Flight " + flightNo + " is landing.");
        bookingSystem.changeFlightStatus(flightNo, FlightStatus.LANDING);

        System.out.println("Flight " + flightNo + " is refueling.");
        bookingSystem.changeFlightStatus(flightNo, FlightStatus.REFUEL);
            
        bookingSystem.changeFlightStatus(flightNo, FlightStatus.READY);
        System.out.println("Flight " + flightNo + " is ready.");
    }
    
}

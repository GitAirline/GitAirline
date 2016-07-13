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
public interface SeatInterface {
    String getSeatNo();
    Person getPessanger();
    ArrayList<FoodItem> getSelectedFood();
    SeatStatus getStatus();
    double getPrice();
    boolean isFree();
}

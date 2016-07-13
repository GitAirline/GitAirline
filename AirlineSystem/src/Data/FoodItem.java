/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author User
 */
public class FoodItem {
    protected String name;
    protected String description;
    protected String picture;
    protected double price;
    private String Id;
    private String idPrefix = "F";
    private static int idSuffix = 1;

    public String getId() {
        return Id;
    }

    public MENUCLASS getMenuClass() {
        return menuClass;
    }
    
    public enum MENUCLASS {
        ECONOMI, FIRST, BOTH
    };
    
    private MENUCLASS menuClass;
    
    public FoodItem(String name, String description, String picture, double price, MENUCLASS menuClass)
    {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.menuClass = menuClass;
        
        createAndAssignId();
    }
    
    protected void createAndAssignId()
    {
        this.Id = idPrefix + idSuffix++;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }
}

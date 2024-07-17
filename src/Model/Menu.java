/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HP
 */
public class Menu {
    private String Itemname;
    private String type;
    private double price;

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String Itemname) {
        this.Itemname = Itemname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Menu(String Itemname, String type, double price) {
        this.Itemname = Itemname;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return  Itemname + "\t" + price +"\n";
    }
    
}

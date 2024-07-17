
package Model;


public class OrderItem {
    private int tablenumber;
    private String foodname;
    private int quantity;

    public OrderItem(int tablenumber, String foodname, int quantity) {
        this.tablenumber = tablenumber;
        this.foodname = foodname;
        this.quantity = quantity;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + "\t" + foodname + "\t";
    }
    
    
}

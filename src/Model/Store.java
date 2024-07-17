
package Model;


public class Store {
   private int ingreid;
   private int quantity;
 private String name;
    public Store(int ingreid, int quantity, String name) {
        this.ingreid = ingreid;
        this.quantity = quantity;
        this.name = name;
    }
   public int getIngreid() {
        return ingreid;
    }

    public void setIngreid(int ingreid) {
        this.ingreid = ingreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return   ingreid + "\t" + name + "\t" + quantity ;
    }
   

   
    
   
   
   
}

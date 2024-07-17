
package Model;

public class Order {
    
 private int orderid;
 private int resid;
 private double totalamount;
 public Order(int orderid, int resid, double totalamount) {
        this.orderid = orderid;
        this.resid = resid;
        this.totalamount = totalamount;
    }
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

   


    

   

   
    


    

    
    
 
 
}

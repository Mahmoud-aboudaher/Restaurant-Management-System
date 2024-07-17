
package Model;


public class Reservation {
  private int resid;
  private int tablenumber;
private String customername;
private String time ;
private int nbrofguests;

   public Reservation(int resid, int tablenumber, String customername, String time, int nbrofguests) {
        this.resid = resid;
        this.tablenumber = tablenumber;
        this.customername = customername;
        this.time=time;
        this.nbrofguests = nbrofguests;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

   

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    public int getNbrofguests() {
        return nbrofguests;
    }

    public void setNbrofguests(int nbrofguests) {
        this.nbrofguests = nbrofguests;
    }
    


}

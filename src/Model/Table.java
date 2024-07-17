
package Model;


public class Table {
    private int tablenumber;
    private int nbrofseats;
    private boolean isavailable;

    public Table(int tablenumber, int nbrofseats, boolean isavailable) {
        this.tablenumber = tablenumber;
        this.nbrofseats = nbrofseats;
        this.isavailable = isavailable;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public int getNbrofseats() {
        return nbrofseats;
    }

    public void setNbrofseats(int nbrofseats) {
        this.nbrofseats = nbrofseats;
    }

    public boolean isIsavailable() {
        return isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }
    

    
}

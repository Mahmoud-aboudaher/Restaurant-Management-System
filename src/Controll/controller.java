
package Controll;

import Model.Employee;
import Model.Menu;
import Model.Reservation;
import Model.Store;
import Model.Table;
import java.util.ArrayList;


public class controller {
    DataBaseAccess db = new DataBaseAccess(); 
   public void addemployee(int empid,String name,double salary,String pos){
       db.insertemployee(empid, name, salary, pos);
   }  
   public String [][]  filltableEmp(){
        ArrayList<Employee> emplist =db.selectFromTableEmp();
        String [][] table = new String [emplist.size()][4];
        for (int i = 0; i < emplist.size(); i++) {
           table[i][0]=emplist.get(i).getId()+"";
           table[i][1]=emplist.get(i).getName();
           table[i][2]=emplist.get(i).getPosition();
           table[i][3]=emplist.get(i).getSalary()+"";
       }
        return table;
   }
   
    public String[] fillcomboyid(){
         ArrayList<Employee> emplist =db.selectFromTableEmp();
         String []ids=new String[emplist.size()];
         for (int i = 0; i < emplist.size(); i++) {
            ids[i]=emplist.get(i).getId()+"";
        }
         return ids;
    }
    public void removeemployee(int id){      
       db.deleteemp(id);
   }
    public String getempname(int id){
        ArrayList<Employee> emplist =db.selectFromTableEmp();
        for (int i = 0; i < emplist.size(); i++) {
            if(emplist.get(i).getId()==id){
                return emplist.get(i).getName();
            }
        }
        return null;
    }
    public void addItemMenu(String Itemname,String type,double price){
       db.insertitem(Itemname, type, price);
   }
     public String[] fillcomboynameofitem(){
         ArrayList<Menu> list =db.selectFromTableMenu();
         String []names=new String[list.size()];
         for (int i = 0; i < list.size(); i++) {
           names[i]=list.get(i).getItemname();
        }
         return names;
    }
     public void removeItemmenu(String name){      
      db.deleteitem(name);
   }
    public void addIngredientToStore(int id,int quantity,String name){
       db.insertIngredienttoStore(id, quantity, name);
   } 
    public String printallIngredients(){
       ArrayList<Store> list =db.selectFromTableStore();
       String all="";
        for (int i = 0; i < list.size(); i++) {
           all+=list.get(i).toString()+"\n";
        }
       return all;
       
    }
    public String [] fillcombobyStoreingre(){
      ArrayList<Store> list =db.selectFromTableStore();
      String []all=new String [list.size()];
        for (int i = 0; i < list.size(); i++) {
            all[i]=list.get(i).getIngreid()+"-"+list.get(i).getName();
        }
        return all;
    }
    public String [] fillcombobyStoreingrename(){
      ArrayList<Store> list =db.selectFromTableStore();
      String []all=new String [list.size()];
        for (int i = 0; i < list.size(); i++) {
            all[i]=list.get(i).getName();
        }
        return all;
    }
    public void editqunatityInstore(int quantity,String name){
       db.altertablestore(quantity, name);
    }
     public void removeIngerdientInStore(String name){      
      db.deleteingre(name);
     }
    public void addDescription(String itemMenu,ArrayList<Integer> id){
        db.insertdescription(itemMenu, id);
    }
    public void removedescriptionforItemMenu(String name){
       db.deletedescription(name);
    }
       public void addTable(int num,int seats){
      db.insertNewTable(num, seats);
   } 
       public void removeTablesFromRestaurant(int tabnum){
         db.deleteTable(tabnum);
     }
   public String [][] filltablebyTables(){
       ArrayList<Table> list=db.selectFromtable_Tables();
      String [][] table=new String [list.size()][3];
       for (int i = 0; i < list.size(); i++) {
           table[i][0]=list.get(i).getTablenumber()+"";
           table[i][1]=list.get(i).getNbrofseats()+"";
           if(list.get(i).isIsavailable()){
            table[i][2]="reserved";   
           }else{
              table[i][2]="not reserved";  
           }
           
       }
      return table;
   }
  public String fillMenuByfood() {
    ArrayList<Menu> list = db.selectFromTableMenu();
    StringBuilder s = new StringBuilder("<html>");
             s.append("FOOD") .append("<br>");
        for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getType().equals("food")) {
            s.append(list.get(i).getItemname())
             .append("-------------------")
             .append(list.get(i).getPrice())
             .append("$<br>");
        }
    }
    s.append("</html>");
    return s.toString();
  }
 public String fillMenuByDrink() {
    ArrayList<Menu> list = db.selectFromTableMenu();
    StringBuilder s = new StringBuilder("<html>");
    s.append("DRINK") .append("<br>");
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getType().equals("drink")) {
            s.append(list.get(i).getItemname())
             .append("-------------------")
             .append(list.get(i).getPrice())
             .append("$<br>");
        }
    }
    s.append("</html>");
    return s.toString();
 }
   
   
     public String [] fillcombobytablenumbers(){
       ArrayList<Table> list=db.selectFromtable_Tables();
       String[]num=new String [list.size()];
         for (int i = 0; i < list.size(); i++) {
            num[i]=list.get(i).getTablenumber()+"";
         }
         return num;
     }
     
     public void setTableReserved(int tablenumber){
        db.altertableTABLESandSetReserved(tablenumber);
     }
     public void setTableunReserved(int tablenumber){
         db.altertableTABLESandSetunReserved(tablenumber);
     }
     public String  showdescription(String name){
     
     return db.AltertabletoGetDescription(name);
     }
     public boolean checkRepitionEmpId(int id){
         ArrayList<Integer> empids=db.altertablemployeeToGetIds();
         for (int i = 0; i <empids.size() ; i++) {
             if(empids.get(i)==id){
                 return true;
             }
         }
         return false;
     }
     public boolean checkRepitionIngreid(int id){
         ArrayList<Integer> ingreids=db.altertableStoretoGetids();
         for (int i = 0; i <ingreids.size() ; i++) {
             if(ingreids.get(i)==id){
                 return true;
             }
         }
         return false;
     }
     public boolean checkRepitionnameInMneu(String name){
         ArrayList<String> names=db.altertableMneuTogetNames();
         for (int i = 0; i <names.size() ; i++) {
             if(names.get(i).equals(name)){
                 return true;
             }
         }
         return false;
     }
      public boolean checkRepitionOfTableNumber(int tb){
         ArrayList<Integer> tablenumbers=db.altertableTablestogetNumber();
         for (int i = 0; i <tablenumbers.size() ; i++) {
             if(tablenumbers.get(i)==tb){
                 return true;
             }
         }
         return false;
     }
       public boolean checkDescriptionOfitemIffound(String name){
         ArrayList<String> n=db.AlterTableComposeTocheckDes();
         for (int i = 0; i <n.size() ; i++) {
             if(n.get(i).equals(name)){
                 return true;
             }
         }
         return false;
     } 
       public boolean checktablesActivity(){
         ArrayList<Table> list=db.selectFromtable_Tables();
         
           for (int i = 0; i < list.size(); i++) {
              if(list.get(i).isIsavailable()) {
                  return true;
              }
           }
           return false;
       }
      
        
}
      
   



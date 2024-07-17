
package Controll;

import Model.Employee;
import Model.Menu;
import Model.Reservation;
import Model.Store;
import Model.Table;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataBaseAccess {
    private Connection connection;
    private Statement statement;
    private PreparedStatement state;
private void connect()throws SQLException {
   connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant ","root","");
   statement=connection.createStatement();
}
private void disconnect()throws SQLException {
     connection.close();
     statement.close();
           
 }
 public void insertemployee(int empid,String name,double salary,String pos) {

    String query = "INSERT INTO employee(empid, name, salary,position) VALUES (?, ?, ?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, empid);
        state.setString(2, name);
        state.setDouble(3, salary);
        state.setString(4, pos);
       state.executeUpdate();
       state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
     
 }
 public ArrayList<Employee> selectFromTableEmp(){
     ArrayList<Employee> emplist = new ArrayList();
     String query="SELECT * FROM employee;";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
             int id=res.getInt("empid");
             String name=res.getString("name");
             double salary=res.getDouble("SALARY");
             String pos=res.getString("position");
             Employee emp=new  Employee(id,name,salary,pos); 
             emplist.add(emp);
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return emplist;
 }
 public void deleteemp(int id){
     String query = "delete from employee where empid="+id;
     try{
        connect();
       statement.executeUpdate(query);
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to submit the data: ");}
 }
 public void insertitem(String name,String type,double price) {

    String query = "INSERT INTO Menu(name, type, price) VALUES (?, ?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setString(1, name);
        state.setString(2, type);
        state.setDouble(3, price);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
     
 }
 public ArrayList<Menu> selectFromTableMenu(){
     ArrayList<Menu> list = new ArrayList();
     String query="SELECT * FROM Menu;";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
            Menu m=new Menu(res.getString("name"),res.getString("type"),res.getDouble("price"));
            list.add(m);
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return list;
 }
  public void deleteitem(String name){
     String query = "delete from Menu where name='"+name+"'";
     try{
        connect();
       statement.executeUpdate(query);
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to submit the data: ");}
 }
  public void insertIngredienttoStore(int ingreid, int quantity,String name) {

    String query = "INSERT INTO Store(ingreid, quantity, name) VALUES (?, ?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
       state.setInt(1, ingreid);
       state.setInt(2, quantity);
       state.setString(3, name);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
     
 }
   public ArrayList<Store> selectFromTableStore(){
     ArrayList<Store> list = new ArrayList();
     String query="SELECT * FROM Store;";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
         Store s= new Store(res.getInt("INGREID"),res.getInt("quantity"),res.getString("NAME"));
         list.add(s);
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return list;
 }
   public void altertablestore(int quantity,String name){
       String query="UPDATE store SET quantity = ? WHERE name = ?";
       try {
        connect();
        state= connection.prepareStatement(query);
       state.setInt(1, quantity);
       state.setString(2, name);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
       
   }
   public void deleteingre(String name){
     String query = "delete from Store where name='"+name+"'";
     try{
        connect();
       statement.executeUpdate(query);
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to submit the data: ");}
 }
   public void insertdescription(String itemMenu,ArrayList<Integer> id){
       for (int i = 0; i < id.size(); i++) {
      String query = "INSERT INTO compose(ingreid,name) VALUES (?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, id.get(i));
        state.setString(2,itemMenu);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
   }
   }
   public void deletedescription(String name){
     String query = "delete from compose where name='"+name+"'";
     try{
        connect();
       statement.executeUpdate(query);
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to submit the data: ");}
 }
   public void insertNewTable(int num,int seats) {

    String query = "INSERT INTO Tables(tabnum,nbrofseats) VALUES (?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, num);
        state.setInt(2, seats);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
     
 }
    public void deleteTable(int  tabnum){
     String query = "delete from tables where tabnum='"+tabnum+"'";
     try{
        connect();
       statement.executeUpdate(query);
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to submit the data: ");}
 }
   public ArrayList<Table> selectFromtable_Tables(){
     ArrayList<Table> list = new ArrayList();
     String query="SELECT * FROM tables;";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
          Table t = new Table(res.getInt("tabnum"),
         res.getInt("nbrofseats"),res.getBoolean("isavailable"));
          list.add(t);
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return list;
 }
    public void insertReservation(int resid, int tablenumber, String customername, String time, int nbrofguests) {

    String query = "INSERT INTO reservation(resid, customername, date,nbrseats,tabnum) VALUES (?,?,?,?,?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, resid);
        state.setString(2, customername);
        state.setString(3, time);
        state.setInt(4, nbrofguests);
        state.setInt(5, tablenumber);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
     
 }
    public void altertableTABLESandSetReserved(int tablenumber){
       String query="UPDATE tables SET isavailable = ? WHERE tabnum = ?";
       try {
        connect();
        state= connection.prepareStatement(query);
       state.setBoolean(1, true);
        state.setInt(2, tablenumber);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
       
   }
     public void altertableTABLESandSetunReserved(int tablenumber){
       String query="UPDATE tables SET isavailable = ? WHERE tabnum = ?";
       try {
        connect();
        state= connection.prepareStatement(query);
       state.setBoolean(1, false);
       state.setInt(2, tablenumber);
        state.executeUpdate();
        state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println("Failed to submit the data!!! ");
    }
       
   }
    public void insertOrder(int orderid,int resid,double totalamount){
       

    String query = "INSERT INTO orders(ID,price,resid) VALUES (?, ?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, orderid);
        state.setDouble(2, totalamount);
        state.setInt(3, resid);
       state.executeUpdate();
       state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println(s.getMessage());
    }
     
 }
     public void insertTotableConsistTheOrderItems(int orderid,String name,int quantity){
       

    String query = "INSERT INTO consist(ID,name,quantity) VALUES (?, ?, ?)";
    try {
        connect();
        state= connection.prepareStatement(query);
        state.setInt(1, orderid);
        state.setString(2,name );
        state.setInt(3, quantity);
       state.executeUpdate();
       state.close();
        disconnect();
    } catch (SQLException s) {
        System.out.println(s.getMessage());
    }
     
 }
     
    
   public String AltertabletoGetDescription(String name){
       String des="";
       String query="SELECT store.name FROM store,compose WHERE store.INGREID=compose.ingreid AND compose.name='"+name+"'";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
            des+=res.getString("name")+"\n";
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");} 
     return des;
   }
   public ArrayList<Integer> altertablemployeeToGetIds(){
       String query="Select empid from employee";
       ArrayList<Integer> ids=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           while(res.next()){
             ids.add(res.getInt("empid"));
           }
           disconnect();
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return ids;
   }
   public ArrayList<Integer> altertableStoretoGetids(){
       String query="Select INGREID from store;";
       ArrayList<Integer> ids=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           while(res.next()){
             ids.add(res.getInt("INGREID"));
           }
          disconnect(); 
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return ids;
   }
   public ArrayList<String> altertableMneuTogetNames(){
       String query="Select name from Menu;";
       ArrayList<String> names=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           while(res.next()){
             names.add(res.getString("name"));
           }
           disconnect();
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return names;
   }
    public ArrayList<Integer> altertableTablestogetNumber(){
       String query="Select tabnum from tables;";
       ArrayList<Integer> ids=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           while(res.next()){
             ids.add(res.getInt("tabnum"));
           }
           disconnect();
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return ids;
   }
     public ArrayList<String> AlterTableComposeTocheckDes(){
     ArrayList<String> n=new ArrayList();
     String query="SELECT name from compose";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
        while(res.next()){
           n.add(res.getString("name"));
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return n;
 }
       public ArrayList<Integer> altertablecConsistgetNumber(){
       String query="SELECT id FROM consist;";
       ArrayList<Integer> ids=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           while(res.next()){
             ids.add(res.getInt("id"));
           }
           disconnect();
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return ids;
   }
       public ArrayList<Integer> getOrderIdsOfATable(int resid){
            String query="SELECT id from orders where resid="+resid+";";
     ArrayList<Integer> ids=new ArrayList();
       try{
           connect();
           ResultSet res=statement.executeQuery(query);
           if(res.next()){
             ids.add(res.getInt("ID"));  
           }
           
        
           disconnect();
       }catch(SQLException e){
           System.out.println("Failed to get the data: ");
       }
       return ids;
   } 
       public ArrayList<Reservation> selectFromtable_Reservation(){
     ArrayList<Reservation> list = new ArrayList();
     String query="SELECT * FROM reservation;";
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
       
        while(res.next()){
          int resid=res.getInt("resid");
           int tablenumber=res.getInt("tabnum");
          String customername=res.getString("customername");
          String time=res.getString("date");
         int nbrofguests=res.getInt("nbrseats");
         Reservation r=new Reservation(resid,tablenumber,customername,time,nbrofguests);
          list.add(r);
        }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return list;
      }
       
   public ArrayList<String[]> SelectALLorders(){
         ArrayList<String[]> all=new ArrayList();
        String query="SELECT * from consist natural join orders;";
        
     try{
        connect();
        ResultSet res = statement.executeQuery(query);
       while(res.next()){
          String []row=new String [5];
          row[0]=res.getInt("ID")+"";
          row[1]=res.getString("NAME");
          row[2]=res.getInt("quantity")+"";
          row[3]=res.getInt("price")+"";
          row[4]=res.getInt("resid")+"";
          all.add(row);
          
      }
        disconnect();
        
     }catch(SQLException e){
     System.out.println("Failed to get the data: ");}
     return all;
     
      }
}
    

 

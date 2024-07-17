
package Controll;


import Model.Menu;
import Model.Order;
import Model.OrderItem;
import Model.Reservation;
import Model.Store;

import java.util.ArrayList;


public class ReservationAndOrderControll {
    ArrayList<Reservation>reservation=new ArrayList();
    ArrayList<OrderItem>items=new ArrayList();
    DataBaseAccess db=new DataBaseAccess();
   
   
    public boolean checkReservation(){
        if(reservation.isEmpty()){
            return false;
        }
        return true;
    }
    public void addReservation(int resid, int tablenumber, String customername, String time, int nbrofguests){
        Reservation r=new Reservation( resid,  tablenumber, customername, time, nbrofguests);
        reservation.add(r);
    }
     public String [][] filltablebyResevations(){
     
      String [][] table=new String [reservation.size()][3];
       for (int i = 0; i < reservation.size(); i++) {
           table[i][0]=reservation.get(i).getTablenumber()+"-"+reservation.get(i).getCustomername();
           table[i][1]=reservation.get(i).getNbrofguests()+"";
           table[i][2]=reservation.get(i).getTime();
          
       }
      return table;
   }
    public boolean checkRepetitionTable(int nbrTable){
         if(!reservation.isEmpty()){
          for (int i = 0; i <reservation.size(); i++) {
             if(reservation.get(i).getTablenumber()==nbrTable){
                 return false;
             }  
         }
          return true;
         }
         else{return true;}
            
     }
    public boolean checkRerservationID(int resid){
        if(!reservation.isEmpty()){
          for (int i = 0; i <reservation.size(); i++) {
             if(reservation.get(i).getResid()==resid){
                 return false;
             }  
         }
          return true;
         }
         else{return true;}
            
     }
      public void removerreservation(int index){
         reservation.remove(index);
  
     }
      public void submitReservation(int tablenumber){
          for (int i = 0; i < reservation.size(); i++) {
              if(reservation.get(i).getTablenumber()==tablenumber){
                  int resid=reservation.get(i).getResid();
                  String customername=reservation.get(i).getCustomername();
                  String time=reservation.get(i).getTime();
                  int nbrofguests=reservation.get(i).getNbrofguests();
                  db.insertReservation(resid, tablenumber, customername, time, nbrofguests);
                  break;
              }
          }
  
      }
      public int getTablenumberfromINdex(int row){
          return reservation.get(row).getTablenumber();
      }
     public void EditReservation(int choice,String newname,int index){
             switch(choice){
                 case 0:reservation.get(index).setCustomername(newname);
                 break;
                 case 1: reservation.get(index).setNbrofguests(Integer.parseInt(newname));
                 break;
                 case 2:reservation.get(index).setTime(newname);
             }
         
     }
     public String[]fillComboBoxByFood(){
      ArrayList<Menu>item= db.selectFromTableMenu();
      int count=0;
       for(int i=0;i<item.size();i++){
       if(item.get(i).getType().equals("food"))  { 
       count++;
       }
      }
      String[]stf=new String[count];
      for(int i=0,j=0;i<item.size();i++){
          if(item.get(i).getType().equals("food")){
           stf[j]=item.get(i).getItemname();
       j++;
          }
      }
      return stf;
  }
      public String[]fillComboBoxByDrink(){
      ArrayList<Menu>item= db.selectFromTableMenu();
      int count=0;
      for(int i=0;i<item.size();i++){
          if(item.get(i).getType().equals("drink"))
          count++;
      }
      String[]stf=new String[count];
      
      for(int i=0,j=0;i<item.size();i++){
          if(item.get(i).getType().equals("drink")){
          stf[j]=item.get(i).getItemname();
          j++;
          }
      }
      
      return stf;
  }
      public void addOrder(int tablenumber, String foodname, int quantity){
        OrderItem o=new OrderItem( tablenumber, foodname,  quantity); 
        items.add(o);
      }
      public double getPrice(String name){
           ArrayList<Menu>item= db.selectFromTableMenu();
           double p=0;
           for (int i = 0; i < item.size(); i++) {
              if(item.get(i).getItemname().equals(name)){
                  p=item.get(i).getPrice();
              }
          }
           return p;
      }
      public String printOrderItems(int tablenumber){
          String s="";
          for (int i = 0; i < items.size(); i++) {
              if(items.get(i).getTablenumber()==tablenumber){
                 s+=items.get(i).toString()+ getPrice(items.get(i).getFoodname())+"\n"; 
              }
         
          }
          return s;
      }
      public void removeOrderitem(String text,int tabnum){
          String []a=text.split("\t");
          for (int i = 0; i < items.size(); i++) {
              if(items.get(i).getTablenumber()==tabnum){
                   if(items.get(i).getFoodname().equals(a[1])){
                  items.remove(i);
                 }  
              }
           
          
      }
      }
       public double getTotalAmount(int tablenumber){
        double amount = 0.0;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getTablenumber()==tablenumber){
                String n=items.get(i).getFoodname();
                amount+=items.get(i).getQuantity()*getPrice(n);
            }
        }
        return amount;
    }
         public boolean findItem(String name){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getFoodname().equals(name)){
                return true;
            }
        }
        return false;
    }
         public void changeQuantity(String name,int quantity){
        for (int i = 0; i < items.size(); i++) {
            if( items.get(i).getFoodname().equals(name)){
                 items.get(i).setQuantity( items.get(i).getQuantity()+quantity);
            }
        }
    }
    
      
     public int GetResId(int tablenbr){
         int ResId=0;
         for (int i = 0; i <reservation.size(); i++) {
             if(reservation.get(i).getTablenumber()==tablenbr)
                 ResId=reservation.get(i).getResid();
         }
          return ResId;
     }
    
      
           public String[][] Voucher(int tn){
        int count=0;
    
        for (int i = 0; i < items.size(); i++) {
           if(items.get(i).getTablenumber()==tn){
               count++;
                
            }
        }
        String [][] Check=new String [count][3];
        
        for (int i = 0,j=0; i < items.size(); i++) {
           if(items.get(i).getTablenumber()==tn){
                Check[j][0]=items.get(i).getFoodname();
                Check[j][1]=items.get(i).getQuantity()+"";
                 Check[j][2]= getPrice(items.get(i).getFoodname())+"";
                 j++;
                
            }
        }
        return Check;
        }
      public boolean checkOrderItemList(){
          if(items.isEmpty()){
              return true;
          }
          return false;
      }
       public String getcustomerName(int TableNumber){
           String c="";
           
               for (int i = 0; i < reservation.size(); i++) {
               if(reservation.get(i).getTablenumber()==TableNumber){
                   c=reservation.get(i).getCustomername();
               }
           }
               return c;
          }
       public void submitOrder(int orderid,int resid,double totalamount){
          db.insertOrder(orderid, resid, totalamount);
           
       }
       public void insertOrderItem(int orderid,int tablenumber){
           for (int i = 0; i < items.size(); i++) {
               if(items.get(i).getTablenumber()==tablenumber){
                   String n=items.get(i).getFoodname();
                   int q=items.get(i).getQuantity();
                   db.insertTotableConsistTheOrderItems(orderid, n, q);
               }
           }
          
           
       }
       
        public boolean checkOrderID(int id){
           ArrayList<Integer> ids=db.altertablecConsistgetNumber();
           if(ids.isEmpty()){
               return true;
           }else{
               for (int i = 0; i < ids.size(); i++) {
                   if(ids.get(i)==id){
                       return false;
                   }
               }
           }
           return true;
           
       }
        public void SubmitOrder(int orderid,int resid,int tablenumber){
             db.insertOrder(orderid,resid,getTotalAmount(tablenumber));
        }
        public boolean checkIfOrderIsSubmited(int resid){
            
          ArrayList<Reservation> list=db.selectFromtable_Reservation();
          if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getResid()==resid){
                    return true;
                }
            }
            return false;
          }else{
           return false;   
          }
          
            
     
        }
         public void removeOrder(int tnumber){
        for (int i = items.size() - 1; i >= 0; i--) {
            if(items.get(i).getTablenumber()==tnumber){
               items.remove(i);
            }
        }
    }
          public void removeReservationWhenPay(int tnumber){
         for (int i = 0; i <reservation.size(); i++) {
             if(reservation.get(i).getTablenumber()==tnumber){
                reservation.remove(i);
             }
         }
          }
         public String [][]fillTableReservationFoRmanager(){
            ArrayList<Reservation> list=db.selectFromtable_Reservation();
            String [][]all=new String [list.size()][5];
             for (int i = 0; i <list.size(); i++) {
                 all[i][0]=list.get(i).getResid()+"";
                 all[i][1]=list.get(i).getCustomername();
                 all[i][2]=list.get(i).getTablenumber()+"";
                 all[i][3]=list.get(i).getNbrofguests()+"";
                 all[i][4]=list.get(i).getTime();
             }
             return all;
         } 
         public String [][] fillTableByALLOrders(){
             ArrayList<String[]>all= db.SelectALLorders();
             String [][] table=new String [all.size()][5];
             for (int i = 0; i < all.size(); i++) {
                 table[i]=all.get(i);
             }
             return table;
         }
         public String getType(String foodname){
         ArrayList<Menu>item= db.selectFromTableMenu();
         String d="";
         for (int i = 0; i < item.size(); i++) {
             if(item.get(i).getItemname().equals(foodname)){
                 d=item.get(i).getType();
             }
         }
         return d;
     }
         public void reduceQuantityInStore(int tablenumber){
          ArrayList <Store>store=db.selectFromTableStore();
        
              for (int i = 0; i <  items.size(); i++) {
                  String type=getType( items.get(i).getFoodname());
                  int q = items.get(i).getQuantity();
                if( items.get(i).getTablenumber()==tablenumber&&type.equals("food")){
                  String des = db.AltertabletoGetDescription(items.get(i).getFoodname());
                 String []s=des.split("\n");
                for (int j = 0; j < store.size(); j++) {
                        for (int k = 0; k < s.length; k++) {
                            if(store.get(j).getName().equalsIgnoreCase(s[k])){
                                store.get(j).setQuantity(store.get(j).getQuantity()-q);
                            }
                        }
                    }
                 }else if(items.get(i).getTablenumber()==tablenumber&&type.equals("drink")) {
                    for (int j = 0; j < store.size(); j++) {
                        if(store.get(j).getName().equalsIgnoreCase(items.get(i).getFoodname())){
                            store.get(j).setQuantity(store.get(j).getQuantity()-q);
                        }
                    }
             } 
              
             
         }
              for (int i = 0; i < store.size(); i++) {
                 db.altertablestore(store.get(i).getQuantity(), store.get(i).getName());
             }
            
     
     }
          
        
      
}

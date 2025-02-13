package lk.acpt.demofx;

import java.util.ArrayList;
import java.util.HashMap;

/* Author : pasindu
 place: ACPT student*/public class Demo {
     public static void main(String[] args) {
         Vehicle vehi = new Vehicle("Toyota","Corolla",5);
         System.out.println(vehi.brand());

         CustomerInterface cusInterface = new CustomerInterface() {
             @Override
             public void pay() {
                 System.out.println("Payinghgyu to customer");
             }

             @Override
             public void buy() {
                 System.out.println("Buying to customer");
             }

         };
         cusInterface.buy();
         cusInterface.pay();

         CustomerInterfce01 cusInterface2 = ()-> {

         };
         cusInterface2.showCustomer();

//arraylist interit from list interface
         ArrayList <String> list = new ArrayList();//generics
         list.add("Toyota");
         list.add("Corolla");
         list.add("10");


         //map
         HashMap map = new HashMap();
         map.put("name","pasindu");
         map.get("name");

         //with generics
         HashMap <Integer,Object>map2 = new HashMap();
         map2.put(1,"pasindu");
         map2.put(2,120);
         map2.put(3,"hedigalla");

     }
}

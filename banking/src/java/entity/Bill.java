/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author zeynep
 */
public class Bill {
      private String id;
     private boolean status;
     private String name;
      
     public String getId() {
          return id;
     }

     public boolean isStatus() {
          return status;
     }

     public String getName() {
          return name;
     }

     public void setId(String id) {
          this.id = id;
     }

     public void setStatus(boolean status) {
          this.status = status;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Bill(String id, boolean status, String name) {
          this.id = id;
          this.status = status;
          this.name = name;
     }

     public Bill() {
     }
 
}

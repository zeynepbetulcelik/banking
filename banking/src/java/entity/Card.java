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
public class Card {
    private String Cardno;
    private String id;
    private String limit;

     public String getCardno() {
          return Cardno;
     }

     public void setCardno(String Cardno) {
          this.Cardno = Cardno;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getLimit() {
          return limit;
     }

     public void setLimit(String limit) {
          this.limit = limit;
     }

     public Card() {
     }

     public Card(String Cardno, String id, String limit) {
          this.Cardno = Cardno;
          this.id = id;
          this.limit = limit;
     }
    
    
} 

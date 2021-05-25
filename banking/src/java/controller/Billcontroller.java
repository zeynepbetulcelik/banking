/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import model.DetailDb;

/**
 *
 * @author zeynep
 */
@ManagedBean(name="billcontroller")

public class Billcontroller {
   private DetailDb detaildb;
   private Bill bill;
   private ArrayList<String> billtypelist;
   public Billcontroller(){
     this.bill=new Bill();
     this.detaildb=new DetailDb();
     this.billtypelist=new ArrayList<>();
     
     this.billtypelist.add("TV");
     this.billtypelist.add("TELEFON");
     this.billtypelist.add("INTETRNET");
     this.billtypelist.add("ELEKTRIK");
     this.billtypelist.add("DOGALGAZ");
     this.billtypelist.add("SU");
     
     
     
     }

     public ArrayList<String> getBilltypelist() {
          return billtypelist;
     }

     public void setBilltypelist(ArrayList<String> billtypelist) {
          this.billtypelist = billtypelist;
     }

    

     public DetailDb getDetaildb() {
          return detaildb;
     }

     public void setDetaildb(DetailDb detaildb) {
          this.detaildb = detaildb;
     }

     public Bill getBill() {
          return bill;
     }

     public void setBill(Bill bill) {
          this.bill = bill;
     }
     public ResultSet getbills() throws SQLException{
     ResultSet rs=this.detaildb.getbill();
     return rs;
     
     } 
     public ResultSet getBillAmountbyType(String type) throws SQLException{
        return this.detaildb.getBillAmountByID(type);

     }
     
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.UUID;

/**
 *
 * @author zeynep
 */
public class Utils {
        public static String generateUUID(){
    String uniqueID=UUID.randomUUID().toString();
    return uniqueID;
    }
        
    public static void main(String args[]){
    System.out.println(generateUUID());
    System.out.print(generateUUID());
    }
}

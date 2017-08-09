/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author MBN USER
 */
public class Util {
    
    public static boolean validarEmail(String email){
        boolean correoValido = false;
        try{
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            correoValido = true;
        }catch(AddressException ex){
            System.err.println("Error validando el email: "+ ex);
        }
        return correoValido;
    }
    
}

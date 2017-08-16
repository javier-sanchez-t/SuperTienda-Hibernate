/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author MBN USER
 */
public class SendSMSUtil {

    public boolean enviarSMS(String numero) {

        // Find your Account Sid and Token at twilio.com/user/account
        String ACCOUNT_SID = "";
        String AUTH_TOKEN = "";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(numero),//to
                new PhoneNumber("+14157921150"),//from
                "Este es un mensaje de prueba! Desde mi Compu! :D").create();

        if (message.getSid() != null) {
            return true;
        } else {
            return false;
        }
    }
}

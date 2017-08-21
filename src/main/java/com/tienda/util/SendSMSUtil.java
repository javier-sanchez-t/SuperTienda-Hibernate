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

    public static boolean enviarSMS(String numero, String mensaje) {

        Twilio.init(StaticsConstants.ACCOUNT_SID, StaticsConstants.AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(numero),//to
                new PhoneNumber(StaticsConstants.TELEPHONE_NUMBER_SERVER),//from
                mensaje).create();

        if (message.getSid() != null) {
            return true;
        } else {
            return false;
        }
    }
}

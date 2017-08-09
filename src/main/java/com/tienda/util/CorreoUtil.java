/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreoUtil {

    private static final String CORREO = StaticConstans.CORREO;
    private static final String CONTRASENA = StaticConstans.CONTRASENA;
    private static final String REMITENTE = StaticConstans.REMITENTE;
    private static final String URL_IMAGEN = StaticConstans.URL_IMAGEN;

    public static boolean enviarCorreo(String direccionCorreo, String asunto, String contenido) {
        try {
            // Construir mensaje
            MimeMessage message = new MimeMessage(conexion());
            message.setFrom(new InternetAddress(CORREO, REMITENTE));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(direccionCorreo));

            //Asunto
            message.setSubject(asunto);

            //Contenido del mensaje
            message.setContent("<center><img src=\"" + URL_IMAGEN + "\" ></center>" + contenido, "text/html");

            // Envío
            Transport t = conexion().getTransport("smtp");
            t.connect(CORREO, CONTRASENA);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Session conexion() {
        String correo = CORREO;
        // Propiedades de la conexión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.mbn.com.mx");
        //props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", correo);
        props.setProperty("mail.smtp.auth", "true");
        // Preparar sesión
        Session session = Session.getDefaultInstance(props);
        return session;
    }

    public static boolean validarEmail(String email) {
        boolean correoValido = false;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            correoValido = true;
        } catch (AddressException ex) {
            System.err.println("Error validando el email: " + ex);
        }
        return correoValido;
    }

    

}

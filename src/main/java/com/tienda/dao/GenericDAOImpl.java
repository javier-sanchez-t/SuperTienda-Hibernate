/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.Usuarios;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MBN USER
 */
public class GenericDAOImpl implements GenericDAO<Object> {

    private Session sesion;
    Transaction transaction = null;

    public GenericDAOImpl(Session sesion) {
        this.sesion = sesion;
        
        //Se inicia la transacción si esta no es nula y no esta activa
        if (transaction!=null && !transaction.isActive()) {
            transaction = sesion.beginTransaction();
        }
    }

    @Override
    public boolean guardar(Object T) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean guardado = false;

        try {
            transaction = getSesion().beginTransaction();
            getSesion().saveOrUpdate(T);
            transaction.commit();
            guardado = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            guardado = false;
        }

        return guardado;
    }

    @Override
    public Usuarios login(String nombre_usuario, String contrasena) {
        Usuarios usuario = (Usuarios) getSesion().createSQLQuery("SELECT * FROM usuarios WHERE nombre_usuario=? AND contrasena=?")
                .addEntity(Usuarios.class)
                .setString(0, nombre_usuario)
                .setString(1, contrasena).uniqueResult();
        return usuario;
    }

    /**
     * @return the sesion
     */
    @Override
    public Session getSesion() {
        return sesion;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Session sesion) {
        this.sesion = sesion;
    }

}

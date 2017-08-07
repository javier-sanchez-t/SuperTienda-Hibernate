/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.CategoriasProductos;
import org.hibernate.Session;

/**
 *
 * @author MBN USER
 */
public class Categoria_producto_DAOImpl extends GenericDAOImpl implements Categoria_producto_DAO {

    public Categoria_producto_DAOImpl(Session sesion) {
        super(sesion);
    }

    @Override
    public boolean guardar(CategoriasProductos categoriasProductos) {
        return guardar(categoriasProductos);
    }

}

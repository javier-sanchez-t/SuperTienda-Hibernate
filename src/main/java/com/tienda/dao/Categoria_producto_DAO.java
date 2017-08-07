/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.CategoriasProductos;

/**
 *
 * @author MBN USER
 */
public interface Categoria_producto_DAO extends GenericDAO<Object>{
    boolean guardar(CategoriasProductos categoriasProductos);
}

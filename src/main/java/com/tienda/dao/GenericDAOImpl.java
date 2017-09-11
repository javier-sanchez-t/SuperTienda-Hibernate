/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.CategoriasProductos;
import com.tienda.entities.Productos;
import com.tienda.entities.Proveedores;
import com.tienda.entities.TiposUsuarios;
import com.tienda.entities.Usuarios;
import com.tienda.entities.Ventas;
import java.util.List;
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
        if (transaction != null && !transaction.isActive()) {
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
            getSesion().save(T);
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
    public boolean eliminar(int id, String nombreTabla, String nombreCampo) {
        Transaction transaction = null;
        boolean eliminado = false;

        try {
            transaction = getSesion().beginTransaction();
            getSesion().createSQLQuery("DELETE FROM " + nombreTabla + " WHERE " + nombreCampo + "=?")
                    .setInteger(0, id).executeUpdate();
            transaction.commit();
            eliminado = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            eliminado = false;
        }

        return eliminado;
    }
    
    @Override
    public boolean eliminar(String id, String nombreTabla, String nombreCampo) {
        Transaction transaction = null;
        boolean eliminado = false;

        try {
            transaction = getSesion().beginTransaction();
            getSesion().createSQLQuery("DELETE FROM " + nombreTabla + " WHERE " + nombreCampo + "=?")
                    .setString(0, id).executeUpdate();
            transaction.commit();
            eliminado = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            eliminado = false;
        }

        return eliminado;
    }

    @Override
    public boolean actualizar(Object T) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean guardado = false;

        try {
            transaction = getSesion().beginTransaction();
            getSesion().update(T);
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

    @Override
    public List<Usuarios> buscarUsuarios(String parametros) {
        List<Usuarios> usuarios = (List<Usuarios>) getSesion().createSQLQuery("SELECT * FROM usuarios" + parametros)
                .addEntity(Usuarios.class).list();
        return usuarios;
    }

    @Override
    public Usuarios buscarUsuarioPorId(int usuarioId) {
        Usuarios usuario = (Usuarios) getSesion().createSQLQuery("SELECT * FROM usuarios WHERE usuario_id=?")
                .addEntity(Usuarios.class)
                .setInteger(0, usuarioId).uniqueResult();
        return usuario;
    }

    @Override
    public List<TiposUsuarios> buscarTodosTiposUsuarios() {
        return getSesion().createCriteria(TiposUsuarios.class).list();
    }

    @Override
    public List<Proveedores> buscarTodosProveedores() {
        return getSesion().createCriteria(Proveedores.class).list();
    }

    @Override
    public List<Proveedores> buscarProveedores(String parametros) {
        List<Proveedores> proveedores = getSesion().createSQLQuery("SELECT * FROM proveedores" + parametros)
                .addEntity(Proveedores.class).list();
        return proveedores;
    }

    @Override
    public Proveedores buscarProveedorPorid(int proveedorId) {
        return (Proveedores) getSesion().createSQLQuery("SELECT * FROM proveedores WHERE proveedor_id=?")
                .addEntity(Proveedores.class)
                .setInteger(0, proveedorId).uniqueResult();
    }

    @Override
    public List<CategoriasProductos> buscarTodasCategoriasProductos() {
        return getSesion().createCriteria(CategoriasProductos.class).list();
    }

    @Override
    public List<CategoriasProductos> buscarCategoriasProductos(String parametros) {
        return getSesion().createSQLQuery("SELECT * FROM categorias_productos" + parametros)
                .addEntity(CategoriasProductos.class).list();
    }

    @Override
    public CategoriasProductos buscarCategoriaProductoPorId(int categoriaProdId) {
        return (CategoriasProductos) getSesion().createSQLQuery("SELECT * FROM categorias_productos WHERE categoria_producto_id=?")
                .addEntity(CategoriasProductos.class)
                .setInteger(0, categoriaProdId).uniqueResult();
    } 

    @Override
    public Productos
            buscarProductoPorCodigo(String codigo) {
        Productos producto = (Productos) getSesion().createSQLQuery("SELECT * FROM productos WHERE producto_id=?")
                .addEntity(Productos.class
                )
                .setString(0, codigo).uniqueResult();
        return producto;
    }

    @Override
    public List<Productos> buscarTodosProductos() {
        return getSesion().createCriteria(Productos.class
        ).list();
    }

    @Override
    public void actualizarExistenciaProducto(String productoId, int numProductos) {
        Productos producto = buscarProductoPorCodigo(productoId);
        producto.setExistencia(producto.getExistencia() - numProductos);
        guardar(producto);
    }

    @Override
    public List<Productos> buscarProductos(String parametros) {
        return getSesion().createSQLQuery("SELECT * FROM productos" + parametros)
                .addEntity(Productos.class
                ).list();
    }

    @Override
    public List<Ventas> buscarVentasEntreFechas(String fechaInicio, String fechaFin) {
        String SQL_WHERE = " WHERE 1=1";
        if (fechaInicio.equals(fechaFin)) {
            SQL_WHERE += " AND fecha='" + fechaInicio + "'";
        } else {
            SQL_WHERE += " AND fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";

        }
        List<Ventas> ventas = getSesion().createSQLQuery("SELECT * FROM ventas" + SQL_WHERE)
                .addEntity(Ventas.class
                ).list();
        return ventas;
    }

    @Override
    public List<Object[]> buscarVentasPorAnio(String anio) {
        String SQL = "SELECT * FROM (SELECT extract(month from fecha) as mes, "
                + "extract(year from fecha) as anio, "
                + "sum(\"monto\") as \"monto\" "
                + "FROM ventas GROUP BY fecha) AS historial_ventas WHERE anio=" + anio + " ORDER BY mes";
        List<Object[]> ventas = getSesion().createSQLQuery(SQL).list();
        return ventas;
    }

    @Override
    public List<Object[]> buscarVentasPorUsuario(String fechaInicio, String fechaFin) {
        String SQL_WHERE = " WHERE 1=1";
        if (fechaInicio.equals(fechaFin)) {
            SQL_WHERE += " AND fecha='" + fechaInicio + "'";
        } else {
            SQL_WHERE += " AND fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
        }
        String SQL = "SELECT historial.usuario_id, historial.monto, nombre, apellido_p FROM "
                + "(SELECT usuario_id, sum(\"monto\") as \"monto\" FROM ventas " + SQL_WHERE + " GROUP BY usuario_id) "
                + "AS historial "
                + "LEFT JOIN usuarios ON historial.usuario_id=usuarios.usuario_id";
        List<Object[]> ventas = getSesion().createSQLQuery(SQL).list();
        return ventas;
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

package com.tienda.entities;
// Generated 20/08/2017 06:27:03 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Proveedores generated by hbm2java
 */
public class Proveedores  implements java.io.Serializable {


     private int proveedorId;
     private String nombre;
     private String email;
     private String telefono;
     private boolean notificacion;
     private Set productoses = new HashSet(0);

    public Proveedores() {
    }

	
    public Proveedores(int proveedorId, String nombre, String email, String telefono, boolean notificacion) {
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.notificacion = notificacion;
    }
    public Proveedores(int proveedorId, String nombre, String email, String telefono, boolean notificacion, Set productoses) {
       this.proveedorId = proveedorId;
       this.nombre = nombre;
       this.email = email;
       this.telefono = telefono;
       this.notificacion = notificacion;
       this.productoses = productoses;
    }
   
    public int getProveedorId() {
        return this.proveedorId;
    }
    
    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public boolean isNotificacion() {
        return this.notificacion;
    }
    
    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }
    public Set getProductoses() {
        return this.productoses;
    }
    
    public void setProductoses(Set productoses) {
        this.productoses = productoses;
    }




}



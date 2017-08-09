/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.dao.GenericDAO;
import com.tienda.entities.TiposUsuarios;
import com.tienda.entities.Usuarios;
import com.tienda.util.CorreoUtil;
import com.tienda.util.StaticConstans;
import com.tienda.util.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MBN USER
 */
public class Administracion_usuarios extends javax.swing.JInternalFrame {

    private GenericDAO dao;
    public List<TiposUsuarios> tiposUsuarios;

    /**
     * Creates new form Administracion_usuarios
     */
    public Administracion_usuarios(GenericDAO dao) {
        initComponents();

        //Se recibe el dao desde el jframe inicio
        this.dao = dao;

        //Se agregan los items de los tipos de usuarios
        tiposUsuarios = dao.buscarTodosTiposUsuarios();
        for (TiposUsuarios tipoUsuario : tiposUsuarios) {
            comboTiposUsuarios.addItem(tipoUsuario.getNombre());
        }
    }

    public void limpiarCampos() {
        txtEmail.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        comboTiposUsuarios.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detalle_admin_usuarios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        comboTiposUsuarios = new javax.swing.JComboBox<>();
        opciones = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administración de usuarios");

        detalle_admin_usuarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del usuario"));

        jLabel1.setText("*Email:");

        jLabel2.setText("*Nombre:");

        jLabel3.setText("*Apellido paterno:");

        jLabel5.setText("*Apellido materno:");

        jLabel4.setText("*Tipo usuario:");

        comboTiposUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar ---" }));

        javax.swing.GroupLayout detalle_admin_usuariosLayout = new javax.swing.GroupLayout(detalle_admin_usuarios);
        detalle_admin_usuarios.setLayout(detalle_admin_usuariosLayout);
        detalle_admin_usuariosLayout.setHorizontalGroup(
            detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalle_admin_usuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detalle_admin_usuariosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtNombre)))
                    .addGroup(detalle_admin_usuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidoP)
                            .addComponent(txtApellidoM)
                            .addComponent(comboTiposUsuarios, 0, 180, Short.MAX_VALUE))))
                .addContainerGap())
        );
        detalle_admin_usuariosLayout.setVerticalGroup(
            detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalle_admin_usuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalle_admin_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTiposUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnguardar.setText("Guargar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detalle_admin_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detalle_admin_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String EMAIL = txtEmail.getText().trim();
        String NOMBRE = txtNombre.getText().trim();
        String APELLIDO_P = txtApellidoP.getText().trim();
        String APELLIDO_M = txtApellidoM.getText().trim();
        int TIPO_USUARIO = comboTiposUsuarios.getSelectedIndex();

        if (!"".equals(EMAIL) && !"".equals(NOMBRE) && !"".equals(APELLIDO_P) && !"".equals(APELLIDO_M) && TIPO_USUARIO != 0) {
            //Se valida el email
            if (CorreoUtil.validarEmail(EMAIL)) {
                Random numberRandom = new Random();
                String CONTRASENA = EMAIL + numberRandom.nextInt(10000) + 1;
                String CONTRASENA_ENCRIPTADA = Util.encriptarContrasena(CONTRASENA);

                TiposUsuarios tipoUsuario = new TiposUsuarios();
                tipoUsuario = tiposUsuarios.get(comboTiposUsuarios.getSelectedIndex() - 1);

                Usuarios usuario = new Usuarios();
                usuario.setNombreUsuario(EMAIL);
                usuario.setContrasena(CONTRASENA_ENCRIPTADA);
                usuario.setNombre(NOMBRE);
                usuario.setApellidoP(APELLIDO_P);
                usuario.setApellidoM(APELLIDO_M);
                usuario.setTiposUsuarios(tipoUsuario);

                //Se guarda al usuario
                if (dao.guardar(usuario)) {
                    JOptionPane.showMessageDialog(this, "Usuario registrado satisfactoriamente", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();

                    //Se envia correo con contrasena
                    String contenido = "<p style=\"font-family: Helvetica,sans-serif; font-size:30px; color:#505050; padding:20px 20px 0px 20px\" >" + StaticConstans.MENSAJE_CORREO_ENCABEZADO + "</p>";
                    contenido += "<p style=\"font-family: Helvetica,sans-serif; font-size: 13px; line-height: 150%; color: #505050; padding: 20px 20px 0px 20px;\">" + StaticConstans.MENSAJE_CORREO_CUERPO + "<b>" + CONTRASENA + "</b></p>";
                    contenido += "<p style=\"font-family: Helvetica,sans-serif; font-size: 13px; line-height: 150%; color: #505050; padding: 20px 20px 0px 20px;\">" + StaticConstans.MENSAJE_CORREO_PIE + "</p>";
                    boolean correoEnviado = CorreoUtil.enviarCorreo(usuario.getNombreUsuario(), StaticConstans.ASUNTO, contenido);
                    if (correoEnviado) {
                        JOptionPane.showMessageDialog(this, "La contraseña para ingresar al sistema, se envió vía email", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "La contraseña para ingresar al sistema es: " + usuario.getContrasena(), "Éxito!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar al usuario", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un email valido", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese los campos requeridos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> comboTiposUsuarios;
    private javax.swing.JPanel detalle_admin_usuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel opciones;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

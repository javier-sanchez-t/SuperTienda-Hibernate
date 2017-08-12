/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.dao.GenericDAO;
import com.tienda.entities.Usuarios;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author MBN USER
 */
public class Inicio extends javax.swing.JFrame {

    private GenericDAO dao;

    /**
     * Creates new form Inicio
     */
    public Inicio(GenericDAO dao, Usuarios usuario) throws IOException {
        //Se maximiza el Jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Super tienda");
        initComponents();

        //Se recibe el dao creado en login (el dao ya contiene la sesión necesaria, para conulta a BD)
        this.dao = dao;

        //Se cierra la sesión al cerrar la ventana
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dao.getSesion().close();
            }
        });
        
        //Se deshabilita la opción administración para usuarios no administradores
        if(usuario.getTiposUsuarios().getTipoUsuarioId()==2){
            menuAdministracion.setVisible(false);
        }

        lblUsuario.setText("BIENVENIDO: " + usuario.getNombre().toUpperCase() + " " + usuario.getApellidoP().toUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelEscritorio = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        Menus = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        iMenuCerrarSesion = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        iMenuRegistroVentas = new javax.swing.JMenuItem();
        menuAdministracion = new javax.swing.JMenu();
        imenuUsuarios = new javax.swing.JMenuItem();
        iMenuProveedores = new javax.swing.JMenuItem();
        iMenuCategorias = new javax.swing.JMenuItem();
        iMenuProductos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameInicio"); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("usuario ");

        PanelEscritorio.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PanelEscritorioLayout = new javax.swing.GroupLayout(PanelEscritorio);
        PanelEscritorio.setLayout(PanelEscritorioLayout);
        PanelEscritorioLayout.setHorizontalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscritorioLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblUsuario)
                .addContainerGap(544, Short.MAX_VALUE))
        );
        PanelEscritorioLayout.setVerticalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEscritorioLayout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(30, 30, 30))
        );

        menuArchivo.setText("Archivo");

        iMenuCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        iMenuCerrarSesion.setText("Cerrar sesión");
        iMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMenuCerrarSesionActionPerformed(evt);
            }
        });
        menuArchivo.add(iMenuCerrarSesion);

        Menus.add(menuArchivo);

        menuVentas.setText("Ventas");

        iMenuRegistroVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        iMenuRegistroVentas.setText("Registro de ventas");
        iMenuRegistroVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMenuRegistroVentasActionPerformed(evt);
            }
        });
        menuVentas.add(iMenuRegistroVentas);

        Menus.add(menuVentas);

        menuAdministracion.setText("Administración");

        imenuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        imenuUsuarios.setText("Usuarios");
        imenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imenuUsuariosActionPerformed(evt);
            }
        });
        menuAdministracion.add(imenuUsuarios);

        iMenuProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        iMenuProveedores.setText("Proveedores");
        iMenuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMenuProveedoresActionPerformed(evt);
            }
        });
        menuAdministracion.add(iMenuProveedores);

        iMenuCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        iMenuCategorias.setText("Categorías de productos");
        iMenuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMenuCategoriasActionPerformed(evt);
            }
        });
        menuAdministracion.add(iMenuCategorias);

        iMenuProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        iMenuProductos.setText("Productos");
        iMenuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMenuProductosActionPerformed(evt);
            }
        });
        menuAdministracion.add(iMenuProductos);

        Menus.add(menuAdministracion);

        setJMenuBar(Menus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iMenuRegistroVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMenuRegistroVentasActionPerformed
        Registro_ventas registro_ventas = new Registro_ventas(dao);
        PanelEscritorio.add(registro_ventas);
        registro_ventas.show();
    }//GEN-LAST:event_iMenuRegistroVentasActionPerformed

    private void iMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMenuCerrarSesionActionPerformed
        setVisible(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_iMenuCerrarSesionActionPerformed

    private void iMenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMenuProductosActionPerformed
        Administracion_productos administracion_productos = new Administracion_productos(dao);
        PanelEscritorio.add(administracion_productos);
        administracion_productos.show();
    }//GEN-LAST:event_iMenuProductosActionPerformed

    private void iMenuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMenuProveedoresActionPerformed
        Administracion_proveedores administracion_proveedores = new Administracion_proveedores(dao);
        PanelEscritorio.add(administracion_proveedores);
        administracion_proveedores.show();
    }//GEN-LAST:event_iMenuProveedoresActionPerformed

    private void imenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imenuUsuariosActionPerformed
        Administracion_usuarios administracion_usuarios = new Administracion_usuarios(dao);
        PanelEscritorio.add(administracion_usuarios);
        administracion_usuarios.show();
    }//GEN-LAST:event_imenuUsuariosActionPerformed

    private void iMenuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMenuCategoriasActionPerformed
        Administracion_cat_productos admin_cat_product = new Administracion_cat_productos(dao);
        PanelEscritorio.add(admin_cat_product);
        admin_cat_product.show();
    }//GEN-LAST:event_iMenuCategoriasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menus;
    private javax.swing.JDesktopPane PanelEscritorio;
    private javax.swing.JMenuItem iMenuCategorias;
    private javax.swing.JMenuItem iMenuCerrarSesion;
    private javax.swing.JMenuItem iMenuProductos;
    private javax.swing.JMenuItem iMenuProveedores;
    private javax.swing.JMenuItem iMenuRegistroVentas;
    private javax.swing.JMenuItem imenuUsuarios;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuVentas;
    // End of variables declaration//GEN-END:variables

}

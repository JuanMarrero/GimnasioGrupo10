package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class gestionSocio extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modeloTabla;
    private SocioData sData=new SocioData();
    private Socios socioActual=null;
    

    public gestionSocio() {
        
        modeloTabla = new DefaultTableModel();
        initComponents();
        armarCabeceraTabla();
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textDNI = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonAlta = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Gestion Socios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Por ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 55, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Por DNI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 145, -1, -1));
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 57, 177, -1));
        getContentPane().add(textDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 147, 177, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 247, -1, 88));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 94, -1, -1));

        botonEliminar.setText("Dar de baja");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 412, -1, -1));

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 412, -1, -1));

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(botonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 412, -1, -1));

        botonAlta.setText("Dar de Alta");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });
        getContentPane().add(botonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 412, -1, -1));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 550, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        modeloTabla.setRowCount(0);
        socioActual=null;
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
      try {
        // Limpiar la tabla antes de agregar nuevos datos
        modeloTabla.setRowCount(0);
        
        if (!textID.getText().isEmpty()) {
            // Buscar por ID
            int id = Integer.parseInt(textID.getText());
            Socios socioEncontrado = sData.buscarSocio(id);
            agregarSocioATabla(socioEncontrado);
        } else if (!textDNI.getText().isEmpty()) {
            // Buscar por DNI
            int dni = Integer.parseInt(textDNI.getText());
            Socios socioEncontrado = sData.buscarSocioXDni(dni);
            agregarSocioATabla(socioEncontrado);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor en al menos un campo de búsqueda.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un número válido en los campos de ID o DNI.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al buscar socio.");
        ex.printStackTrace();
     }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow != -1) {
        int idSocio = Integer.parseInt(modeloTabla.getValueAt(selectedRow, 0).toString());
        sData.borrarSocio(idSocio);
        socioActual = null;
        limpiarCampos();
        modeloTabla.setRowCount(0);
    } else {
        JOptionPane.showMessageDialog(this, "NO HAY SOCIOS SELECCIONADOS");
    }

    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1){
            int idSocio = Integer.parseInt(modeloTabla.getValueAt(selectedRow, 0).toString());
            sData.altaSocio(idSocio);
            socioActual = null;
            limpiarCampos();
            modeloTabla.setRowCount(0);
        }else{
            JOptionPane.showMessageDialog(this, "NO HAY SOCIOS SELECCIONADOS");
        }
    }//GEN-LAST:event_botonAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField textDNI;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos(){
        
        textDNI.setText("");
        textID.setText("");
        
    }
    
    private void armarCabeceraTabla(){
        ArrayList <Object> filaCabecera = new ArrayList<>();
        
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Apellido");
        filaCabecera.add("DNI");
        filaCabecera.add("Edad");
        filaCabecera.add("Estado");
        for(Object it: filaCabecera){
            modeloTabla.addColumn(it);
        }
        
        jTable2.setModel(modeloTabla);
    }
    
    private void agregarSocioATabla(Socios socio) {
    if (socio != null) {
        modeloTabla.addRow(new Object[]{socio.getID_Socio(), socio.getNombre(), socio.getApellido(), socio.getDNI(), socio.getEdad(), socio.isEstado()});
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró ningún socio.");
    }
}
    
    

}

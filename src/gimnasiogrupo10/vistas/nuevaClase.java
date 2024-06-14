/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.Clases;
import gimnasiogrupo10.entidades.Entrenadores;
import java.awt.HeadlessException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class nuevaClase extends javax.swing.JInternalFrame {
    
    private ClasesData clasesData = new ClasesData();
    private EntrenadoresData entrenadoresData = new EntrenadoresData();
    
    List<Clases> listaC;
    List<Entrenadores> listaE;
    public nuevaClase() {
        
        initComponents();
        
        listaC = clasesData.listarClases();
        listaE = entrenadoresData.listarEntrenadores();
        
        cargarEntrenadores();
        cargarHorariosDisponibles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textCapacidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbActivo = new javax.swing.JRadioButton();
        botonGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboEntrenadores = new javax.swing.JComboBox<>();
        comboHorario = new javax.swing.JComboBox<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Clase");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 0, -1, -1));

        jLabel2.setText("Nombre de la Clase:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 46, -1, -1));
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 42, 193, -1));

        jLabel3.setText("Capacidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 92, -1, -1));
        getContentPane().add(textCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 88, 108, -1));

        jLabel4.setText("Horario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 135, -1, -1));

        jLabel5.setText("Entrenador");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 185, -1, -1));

        jLabel6.setText("Estado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 248, -1, -1));

        rbActivo.setText("Activo");
        getContentPane().add(rbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 242, -1, -1));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 312, -1, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 312, -1, -1));

        getContentPane().add(comboEntrenadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 180, 193, -1));

        comboHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(comboHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 130, 193, -1));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 480, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try {
        String nombre = textNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
            return;
        }

        int capacidad;
        try {
            capacidad = Integer.parseInt(textCapacidad.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un número válido");
            return;
        }

        LocalTime horario = (LocalTime) comboHorario.getSelectedItem();
        if (horario == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un horario", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Entrenadores entrenadorSeleccionado = (Entrenadores) comboEntrenadores.getSelectedItem();
        if (entrenadorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un entrenador");
            return;
        }

        boolean estado = rbActivo.isSelected();

        Clases clase = new Clases();
        clase.setNombre(nombre);
        clase.setCapacidad(capacidad);
        clase.setHorario(horario);
        clase.setEntrenadores(entrenadorSeleccionado);
        clase.setEstado(estado);

        clasesData.guardarClase(clase);

        JOptionPane.showMessageDialog(this, "Clase guardada con éxito!");
        limpiarFormulario();
    } catch (HeadlessException ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

 
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboHorarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<Entrenadores> comboEntrenadores;
    private javax.swing.JComboBox<LocalTime> comboHorario;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JTextField textCapacidad;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables

 private void cargarEntrenadores(){
     
     for (Entrenadores entrenadores : listaE){
         comboEntrenadores.addItem(entrenadores);
     }
             
     
 }

 private void limpiarFormulario() {
        textNombre.setText("");
        textCapacidad.setText("");
        comboHorario.setSelectedIndex(0);
        comboEntrenadores.setSelectedIndex(0);
        rbActivo.setSelected(true);
    }

             private void cargarHorariosDisponibles() {
        List<LocalTime> horarios = clasesData.listarHorariosDisponibles();
        comboHorario.removeAllItems();
        for (LocalTime horario : horarios) {
            comboHorario.addItem(horario);
        }
    }
}

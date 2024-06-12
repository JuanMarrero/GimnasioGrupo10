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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Clase");

        jLabel2.setText("Nombre de la Clase:");

        jLabel3.setText("Capacidad:");

        jLabel4.setText("Horario");

        jLabel5.setText("Entrenador");

        jLabel6.setText("Estado");

        rbActivo.setText("Activo");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(botonGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(rbActivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNombre)
                                    .addComponent(textCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboEntrenadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboHorario, 0, 193, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

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

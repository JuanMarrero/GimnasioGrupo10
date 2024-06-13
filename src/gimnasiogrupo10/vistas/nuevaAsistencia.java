package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;


public class nuevaAsistencia extends javax.swing.JInternalFrame {

    private AsistenciaData asistenciaData;
    private SocioData socioData;
    private ClasesData clasesData;
    
    public nuevaAsistencia() {        
        initComponents();
        LocalDate fechaActual = LocalDate.now();
        String textoFechaActual = fechaActual.toString();
        jLabel5.setText("Fecha: " + textoFechaActual);
        asistenciaData = new AsistenciaData();
        socioData = new SocioData();
        clasesData = new ClasesData();
        
        cargarClases();
        cargarHorarios();         
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textDNI = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        textSocio = new javax.swing.JTextField();
        comboClase = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboHorario = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Control Asistencia");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("DNI");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        textSocio.setText("Apellido y nombre del Socio");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Clase");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Horario");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha: 13/06/2024 ");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(botonBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(botonGuardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(comboHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(18, 18, 18)
                .addComponent(textSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(jButton1))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
     try {
            // Obtener el DNI del campo de texto
            int dni = Integer.parseInt(textDNI.getText());
            
            // Buscar al socio por su DNI
            Socios socio = socioData.buscarSocioXDni(dni);
            
            if (socio != null) {
                // Mostrar el nombre completo del socio en el campo de texto correspondiente
                textSocio.setText(socio.getApellido() + " " + socio.getNombre());
            } else {
                // Mostrar un mensaje de error si el socio no fue encontrado
                JOptionPane.showMessageDialog(this, "Socio no encontrado");
            }
        } catch (NumberFormatException ex) {
            // Mostrar un mensaje de error si el DNI ingresado no es válido
            JOptionPane.showMessageDialog(this, "Debe ingresar un número válido en el campo DNI");
        }
        
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
try {
    // Obtener el socio seleccionado
    int dni = Integer.parseInt(textDNI.getText());
    Socios socio = socioData.buscarSocioXDni(dni);

    if (socio != null) {
        // Obtener el nombre de la clase seleccionada
        String nombreClaseSeleccionada = (String) comboClase.getSelectedItem();

        // Buscar el objeto Clases correspondiente en la lista
        Clases claseSeleccionada = null;
        for (Clases clase : clasesData.listarClasesActivas()) {
            if (clase.getNombre().equals(nombreClaseSeleccionada)) {
                claseSeleccionada = clase;
                break; // No es necesario continuar el bucle una vez encontrada la clase
            }
        }

        if (claseSeleccionada != null) {
            // Obtener la fecha de asistencia actual
            LocalDate fechaAsistencia = LocalDate.now();

            // Guardar la nueva asistencia en la base de datos
            asistenciaData.registrarAsistencia(new Asistencia(socio, claseSeleccionada, fechaAsistencia));

            // Restar un pase al socio
            socioData.restarPase(socio.getID_Socio());

            // Decrementar la capacidad de la clase
            clasesData.decrementarCapacidad(claseSeleccionada.getID_Clase());

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Asistencia registrada correctamente");
        } else {
            // Mostrar un mensaje de error si no se encuentra la clase seleccionada
            JOptionPane.showMessageDialog(this, "Clase seleccionada no encontrada");
        }
    } else {
        // Mostrar un mensaje de error si el socio no fue encontrado
        JOptionPane.showMessageDialog(this, "Socio no encontrado");
    }
} catch (NumberFormatException ex) {
    // Mostrar un mensaje de error si el DNI ingresado no es válido
    JOptionPane.showMessageDialog(this, "Debe ingresar un número válido en el campo DNI");
} catch (Exception ex) {
    // Mostrar un mensaje de error genérico si ocurre un error al guardar la asistencia
    JOptionPane.showMessageDialog(this, "Error al guardar la asistencia");
    ex.printStackTrace();
}
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<String> comboClase;
    private javax.swing.JComboBox<LocalTime> comboHorario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textDNI;
    private javax.swing.JTextField textSocio;
    // End of variables declaration//GEN-END:variables

    private void cargarClases() {
        // Obtener la lista de clases disponibles
        List<Clases> clasesDisponibles = clasesData.listarClasesActivas();
        
        // Limpiar el combo de clases
        comboClase.removeAllItems();
        
        // Llenar el combo de clases con las clases disponibles
        for (Clases clase : clasesDisponibles) {
            comboClase.addItem(clase.getNombre());
        }
    }
    
    private void cargarHorarios() {
        // Obtener la lista de horarios disponibles
        List<LocalTime> horariosDisponibles = clasesData.listarHorariosDisponibles();
        
        // Limpiar el combo de horarios
        comboHorario.removeAllItems();
        
        // Llenar el combo de horarios con los horarios disponibles
        for (LocalTime horario : horariosDisponibles) {
            comboHorario.addItem(horario);
        }
    }    



}

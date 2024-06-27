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

        jLabel3 = new javax.swing.JLabel();
        textDNI = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textSocio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboClase = new javax.swing.JComboBox<>();
        comboHorario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("DNI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 58, -1, -1));
        getContentPane().add(textDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 56, 139, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 52, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Control Asistencia");

        jLabel5.setText("Fecha: 13/06/2024 ");

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

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(textSocio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboClase, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboHorario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(46, 46, 46))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(botonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(84, 84, 84))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(83, 83, 83)
                .addComponent(textSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(63, 63, 63)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(jButton1))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 490, 390));

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
        
        int pasesRestantes = socioData.obtenerCantidadPases(socio.getID_Socio());
        if (pasesRestantes <= 0 ){
            JOptionPane.showMessageDialog(this, "Usted no tiene pases disponibles");
            return;
        }
        
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
    private javax.swing.JDesktopPane jDesktopPane1;
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

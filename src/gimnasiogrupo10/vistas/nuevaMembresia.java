
package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.*;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class nuevaMembresia extends javax.swing.JInternalFrame {
    
    private SocioData socioData;
    private ClasesData clasesData;
    private MembresiasData membresiasData;

    public nuevaMembresia() {
        
        initComponents();
        
        socioData = new SocioData();
        clasesData = new ClasesData();
        membresiasData = new MembresiasData();
        
        cargarClases();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textSocio = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        textresultado = new javax.swing.JTextField();
        comboPases = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateInscripcion = new com.toedter.calendar.JDateChooser();
        dateVencimiento = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textCosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboClase = new javax.swing.JComboBox<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nueva Membresia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID SOCIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 50, 81, -1));
        getContentPane().add(textSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 48, 158, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 44, -1, -1));
        getContentPane().add(textresultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 94, 284, -1));

        comboPases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "12", "20" }));
        getContentPane().add(comboPases, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 140, 62, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Pases");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 143, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Inscripcion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 269, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Vencimiento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 342, -1, -1));
        getContentPane().add(dateInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 269, -1, -1));
        getContentPane().add(dateVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 332, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 382, -1, -1));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 382, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Costo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 186, -1, -1));
        getContentPane().add(textCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 184, 95, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Clase");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 143, -1, -1));

        getContentPane().add(comboClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 98, -1));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 470, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
             try {
            int idSocio = Integer.parseInt(textSocio.getText());
            Socios socio = socioData.buscarSocio(idSocio);
            if (socio != null) {
                textresultado.setText(socio.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Socio no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar socio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
     try {
        // Obtener datos de la interfaz
        int idSocio = Integer.parseInt(textSocio.getText());
        int cantidadPases = Integer.parseInt(comboPases.getSelectedItem().toString());
        double costo = Double.parseDouble(textCosto.getText().trim());
        Date fechaInscripcion = dateInscripcion.getDate();
        Date fechaVencimiento = dateVencimiento.getDate();

        // Validación simple de datos
        if (idSocio <= 0 || costo <= 0 || fechaInscripcion == null || fechaVencimiento == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios y deben ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear instancia de Membresia
        Socios socio = socioData.buscarSocio(idSocio);
        if (socio == null) {
            JOptionPane.showMessageDialog(this, "Socio no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Clases clase = (Clases) comboClase.getSelectedItem();
        int idClase = clase.getID_Clase();
        Membresias membresia = new Membresias(socio, clase, costo, cantidadPases, fechaInscripcion, fechaVencimiento, true);

        // Guardar la membresía en la base de datos
        membresiasData.guardarInscripcion(membresia);

        JOptionPane.showMessageDialog(this, "Membresía guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la membresía: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
  
        
    }//GEN-LAST:event_botonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<Clases> comboClase;
    private javax.swing.JComboBox<String> comboPases;
    private com.toedter.calendar.JDateChooser dateInscripcion;
    private com.toedter.calendar.JDateChooser dateVencimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textCosto;
    private javax.swing.JTextField textSocio;
    private javax.swing.JTextField textresultado;
    // End of variables declaration//GEN-END:variables

    private void cargarClases() {
        try {
            List<Clases> clases = clasesData.listarClases(); // Obtener la lista de clases desde la base de datos
            for (Clases clase : clases) {
                comboClase.addItem(clase);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las clases: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

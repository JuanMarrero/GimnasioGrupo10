package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.AsistenciaData;
import gimnasiogrupo10.AccesoADatos.ClasesData;
import gimnasiogrupo10.AccesoADatos.EntrenadoresData;
import gimnasiogrupo10.AccesoADatos.MembresiasData;
import gimnasiogrupo10.AccesoADatos.SocioData;
import gimnasiogrupo10.entidades.Asistencia;
import gimnasiogrupo10.entidades.Membresias;
import gimnasiogrupo10.entidades.Socios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class gestionAsistencia extends javax.swing.JInternalFrame {

    private SocioData socioData;
    private ClasesData claseData;
    private EntrenadoresData entrenadoresData;
    private AsistenciaData asistenciaData;
    private MembresiasData membresiasData;
    private DefaultTableModel tablaModelo;
    
    List <Socios> listaS;
    public gestionAsistencia() {
        
        initComponents();
        
    socioData = new SocioData();
    claseData= new ClasesData();
    entrenadoresData = new EntrenadoresData();
    asistenciaData = new AsistenciaData();
    membresiasData = new MembresiasData();
    listaS = socioData.listarSocios();
    
    
    tablaModelo=new DefaultTableModel();
    armarCabeceraTabla();
    cargarSocios();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboSocios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Asistencia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Socio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 45, -1, -1));

        getContentPane().add(comboSocios, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 42, 208, -1));

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 139, -1, 116));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 296, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 296, -1, -1));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 470, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

      // Obtener el socio seleccionado del combo
        Socios socioSeleccionado = (Socios) comboSocios.getSelectedItem();
        
        if (socioSeleccionado != null) {
            // Limpiar la tabla antes de agregar nuevos datos
            limpiarTabla();
            
            // Obtener las membresías del socio seleccionado
            List<Asistencia> asistencias = asistenciaData.listarAsistenciasPorSocio(socioSeleccionado.getID_Socio());
            // Llenar la tabla con las membresías encontradas
            for (Asistencia asistencia : asistencias) {
                Object[] fila = {
                    asistencia.getID_Asistencia(),
                    asistencia.getFecha_Asistencia(),
                    asistencia.getClase().getNombre(),
 
                };
                tablaModelo.addRow(fila);
            }
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JComboBox<Socios> comboSocios;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables


        private void armarCabeceraTabla(){
        ArrayList <Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID Asistencia");
        filaCabecera.add("Fecha de Asistencia");
        filaCabecera.add("Clase");
        for(Object it: filaCabecera){
         tablaModelo.addColumn(it);
        }
        
        jtTabla.setModel(tablaModelo);
    }
        
        private void cargarSocios() {
        for (Socios socio: listaS){
        comboSocios.addItem(socio);
        }
    }
        
         private void limpiarTabla() {
        while (tablaModelo.getRowCount() > 0) {
            tablaModelo.removeRow(0);
        }
    }         

}

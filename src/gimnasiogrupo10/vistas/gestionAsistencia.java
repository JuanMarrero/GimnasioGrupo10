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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Asistencia");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Socio");

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

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(comboSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(botonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(jButton1))
                .addGap(31, 31, 31))
        );

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

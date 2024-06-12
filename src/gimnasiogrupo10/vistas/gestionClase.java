package gimnasiogrupo10.vistas;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class gestionClase extends javax.swing.JInternalFrame {

    List<Entrenadores> listaE;
    List<Clases> listaC;
    
    private EntrenadoresData eData=new EntrenadoresData();
    private ClasesData cData=new ClasesData();
    
    private DefaultTableModel tablaModelo;

    
    public gestionClase() {
        initComponents();
        
        tablaModelo=new DefaultTableModel();
       listaC = cData.listarClases();
       listaE = eData.listarEntrenadores();
        
       armarCabeceraTabla();
       cargarEntrenadores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboEntrenadores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Listado de clases por Entrenador");

        jLabel2.setText("Seleccione un entrenador");

        comboEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntrenadoresActionPerformed(evt);
            }
        });

        tablaClases.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaClases);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("CLASES:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(63, 63, 63))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(comboEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntrenadoresActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        cargarClases();
    }//GEN-LAST:event_comboEntrenadoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Entrenadores> comboEntrenadores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClases;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla(){
        ArrayList <Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Entrenador");
        filaCabecera.add("Horario");
        filaCabecera.add("Capacidad");
        filaCabecera.add("Estado");
        for(Object it: filaCabecera){
            tablaModelo.addColumn(it);
        }
        
        tablaClases.setModel(tablaModelo);
    }

    private void cargarEntrenadores(){
        for (Entrenadores entrenadores: listaE){
        comboEntrenadores.addItem(entrenadores);
        }
    }

    private void cargarClases(){
      
        
        Entrenadores entrenadorSeleccionado =  (Entrenadores) comboEntrenadores.getSelectedItem();
        
        int ID_Entrenador = entrenadorSeleccionado.getID_Entrenador();
        
        
        listaC = cData.buscarClasesPorEntrenador(ID_Entrenador);

        if (listaC.isEmpty()) {
            
        System.out.println("no se encuentran clases para ese entrenador");        
    }
        for (Clases a: listaC){
         
           tablaModelo.addRow(new Object[]{a.getID_Clase(),a.getNombre(),a.getEntrenadores().getNombre(),a.getHorario(),a.getCapacidad(),a.isEstado()});
            

            }
        }
    
   private void borrarFilaTabla(){
        int indice = tablaModelo.getRowCount()-1;
        
        for (int i = indice;i>=0;i--){
            tablaModelo.removeRow(i);
        }
    }    

    
    
}

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
        jDesktopPane1 = new javax.swing.JDesktopPane();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Listado de clases por Entrenador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 0, -1, -1));

        jLabel2.setText("Seleccione un entrenador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, -1, -1));

        comboEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntrenadoresActionPerformed(evt);
            }
        });
        getContentPane().add(comboEntrenadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 45, 200, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 180, -1, 94));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 323, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("CLASES:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 111, -1, -1));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 500, 400));

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
    private javax.swing.JDesktopPane jDesktopPane1;
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

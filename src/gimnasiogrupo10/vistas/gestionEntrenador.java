
package gimnasiogrupo10.vistas;

import gimnasiogrupo10.entidades.*;
import gimnasiogrupo10.AccesoADatos.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gestionEntrenador extends javax.swing.JInternalFrame {

    List<Entrenadores> listaE;
    List<Clases> listaC;
    private EntrenadoresData entrenadorData;
    Entrenadores entrenadorActual=null;
    private ClasesData clasesData;
    private DefaultTableModel modelo;
    
    
    public gestionEntrenador() {
        initComponents();
        entrenadorData= new EntrenadoresData();
        clasesData = new ClasesData();
        listaE = entrenadorData.listarEntrenadores();
        listaC = clasesData.listarClases();
        modelo=new DefaultTableModel();
        
        armarCabeceraTabla();
        cargarEntrenadores();
        
    }
    
    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("Clase");
        filaCabecera.add("Nombre");
        filaCabecera.add("Hora");
        filaCabecera.add("Capacidad");
        filaCabecera.add("Estado");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTable2.setModel(modelo);
    }
    
    private void borrarFilaTabla(){
        int indice = modelo.getRowCount()-1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jbDarBaja = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        cbEntrenadores = new javax.swing.JComboBox<>();

        jLabel1.setText("GESTION DE ENTRENADORES");

        jLabel2.setText("ENTRENADOR");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable2);

        jbDarBaja.setText("Dar Baja");
        jbDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarBajaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        cbEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntrenadoresActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbDarBaja, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cbEntrenadores, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jbDarBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(75, 75, 75)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(cbEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jbBuscar)))
                .addGap(14, 14, 14))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbBuscar)
                    .addComponent(cbEntrenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarBaja)
                    .addComponent(jbSalir))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarBajaActionPerformed
     int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
        int idEntrenador = Integer.parseInt(modelo.getValueAt(selectedRow, 0).toString());
        entrenadorData.darBaja(idEntrenador);
        entrenadorActual = null;
        borrarFilaTabla();
        modelo.setRowCount(0);
    } else {
        JOptionPane.showMessageDialog(this, "NO HAY SOCIOS SELECCIONADOS");
    }
    }//GEN-LAST:event_jbDarBajaActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
 
        
        
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void cbEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntrenadoresActionPerformed
        borrarFilaTabla();
        cargarClases();
    }//GEN-LAST:event_cbEntrenadoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Entrenadores> cbEntrenadores;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbDarBaja;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables

    private void cargarEntrenadores() {
        for (Entrenadores entrenadores: listaE){
        cbEntrenadores.addItem(entrenadores);
        }
    }  
    
    private void cargarClases(){
      
        
        Entrenadores entrenadorSeleccionado =  (Entrenadores) cbEntrenadores.getSelectedItem();
        
        int idEntrenador = entrenadorSeleccionado.getID_Entrenador();
        
        listaC = clasesData.buscarClasesPorEntrenador(idEntrenador);

        if (listaC.isEmpty()) {
            
        System.out.println("No se encontraron socios para clases.");        
    }
        for (Clases a: listaC){
         
           modelo.addRow(new Object[]{a.getEntrenadores().getID_Entrenador(), a.getNombre(),a.getEntrenadores().getNombre(),a.getHorario(),a.getCapacidad(),a.isEstado()});
            
            }
        }


}
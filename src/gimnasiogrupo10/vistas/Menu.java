package gimnasiogrupo10.vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jdpEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmNuevoSocio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Gestion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiNuevoEntrenador = new javax.swing.JMenuItem();
        jmiBuscarListarEntrenador = new javax.swing.JMenuItem();
        jmClase = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmGestionClase = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmNuevaMem = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        jMenuItem2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jdpEscritorio.setBackground(new java.awt.Color(11, 9, 9));
        jdpEscritorio.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jdpEscritorio.setOpaque(false);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setMargin(new java.awt.Insets(4, 5, 4, 5));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(386, 40));

        jmNuevoSocio.setText("Socios");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmNuevoSocio.add(jMenuItem1);

        Gestion.setText("Gestión");
        Gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionActionPerformed(evt);
            }
        });
        jmNuevoSocio.add(Gestion);

        jMenuBar1.add(jmNuevoSocio);

        jMenu2.setText("Entrenadores");

        jmiNuevoEntrenador.setText("Nuevo");
        jmiNuevoEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoEntrenadorActionPerformed(evt);
            }
        });
        jMenu2.add(jmiNuevoEntrenador);

        jmiBuscarListarEntrenador.setText("Gestión");
        jmiBuscarListarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarListarEntrenadorActionPerformed(evt);
            }
        });
        jMenu2.add(jmiBuscarListarEntrenador);

        jMenuBar1.add(jMenu2);

        jmClase.setText("Clases");
        jmClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClaseActionPerformed(evt);
            }
        });

        jMenuItem8.setText("Nueva");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmClase.add(jMenuItem8);

        jmGestionClase.setText("Gestión");
        jmGestionClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionClaseActionPerformed(evt);
            }
        });
        jmClase.add(jmGestionClase);

        jMenuBar1.add(jmClase);

        jMenu4.setText("Membresias");

        jmNuevaMem.setText("Nueva");
        jmNuevaMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNuevaMemActionPerformed(evt);
            }
        });
        jMenu4.add(jmNuevaMem);

        jMenuItem12.setText("Gestion");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Asistencias");

        jMenuItem14.setText("Nueva");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem3.setText("Administrar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jmSalir.setText("Salir");
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        nuevoSocio socioN = new nuevoSocio();
        socioN.setVisible(true);
        jdpEscritorio.add(socioN);//
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiNuevoEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoEntrenadorActionPerformed
        // TODO add your handling code here:
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        nuevoEntrenador entrenador = new nuevoEntrenador();
        entrenador.setVisible(true);
        jdpEscritorio.add(entrenador);// agrega al escritorio al jdesktoppane
    }//GEN-LAST:event_jmiNuevoEntrenadorActionPerformed

    private void jmiBuscarListarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarListarEntrenadorActionPerformed
        // TODO add your handling code here:
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        gestionEntrenador listarEntrenador = new gestionEntrenador();
        listarEntrenador.setVisible(true);
        jdpEscritorio.add(listarEntrenador);// agrega al escritorio al jdesktoppane
    }//GEN-LAST:event_jmiBuscarListarEntrenadorActionPerformed

    private void jmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMouseClicked
        // TODO add your handling code here:
        System.out.println("Cerrando ventana...");
        dispose(); // o System.exit(0);
    }//GEN-LAST:event_jmSalirMouseClicked

    private void jmNuevaMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNuevaMemActionPerformed
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        nuevaMembresia nuevaMem = new nuevaMembresia();
        nuevaMem.setVisible(true);
        jdpEscritorio.add(nuevaMem);// agrega al escritorio al jdesktoppane        // TODO add your handling code here:
    }//GEN-LAST:event_jmNuevaMemActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        gestionMembresia mem = new gestionMembresia();
        mem.setVisible(true);
        jdpEscritorio.add(mem);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        nuevaClase clase = new nuevaClase();
        clase.setVisible(true);
        jdpEscritorio.add(clase);
    }//GEN-LAST:event_jMenuItem8ActionPerformed


    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        gestionSocio socio = new gestionSocio();
        socio.setVisible(true);
        jdpEscritorio.add(socio);//

    }//GEN-LAST:event_GestionActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        nuevaAsistencia asistencia = new nuevaAsistencia();
        asistencia.setVisible(true);
        jdpEscritorio.add(asistencia);//
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        gestionAsistencia gestionA = new gestionAsistencia();
        gestionA.setVisible(true);
        jdpEscritorio.add(gestionA);//
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jmClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClaseActionPerformed
        
    }//GEN-LAST:event_jmClaseActionPerformed

    private void jmGestionClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionClaseActionPerformed
       jdpEscritorio.removeAll();//removemos todos los componentes
        jdpEscritorio.repaint();// repintamos
        gestionClase clases = new gestionClase();
        clases.setVisible(true);
        jdpEscritorio.add(clases);
    }//GEN-LAST:event_jmGestionClaseActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Gestion;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JMenu jmClase;
    private javax.swing.JMenuItem jmGestionClase;
    private javax.swing.JMenuItem jmNuevaMem;
    private javax.swing.JMenu jmNuevoSocio;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenuItem jmiBuscarListarEntrenador;
    private javax.swing.JMenuItem jmiNuevoEntrenador;
    // End of variables declaration//GEN-END:variables
}

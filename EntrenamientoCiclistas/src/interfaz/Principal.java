package interfaz;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import modelo.Ciclista;

public class Principal extends javax.swing.JFrame {

    /**
     * Crea el JFrame Principal, inicia sus componentes gráficos y coloca una imagen en el fondo.
     */    
    public Principal() {
        setContentPane(new javax.swing.JPanel(new java.awt.BorderLayout()) {
            @Override public void paintComponent(java.awt.Graphics g) {
                try {
                    g.drawImage(javax.imageio.ImageIO.read(getClass().getResourceAsStream("/data/fondo.jpg")), 0, 0, null);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        initComponents();
        this.setTitle("Menú Principal");
        this.setLocationRelativeTo(null);
        addHighlight(registrarCiclista);
        addHighlight(registrarPractica);
        addHighlight(visualizarDatos);
        addHighlight(salir);
    }
    
    /**
     * Agrega un efecto de sombreado y realce a un JButton.
     * @param bttn JButton al cual se le agregará este efecto.
     */
    private void addHighlight(JButton bttn){
        bttn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttn.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttn.setBackground(javax.swing.UIManager.getColor("control"));
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        registrarCiclista = new javax.swing.JButton();
        registrarPractica = new javax.swing.JButton();
        visualizarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        salir.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        registrarCiclista.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        registrarCiclista.setText("Registrar ciclista");
        registrarCiclista.setBorderPainted(false);
        registrarCiclista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCiclistaActionPerformed(evt);
            }
        });

        registrarPractica.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        registrarPractica.setText("Registrar práctica");
        registrarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPracticaActionPerformed(evt);
            }
        });

        visualizarDatos.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        visualizarDatos.setText("Visualizar datos");
        visualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(registrarCiclista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(visualizarDatos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(registrarPractica)))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(registrarCiclista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarPractica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualizarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarDatosActionPerformed
        new VisualizarDatos(this, true).setVisible(true);
    }//GEN-LAST:event_visualizarDatosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        data.Data.actualizarCiclistas(Ciclista.ciclistas);
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void registrarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPracticaActionPerformed
        new RegistrarPractica(this, true).setVisible(true);
    }//GEN-LAST:event_registrarPracticaActionPerformed

    private void registrarCiclistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCiclistaActionPerformed
        new RegistrarCiclista(this, true).setVisible(true);
    }//GEN-LAST:event_registrarCiclistaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        data.Data.actualizarCiclistas(Ciclista.ciclistas);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        data.Data.leerVueltas();
        /*
        Para limpiar los datos de ciclistas registrados hasta el momento:
            Comentar la línea 202
            Descomentar la línea 203
            Descomentar la línea 204
            Ejecutar la aplicación y cerrarla
        NO OLVIDAR revertir las líneas modificadas luego
        */
        Ciclista.ciclistas = data.Data.cargarCiclistas();
//        Ciclista.ciclistas = new java.util.HashMap<>();
//        data.Data.actualizarCiclistas(Ciclista.ciclistas);
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton registrarCiclista;
    private javax.swing.JButton registrarPractica;
    private javax.swing.JButton salir;
    private javax.swing.JButton visualizarDatos;
    // End of variables declaration//GEN-END:variables
}

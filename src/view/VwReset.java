/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Constants;

/**
 *
 * @author rms
 */
public class VwReset extends javax.swing.JFrame {

    public static JButton[] btnPersonArray = {
        VwMain.btnPerson1, VwMain.btnPerson2, VwMain.btnPerson3,
        VwMain.btnPerson4, VwMain.btnPerson5,
        VwMain.btnPerson6, VwMain.btnPerson7, VwMain.btnPerson8,
        VwMain.btnPerson9, VwMain.btnPerson10,
        VwMain.btnPerson11, VwMain.btnPerson12, VwMain.btnPerson13,
        VwMain.btnPerson14, VwMain.btnPerson15,
        VwMain.btnPerson16, VwMain.btnPerson17, VwMain.btnPerson18,
        VwMain.btnPerson19, VwMain.btnPerson20
    };

    public static JButton[] btnQuestionArray = {
        VwMain.btnQuestion1, VwMain.btnQuestion2, VwMain.btnQuestion3,
        VwMain.btnQuestion4, VwMain.btnQuestion5,
        VwMain.btnQuestion6, VwMain.btnQuestion7, VwMain.btnQuestion8,
        VwMain.btnQuestion9, VwMain.btnQuestion10,
        VwMain.btnQuestion11, VwMain.btnQuestion12, VwMain.btnQuestion13,
        VwMain.btnQuestion14, VwMain.btnQuestion15,
        VwMain.btnQuestion16, VwMain.btnQuestion17, VwMain.btnQuestion18,
        VwMain.btnQuestion19, VwMain.btnQuestion20
    };

    public static JComboBox[] cbAnswers = {
        VwMain.cbAnswers1, VwMain.cbAnswers2, VwMain.cbAnswers3,
        VwMain.cbAnswers4, VwMain.cbAnswers5,
        VwMain.cbAnswers6, VwMain.cbAnswers7, VwMain.cbAnswers8,
        VwMain.cbAnswers9, VwMain.cbAnswers10,
        VwMain.cbAnswers11, VwMain.cbAnswers12, VwMain.cbAnswers13,
        VwMain.cbAnswers14, VwMain.cbAnswers15,
        VwMain.cbAnswers16, VwMain.cbAnswers17, VwMain.cbAnswers18,
        VwMain.cbAnswers19, VwMain.cbAnswers20,
    };

    /** Creates new form VwStart */
    public VwReset() {
        initComponents();
    }

    private void reset() {
        VwMain.characterPlayer = null;
        VwMain.characterIA = null;
        VwMain.answer = "";
        VwMain.answersPlayer = null;
        VwMain.answersIA = null;
        VwMain.turnPlayer = false;
        
        VwMain.cbCharacterPlayer.setSelectedIndex(-1);
        VwMain.cbCharacterIA.setSelectedIndex(-1);
        
        VwMain.guessCharactersIA = Constants.PEOPLEARRAY;

        for (int i = 0; i < btnPersonArray.length; i++) {
            btnPersonArray[i].setEnabled(true);
        }
        for (int i = 0; i < btnQuestionArray.length; i++) {
            btnQuestionArray[i].setEnabled(true);
        }
        for (int i = 0; i < cbAnswers.length; i++) {
            cbAnswers[i].setSelectedIndex(-1);
        }
        
        VwMain.getFirstTurn();
        
        
        
        
        
        VwMain.turnCounter = 0;
        VwMain.end = false;
        VwMain.error = false;

        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lbStart = new javax.swing.JLabel();
        btnStart = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar juego");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbStart.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStart.setText("¿Seguro que deseas reiniciar el juego?");

        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(143, 143, 143))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStart)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        reset();
    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VwReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VwReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VwReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VwReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VwReset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnStart;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbStart;
    // End of variables declaration//GEN-END:variables
}

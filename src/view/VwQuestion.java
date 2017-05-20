/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import model.Constants;
import model.Game;
import static view.VwMain.answer;
import static view.VwMain.questionSelected;

/**
 *
 * @author rms
 */
public class VwQuestion extends javax.swing.JFrame {

    /** Creates new form VwQSex */
    public VwQuestion() {
        initComponents();
    }
    
    public static JButton[] btnPersonArray = {
        VwMain.btnPerson1, VwMain.btnPerson2, VwMain.btnPerson3,
        VwMain.btnPerson4, VwMain.btnPerson5,
        VwMain.btnPerson6, VwMain.btnPerson7, VwMain.btnPerson8,
        VwMain.btnPerson9, VwMain.btnPerson10
    };

    public void answer() {
        VwMain.answer = (String) cbAnswers.getSelectedItem();
        switch (VwMain.questionSelected) {
            case 1:
                VwMain.answersPlayer[0] = answer;
                VwMain.cbAnswers1.setSelectedItem(answer);
                VwMain.btnQuestion1.setEnabled(false);
                break;
            case 2:
                VwMain.answersPlayer[1] = answer;
                VwMain.cbAnswers2.setSelectedItem(answer);
                VwMain.btnQuestion2.setEnabled(false);
                break;
            case 3:
                VwMain.answersPlayer[2] = answer;
                VwMain.cbAnswers3.setSelectedItem(answer);
                VwMain.btnQuestion3.setEnabled(false);
                break;
            case 4:
                VwMain.answersPlayer[3] = answer;
                VwMain.cbAnswers4.setSelectedItem(answer);
                VwMain.btnQuestion4.setEnabled(false);
                break;
            case 5:
                VwMain.answersPlayer[4] = answer;
                VwMain.cbAnswers5.setSelectedItem(answer);
                VwMain.btnQuestion5.setEnabled(false);
                break;
            case 6:
                VwMain.answersPlayer[5] = answer;
                VwMain.cbAnswers6.setSelectedItem(answer);
                VwMain.btnQuestion6.setEnabled(false);
                break;
            case 7:
                VwMain.answersPlayer[6] = answer;
                VwMain.cbAnswers7.setSelectedItem(answer);
                VwMain.btnQuestion7.setEnabled(false);
                break;
            case 8:
                VwMain.answersPlayer[7] = answer;
                VwMain.cbAnswers8.setSelectedItem(answer);
                VwMain.btnQuestion8.setEnabled(false);
                break;
            case 9:
                VwMain.answersPlayer[8] = answer;
                VwMain.cbAnswers9.setSelectedItem(answer);
                VwMain.btnQuestion9.setEnabled(false);
                break;
            case 10:
                VwMain.answersPlayer[9] = answer;
                VwMain.cbAnswers10.setSelectedItem(answer);
                VwMain.btnQuestion10.setEnabled(false);
                break;
        }
        deactivate();
        dispose();
    }

    public void deactivate() {
        System.out.println("DISABLING: ");
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if ((!Constants.PEOPLEARRAY[i][questionSelected].equals(answer)) 
                    && VwQuestion.btnPersonArray[i].isEnabled()
                    ) {
                System.out.println("\t" + i + " "
                        + Constants.PEOPLEARRAY[i][questionSelected] + " "
                        + VwQuestion.btnPersonArray[i].getText());
                VwQuestion.btnPersonArray[i].setEnabled(false);
            }
        }
    }

    private void loadQuestion() {
        switch (Game.turn) {
            case 1:
                lbTurn.setText("Turno: IA");
                break;
            case 2:
                lbTurn.setText("Turno: Jugador");
                break;
            default:
                lbTurn.setText("Sin turno");
        }
        
        switch (VwMain.questionSelected) {
            case 1:
                lbQuestion.setText(Constants.QUESTION1);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS1));
                break;
            case 2:
                lbQuestion.setText(Constants.QUESTION2);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS2));
                break;
            case 3:
                lbQuestion.setText(Constants.QUESTION3);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS3));
                break;
            case 4:
                lbQuestion.setText(Constants.QUESTION4);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS4));
                break;
            case 5:
                lbQuestion.setText(Constants.QUESTION5);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS5));
                break;
            case 6:
                lbQuestion.setText(Constants.QUESTION6);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS6));
                break;
            case 7:
                lbQuestion.setText(Constants.QUESTION7);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS7));
                break;
            case 8:
                lbQuestion.setText(Constants.QUESTION8);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS8));
                break;
            case 9:
                lbQuestion.setText(Constants.QUESTION9);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS9));
                break;
            case 10:
                lbQuestion.setText(Constants.QUESTION10);
                cbAnswers.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS10));
                break;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        cbAnswers = new javax.swing.JComboBox<>();
        btnAnswer = new javax.swing.JButton();
        lbTurn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbQuestion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuestion.setText("Question");

        cbAnswers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAnswer.setText("Responder");
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        lbTurn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTurn.setText("Turn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btnAnswer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(cbAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerActionPerformed
        answer();
    }//GEN-LAST:event_btnAnswerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadQuestion();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VwQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer;
    private javax.swing.JComboBox<String> cbAnswers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JLabel lbTurn;
    // End of variables declaration//GEN-END:variables
}

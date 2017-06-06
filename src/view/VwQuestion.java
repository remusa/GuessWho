/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import interfaz.LookandFeel;
import javax.swing.JButton;
import model.Constants;
import static view.VwMain.answer;
import static view.VwMain.questionSelected;

/**
 *
 * @author rms
 */
public class VwQuestion extends javax.swing.JFrame {

    public static JButton[] btnPersonArray = {
        VwMain.btnPerson1, VwMain.btnPerson2, VwMain.btnPerson3,
        VwMain.btnPerson4, VwMain.btnPerson5,
        VwMain.btnPerson6, VwMain.btnPerson7, VwMain.btnPerson8,
        VwMain.btnPerson9, VwMain.btnPerson10
    };
    
    /** Creates new form VwQSex */
    public VwQuestion() {
        initComponents();
    }

    public void answer() {
        VwMain.answer = VwMain.characterIA[questionSelected];
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
        VwMain.turnPlayer = false;
        VwMain.turnCounter++;
        deactivate();
        dispose();
    }

    private void deactivate() {
        System.out.println("DISABLING (Player): ");
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if ((!Constants.PEOPLEARRAY[i][questionSelected].equals(answer)) 
                    && VwQuestion.btnPersonArray[i].isEnabled()
                    ) {
                VwQuestion.btnPersonArray[i].setEnabled(false);
                System.out.println("\t" + i + " " + Constants.PEOPLEARRAY[i][questionSelected] + " " + VwQuestion.btnPersonArray[i].getText());
            }
        }
    }

    private void loadQuestion() {
        lbTurn.setText("Turno: Jugador");

        switch (VwMain.questionSelected) {
            case 1:
                lbQuestion.setText(Constants.QUESTION1);
                break;
            case 2:
                lbQuestion.setText(Constants.QUESTION2);
                break;
            case 3:
                lbQuestion.setText(Constants.QUESTION3);
                break;
            case 4:
                lbQuestion.setText(Constants.QUESTION4);
                break;
            case 5:
                lbQuestion.setText(Constants.QUESTION5);
                break;
            case 6:
                lbQuestion.setText(Constants.QUESTION6);
                break;
            case 7:
                lbQuestion.setText(Constants.QUESTION7);
                break;
            case 8:
                lbQuestion.setText(Constants.QUESTION8);
                break;
            case 9:
                lbQuestion.setText(Constants.QUESTION9);
                break;
            case 10:
                lbQuestion.setText(Constants.QUESTION10);
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
        lbTurn = new javax.swing.JLabel();
        lbQuestion = new javax.swing.JLabel();
        lbAnswer = new javax.swing.JLabel();
        btnAnswer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbTurn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTurn.setText("Turn");

        lbQuestion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuestion.setText("Question");

        lbAnswer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnswer.setText(VwMain.characterIA[VwMain.questionSelected]);

        btnAnswer.setText("OK");
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
                    .addComponent(lbAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnAnswer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuestion)
                .addGap(30, 30, 30)
                .addComponent(lbAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer)
                .addContainerGap(12, Short.MAX_VALUE))
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
        LookandFeel lf = new LookandFeel();
        lf.darculaLF();
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VwQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAnswer;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JLabel lbTurn;
    // End of variables declaration//GEN-END:variables
}

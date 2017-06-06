/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import javax.swing.JButton;
import model.Constants;

/**
 *
 * @author rms
 */
public class VwQuestionIA extends javax.swing.JFrame {

    private String answer2 = "";
    private int questionSelectedIA = 1;
    
    public static JButton[] btnPersonArray = {
        VwMain.btnPerson11, VwMain.btnPerson12, VwMain.btnPerson13,
        VwMain.btnPerson14, VwMain.btnPerson15,
        VwMain.btnPerson16, VwMain.btnPerson17, VwMain.btnPerson18,
        VwMain.btnPerson19, VwMain.btnPerson20
    };

    /** Creates new form VwQSex */
    public VwQuestionIA() {
        initComponents();
    }

    public void answer() {
//        VwMain.answer2 = VwMain.characterPlayer[questionSelected];
//        answer2 = VwMain.characterPlayer[questionSelectedIA];
        answer2 = (String) cbAnswers.getSelectedItem();
        switch (questionSelectedIA) {
            case 1:
                VwMain.answersIA[0] = answer2;
                VwMain.cbAnswers11.setSelectedItem(answer2);
                VwMain.btnQuestion11.setEnabled(false);
                break;
            case 2:
                VwMain.answersIA[1] = answer2;
                VwMain.cbAnswers12.setSelectedItem(answer2);
                VwMain.btnQuestion12.setEnabled(false);
                break;
            case 3:
                VwMain.answersIA[2] = answer2;
                VwMain.cbAnswers13.setSelectedItem(answer2);
                VwMain.btnQuestion13.setEnabled(false);
                break;
            case 4:
                VwMain.answersIA[3] = answer2;
                VwMain.cbAnswers14.setSelectedItem(answer2);
                VwMain.btnQuestion14.setEnabled(false);
                break;
            case 5:
                VwMain.answersIA[4] = answer2;
                VwMain.cbAnswers15.setSelectedItem(answer2);
                VwMain.btnQuestion15.setEnabled(false);
                break;
            case 6:
                VwMain.answersIA[5] = answer2;
                VwMain.cbAnswers16.setSelectedItem(answer2);
                VwMain.btnQuestion16.setEnabled(false);
                break;
            case 7:
                VwMain.answersIA[6] = answer2;
                VwMain.cbAnswers17.setSelectedItem(answer2);
                VwMain.btnQuestion17.setEnabled(false);
                break;
            case 8:
                VwMain.answersIA[7] = answer2;
                VwMain.cbAnswers18.setSelectedItem(answer2);
                VwMain.btnQuestion18.setEnabled(false);
                break;
            case 9:
                VwMain.answersIA[8] = answer2;
                VwMain.cbAnswers19.setSelectedItem(answer2);
                VwMain.btnQuestion19.setEnabled(false);
                break;
            case 10:
                VwMain.answersIA[9] = answer2;
                VwMain.cbAnswers20.setSelectedItem(answer2);
                VwMain.btnQuestion20.setEnabled(false);
                break;
        }
        VwMain.turnPlayer = true;
        VwMain.turnCounter++;
        deactivate();
        dispose();
    }

    private void deactivate() {
        System.out.println("DISABLING (IA): ");
        
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if ((!Constants.PEOPLEARRAY[i][questionSelectedIA].equals(answer2)) 
//                    && btnPersonArray[i].isEnabled()
                    && btnPersonArray[i].getText() != (String) VwMain.cbCharacterPlayer.getSelectedItem()
                    ) {
//                System.out.println("jdksj " + btnPersonArray[i].getText());
//                System.out.println("test " + VwMain.cbCharacterPlayer.getSelectedItem());
                btnPersonArray[i].setEnabled(false);
                System.out.println("\t" + i + " " + Constants.PEOPLEARRAY[i][questionSelectedIA] + " " + btnPersonArray[i].getText());
            }
        }
        
        int counter = 0;
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if (btnPersonArray[i].isEnabled()) {
                counter++;
            }
        }
        if (counter <= 3) {
            VwMain.end = true;
        }
        if (counter == 0) {
            VwMain.error = true;
        }

//        for (int i = 0; i < VwMain.guessCharactersIA.length; i++) {
//            if (!Constants.PEOPLEARRAY[i][questionSelectedIA].equals(answer2)) {
//                System.out.println("\t" + i + " " + Constants.PEOPLEARRAY[i][questionSelectedIA] + " ");
////                System.out.println("\t" + i + " " + Constants.PEOPLEARRAY[i][questionSelectedIA] + " " + VwMain.guessCharactersIA[i][0]);
//            }
//        }
    }

    private void getQuestion() {
        int i = 0;
        do {
            questionSelectedIA = new Random().nextInt(10);
        } while ((questionSelectedIA < 1 || questionSelectedIA > 10)
                && btnPersonArray[i].isEnabled());
    }

    private void loadQuestion() {
        lbTurn.setText("Turno: IA");

        getQuestion();

        switch (questionSelectedIA) {
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
        lbTurn = new javax.swing.JLabel();
        lbQuestion = new javax.swing.JLabel();
        btnAnswer = new javax.swing.JButton();
        cbAnswers = new javax.swing.JComboBox<>();

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

        btnAnswer.setText("OK");
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        cbAnswers.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnswer))
                        .addGap(142, 142, 142))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnAnswer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(VwQuestionIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VwQuestionIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VwQuestionIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VwQuestionIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VwQuestionIA().setVisible(true);
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

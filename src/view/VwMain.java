/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import comportamiento.Mensajes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.Constants;

/**
 *
 * @author rms
 */
public class VwMain extends javax.swing.JFrame {

    private String[] characterPlayer = {};
    private String[] characterIA = {};

    public static int questionSelected = 0;
    public static String answer = "";
    public static String[] answers = new String[10];

    public JButton[] btnPersonArray = {
        VwMain.btnPerson1, VwMain.btnPerson2, VwMain.btnPerson3, 
        VwMain.btnPerson4, VwMain.btnPerson5,
        VwMain.btnPerson6, VwMain.btnPerson7, VwMain.btnPerson8, 
        VwMain.btnPerson9, VwMain.btnPerson10};

    public JButton[] btnQuestionArray = {
        btnQuestion1, btnQuestion2, btnQuestion3, 
        btnQuestion4, btnQuestion5,
        btnQuestion6, btnQuestion7, btnQuestion8, 
        btnQuestion9, btnQuestion10
    };

    /** Creates new form VwMain */
    public VwMain() {
        initComponents();
    }

    public void selectPerson(String[] person) {
        cbCharacterPlayer.setSelectedItem(person[0]);
        characterPlayer = person;
    }

    public void saveSelection() {
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if (Constants.PEOPLEARRAY[i][0].equals(cbCharacterPlayer.getSelectedItem())) {
                System.out.println(Constants.PEOPLEARRAY[i][0] + " " + cbCharacterPlayer.getSelectedItem());
                JButton temp = btnPersonArray[i];
                temp.setEnabled(false);
                System.out.println(temp.toString());
            }
        }
        cbCharacterPlayer.setEnabled(false);
    }

    public void getIACharacter() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(Constants.PEOPLEARRAY.length);
        } while (Constants.PEOPLEARRAY[randomIndex][0].equals(cbCharacterPlayer.getSelectedItem()));
        cbCharacterIA.setSelectedItem(Constants.PEOPLEARRAY[randomIndex][0]);
        characterIA = Constants.PEOPLEARRAY[randomIndex];
    }

    private void printCharacters() {
        try {
            System.out.println("Player: " + (characterPlayer[0]) + "\tIA: " + (characterIA[0]));
        } catch (NullPointerException e) {
            Mensajes.falla(this, "Selecciona un personaje");
        }
    }

    private void guessIACharacter() {

    }

    private void selectQuestion(int selection) {
        questionSelected = selection;
        VwQuestion question = new VwQuestion();
        question.setTitle("Pregunta " + questionSelected);
        question.setVisible(true);
    }

    public void answer() {
        switch (VwMain.questionSelected) {
            case 1:
                VwMain.answers[0] = answer;
                VwMain.cbAnswers1.setSelectedItem(answer);
//                VwMain.btnQuestion1.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected -1].setEnabled(false);
                break;
            case 2:
                VwMain.answers[1] = answer;
                VwMain.cbAnswers2.setSelectedItem(answer);
//                VwMain.btnQuestion2.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 3:
                VwMain.answers[2] = answer;
                VwMain.cbAnswers3.setSelectedItem(answer);
//                VwMain.btnQuestion3.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 4:
                VwMain.answers[3] = answer;
                VwMain.cbAnswers4.setSelectedItem(answer);
//                VwMain.btnQuestion4.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 5:
                VwMain.answers[4] = answer;
                VwMain.cbAnswers5.setSelectedItem(answer);
//                VwMain.btnQuestion5.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 6:
                VwMain.answers[5] = answer;
                VwMain.cbAnswers6.setSelectedItem(answer);
//                VwMain.btnQuestion6.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 7:
                VwMain.answers[6] = answer;
                VwMain.cbAnswers7.setSelectedItem(answer);
//                VwMain.btnQuestion7.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 8:
                VwMain.answers[7] = answer;
                VwMain.cbAnswers8.setSelectedItem(answer);
//                VwMain.btnQuestion8.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 9:
                VwMain.answers[8] = answer;
                VwMain.cbAnswers9.setSelectedItem(answer);
//                VwMain.btnQuestion9.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
            case 10:
                VwMain.answers[9] = answer;
                VwMain.cbAnswers10.setSelectedItem(answer);
//                VwMain.btnQuestion10.setEnabled(false);
                btnQuestionArray[VwMain.questionSelected - 1].setEnabled(false);
                break;
        }
        deactivate();
    }

    public void deactivate() {
        System.out.println("DEACTIVATING: ");
        for (int i = 0; i < Constants.PEOPLEARRAY.length; i++) {
            if ((!Constants.PEOPLEARRAY[i][questionSelected].equals(answer)) && btnPersonArray[i].isEnabled()) {
                System.out.println("\t" + i + " "
                        + Constants.PEOPLEARRAY[i][questionSelected] + " "
                        + btnPersonArray[i].getText());
                btnPersonArray[i].setEnabled(false);

            }
        }
    }

    private void disable(Object... objs) {
        try {
            for (Object obj : objs) {
                if (obj instanceof JButton) {
                    JButton f = (JButton) obj;
                    f.setEnabled(false);
                }
                if (obj instanceof JTextField) {
                    JTextField f = (JTextField) obj;
                    f.setEnabled(false);
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private void reset() {
//        for (int i = 0; i < btnPersonArray.length; i++) {
//            btnPersonArray[i].setEnabled(true);
//        }
//        for (int i = 0; i < btnQuestionArray.length; i++) {
//            btnQuestionArray[i].setEnabled(true);
//        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnQuestions = new javax.swing.JPanel();
        btnQuestion1 = new javax.swing.JButton();
        btnQuestion2 = new javax.swing.JButton();
        btnQuestion3 = new javax.swing.JButton();
        btnQuestion4 = new javax.swing.JButton();
        btnQuestion5 = new javax.swing.JButton();
        btnQuestion6 = new javax.swing.JButton();
        btnQuestion7 = new javax.swing.JButton();
        btnQuestion8 = new javax.swing.JButton();
        btnQuestion9 = new javax.swing.JButton();
        btnQuestion10 = new javax.swing.JButton();
        cbAnswers1 = new javax.swing.JComboBox<>();
        cbAnswers2 = new javax.swing.JComboBox<>();
        cbAnswers3 = new javax.swing.JComboBox<>();
        cbAnswers4 = new javax.swing.JComboBox<>();
        cbAnswers5 = new javax.swing.JComboBox<>();
        cbAnswers6 = new javax.swing.JComboBox<>();
        cbAnswers7 = new javax.swing.JComboBox<>();
        cbAnswers8 = new javax.swing.JComboBox<>();
        cbAnswers9 = new javax.swing.JComboBox<>();
        cbAnswers10 = new javax.swing.JComboBox<>();
        pnCharacters = new javax.swing.JPanel();
        btnPerson1 = new javax.swing.JButton();
        btnPerson2 = new javax.swing.JButton();
        btnPerson3 = new javax.swing.JButton();
        btnPerson4 = new javax.swing.JButton();
        btnPerson5 = new javax.swing.JButton();
        btnPerson6 = new javax.swing.JButton();
        btnPerson7 = new javax.swing.JButton();
        btnPerson8 = new javax.swing.JButton();
        btnPerson9 = new javax.swing.JButton();
        btnPerson10 = new javax.swing.JButton();
        pnOptions = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCharacterPlayer = new javax.swing.JComboBox<>();
        cbAnswer = new javax.swing.JComboBox<>();
        btnSelect = new javax.swing.JButton();
        btnGuess = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbCharacterIA = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adivina Quién");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adivina quién");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnQuestions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnQuestion1.setText(model.Constants.QUESTION1);
        btnQuestion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion1ActionPerformed(evt);
            }
        });

        btnQuestion2.setText(model.Constants.QUESTION2);
        btnQuestion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion2ActionPerformed(evt);
            }
        });

        btnQuestion3.setText(model.Constants.QUESTION3);
        btnQuestion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion3ActionPerformed(evt);
            }
        });

        btnQuestion4.setText(model.Constants.QUESTION4);
        btnQuestion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion4ActionPerformed(evt);
            }
        });

        btnQuestion5.setText(model.Constants.QUESTION5);
        btnQuestion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion5ActionPerformed(evt);
            }
        });

        btnQuestion6.setText(model.Constants.QUESTION6);
        btnQuestion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion6ActionPerformed(evt);
            }
        });

        btnQuestion7.setText(model.Constants.QUESTION7);
        btnQuestion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion7ActionPerformed(evt);
            }
        });

        btnQuestion8.setText(model.Constants.QUESTION8);
        btnQuestion8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion8ActionPerformed(evt);
            }
        });

        btnQuestion9.setText(model.Constants.QUESTION9);
        btnQuestion9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion9ActionPerformed(evt);
            }
        });

        btnQuestion10.setText(model.Constants.QUESTION10);
        btnQuestion10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion10ActionPerformed(evt);
            }
        });

        cbAnswers1.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS1));
        cbAnswers1.setSelectedIndex(-1);
        cbAnswers1.setEnabled(false);

        cbAnswers2.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS2));
        cbAnswers2.setSelectedIndex(-1);
        cbAnswers2.setEnabled(false);

        cbAnswers3.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS3));
        cbAnswers3.setSelectedIndex(-1);
        cbAnswers3.setEnabled(false);

        cbAnswers4.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS4));
        cbAnswers4.setSelectedIndex(-1);
        cbAnswers4.setEnabled(false);

        cbAnswers5.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS5));
        cbAnswers5.setSelectedIndex(-1);
        cbAnswers5.setEnabled(false);

        cbAnswers6.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS6));
        cbAnswers6.setSelectedIndex(-1);
        cbAnswers6.setEnabled(false);

        cbAnswers7.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS7));
        cbAnswers7.setSelectedIndex(-1);
        cbAnswers7.setEnabled(false);

        cbAnswers8.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS8));
        cbAnswers8.setSelectedIndex(-1);
        cbAnswers8.setEnabled(false);

        cbAnswers9.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS9));
        cbAnswers9.setSelectedIndex(-1);
        cbAnswers9.setEnabled(false);

        cbAnswers10.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS10));
        cbAnswers10.setSelectedIndex(-1);
        cbAnswers10.setEnabled(false);

        javax.swing.GroupLayout pnQuestionsLayout = new javax.swing.GroupLayout(pnQuestions);
        pnQuestions.setLayout(pnQuestionsLayout);
        pnQuestionsLayout.setHorizontalGroup(
            pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers1, 0, 130, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnQuestionsLayout.setVerticalGroup(
            pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion1)
                    .addComponent(cbAnswers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion2)
                    .addComponent(cbAnswers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion3)
                    .addComponent(cbAnswers3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion4)
                    .addComponent(cbAnswers4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion5)
                    .addComponent(cbAnswers5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion6)
                    .addComponent(cbAnswers6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion7)
                    .addComponent(cbAnswers7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion8)
                    .addComponent(cbAnswers8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion9)
                    .addComponent(cbAnswers9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestion10)
                    .addComponent(cbAnswers10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCharacters.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPerson1.setText(Constants.PERSON1[0]);
        btnPerson1.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson1.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson1.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson1ActionPerformed(evt);
            }
        });

        btnPerson2.setText(Constants.PERSON2[0]);
        btnPerson2.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson2.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson2.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson2ActionPerformed(evt);
            }
        });

        btnPerson3.setText(Constants.PERSON3[0]);
        btnPerson3.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson3.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson3.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson3ActionPerformed(evt);
            }
        });

        btnPerson4.setText(Constants.PERSON4[0]);
        btnPerson4.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson4.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson4.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson4ActionPerformed(evt);
            }
        });

        btnPerson5.setText(Constants.PERSON5[0]);
        btnPerson5.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson5.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson5.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson5ActionPerformed(evt);
            }
        });

        btnPerson6.setText(Constants.PERSON6[0]);
        btnPerson6.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson6.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson6.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson6ActionPerformed(evt);
            }
        });

        btnPerson7.setText(Constants.PERSON7[0]);
        btnPerson7.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson7.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson7.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson7ActionPerformed(evt);
            }
        });

        btnPerson8.setText(Constants.PERSON8[0]);
        btnPerson8.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson8.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson8.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson8ActionPerformed(evt);
            }
        });

        btnPerson9.setText(Constants.PERSON9[0]);
        btnPerson9.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson9.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson9.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson9ActionPerformed(evt);
            }
        });

        btnPerson10.setText(Constants.PERSON10[0]);
        btnPerson10.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson10.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson10.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCharactersLayout = new javax.swing.GroupLayout(pnCharacters);
        pnCharacters.setLayout(pnCharactersLayout);
        pnCharactersLayout.setHorizontalGroup(
            pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCharactersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCharactersLayout.createSequentialGroup()
                        .addComponent(btnPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPerson3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCharactersLayout.createSequentialGroup()
                        .addComponent(btnPerson5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPerson6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCharactersLayout.createSequentialGroup()
                        .addComponent(btnPerson8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPerson9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPerson10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCharactersLayout.setVerticalGroup(
            pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCharactersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCharacters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnCharacters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnQuestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Personaje:");

        jLabel3.setText("Respuesta:");

        cbCharacterPlayer.setModel(new javax.swing.DefaultComboBoxModel(Constants.PEOPLE));
        cbCharacterPlayer.setSelectedIndex(-1);
        cbCharacterPlayer.setEnabled(false);

        cbAnswer.setModel(new javax.swing.DefaultComboBoxModel(Constants.PEOPLE));
        cbAnswer.setSelectedIndex(-1);

        btnSelect.setText("Iniciar");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnGuess.setText("Adivinar");
        btnGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuessActionPerformed(evt);
            }
        });

        btnReset.setText("Reiniciar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbCharacterIA.setModel(new javax.swing.DefaultComboBoxModel(Constants.PEOPLE));
        cbCharacterIA.setSelectedIndex(-1);
        cbCharacterIA.setEnabled(false);

        jLabel4.setText("IA:");

        javax.swing.GroupLayout pnOptionsLayout = new javax.swing.GroupLayout(pnOptions);
        pnOptions.setLayout(pnOptionsLayout);
        pnOptionsLayout.setHorizontalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCharacterPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbCharacterIA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnOptionsLayout.setVerticalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelect)
                    .addComponent(jLabel2)
                    .addComponent(cbCharacterPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbCharacterIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnGuess)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        jMenu1.setText("Ayuda");

        jMenuItem1.setText("Acerca De");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerson1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson1ActionPerformed
        selectPerson(Constants.PERSON1);
    }//GEN-LAST:event_btnPerson1ActionPerformed

    private void btnPerson2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson2ActionPerformed
        selectPerson(Constants.PERSON2);
    }//GEN-LAST:event_btnPerson2ActionPerformed

    private void btnPerson3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson3ActionPerformed
        selectPerson(Constants.PERSON3);
    }//GEN-LAST:event_btnPerson3ActionPerformed

    private void btnPerson4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson4ActionPerformed
        selectPerson(Constants.PERSON4);
    }//GEN-LAST:event_btnPerson4ActionPerformed

    private void btnPerson5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson5ActionPerformed
        selectPerson(Constants.PERSON5);
    }//GEN-LAST:event_btnPerson5ActionPerformed

    private void btnPerson6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson6ActionPerformed
        selectPerson(Constants.PERSON6);
    }//GEN-LAST:event_btnPerson6ActionPerformed

    private void btnPerson7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson7ActionPerformed
        selectPerson(Constants.PERSON7);
    }//GEN-LAST:event_btnPerson7ActionPerformed

    private void btnPerson8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson8ActionPerformed
        selectPerson(Constants.PERSON8);
    }//GEN-LAST:event_btnPerson8ActionPerformed

    private void btnPerson9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson9ActionPerformed
        selectPerson(Constants.PERSON9);
    }//GEN-LAST:event_btnPerson9ActionPerformed

    private void btnPerson10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson10ActionPerformed
        selectPerson(Constants.PERSON10);
    }//GEN-LAST:event_btnPerson10ActionPerformed

    private void btnGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuessActionPerformed
        guessIACharacter();
    }//GEN-LAST:event_btnGuessActionPerformed

    private void btnQuestion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion1ActionPerformed
        selectQuestion(1);
    }//GEN-LAST:event_btnQuestion1ActionPerformed

    private void btnQuestion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion2ActionPerformed
        selectQuestion(2);
    }//GEN-LAST:event_btnQuestion2ActionPerformed

    private void btnQuestion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion3ActionPerformed
        selectQuestion(3);
    }//GEN-LAST:event_btnQuestion3ActionPerformed

    private void btnQuestion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion4ActionPerformed
        selectQuestion(4);
    }//GEN-LAST:event_btnQuestion4ActionPerformed

    private void btnQuestion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion5ActionPerformed
        selectQuestion(5);
    }//GEN-LAST:event_btnQuestion5ActionPerformed

    private void btnQuestion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion6ActionPerformed
        selectQuestion(6);
    }//GEN-LAST:event_btnQuestion6ActionPerformed

    private void btnQuestion7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion7ActionPerformed
        selectQuestion(7);
    }//GEN-LAST:event_btnQuestion7ActionPerformed

    private void btnQuestion8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion8ActionPerformed
        selectQuestion(8);
    }//GEN-LAST:event_btnQuestion8ActionPerformed

    private void btnQuestion9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion9ActionPerformed
        selectQuestion(9);
    }//GEN-LAST:event_btnQuestion9ActionPerformed

    private void btnQuestion10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion10ActionPerformed
        selectQuestion(10);
    }//GEN-LAST:event_btnQuestion10ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        getIACharacter();
        printCharacters();
    }//GEN-LAST:event_btnSelectActionPerformed

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
            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VwMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuess;
    public static javax.swing.JButton btnPerson1;
    public static javax.swing.JButton btnPerson10;
    public static javax.swing.JButton btnPerson2;
    public static javax.swing.JButton btnPerson3;
    public static javax.swing.JButton btnPerson4;
    public static javax.swing.JButton btnPerson5;
    public static javax.swing.JButton btnPerson6;
    public static javax.swing.JButton btnPerson7;
    public static javax.swing.JButton btnPerson8;
    public static javax.swing.JButton btnPerson9;
    public static javax.swing.JButton btnQuestion1;
    public static javax.swing.JButton btnQuestion10;
    public static javax.swing.JButton btnQuestion2;
    public static javax.swing.JButton btnQuestion3;
    public static javax.swing.JButton btnQuestion4;
    public static javax.swing.JButton btnQuestion5;
    public static javax.swing.JButton btnQuestion6;
    public static javax.swing.JButton btnQuestion7;
    public static javax.swing.JButton btnQuestion8;
    public static javax.swing.JButton btnQuestion9;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cbAnswer;
    public static javax.swing.JComboBox<String> cbAnswers1;
    public static javax.swing.JComboBox<String> cbAnswers10;
    public static javax.swing.JComboBox<String> cbAnswers2;
    public static javax.swing.JComboBox<String> cbAnswers3;
    public static javax.swing.JComboBox<String> cbAnswers4;
    public static javax.swing.JComboBox<String> cbAnswers5;
    public static javax.swing.JComboBox<String> cbAnswers6;
    public static javax.swing.JComboBox<String> cbAnswers7;
    public static javax.swing.JComboBox<String> cbAnswers8;
    public static javax.swing.JComboBox<String> cbAnswers9;
    private javax.swing.JComboBox<String> cbCharacterIA;
    private javax.swing.JComboBox<String> cbCharacterPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnCharacters;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnQuestions;
    // End of variables declaration//GEN-END:variables
}

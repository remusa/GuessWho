/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import comportamiento.Mensajes;
import interfaz.LookandFeel;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import model.Constants;

/**
 *
 * @author rms
 */
public class VwMain extends javax.swing.JFrame {

    public static String[] characterPlayer = {};
    public static String[] characterIA = {};
    public static int questionSelected = 0;
    public static String answer = "";
    public static String answer2 = "";
    public static String[] answersPlayer = new String[11];
    public static String[] answersIA = new String[11];
    public static boolean turnPlayer = false; //false for IA, true for Player

    public static int turnCounter = 0;
    public static boolean end = false;
    public static boolean error = false;
    public static boolean evaluated = false;

//    public static ArrayList<String[]> guessIA = new ArrayList<>();
    public static String[][] guessCharactersIA = Constants.PEOPLEARRAY;

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
        VwMain.btnQuestion9, VwMain.btnQuestion10
    };

    public static JButton[] btnQuestionArray2 = {
        VwMain.btnQuestion11, VwMain.btnQuestion12, VwMain.btnQuestion13,
        VwMain.btnQuestion14, VwMain.btnQuestion15,
        VwMain.btnQuestion16, VwMain.btnQuestion17, VwMain.btnQuestion18,
        VwMain.btnQuestion19, VwMain.btnQuestion20
    };

    /** Creates new form VwMain */
    public VwMain() {
        initComponents();

//        guessIA.addAll(Arrays.asList(Constants.PEOPLEARRAY));
    }

    private void evaluate() {
//        if (!turnPlayer) {
        if (error) {
            Mensajes.falla(this, "No se puede encontrar tu personaje");
            evaluated = true;
        }
        if (end) {
            Mensajes.falla(this, "Tu personaje es: \n" + characterPlayer[0]);
            evaluated = true;
        }
        if (turnCounter >= 6) {
            Mensajes.falla(this, "Tu personaje es: \n" + characterPlayer[0]);
            evaluated = true;
        }

//        }
        printGuessIA();
    }

    public void printGuessIA() {
        //ARRAY
//        for (int i = 0; i < guessIA.length; i++) {
//            for (int j = 0; j < guessIA[i].length; j++) {
//                if (guessIA[i][j] != null) {
//                    System.out.println(i + "," + j + guessIA[i][j]);
//                }
//            }
//        }
    }

    private void getCharacters() {
        getTurn();
        getPlayerCharacter();
        getIACharacter();
        printCharacters();
    }

    private void getPlayerCharacter() {
        switch ((int) cbCharacterPlayer.getSelectedIndex()) {
            case 0:
                VwMain.characterPlayer = Constants.PERSON1;
                break;
            case 1:
                VwMain.characterPlayer = Constants.PERSON2;
                break;
            case 2:
                VwMain.characterPlayer = Constants.PERSON3;
                break;
            case 3:
                VwMain.characterPlayer = Constants.PERSON4;
                break;
            case 4:
                VwMain.characterPlayer = Constants.PERSON5;
                break;
            case 5:
                VwMain.characterPlayer = Constants.PERSON6;
                break;
            case 6:
                VwMain.characterPlayer = Constants.PERSON7;
                break;
            case 7:
                VwMain.characterPlayer = Constants.PERSON8;
                break;
            case 8:
                VwMain.characterPlayer = Constants.PERSON9;
                break;
            case 9:
                VwMain.characterPlayer = Constants.PERSON10;
                break;
        }
    }

    private void getIACharacter() {
        if (cbCharacterPlayer.getSelectedIndex() != -1) {
            int randomIndex;
            do {
                randomIndex = new Random().nextInt(Constants.PEOPLEARRAY.length);
            } while (Constants.PEOPLEARRAY[randomIndex][0].equals(cbCharacterPlayer.getSelectedItem()));
            cbCharacterIA.setSelectedItem(Constants.PEOPLEARRAY[randomIndex][0]);
            VwMain.characterIA = Constants.PEOPLEARRAY[randomIndex];
        }
    }

    private void printCharacters() {
        try {
            System.out.println("Player: " + (characterPlayer[0]) + "\tIA: " + (characterIA[0]));
        } catch (NullPointerException e) {
            Mensajes.falla(this, "Selecciona un personaje");
            System.out.println("e " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            Mensajes.falla(this, "No se encontró personaje");
            System.out.println("e " + e.getMessage());
        }
    }

    private void selectQuestion(int selection) {
        if (turnPlayer) {
            if (cbCharacterPlayer.getSelectedIndex() != -1) {
                questionSelected = selection;
                VwQuestion question = new VwQuestion();
                question.setTitle("Pregunta " + questionSelected);
                question.setVisible(true);
            } else {
                Mensajes.falla(this, "Selecciona un personaje");
            }
        } else {
            Mensajes.falla(this, "Turno de la IA");
        }
    }

    private void guessIACharacter(String[] person) {
        if (turnPlayer) {
            if (cbCharacterIA.getSelectedIndex() != -1) {
                if (VwMain.characterIA[0].equals(person[0])) {
                    Mensajes.mensajes(this, "ADIVINASTE");
                } else {
                    Mensajes.mensajes(this, "INCORRECTO");
                }
            } else {
                Mensajes.falla(this, "Selecciona un personaje");
            }
        } else {
            Mensajes.falla(this, "Turno de la IA");
        }
    }

    public static void getFirstTurn() {
        int random = new Random().nextInt(2);
        System.out.println("random " + random);
        if (random != 0) {
            turnPlayer = true;
        } else {
            turnPlayer = false;
        }

        turnPlayer = false;
    }

    private void getTurn() {
        if (turnPlayer) {
            tfTurn.setText("Jugador");
            tfTurn.setBackground(Color.GREEN);
        } else {
            if (!evaluated) {
                evaluate();
            }
            tfTurn.setText("IA");
            tfTurn.setBackground(Color.RED);
        }
        tfTurn.validate();
        tfTurn.repaint();
    }

    public void nextTurn() {
        if (cbCharacterPlayer.getSelectedIndex() != -1) {
            if (turnPlayer) {
                Mensajes.mensajes(this, "Pregunta algo antes de continuar");
            } else {
                new VwQuestionIA().setVisible(true);
            }
        } else {
            Mensajes.falla(this, "Selecciona un personaje antes de continuar");
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

        jButton1 = new javax.swing.JButton();
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
        cbAnswers11 = new javax.swing.JComboBox<>();
        cbAnswers12 = new javax.swing.JComboBox<>();
        cbAnswers13 = new javax.swing.JComboBox<>();
        cbAnswers14 = new javax.swing.JComboBox<>();
        cbAnswers15 = new javax.swing.JComboBox<>();
        cbAnswers16 = new javax.swing.JComboBox<>();
        cbAnswers17 = new javax.swing.JComboBox<>();
        cbAnswers18 = new javax.swing.JComboBox<>();
        cbAnswers19 = new javax.swing.JComboBox<>();
        cbAnswers20 = new javax.swing.JComboBox<>();
        btnQuestion11 = new javax.swing.JButton();
        btnQuestion12 = new javax.swing.JButton();
        btnQuestion13 = new javax.swing.JButton();
        btnQuestion14 = new javax.swing.JButton();
        btnQuestion15 = new javax.swing.JButton();
        btnQuestion16 = new javax.swing.JButton();
        btnQuestion17 = new javax.swing.JButton();
        btnQuestion18 = new javax.swing.JButton();
        btnQuestion19 = new javax.swing.JButton();
        btnQuestion20 = new javax.swing.JButton();
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
        pnCharacters1 = new javax.swing.JPanel();
        btnPerson11 = new javax.swing.JButton();
        btnPerson12 = new javax.swing.JButton();
        btnPerson13 = new javax.swing.JButton();
        btnPerson14 = new javax.swing.JButton();
        btnPerson15 = new javax.swing.JButton();
        btnPerson16 = new javax.swing.JButton();
        btnPerson17 = new javax.swing.JButton();
        btnPerson18 = new javax.swing.JButton();
        btnPerson19 = new javax.swing.JButton();
        btnPerson20 = new javax.swing.JButton();
        pnOptions = new javax.swing.JPanel();
        lbPlayer = new javax.swing.JLabel();
        lbIA = new javax.swing.JLabel();
        lbTurn = new javax.swing.JLabel();
        tfTurn = new javax.swing.JTextField();
        cbCharacterPlayer = new javax.swing.JComboBox<>();
        cbCharacterIA = new javax.swing.JComboBox<>();
        btnNextTurn = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adivina Quién");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
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

        cbAnswers11.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS1));
        cbAnswers11.setSelectedIndex(-1);
        cbAnswers11.setEnabled(false);

        cbAnswers12.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS2));
        cbAnswers12.setSelectedIndex(-1);
        cbAnswers12.setEnabled(false);

        cbAnswers13.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS3));
        cbAnswers13.setSelectedIndex(-1);
        cbAnswers13.setEnabled(false);

        cbAnswers14.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS4));
        cbAnswers14.setSelectedIndex(-1);
        cbAnswers14.setEnabled(false);

        cbAnswers15.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS5));
        cbAnswers15.setSelectedIndex(-1);
        cbAnswers15.setEnabled(false);

        cbAnswers16.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS6));
        cbAnswers16.setSelectedIndex(-1);
        cbAnswers16.setEnabled(false);

        cbAnswers17.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS7));
        cbAnswers17.setSelectedIndex(-1);
        cbAnswers17.setEnabled(false);

        cbAnswers18.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS8));
        cbAnswers18.setSelectedIndex(-1);
        cbAnswers18.setEnabled(false);

        cbAnswers19.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS9));
        cbAnswers19.setSelectedIndex(-1);
        cbAnswers19.setEnabled(false);

        cbAnswers20.setModel(new javax.swing.DefaultComboBoxModel(Constants.ANSWERS10));
        cbAnswers20.setSelectedIndex(-1);
        cbAnswers20.setEnabled(false);

        btnQuestion11.setText(model.Constants.QUESTION1);
        btnQuestion11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion11ActionPerformed(evt);
            }
        });

        btnQuestion12.setText(model.Constants.QUESTION2);
        btnQuestion12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion12ActionPerformed(evt);
            }
        });

        btnQuestion13.setText(model.Constants.QUESTION3);
        btnQuestion13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion13ActionPerformed(evt);
            }
        });

        btnQuestion14.setText(model.Constants.QUESTION4);
        btnQuestion14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion14ActionPerformed(evt);
            }
        });

        btnQuestion15.setText(model.Constants.QUESTION5);
        btnQuestion15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion15ActionPerformed(evt);
            }
        });

        btnQuestion16.setText(model.Constants.QUESTION6);
        btnQuestion16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion16ActionPerformed(evt);
            }
        });

        btnQuestion17.setText(model.Constants.QUESTION7);
        btnQuestion17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion17ActionPerformed(evt);
            }
        });

        btnQuestion18.setText(model.Constants.QUESTION8);
        btnQuestion18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion18ActionPerformed(evt);
            }
        });

        btnQuestion19.setText(model.Constants.QUESTION9);
        btnQuestion19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion19ActionPerformed(evt);
            }
        });

        btnQuestion20.setText(model.Constants.QUESTION10);
        btnQuestion20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestion20ActionPerformed(evt);
            }
        });

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
                        .addComponent(cbAnswers1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnswers9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAnswers11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnswers19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuestion11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion17, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuestion19, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQuestionsLayout.setVerticalGroup(
            pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addComponent(btnQuestion11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestion20))
                    .addGroup(pnQuestionsLayout.createSequentialGroup()
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion1)
                            .addComponent(cbAnswers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion2)
                            .addComponent(cbAnswers2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion3)
                            .addComponent(cbAnswers3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion4)
                            .addComponent(cbAnswers4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion5)
                            .addComponent(cbAnswers5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion6)
                            .addComponent(cbAnswers6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion7)
                            .addComponent(cbAnswers7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion8)
                            .addComponent(cbAnswers8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion9)
                            .addComponent(cbAnswers9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuestion10)
                            .addComponent(cbAnswers10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnswers20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCharacters.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPerson1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1Homero.png"))); // NOI18N
        btnPerson1.setText(Constants.PERSON1[0]);
        btnPerson1.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson1.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson1.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson1ActionPerformed(evt);
            }
        });

        btnPerson2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/2Marge.png"))); // NOI18N
        btnPerson2.setText(Constants.PERSON2[0]);
        btnPerson2.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson2.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson2.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson2ActionPerformed(evt);
            }
        });

        btnPerson3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3Bart.png"))); // NOI18N
        btnPerson3.setText(Constants.PERSON3[0]);
        btnPerson3.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson3.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson3.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson3ActionPerformed(evt);
            }
        });

        btnPerson4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/4Lisa.png"))); // NOI18N
        btnPerson4.setText(Constants.PERSON4[0]);
        btnPerson4.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson4.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson4.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson4ActionPerformed(evt);
            }
        });

        btnPerson5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/5Maggie.png"))); // NOI18N
        btnPerson5.setText(Constants.PERSON5[0]);
        btnPerson5.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson5.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson5.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson5ActionPerformed(evt);
            }
        });

        btnPerson6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/6Abraham.png"))); // NOI18N
        btnPerson6.setText(Constants.PERSON6[0]);
        btnPerson6.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson6.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson6.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson6ActionPerformed(evt);
            }
        });

        btnPerson7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/7Krusty.png"))); // NOI18N
        btnPerson7.setText(Constants.PERSON7[0]);
        btnPerson7.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson7.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson7.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson7ActionPerformed(evt);
            }
        });

        btnPerson8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/8Ned.jpg"))); // NOI18N
        btnPerson8.setText(Constants.PERSON8[0]);
        btnPerson8.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson8.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson8.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson8ActionPerformed(evt);
            }
        });

        btnPerson9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9Edna.png"))); // NOI18N
        btnPerson9.setText(Constants.PERSON9[0]);
        btnPerson9.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson9.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson9.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson9ActionPerformed(evt);
            }
        });

        btnPerson10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/10Patty.jpg"))); // NOI18N
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
                    .addGroup(pnCharactersLayout.createSequentialGroup()
                        .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPerson4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPerson7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCharactersLayout.createSequentialGroup()
                                .addComponent(btnPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCharactersLayout.createSequentialGroup()
                                .addComponent(btnPerson5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCharactersLayout.createSequentialGroup()
                                .addComponent(btnPerson8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnPerson10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnCharactersLayout.setVerticalGroup(
            pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCharactersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPerson10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnCharacters1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPerson11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1Homero.png"))); // NOI18N
        btnPerson11.setText(Constants.PERSON1[0]);
        btnPerson11.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson11.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson11.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson11ActionPerformed(evt);
            }
        });

        btnPerson12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/2Marge.png"))); // NOI18N
        btnPerson12.setText(Constants.PERSON2[0]);
        btnPerson12.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson12.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson12.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson12ActionPerformed(evt);
            }
        });

        btnPerson13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3Bart.png"))); // NOI18N
        btnPerson13.setText(Constants.PERSON3[0]);
        btnPerson13.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson13.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson13.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson13ActionPerformed(evt);
            }
        });

        btnPerson14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/4Lisa.png"))); // NOI18N
        btnPerson14.setText(Constants.PERSON4[0]);
        btnPerson14.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson14.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson14.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson14ActionPerformed(evt);
            }
        });

        btnPerson15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/5Maggie.png"))); // NOI18N
        btnPerson15.setText(Constants.PERSON5[0]);
        btnPerson15.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson15.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson15.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson15ActionPerformed(evt);
            }
        });

        btnPerson16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/6Abraham.png"))); // NOI18N
        btnPerson16.setText(Constants.PERSON6[0]);
        btnPerson16.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson16.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson16.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson16ActionPerformed(evt);
            }
        });

        btnPerson17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/7Krusty.png"))); // NOI18N
        btnPerson17.setText(Constants.PERSON7[0]);
        btnPerson17.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson17.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson17.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson17ActionPerformed(evt);
            }
        });

        btnPerson18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/8Ned.jpg"))); // NOI18N
        btnPerson18.setText(Constants.PERSON8[0]);
        btnPerson18.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson18.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson18.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson18ActionPerformed(evt);
            }
        });

        btnPerson19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9Edna.png"))); // NOI18N
        btnPerson19.setText(Constants.PERSON9[0]);
        btnPerson19.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson19.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson19.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson19ActionPerformed(evt);
            }
        });

        btnPerson20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/10Patty.jpg"))); // NOI18N
        btnPerson20.setText(Constants.PERSON10[0]);
        btnPerson20.setMaximumSize(new java.awt.Dimension(75, 75));
        btnPerson20.setMinimumSize(new java.awt.Dimension(75, 75));
        btnPerson20.setPreferredSize(new java.awt.Dimension(75, 75));
        btnPerson20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerson20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCharacters1Layout = new javax.swing.GroupLayout(pnCharacters1);
        pnCharacters1.setLayout(pnCharacters1Layout);
        pnCharacters1Layout.setHorizontalGroup(
            pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCharacters1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCharacters1Layout.createSequentialGroup()
                        .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPerson11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPerson14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPerson17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCharacters1Layout.createSequentialGroup()
                                .addComponent(btnPerson12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCharacters1Layout.createSequentialGroup()
                                .addComponent(btnPerson15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCharacters1Layout.createSequentialGroup()
                                .addComponent(btnPerson18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPerson19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnPerson20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCharacters1Layout.setVerticalGroup(
            pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCharacters1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCharacters1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerson19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPerson20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCharacters1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCharacters1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCharacters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnQuestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbPlayer.setText("Personaje:");

        lbIA.setText("IA:");

        lbTurn.setText("Turno: ");

        tfTurn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tfTurn.setEnabled(false);

        cbCharacterPlayer.setModel(new javax.swing.DefaultComboBoxModel(Constants.PEOPLE));
        cbCharacterPlayer.setSelectedIndex(-1);
        cbCharacterPlayer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCharacterPlayerItemStateChanged(evt);
            }
        });

        cbCharacterIA.setModel(new javax.swing.DefaultComboBoxModel(Constants.PEOPLE));
        cbCharacterIA.setSelectedIndex(-1);
        cbCharacterIA.setEnabled(false);

        btnNextTurn.setBackground(new java.awt.Color(255, 255, 0));
        btnNextTurn.setForeground(new java.awt.Color(204, 204, 0));
        btnNextTurn.setText("SIGUIENTE");
        btnNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextTurnActionPerformed(evt);
            }
        });

        btnReset.setText("REINICIAR");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnOptionsLayout = new javax.swing.GroupLayout(pnOptions);
        pnOptions.setLayout(pnOptionsLayout);
        pnOptionsLayout.setHorizontalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPlayer)
                    .addComponent(lbIA))
                .addGap(21, 21, 21)
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOptionsLayout.createSequentialGroup()
                        .addComponent(cbCharacterPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTurn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbCharacterIA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNextTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap())
        );
        pnOptionsLayout.setVerticalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionsLayout.createSequentialGroup()
                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNextTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnOptionsLayout.createSequentialGroup()
                        .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnOptionsLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPlayer)
                                    .addComponent(cbCharacterPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTurn)
                                    .addComponent(tfTurn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbIA)
                                    .addComponent(cbCharacterIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnOptionsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerson1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson1ActionPerformed
        guessIACharacter(Constants.PERSON1);
    }//GEN-LAST:event_btnPerson1ActionPerformed

    private void btnPerson2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson2ActionPerformed
        guessIACharacter(Constants.PERSON2);
    }//GEN-LAST:event_btnPerson2ActionPerformed

    private void btnPerson3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson3ActionPerformed
        guessIACharacter(Constants.PERSON3);
    }//GEN-LAST:event_btnPerson3ActionPerformed

    private void btnPerson4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson4ActionPerformed
        guessIACharacter(Constants.PERSON4);
    }//GEN-LAST:event_btnPerson4ActionPerformed

    private void btnPerson5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson5ActionPerformed
        guessIACharacter(Constants.PERSON5);
    }//GEN-LAST:event_btnPerson5ActionPerformed

    private void btnPerson6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson6ActionPerformed
        guessIACharacter(Constants.PERSON6);
    }//GEN-LAST:event_btnPerson6ActionPerformed

    private void btnPerson7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson7ActionPerformed
        guessIACharacter(Constants.PERSON7);
    }//GEN-LAST:event_btnPerson7ActionPerformed

    private void btnPerson8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson8ActionPerformed
        guessIACharacter(Constants.PERSON8);
    }//GEN-LAST:event_btnPerson8ActionPerformed

    private void btnPerson9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson9ActionPerformed
        guessIACharacter(Constants.PERSON9);
    }//GEN-LAST:event_btnPerson9ActionPerformed

    private void btnPerson10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson10ActionPerformed
        guessIACharacter(Constants.PERSON10);
    }//GEN-LAST:event_btnPerson10ActionPerformed

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
        new VwReset().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbCharacterPlayerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCharacterPlayerItemStateChanged
        getCharacters();
    }//GEN-LAST:event_cbCharacterPlayerItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getFirstTurn();
        getTurn();
    }//GEN-LAST:event_formWindowOpened

    private void btnNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextTurnActionPerformed
        nextTurn();
    }//GEN-LAST:event_btnNextTurnActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        getTurn();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnQuestion11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion11ActionPerformed

    private void btnQuestion12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion12ActionPerformed

    private void btnQuestion13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion13ActionPerformed

    private void btnQuestion14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion14ActionPerformed

    private void btnQuestion15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion15ActionPerformed

    private void btnQuestion16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion16ActionPerformed

    private void btnQuestion17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion17ActionPerformed

    private void btnQuestion18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion18ActionPerformed

    private void btnQuestion19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion19ActionPerformed

    private void btnQuestion20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestion20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestion20ActionPerformed

    private void btnPerson11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson11ActionPerformed

    private void btnPerson12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson12ActionPerformed

    private void btnPerson13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson13ActionPerformed

    private void btnPerson14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson14ActionPerformed

    private void btnPerson15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson15ActionPerformed

    private void btnPerson16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson16ActionPerformed

    private void btnPerson17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson17ActionPerformed

    private void btnPerson18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson18ActionPerformed

    private void btnPerson19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson19ActionPerformed

    private void btnPerson20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerson20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerson20ActionPerformed

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
//            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VwMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VwMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextTurn;
    public static javax.swing.JButton btnPerson1;
    public static javax.swing.JButton btnPerson10;
    public static javax.swing.JButton btnPerson11;
    public static javax.swing.JButton btnPerson12;
    public static javax.swing.JButton btnPerson13;
    public static javax.swing.JButton btnPerson14;
    public static javax.swing.JButton btnPerson15;
    public static javax.swing.JButton btnPerson16;
    public static javax.swing.JButton btnPerson17;
    public static javax.swing.JButton btnPerson18;
    public static javax.swing.JButton btnPerson19;
    public static javax.swing.JButton btnPerson2;
    public static javax.swing.JButton btnPerson20;
    public static javax.swing.JButton btnPerson3;
    public static javax.swing.JButton btnPerson4;
    public static javax.swing.JButton btnPerson5;
    public static javax.swing.JButton btnPerson6;
    public static javax.swing.JButton btnPerson7;
    public static javax.swing.JButton btnPerson8;
    public static javax.swing.JButton btnPerson9;
    public static javax.swing.JButton btnQuestion1;
    public static javax.swing.JButton btnQuestion10;
    public static javax.swing.JButton btnQuestion11;
    public static javax.swing.JButton btnQuestion12;
    public static javax.swing.JButton btnQuestion13;
    public static javax.swing.JButton btnQuestion14;
    public static javax.swing.JButton btnQuestion15;
    public static javax.swing.JButton btnQuestion16;
    public static javax.swing.JButton btnQuestion17;
    public static javax.swing.JButton btnQuestion18;
    public static javax.swing.JButton btnQuestion19;
    public static javax.swing.JButton btnQuestion2;
    public static javax.swing.JButton btnQuestion20;
    public static javax.swing.JButton btnQuestion3;
    public static javax.swing.JButton btnQuestion4;
    public static javax.swing.JButton btnQuestion5;
    public static javax.swing.JButton btnQuestion6;
    public static javax.swing.JButton btnQuestion7;
    public static javax.swing.JButton btnQuestion8;
    public static javax.swing.JButton btnQuestion9;
    private javax.swing.JButton btnReset;
    public static javax.swing.JComboBox<String> cbAnswers1;
    public static javax.swing.JComboBox<String> cbAnswers10;
    public static javax.swing.JComboBox<String> cbAnswers11;
    public static javax.swing.JComboBox<String> cbAnswers12;
    public static javax.swing.JComboBox<String> cbAnswers13;
    public static javax.swing.JComboBox<String> cbAnswers14;
    public static javax.swing.JComboBox<String> cbAnswers15;
    public static javax.swing.JComboBox<String> cbAnswers16;
    public static javax.swing.JComboBox<String> cbAnswers17;
    public static javax.swing.JComboBox<String> cbAnswers18;
    public static javax.swing.JComboBox<String> cbAnswers19;
    public static javax.swing.JComboBox<String> cbAnswers2;
    public static javax.swing.JComboBox<String> cbAnswers20;
    public static javax.swing.JComboBox<String> cbAnswers3;
    public static javax.swing.JComboBox<String> cbAnswers4;
    public static javax.swing.JComboBox<String> cbAnswers5;
    public static javax.swing.JComboBox<String> cbAnswers6;
    public static javax.swing.JComboBox<String> cbAnswers7;
    public static javax.swing.JComboBox<String> cbAnswers8;
    public static javax.swing.JComboBox<String> cbAnswers9;
    public static javax.swing.JComboBox<String> cbCharacterIA;
    public static javax.swing.JComboBox<String> cbCharacterPlayer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbIA;
    private javax.swing.JLabel lbPlayer;
    private javax.swing.JLabel lbTurn;
    private javax.swing.JPanel pnCharacters;
    private javax.swing.JPanel pnCharacters1;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnQuestions;
    private javax.swing.JTextField tfTurn;
    // End of variables declaration//GEN-END:variables
}

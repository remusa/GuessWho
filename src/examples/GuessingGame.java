/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples;

/**
 * 
 * @author rms
 */
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GuessingGame extends JFrame implements ActionListener {
/**
 * 
 */
private static final long serialVersionUID = 1L;
private static JPanel startpanel;
private static JPanel aboutpanel;
private static JPanel creditpanel;
private static JPanel loadingEffect;
private static JPanel LST;
private static JPanel LSTfinal;
private static JPanel Next0Prev;
private JPanel loadingEffectBtn;
private JPanel firstPicblur;
private JPanel firstPicblurA;
private JPanel firstPiclabelA;
private ImageIcon guess,loading;
private JLabel    title,aboutmsg,aboutlabel,creditmsg,creditlabel,startLoading,level01,score01,time01,clueNo1;
private JButton start,about,credits,back2f1A,back2f1B,continueButton,Next,Prev;
private JTextField TypeHere;
static int gTime = 1000;
static int gScore = 1000000;

public GuessingGame(){
//Title page    
startpanel = new JPanel(new GridBagLayout());   
guess = new ImageIcon("C:\\java pics\\jigsaw.png");
title = new JLabel(guess);
start = new JButton("   Start  ");
about = new JButton("  About  ");
credits = new JButton(" Credits");

GridBagConstraints c = new GridBagConstraints();
c.insets = new Insets(10, 10, 10, 10);
c.gridx = 200;
c.gridy = 150;
startpanel.add(title,c);
c.gridx = 200;
c.gridy = 250;
startpanel.add(start,c);
c.gridx = 200;
c.gridy = 300;
startpanel.add(about,c);
c.gridx = 200;
c.gridy = 350;
startpanel.add(credits,c);

//About page
aboutpanel = new JPanel(new GridBagLayout());
aboutmsg = new JLabel("About the Game");
aboutlabel = new JLabel("This game is created for educational purpose");
back2f1A = new JButton("Back");

c.gridx = 100;
c.gridy = 5;
aboutpanel.add(aboutmsg,c);
c.gridx = 100;
c.gridy = 100;
aboutpanel.add(aboutlabel,c);
c.gridx = 100;
c.gridy = 150;
aboutpanel.add(back2f1A,c);

//Credit page
creditpanel = new JPanel(new GridBagLayout());
creditmsg = new JLabel("Created by");
creditlabel = new JLabel("estomo, Lim ,gelle");
back2f1B = new JButton("Back");

c.gridx = 100;
c.gridy = 5;
creditpanel.add(creditmsg,c);
c.gridx = 100;
c.gridy = 150;
creditpanel.add(creditlabel,c);
c.gridx = 100;
c.gridy = 200;
creditpanel.add(back2f1B,c);

//loading effect
loadingEffect = new JPanel(new GridBagLayout());
loadingEffectBtn = new JPanel(new GridBagLayout());
loading = new ImageIcon("C:\\java pics\\loading.gif");
startLoading = new JLabel(loading);
continueButton = new JButton("Continue");

c.gridx = 200;
c.gridy = 150;
loadingEffect.add(startLoading,c);
c.gridx = 200;
c.gridy = 250;
loadingEffectBtn.add(continueButton,c);

//first picture
LST = new JPanel();
level01 = new JLabel("Level: 1");
score01 = new JLabel("Score :__");
time01 = new JLabel("Time :__");

LST.add(level01);
LST.add(score01);
LST.add(time01);

//Next0Prev 
Next0Prev = new JPanel(new BorderLayout());
Next = new JButton("NEXT");
Prev = new JButton("PREV");
TypeHere = new JTextField("Guess Who");
clueNo1 = new JLabel("Picture Number 01");

Next0Prev.add(Next,BorderLayout.EAST);
Next0Prev.add(Prev,BorderLayout.WEST);
Next0Prev.add(TypeHere,BorderLayout.CENTER);
Next0Prev.add(clueNo1,BorderLayout.SOUTH);

//adding listener to all buttons
start.addActionListener(this);
continueButton.addActionListener(this);
credits.addActionListener(this);
back2f1A.addActionListener(this);
about.addActionListener(this);
back2f1B.addActionListener(this);
}
public static void main(String[] args){
    GuessingGame gg = new GuessingGame();
    gg.setTitle("Guesing Game");
    gg.setVisible(true);
    gg.setSize(500,500);
    gg.setLocationRelativeTo(null);
    gg.add(startpanel);


}
@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if (e.getSource() == about) {
        add(aboutpanel);
        aboutpanel.setVisible(true);
        aboutpanel.repaint();
        aboutpanel.revalidate();
        startpanel.setVisible(false);
    }
    else if (e.getSource() == back2f1A){
        add(startpanel);
        startpanel.setVisible(true);
        startpanel.repaint();
        startpanel.revalidate();
        aboutpanel.setVisible(false);
    }
    else if (e.getSource() == back2f1B){
        add(startpanel);
        startpanel.setVisible(true);
        startpanel.repaint();
        startpanel.revalidate();
        creditpanel.setVisible(false);
    }
    else if(e.getSource() == credits){
        add(creditpanel);
        creditpanel.setVisible(true);
        creditpanel.repaint();
        creditpanel.revalidate();
        startpanel.setVisible(false);
    }
    else if(e.getSource() == start){
        add(loadingEffect);
        loadingEffect.setVisible(true);
        loadingEffect.repaint();
        loadingEffect.revalidate();
        startpanel.setVisible(false);
        Timer t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(loadingEffectBtn);
                loadingEffectBtn.setVisible(true);
                loadingEffectBtn.repaint();
                loadingEffect.invalidate();
                loadingEffect.setVisible(false);
                }
                });
                t.start();
                t.setRepeats(false);
     }
    else if(e.getSource() == continueButton){
        add(Next0Prev);
        Next0Prev.setVisible(true);
        Next0Prev.repaint();
        Next0Prev.revalidate();
        loadingEffectBtn.setVisible(false);

        Timer t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(LST,BorderLayout.NORTH);
                time01.setText("time: " + gTime);
                gTime--;
         Timer t = new Timer(100, new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                score01.setText("score: " + gScore);
                gScore--;     
                }
                });
                t.start();
                t.setRepeats(true);
                }
                });
                t.start();
                t.setRepeats(true);
        }
    }
}

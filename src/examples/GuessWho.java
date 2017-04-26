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
//Name: Bhavika Sharma
//Date: Monday, January 14, 2013
//Purpose: Like the original Hasbro game, in which players ask true or false questions and use the answers to "Guess Who" the mystery person is. Created for Oskar Morgenstern's lectures for high school students on economics.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class GuessWho extends Applet implements ActionListener {

    Panel p_card; //to hold all of the screens
    Panel card1, card2, card3, card4, card5, card6, card7; //the six screens
    CardLayout cdLayout = new CardLayout();
    JButton reset1, reset2, reset3, reset4; //reset buttons
    JButton a[] = new JButton[9], c[] = new JButton[16], g[] = new JButton[20], j[] = new JButton[24]; //characters printed on JButtons, higher level means more people

    int pointsTracker[] = new int[4]; //tracks points for each level
    int attemptsTracker[] = new int[4]; //tracks attempts for each level
    int tracker[] = new int[24]; //tracks random numbers which determine which characters to show
    int secret[] = new int[4]; //index of "mystery person"

    int screens = 2; //determines what screen player is on
    int beginning = 0;

    JButton points[] = new JButton[15]; //buttons on points screen

    int progress, progress2, progress3, progress4; //progress percentage for each level

    JButton next1, next2, next3, next4; //button that allows player to move to next level / main page when they guess the "mystery person"
    JButton enter1, enter2, enter3, enter4; //allows player to submit answer

    JTextField ans1, ans2, ans3, ans4; //player types in answers in textfields

    //name of people / characters
    String name[] = {"Alejandro", "Alfredo", "Ana", "Anita", "Bernardo", "Carlos", "Clara", "David", "Ernesto", "Felipe", "German", "Guillermo", "Jorge", "Manuel", "Maria", "Pablo", "Paco", "Pedro", "Pepe", "Ricardo", "Roberto", "Samuel", "Susana", "Tomas"};

    //questions to ask
    String command[] = {"Is your 'mystery person' a boy?", "Does your 'mystery person' wear glasses?", "Is your 'mystery person' wearing a hat?", "Does your 'mystery person' look sad?", "Does your 'mystery person' have blue eyes?", "Does your 'mystery person' have brown eyes?", "Does your 'mystery person' have black hair?", "Does your 'mystery person' have brown hair?", "Does your 'mystery person' have white hair?", "Does your 'mystery person' have blond hair?", "Does your 'mystery person' have orange hair?", "Does your 'mystery person' have a mustache?", "Does your 'mystery person' have a beard?", "Does your 'mystery person' have red cheeks?", "Does your 'mystery person' have a big nose?", "Does your 'mystery person' have big lips?"};

    JButton b[] = new JButton[command.length], d[] = new JButton[command.length], f[] = new JButton[command.length]; //used in Panel as a list of JButtons for questions in levels 1-3

    JCheckBox h[] = new JCheckBox[command.length]; //used in Panel as a list of JCheckBox for questions in level 4

    //progressbar for levels 1-4 respectively
    JProgressBar p, p2, p3, p4; //increases as characters are removed from screen

    JMenuItem menuItem; //adding to menu is a seperate method

    //stores answers to questions (whether they're true or false)
    //columns represent poeple, rows represent questions
    boolean options[][] = {{
        true, true, false, false, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true},
    {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true, false, false, true, false, true},
    {false, false, false, false, true, false, true, false, true, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false},
    {false, true, true, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false},
    {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, false, true},
    {true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, false, true, true, false},
    {true, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
    {false, false, false, false, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, true, true, false, false, false},
    {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, true, false, false, false, true, true, false},
    {false, false, false, true, false, true, false, true, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false},
    {false, true, false, false, false, false, true, false, false, false, true, true, false, false, false, false, true, false, false, false, false, false, false, false},
    {true, true, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false,},
    {false, false, false, false, false, false, false, true, false, true, false, true, false, false, false, false, false, false, false, true, false, false, false, false},
    {false, false, false, true, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, true, false, true, false},
    {false, false, true, false, true, false, false, false, false, false, true, false, false, true, false, false, false, true, false, false, true, false, false, false},
    {true, false, false, false, false, true, false, true, true, true, false, false, true, true, false, false, false, true, false, false, true, false, true, false}};

    //initializes game
    public void init() {
        for (int i = 0; i < 24; i++) {
            tracker[i] = i;
        }
        p_card = new Panel();
        p_card.setLayout(cdLayout);

        screen1();
        screen2();
        screen3();
        screen4();
        screen5();
        screen6();
        screen7();
        resize(1040, 700);
        setLayout(new BorderLayout());
        initMenu();
        add("Center", p_card);
    }

    //puts the people's names / "cards" in a random order
    public void randomize() {
        for (int i = 0; i < 500; i++) {
            int p = (int) (Math.random() * 24);
            int q = (int) (Math.random() * 24);
            //tracked using "tracker []"
            int temp = tracker[p];
            tracker[p] = tracker[q];
            tracker[q] = temp;
        }
    }

    //resets level 1
    public void resetA() {
        for (int i = 0; i < a.length; i++) //prints pictures according to tracker []
        {
            a[i].setIcon(createImageIcon(name[tracker[i]] + ".jpg")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
        }
        for (int i = 0; i < a.length; i++) //shows all pictures
        {
            a[i].setVisible(true);
        }
        //resets progress bar
        progress = 0;
        p.setValue(progress);

        for (int i = 0; i < b.length; i++) //resets questions
        {
            b[i].setText(command[i]);
            b[i].setFont(new Font("Arial", Font.BOLD, 12));
        }

        secret[0] = (int) (Math.random() * (a.length - 1));
        next1.setVisible(false);
        enter1.setEnabled(true);
        ans1.setText("");
    }

    //resets level 2
    public void resetB() {
        for (int i = 0; i < c.length; i++) //prints pictures according to tracker []
        {
            c[i].setIcon(createImageIcon(name[tracker[i]] + ".jpg")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
        }
        for (int i = 0; i < c.length; i++) //shows all pictures
        {
            c[i].setVisible(true);
        }
        //resets progress bar
        progress2 = 0;
        p2.setValue(progress2);

        for (int i = 0; i < d.length; i++) //resets questions
        {
            d[i].setText(command[i]);
            d[i].setFont(new Font("Arial", Font.BOLD, 12));
        }
        secret[1] = (int) (Math.random() * (c.length - 1));
        next2.setVisible(false);
        enter2.setEnabled(true);
        ans2.setText("");
    }

    //resets level 3
    public void resetC() {
        for (int i = 0; i < g.length; i++) //prints pictures according to tracker []
        {
            g[i].setIcon(createImageIcon(name[tracker[i]] + ".jpg")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
        }
        for (int i = 0; i < g.length; i++) //shows all pictures
        {
            g[i].setVisible(true);
        }
        //resets progress bar
        progress3 = 0;
        p3.setValue(progress3);

        for (int i = 0; i < f.length; i++) //resets questions
        {
            f[i].setText(command[i]);
            f[i].setFont(new Font("Arial", Font.BOLD, 12));
        }

        secret[2] = (int) (Math.random() * (g.length - 1));
        next3.setVisible(false);
        enter3.setEnabled(true);
        ans3.setText("");
    }

    //resets level 4
    public void resetD() {
        for (int i = 0; i < j.length; i++) //prints pictures according to tracker []
        {
            j[i].setIcon(createImageIcon(name[tracker[i]] + ".jpg")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
        }
        for (int i = 0; i < j.length; i++) //shows all pictures
        {
            j[i].setVisible(true);
        }
        //resets progress bar
        progress4 = 0;
        p4.setValue(progress4);

        for (int i = 0; i < h.length; i++) //resets questions
        {
            h[i].setText(command[i]);
            h[i].setFont(new Font("Arial", Font.BOLD, 12));
            h[i].setEnabled(true);
            h[i].setSelected(false);
        }

        secret[3] = (int) (Math.random() * (j.length - 1));
        next4.setVisible(false);
        enter4.setEnabled(true);
        ans4.setText("");
    }

    //resets (changes to 0) points and the number of attempts for level 1
    //prints the points (0) and accuracy rate (0.0% right)
    public void resetPointsA() {
        pointsTracker[0] = 0;
        attemptsTracker[0] = 0;
        points[5].setIcon((null));
        points[9].setIcon((null));
        points[5].setText("Level 1 points: 0 (0.0% right)");
    }

    //resets (changes to 0) points and the number of attempts for level 2
    //prints the points (0) and accuracy rate (0.0% right)
    public void resetPointsB() {
        pointsTracker[1] = 0;
        attemptsTracker[1] = 0;
        points[6].setIcon((null));
        points[9].setIcon((null));
        points[6].setText("Level 2 points: 0 (0.0% right)");
    }

    //resets (changes to 0) points and the number of attempts for level 3
    //prints the points (0) and accuracy rate (0.0% right)
    public void resetPointsC() {
        pointsTracker[2] = 0;
        attemptsTracker[2] = 0;
        points[7].setIcon((null));
        points[9].setIcon((null));
        points[7].setText("Level 3 points: 0 (0.0% right)");
    }

    //resets (changes to 0) points and the number of attempts for level 4
    //prints the points (0) and accuracy rate (0.0% right)
    public void resetPointsD() {
        pointsTracker[3] = 0;
        attemptsTracker[3] = 0;
        points[8].setIcon((null));
        points[9].setIcon((null));
        points[8].setText("Level 4 points: 0 (0.0% right)");
    }

    //prints the points and accuracy rate
    public void countPoints() {
        int score = 0;
        for (int i = 0; i < pointsTracker.length; i++) //counts the total points
        {
            score += pointsTracker[i];
        }
        double attempts = 0;
        for (int i = 0; i < attemptsTracker.length; i++) //counts the total attempts
        {
            attempts += attemptsTracker[i];
        }
        double right = score;
        points[9].setText("Total points: " + score + " (" + round(right / attempts) * 100 + "% right)");
    }

    //rounds a number (num) to 2 place values before the decimal
    public double round(double num) {
        double num2 = num * Math.pow(10, 2);
        double num3 = (num2 - ((int) num2)) * 10;
        num2 = ((int) num2);
        if (num3 >= 5) {
            num2++;
        }
        return num2 /= Math.pow(10, 2);
    }

    //creates a Panel of people accoring to what level / screen(i.e. what JButton array and size of board) the player is on
    //returns Panel
    public Panel people(JButton array[], int length, int width, char action, int red, int green, int blue) {
        //based on tracker []
        //uses the value to output a card with that index in name []
        Panel grid1 = new Panel(new GridLayout(length, width));
        for (int i = 0; i < array.length; i++) //adds people to Panel
        {
            array[i] = new JButton(createImageIcon(name[tracker[i]] + ".jpg")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
            array[i].addActionListener(this);
            array[i].setActionCommand("" + action + i);
            array[i].setBackground(new Color(red, green, blue));
            array[i].setPreferredSize(new Dimension(100, 100));
            grid1.add(array[i]);
        }
        return grid1;
    }

    //creates a Panel of 16 questions on JButtons
    //variable array [] defines what screen the Panel is used on (e.g. if array [] = b [], refers to level 1)
    //returns Panel
    public Panel questions(JButton array[], int red, int green, int blue) {
        Panel grid2 = new Panel(new GridLayout(16, 1));
        for (int i = 0; i < array.length; i++) //adds people to Panel
        {
            array[i] = new JButton(command[i]);
            array[i].addActionListener(this);
            array[i].setActionCommand("" + i);
            array[i].setBackground(new Color(red, green, blue));
            array[i].setPreferredSize(new Dimension(410, 25));
            grid2.add(array[i]);
        }
        return grid2;
    }

    //prints true or false according to the question the player asked
    public void trueOrFalse(JButton array[], int num, int level) {
        //checks mystery person's characteristics, defined in options []
        if (!options[num][tracker[secret[level]]]) //if false prints false
        {
            array[num].setText(command[num] + " No");
            array[num].setFont(new Font("Papyrus", Font.ITALIC, 12));
        } else {
            array[num].setText(command[num] + " Yes"); //else prints true
            array[num].setFont(new Font("Papyrus", Font.PLAIN, 12));
        }
    }

    public void ifCorrect(String playerAns, JButton next, JButton enter, JProgressBar bar, int progress, int array) {
        if (playerAns.equalsIgnoreCase(name[tracker[secret[array]]])) {
            next.setVisible(true); //allows player to go to home screen
            enter.setEnabled(false); //controls input by disabling enter
            progress = 100;
            bar.setValue(progress);
            pointsTracker[array]++; //also adds a point if it is correct
            JOptionPane.showMessageDialog(null, createImageIcon("You Passed.jpg"), "Good Job! You're Right!",
                    JOptionPane.INFORMATION_MESSAGE); //"Court Ordered Classes." Justice Law Center - Las Vegas. http://mylasvegaslawyer.com/court-ordered-classes/ (accessed January 5, 2013).
        } //Shows an error dialog that tells the player they are wrong
        else {
            JOptionPane.showMessageDialog(null, "Sorry, that's the wrong answer! Please try again.", "Sorry",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //prints points and accuracy rate depending on level
    public void printPoints(int one, int two) {
        double right = pointsTracker[two];
        double tries = attemptsTracker[two];
        points[one].setIcon((null)); //removes picture to print points
        points[one].setText("Level " + (two + 1) + " points: " + pointsTracker[two] + " (" + round(right / tries) * 100 + "% right)");
    }

    //adds a item to JMenu
    //changes the colour of the item to match theme of game
    public void addToMenu(String text, String action) {
        menuItem = new JMenuItem(text);
        menuItem.addActionListener(this);
        menuItem.setActionCommand(action);
        menuItem.setBackground(new Color(206, 238, 251));
    }

    //creates a JMenu with menus "File" and "Navigate"
    //submenus include levels and resetting levels and points
    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu, submenu;

        menu = new JMenu("File");
        menuBar.add(menu);
        menuBar.setBackground(new Color(206, 238, 251));
        menu.setBackground(new Color(206, 238, 251));

        addToMenu("Close", "Close");
        menu.add(menuItem);

        //a submenu
        submenu = new JMenu("Reset Level");
        submenu.setBackground(new Color(206, 238, 251));

        for (int i = 0; i < 3; i++) {
            addToMenu("Reset Level " + (i + 1), "reset" + (i + 1));
            submenu.add(menuItem);
        }
        addToMenu("Reset All Levels", "reset all");
        submenu.add(menuItem);

        menu.add(submenu);

        //a submenu
        submenu = new JMenu("Reset Points (and Accuracy Rate)");
        submenu.setBackground(new Color(206, 238, 251));

        for (int i = 0; i < 3; i++) {
            addToMenu("Reset Level " + (i + 1) + " Points", "reset points" + (i + 1));
            submenu.add(menuItem);
        }
        addToMenu("Reset All Points", "reset points5");
        submenu.add(menuItem);

        menu.add(submenu);

        addToMenu("Reset Entire Game / Play Again", "play again");
        menu.add(menuItem);

        menu = new JMenu("Navigate");
        menuBar.add(menu);
        menu.setBackground(new Color(206, 238, 251));

        addToMenu("Main Menu", "s1");
        menu.add(menuItem);

        addToMenu("Instruction / Help", "s7");
        menu.add(menuItem);

        addToMenu("Points", "s6");
        menu.add(menuItem);

        //a submenu
        submenu = new JMenu("Play");
        submenu.setBackground(new Color(206, 238, 251));

        for (int i = 0; i < 3; i++) {
            addToMenu("Level " + (i + 1), "s" + (i + 2));
            submenu.add(menuItem);
        }

        menu.add(submenu);

        add("North", menuBar);
    }

    //screen 1 (homepage) is set up
    public void screen1() {
        card1 = new Panel();

        String playerName = JOptionPane.showInputDialog("Please enter your name");

        JLabel title = new JLabel(createImageIcon("Title Page 2.jpg"));
        //"Identifican cinco genes responsable de dar forma al rostro humano ." Fantasymundo.com: ENTRETENIMIENTO Y CULTURA. http://www.fantasymundo.com/noticias/23136/identifican_cinco_genes_responsable_dar_forma_rostro_humano (accessed December 19, 2012).
        //"Hasbro GUESS WHO?® Game.". Walmart.http://www.walmart.ca/en/ip/hasbro-guess-who-game/157352. (accessed December 14, 2012)
        title.setPreferredSize(new Dimension(1000, 580));
        card1.setBackground(new Color(206, 238, 251));

        Panel home = new Panel(new GridLayout(1, 3));

        JButton homepage[] = new JButton[3];
        //images on buttons created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 15, 2012).
        String homepage2[] = {"instructions.jpg", "play.jpg", "points.jpg"};
        String homepage3[] = {"s7", "s2", "s6"};

        for (int i = 0; i < homepage.length; i++) //adds buttons and ActionCommands to navigate from homepage
        {
            homepage[i] = new JButton((createImageIcon(homepage2[i])));
            homepage[i].setPreferredSize(new Dimension(299, 58));
            homepage[i].setActionCommand(homepage3[i]);
            homepage[i].addActionListener(this);
            home.add(homepage[i]);
        }

        JLabel peoplePic1 = new JLabel(createImageIcon("All People.gif")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).
        JLabel peoplePic2 = new JLabel(createImageIcon("All People 2.gif")); //"Juegos para practicar el español - ?a????d?a e??s??s?? ?spa????? ." Espanol.gr. http://espanolgr.blogspot.ca/ (accessed December 14, 2012).

        card1.add(title);
        card1.add(peoplePic1);
        card1.add(home);
        card1.add(peoplePic2);
        p_card.add("1", card1);
    }

    //screen 2 (level 1) is set up
    public void screen2() {
        card2 = new Panel();
        card2.setBackground(new Color(244, 244, 95));

        JLabel title = new JLabel(createImageIcon("Level 1.jpg")); //title created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 15, 2012).

        title.setPreferredSize(new Dimension(900, 175));
        ans1 = new JTextField(8);

        //quick explanation of basic game functions
        //prompt created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 17, 2012).
        JLabel prompt1 = new JLabel(createImageIcon("prompt 1.jpg"));
        JLabel prompt2 = new JLabel(createImageIcon("prompt 2.jpg"));

        JLabel whoIsIt = new JLabel("Who do you think the mystery person is? Enter Here ");
        JLabel arrow = new JLabel(createImageIcon("level 1 arrow.jpg"));

        //buttton created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 17, 2012).
        enter1 = new JButton(createImageIcon("enter 1.jpg"));
        enter1.addActionListener(this);
        enter1.setActionCommand("enter1");
        enter1.setPreferredSize(new Dimension(60, 30));

        //buttton created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 18, 2012).
        next1 = new JButton(createImageIcon("next level 1.gif"));
        next1.setActionCommand("s3");
        next1.addActionListener(this);
        next1.setPreferredSize(new Dimension(178, 38));

        p = new JProgressBar(0, 0, 100);
        p.setValue(0);
        p.setStringPainted(true);
        p.setForeground(Color.orange);

        Panel level1 = new Panel(new GridLayout(1, 2));
        level1.add(people(a, 3, 3, 'a', 244, 244, 95));
        level1.add(questions(b, 255, 200, 0));

        card2.add(title);
        card2.add(prompt1);
        card2.add(prompt2);
        card2.add(level1);
        card2.add(whoIsIt);
        card2.add(arrow);
        card2.add(ans1);
        card2.add(enter1);
        card2.add(p);
        card2.add(next1);

        p_card.add("2", card2);
    }

    //screen 3 (level 2) is set up
    public void screen3() {
        card3 = new Panel();
        card3.setBackground(new Color(66, 252, 141));

        JLabel title = new JLabel(createImageIcon("Level 2.jpg")); //title created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 25, 2012).
        title.setPreferredSize(new Dimension(900, 165));
        ans2 = new JTextField(8);

        //quick explanation of basic game functions
        //prompt created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 17, 2012).
        JLabel prompt1 = new JLabel(createImageIcon("prompt 3.jpg"));
        JLabel prompt2 = new JLabel(createImageIcon("prompt 4.jpg"));

        JLabel whoIsIt = new JLabel("Who do you think the mystery person is? Enter Here ");
        JLabel arrow = new JLabel(createImageIcon("level 2 arrow.jpg"));

        //button created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 14, 2012).
        enter2 = new JButton(createImageIcon("enter 2.jpg"));
        enter2.addActionListener(this);
        enter2.setActionCommand("enter2");
        enter2.setPreferredSize(new Dimension(60, 30));

        Panel level2 = new Panel(new GridLayout(1, 2));
        level2.add(people(c, 4, 4, 'k', 66, 252, 141));
        level2.add(questions(d, 64, 205, 28));

        //button created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 17, 2012).
        next2 = new JButton(createImageIcon("next level 2.gif"));
        next2.setActionCommand("s4");
        next2.addActionListener(this);
        next2.setPreferredSize(new Dimension(178, 38));

        p2 = new JProgressBar(0, 0, 100);
        p2.setValue(0);
        p2.setStringPainted(true);
        p2.setForeground(new Color(64, 205, 28));

        card3.add(title);
        card3.add(prompt1);
        card3.add(prompt2);
        card3.add(level2);
        card3.add(whoIsIt);
        card3.add(arrow);
        card3.add(ans2);
        card3.add(enter2);
        card3.add(p2);
        card3.add(next2);

        p_card.add("3", card3);
    }

    //screen 4 (level 3) is set up
    public void screen4() {
        card4 = new Panel();
        card4.setBackground(new Color(250, 25, 115));

        //title created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 29, 2012).
        JLabel title = new JLabel(createImageIcon("Level 3.jpg"));
        title.setPreferredSize(new Dimension(900, 168));
        ans3 = new JTextField(8);

        //quick explanation of basic game functions
        //prompt created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 14, 2012).
        JLabel prompt1 = new JLabel(createImageIcon("prompt 5.jpg"));
        JLabel prompt2 = new JLabel(createImageIcon("prompt 6.jpg"));

        JLabel whoIsIt = new JLabel("Who do you think the mystery person is? Enter Here ");
        JLabel arrow = new JLabel(createImageIcon("level 3 arrow.jpg"));

        //button created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 30, 2012).
        enter3 = new JButton(createImageIcon("enter 3.jpg"));
        enter3.addActionListener(this);
        enter3.setActionCommand("enter3");
        enter3.setPreferredSize(new Dimension(60, 30));

        //button created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed January 10, 2013).
        next3 = new JButton(createImageIcon("back to main page 1.gif"));
        next3.setActionCommand("s1");
        next3.addActionListener(this);
        next3.setPreferredSize(new Dimension(283, 37));

        p3 = new JProgressBar(0, 0, 100);
        p3.setValue(0);
        p3.setStringPainted(true);
        p3.setForeground(new Color(255, 128, 128));

        card4.add(title);
        card4.add(prompt1);
        card4.add(prompt2);
        card4.add(people(g, 4, 5, 'A', 250, 25, 115));
        card4.add(questions(f, 255, 128, 128));
        card4.add(whoIsIt);
        card4.add(arrow);
        card4.add(ans3);
        card4.add(enter3);
        card4.add(p3);
        card4.add(next3);

        p_card.add("4", card4);
    }

    //screen 5 (level 4) is set up
    public void screen5() {
        card5 = new Panel();
        card5.setBackground(new Color(202, 0, 5));

        //title created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 23, 2012).
        JLabel title = new JLabel(createImageIcon("Level 4.jpg"));
        title.setPreferredSize(new Dimension(900, 150));
        ans4 = new JTextField(8);

        //quick explanation of basic game functions
        //prompt created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 23, 2012).
        JLabel prompt1 = new JLabel(createImageIcon("prompt 7.jpg"));
        JLabel prompt2 = new JLabel(createImageIcon("prompt 8.jpg"));

        JLabel whoIsIt = new JLabel("Who do you think the mystery person is? Enter Here ");
        JLabel arrow = new JLabel(createImageIcon("level 4 arrow.jpg"));

        //buttton created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 17, 2012).
        enter4 = new JButton(createImageIcon("enter 4.jpg"));
        enter4.addActionListener(this);
        enter4.setActionCommand("enter4");
        enter4.setPreferredSize(new Dimension(60, 30));

        //buttton created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed December 18, 2012).
        next4 = new JButton(createImageIcon("back to main page 3.gif"));
        next4.setActionCommand("s1");
        next4.addActionListener(this);
        next4.setPreferredSize(new Dimension(283, 37));

        p4 = new JProgressBar(0, 0, 100);
        p4.setValue(0);
        p4.setStringPainted(true);
        p4.setForeground(new Color(170, 0, 4));

        //creates a Panel of 16 questions on JCheckBoxes
        Panel grid3 = new Panel(new GridLayout(16, 1));

        for (int i = 0; i < h.length; i++) {
            h[i] = new JCheckBox(command[i]);
            h[i].addActionListener(this);
            h[i].setActionCommand("" + i);
            h[i].setBackground(new Color(170, 0, 4));
            h[i].setPreferredSize(new Dimension(325, 25));
            grid3.add(h[i]);
        }

        card5.add(title);
        card5.add(prompt1);
        card5.add(prompt2);
        card5.add(people(j, 4, 6, 'K', 202, 0, 5));
        card5.add(grid3);
        card5.add(whoIsIt);
        card5.add(arrow);
        card5.add(ans4);
        card5.add(enter4);
        card5.add(p4);
        card5.add(next4);

        p_card.add("5", card5);
    }

    //screen 7 (instructions page) is set up
    public void screen7() {
        card7 = new Panel();
        card7.setBackground(new Color(0, 187, 255));

        JLabel pic = new JLabel(createImageIcon("instructions 6.jpg"));
        //Microsoft.confusedPerson.MicrosoftWordClipart (2010).
        //"free digital vintage flower frame & border." MeinLilaPark. http://meinlilapark.blogspot.ca/2012/10/free-digital-vintage-flower-frame.html (accessed January 15, 2013).
        pic.setPreferredSize(new Dimension(1040, 625));

        //button created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed January 4, 2013).
        JButton next5 = new JButton(createImageIcon("back to main page 2.gif"));
        next5.setActionCommand("s1");
        next5.addActionListener(this);
        next5.setPreferredSize(new Dimension(283, 37));

        card7.add(pic);
        card7.add(next5);
        p_card.add("7", card7);
    }

    //screen 6 (points page) is set up
    public void screen6() {
        card6 = new Panel();
        card6.setBackground(new Color(204, 143, 231));

        //title created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed January 8, 2013).
        JLabel title = new JLabel(createImageIcon("points title.jpg"));
        title.setPreferredSize(new Dimension(705, 190));

        JLabel prompt = new JLabel("All of the following pictures are buttons. Click on the first row to change the screen, the second row to check your points and the third row to reset them.");

        Panel pointsPanel = new Panel(new GridLayout(1, 5));

        //images created using "Cool Text: Logo and Graphics Generator." Cool Text: Logo and Graphics Generator. http://cooltext.com/ (accessed January 3, 2013).
        for (int i = 0; i < points.length; i++) //chooses picture according to placement of button
        {
            if (i < 5) {
                points[i] = new JButton(createImageIcon("level " + (i + 1) + " screen pic.jpg"));
            } else if (i < 10) {
                points[i] = new JButton(createImageIcon("points check " + i + ".jpg"));
            } else {
                points[i] = new JButton(createImageIcon("reset points " + (i - 9) + ".jpg"));
            }
            points[i].setPreferredSize(new Dimension(200, 132));
        }

        Panel allLevelPoints[] = new Panel[5];

        for (int i = 0; i < allLevelPoints.length; i++) //makes screen look ordered using a Panel inside a Panel array
        {
            allLevelPoints[i] = new Panel(new GridLayout(3, 1));
            for (int j = 0; j < points.length; j += 5) {
                allLevelPoints[i].add(points[j + i]);
            }
            pointsPanel.add(allLevelPoints[i]);
        }

        for (int i = 0; i < points.length; i++) //sets ActionCommands and background colour of 15 buttons
        {
            points[i].addActionListener(this);
            points[i].setBackground(new Color(204, 143, 231));
            if (i > 9) {
                points[i].setActionCommand("reset points" + (i - 9));
            } else if (i > 4) {
                points[i].setActionCommand("points" + (i - 4));
            } else if (i == 4) {
                points[i].setActionCommand("s" + (i - 3));
            } else {
                points[i].setActionCommand("s" + (i + 2));
            }
        }

        JLabel reminder = new JLabel("It should be noted that resetting your points for a certain level resets the accuracy rate for that level as well.");

        card6.add(title);
        card6.add(prompt);
        card6.add(pointsPanel);
        card6.add(reminder);
        p_card.add("6", card6);
    }

    //actions carried out
    public void actionPerformed(ActionEvent e) {
        //moves between screens
        if (e.getActionCommand().equals("s1")) {
            cdLayout.show(p_card, "1");
        } else if (e.getActionCommand().equals("s2")) {
            randomize();
            cdLayout.show(p_card, "2");
            screens = 2;
            resetA();
            if (beginning == 0) {
                //Shows an information box introducing game
                JOptionPane.showMessageDialog(null, "   The object of the game is to eliminate people from the screen. \nWhen only one person is left, you know they're the mystery person.", "Reminder",
                        JOptionPane.INFORMATION_MESSAGE);
                beginning++;
            }
        } else if (e.getActionCommand().equals("s3")) {
            randomize();
            cdLayout.show(p_card, "3");
            resetB();
            screens = 3;
            if (beginning == 0) {
                //Shows an information box introducing game
                JOptionPane.showMessageDialog(null, "   The object of the game is to eliminate people from the screen. \nWhen only one person is left, you know they're the mystery person.", "Reminder",
                        JOptionPane.INFORMATION_MESSAGE);
                beginning++;
            }
        } else if (e.getActionCommand().equals("s4")) {
            randomize();
            cdLayout.show(p_card, "4");
            resetC();
            screens = 4;
            if (beginning == 0) {
                //Shows an information box introducing game
                JOptionPane.showMessageDialog(null, "   The object of the game is to eliminate people from the screen. \nWhen only one person is left, you know they're the mystery person.", "Reminder",
                        JOptionPane.INFORMATION_MESSAGE);
                beginning++;
            }
        } //only accessible through points screen after guessing correctly for each level
        else if (e.getActionCommand().equals("s5")) {
            randomize();
            cdLayout.show(p_card, "5");
            resetD();
            screens = 5;
            //Shows an information box telling player that level 4 is a secret
            JOptionPane.showMessageDialog(null, "   You have accessed the secret level, level 4. This means that you have \nguessed the 'mystery person' in each level. Try this final level. Good Luck!", "Good Job!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getActionCommand().equals("s7")) {
            cdLayout.show(p_card, "7");
        } else if (e.getActionCommand().equals("s6")) {
            cdLayout.show(p_card, "6");
            for (int i = 5; i < 10; i++) //resets points screen
            {
                points[i].setText("");
                points[i].setIcon(createImageIcon("points check " + i + ".jpg"));
            }
            if (pointsTracker[0] > 0 && pointsTracker[1] > 0 && pointsTracker[2] > 0) //shows level 4 in "secret location"
            {
                for (int i = 3; i < points.length; i += 5) {
                    points[i].setVisible(true);
                }
            } else //hides "secret" fourth level
            {
                for (int i = 3; i < points.length; i += 5) {
                    points[i].setVisible(false);
                }
            }

        } //checks if player's answer is correct for level 1
        else if (e.getActionCommand().equals("enter1")) {
            String playerAns1 = ans1.getText();
            attemptsTracker[0]++;
            ifCorrect(playerAns1, next1, enter1, p, progress, 0);
        } //checks if player's answer is correct for level 2
        else if (e.getActionCommand().equals("enter2")) {
            String playerAns2 = ans2.getText();
            attemptsTracker[1]++;
            ifCorrect(playerAns2, next2, enter2, p2, progress2, 1);
        } //checks if player's answer is correct for level 3
        else if (e.getActionCommand().equals("enter3")) {
            String playerAns3 = ans3.getText();
            attemptsTracker[2]++;
            ifCorrect(playerAns3, next3, enter3, p3, progress3, 2);

        } //checks if player's answer is correct for level 4
        else if (e.getActionCommand().equals("enter4")) {
            String playerAns4 = ans4.getText();
            attemptsTracker[3]++;
            ifCorrect(playerAns4, next4, enter4, p4, progress4, 3);
        } //prints points using printPoints method
        else if (e.getActionCommand().equals("points1")) {
            printPoints(5, 0);
        } else if (e.getActionCommand().equals("points2")) {
            printPoints(6, 1);
        } else if (e.getActionCommand().equals("points3")) {
            printPoints(7, 2);
        } else if (e.getActionCommand().equals("points4")) {
            printPoints(8, 3);
        } else if (e.getActionCommand().equals("points5")) {
            points[9].setIcon((null));
            countPoints();
        } //randomizes tracker and resets and reprints level 1
        else if (e.getActionCommand().equals("reset1")) {
            randomize();
            resetA();
        } //randomizes tracker and resets and reprints level 2
        else if (e.getActionCommand().equals("reset2")) {
            randomize();
            resetB();
        } //randomizes tracker and resets and reprints level 3
        else if (e.getActionCommand().equals("reset3")) {
            randomize();
            resetC();
        } //randomizes tracker and resets and reprints level 4
        else if (e.getActionCommand().equals("reset4")) {
            randomize();
            resetD();
        } //randomizes tracker and resets and reprints all levels
        else if (e.getActionCommand().equals("reset all")) {
            randomize();
            resetA();
            resetB();
            resetC();
            resetD();
            beginning = 0;
        } //resets points for level 1 and reprints points for level 1 and total
        else if (e.getActionCommand().equals("reset points1")) {
            resetPointsA();
            countPoints();
        } //resets points for level 2 and reprints points for level 2 and total
        else if (e.getActionCommand().equals("reset points2")) {
            resetPointsB();
            countPoints();
        } //resets points for level 3 and reprints points for level 3 and total
        else if (e.getActionCommand().equals("reset points3")) {
            resetPointsC();
            countPoints();
        } //resets points for level 4 and reprints points for level 4 and total
        else if (e.getActionCommand().equals("reset points4")) {
            resetPointsD();
            countPoints();
        } //resets all points and reprints points all points
        else if (e.getActionCommand().equals("reset points5")) {
            resetPointsA();
            resetPointsB();
            resetPointsC();
            resetPointsD();
            countPoints();
        } //resets all levels and points
        else if (e.getActionCommand().equals("play again")) {
            randomize();
            resetA();
            resetB();
            resetC();
            resetD();
            resetPointsA();
            resetPointsB();
            resetPointsC();
            resetPointsD();
            countPoints();
            beginning = 0;
            cdLayout.show(p_card, "1");
        } else if (e.getActionCommand().equals("Close")) {
            System.exit(0);
        } else {
            //eliminates character that player clicks on for level 1
            //increases progress bar according to number of buttons clicked
            if (e.getActionCommand().substring(0, 1).equals("a")) {
                int pos1 = Integer.parseInt(e.getActionCommand().substring(1, e.getActionCommand().length()));
                a[pos1].setVisible(false);
                if (progress > 98) {
                    p.setValue(progress);
                } else if ((progress + 13) > 100) {
                    progress += 8;
                    p.setValue(progress);
                } else {
                    progress += 13;
                    p.setValue(progress);
                }
            } //eliminates character that player clicks on for level 2
            //increases progress bar according to number of buttons clicked
            else if (e.getActionCommand().substring(0, 1).equals("k")) {
                int pos2 = Integer.parseInt(e.getActionCommand().substring(1, e.getActionCommand().length()));
                c[pos2].setVisible(false);

                if (progress2 > 98) {
                    p2.setValue(progress2);
                } else if ((progress2 + 7) > 100) {
                    progress2 += 1;
                    p2.setValue(progress2);
                } else {
                    progress2 += 7;
                    p2.setValue(progress2);
                }
            } //eliminates character that player clicks on for level 3
            //increases progress bar according to number of buttons clicked
            else if (e.getActionCommand().substring(0, 1).equals("A")) {
                int pos3 = Integer.parseInt(e.getActionCommand().substring(1, e.getActionCommand().length()));
                g[pos3].setVisible(false);

                if (progress3 > 98) {
                    p3.setValue(progress3);
                } else if ((progress3 + 11) > 100) {
                    progress3 += 9;
                    p3.setValue(progress3);
                } else {
                    progress3 += 5;
                    p3.setValue(progress3);
                }
            } //eliminates character that player clicks on for level 4
            //increases progress bar according to number of buttons clicked
            else if (e.getActionCommand().substring(0, 1).equals("K")) {
                int pos4 = Integer.parseInt(e.getActionCommand().substring(1, e.getActionCommand().length()));
                j[pos4].setVisible(false);

                if (progress4 > 98) {
                    p4.setValue(progress4);
                } else if ((progress4 + 13) > 100) {
                    progress4 += 11;
                    p4.setValue(progress4);
                } else {
                    progress4 += 4;
                    p4.setValue(progress4);
                }
            } else //choices, prints true or false
            {
                int pos = Integer.parseInt(e.getActionCommand());

                if (screens == 2) {
                    trueOrFalse(b, pos, 0);
                } else if (screens == 3) {
                    trueOrFalse(d, pos, 1);
                } else if (screens == 4) {
                    trueOrFalse(f, pos, 2);
                } else //if (screens == 5)
                {
                    if (!options[pos][tracker[secret[2]]]) //if false prints false
                    {
                        h[pos].setText(command[pos] + " No");
                        h[pos].setFont(new Font("Papyrus", Font.ITALIC, 12));
                    } else {
                        h[pos].setText(command[pos] + " Yes"); //else prints true
                        h[pos].setFont(new Font("Papyrus", Font.PLAIN, 12));
                    }
                    h[pos].setEnabled(false); //disables asked questions
                }

            }
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GuessWho.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

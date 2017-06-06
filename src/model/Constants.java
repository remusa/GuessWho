/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * 
 * @author rms
 */
public class Constants {

    public static final String QUESTION1 = "Sexo";
    public static final String QUESTION2 = "Estado civil";
    public static final String QUESTION3 = "Cabello largo o corto";
    public static final String QUESTION4 = "Color de ojos";
    public static final String QUESTION5 = "Color de cabello";
    public static final String QUESTION6 = "Usa anteojos";
    public static final String QUESTION7 = "Tiene barba";
    public static final String QUESTION8 = "Tiene bigote";
    public static final String QUESTION9 = "Alto o bajo";
    public static final String QUESTION10 = "Sigue vivo";

    public static final String[] ANSWERS1 = {"Hombre", "Mujer"};                        //Sexo
    public static final String[] ANSWERS2 = {"Casado", "Soltero", "Otro"};              //Married
    public static final String[] ANSWERS3 = {"Largo", "Corto"};                         //Hair length
    public static final String[] ANSWERS4 = {"Negros", "Verdes", "Cafés", "Grises"};    //Eye color
    public static final String[] ANSWERS5 = {"Azul", "Negro", "Amarillo", "Castaño"};   //Hair color
    public static final String[] ANSWERS6 = {"Si", "No"};                               //Glasses
    public static final String[] ANSWERS7 = {"Si", "No"};                               //Beard
    public static final String[] ANSWERS8 = {"Si", "No"};                               //Moutache
    public static final String[] ANSWERS9 = {"Alto", "Bajo"};                           //Height
    public static final String[] ANSWERS10 = {"Si", "No"};                              //Alive
    
//                                          "Name",              "Sex"      "Married"       "Hair length"   "Eye color"     "Hair color"    "Glasses"   "Beard"     "Moustache" "Height", "Alive"
    public static final String[] PERSON1 =  {"Homero Simpson",   "Hombre",   "Casado",       "Corto",        "Negros",       "Negro",        "No",       "No",       "No",       "Alto"};
    public static final String[] PERSON2 =  {"Marge Simpson",    "Mujer",    "Casado",       "Largo",        "Negros",       "Azul",         "No",       "No",       "No",       "Alto"};
    public static final String[] PERSON3 =  {"Bart Simpson",     "Hombre",   "Soltero",      "Corto",        "Negros",       "Amarillo",     "No",       "No",       "No",       "Bajo"};
    public static final String[] PERSON4 =  {"Lisa Simpson",     "Mujer",    "Soltero",      "Corto",        "Negros",       "Amarillo",     "No",       "No",       "No",       "Bajo"};
    public static final String[] PERSON5 =  {"Maggie Simpson",   "Mujer",    "Soltero",      "Corto",        "Negros",       "Amarillo",     "No",       "No",       "No",       "Bajo"};
    public static final String[] PERSON6 =  {"Abraham Simpson",  "Hombre",   "Otro",         "Corto",        "Negros",       "Amarillo",     "Si",       "No",       "Si",       "Alto"};
    public static final String[] PERSON7 =  {"Krusty",           "Hombre",   "Otro",         "Largo",        "Negros",       "Azul",         "No",       "Si",       "No",       "Alto"};
    public static final String[] PERSON8 =  {"Ned Flanders",     "Hombre",   "Otro",         "Corto",        "Negros",       "Castaño",      "Si",       "No",       "Si",       "Alto"};
    public static final String[] PERSON9 =  {"Edna Krabappel",   "Mujer",    "Otro",         "Corto",        "Negros",       "Castaño",      "No",       "No",       "No",       "Alto"};
    public static final String[] PERSON10 = {"Patty",            "Mujer",    "Soltero",      "Largo",        "Negros",       "Azul",         "No",       "No",       "No",       "Alto"};


    public static final String[] PEOPLE = {
        Constants.PERSON1[0], Constants.PERSON2[0], Constants.PERSON3[0], Constants.PERSON4[0], Constants.PERSON5[0],
        Constants.PERSON6[0], Constants.PERSON7[0], Constants.PERSON8[0], Constants.PERSON9[0], Constants.PERSON10[0]
    };

    public static final String[][] PEOPLEARRAY = {
        PERSON1, PERSON2, PERSON3, PERSON4, PERSON5,
        PERSON6, PERSON7, PERSON8, PERSON9, PERSON10
    };

}

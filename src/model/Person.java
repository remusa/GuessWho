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
public class Person {

    public String name;
    public String sex;
    public String hairColor;
    public String hairLength;
    public String eyesColor;
    public boolean glasses;
    public boolean beard;
    public boolean moustache;
    public boolean skinColor;

    public Person(String name, String sex, String hairColor, String hairLength, String eyesColor, boolean glasses, boolean beard, boolean moustache, boolean skinColor) {
        this.name = name;
        this.sex = sex;
        this.hairColor = hairColor;
        this.hairLength = hairLength;
        this.eyesColor = eyesColor;
        this.glasses = glasses;
        this.beard = beard;
        this.moustache = moustache;
        this.skinColor = skinColor;
    }
    
    

}

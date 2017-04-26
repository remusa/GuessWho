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

    private String name;
    private String sex;
    private String hairColor;
    private String hairLength;
    private String eyesColor;
    private boolean glasses;
    private boolean beard;
    private boolean moustache;
    private boolean skinColor;

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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * @param hairColor the hairColor to set
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * @return the hairLength
     */
    public String getHairLength() {
        return hairLength;
    }

    /**
     * @param hairLength the hairLength to set
     */
    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    /**
     * @return the eyesColor
     */
    public String getEyesColor() {
        return eyesColor;
    }

    /**
     * @param eyesColor the eyesColor to set
     */
    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    /**
     * @return the glasses
     */
    public boolean isGlasses() {
        return glasses;
    }

    /**
     * @param glasses the glasses to set
     */
    public void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }

    /**
     * @return the beard
     */
    public boolean isBeard() {
        return beard;
    }

    /**
     * @param beard the beard to set
     */
    public void setBeard(boolean beard) {
        this.beard = beard;
    }

    /**
     * @return the moustache
     */
    public boolean isMoustache() {
        return moustache;
    }

    /**
     * @param moustache the moustache to set
     */
    public void setMoustache(boolean moustache) {
        this.moustache = moustache;
    }

    /**
     * @return the skinColor
     */
    public boolean isSkinColor() {
        return skinColor;
    }

    /**
     * @param skinColor the skinColor to set
     */
    public void setSkinColor(boolean skinColor) {
        this.skinColor = skinColor;
    }

}

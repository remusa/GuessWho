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
final public class Person {

    private int id;
    private String name;
    private String sex;
//    private String hairColor;
//    private String hairLength;
//    private String eyesColor;
//    private String skinColor;
//    private boolean glasses;
//    private boolean beard;
//    private boolean moustache;

    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

}

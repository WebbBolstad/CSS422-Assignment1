/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422_assignment1;

import java.io.Serializable;

/**
 *
 * @author webbb
 */
public class Pet implements Serializable{
    
    private String name;
    private int age;
    
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {return name;}

    /**
     * @param name the name to set
     */
    public void setName(String name) {this.name = name;}

    /**
     * @return the age
     */
    public int getAge() {return age;}

    /**
     * @param age the age to set
     */
    public void setAge(int age) {this.age = age;}
}

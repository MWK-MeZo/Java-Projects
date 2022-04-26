/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

/**
 *
 * @author al
 */
public abstract class Person {
    protected String name,gendar;
    Person(){
        
    }
    Person(String name,String gendar)
    {
        this.name=name;
        this.gendar=gendar;
    }
   
    public String getName() {
        return name;
    }

    public String getGendar() {
        return gendar;
    }
}

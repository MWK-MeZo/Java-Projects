
package student.information.system;

import java.util.Date;


public class STDinfo extends  Person implements Std_Interface{
     private int id,level,hours;
     private String courses;
     Object date = new Date();
     double gpa;

    public STDinfo(int id, String name,  int level,String gendar, double gpa,String courses,int hours,Object date) {
        super(name,gendar);
        this.id = id;
        this.level = level;
        this.gpa = gpa;
        this.courses=courses;
        this.hours=hours;
        this.date=date;
    }
    public STDinfo(String courses) {
        this.courses=courses;
    }
    
    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public double getGpa() {
        return gpa;
    }
    @Override
    public String getcourses(){
    return courses;
    }
    @Override
     public int getHours() {
        return hours;
    }
    @Override 
    public Object getDate() {
        return date;
    }
}

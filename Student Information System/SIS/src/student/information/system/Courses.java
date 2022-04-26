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
class Courses implements course_info{
   private int id ,hours;
   private String name;
   
   public Courses(int id ,int hours, String name)
   {
       this.id=id;
       this.hours=hours;
       this.name=name;
   }
   @Override
   public int getId()
   {
       return id ;
   }
   @Override
   public int getHours()
   {
       return hours ;
   }
   @Override
   public  String getName(){
       return name;
   }
}

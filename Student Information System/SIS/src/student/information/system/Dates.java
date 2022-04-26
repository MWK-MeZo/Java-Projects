/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

import java.util.Date;

/**
 *
 * @author al
 */
public class Dates {
    Date DeadLine;
    Dates(Date DeadLine){
        this.DeadLine=DeadLine;
    }
    Date getDate(){
        return DeadLine;
    }
}

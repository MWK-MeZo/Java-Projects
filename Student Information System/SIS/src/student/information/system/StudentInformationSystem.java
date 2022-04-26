/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

//import com.jtattoo.plaf.noire.*;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.*;
import javax.swing.*;
import static jdk.nashorn.internal.objects.NativeArray.pop;
import static sun.util.logging.LoggingSupport.*;

public class StudentInformationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException{
        
        StudentInformationSystem td = new StudentInformationSystem();
            td.displayTray();
            
	try {
            
       UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        }
        catch (Exception e) {
	}
        the_login view=new the_login();
    
    }   
    
    public void displayTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage(" Welcome ", " Student Information System   ", MessageType.NONE);
    }
}

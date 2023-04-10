/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 77
 */
public class Teacher extends User implements Serializable{
    private ArrayList<Subject> Subjects = new ArrayList<>();

    public Teacher(String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
    }
   

    public void takeAttendance(){
        
    }
    
    public void addHaga(){
        
    }

    @Override
    public String toString() {
        return  super.toString() + "Teacher{" + "Subjects=" + Subjects + '}';
    }


    
    
}

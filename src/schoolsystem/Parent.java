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
public class Parent extends User implements Serializable{
    
    private ArrayList<Student> kids = new ArrayList<>();

    public Parent(String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
    }

    
    public void view(){
        
        
    }
    
    public void drop(){
        
    }

    @Override
    public String toString() {
        return super.toString() + "Parent{" + "kids=" + kids + '}';
    }


    
}

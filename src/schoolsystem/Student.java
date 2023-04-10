/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 77
 */
public class Student extends User implements Serializable{
    private int age;
    private String id;
    static private int x = 0;
    private ArrayList<Subject> Subjects = new ArrayList<>();
    private Parent parent ;

    public Student(int age, Parent parent, String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
        this.age = age;
        Date date=new Date();  
        int year = date.getYear()+1900;
        this.id = year +"/"+(++x);
        this.parent = parent;
        System.out.println("student is created");
    }
  
    public void view(){
    }
    
    public void takeQuiz(){
    }

    @Override
    public String toString() {
        return  super.toString()+  "Student{" + "age=" + age + ", id=" + id + ", Subjects=" + Subjects + ", parent=" + parent + '}';
    }

    
    

    
}

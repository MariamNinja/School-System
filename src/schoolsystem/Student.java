/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private ArrayList<Subject> Subjects = new ArrayList<>();
    private Parent parent ;

    public Student(int age, Parent parent, String userName, String password, String firstName, String lastName, String email) {
        super(userName, password, firstName, lastName, email);
        this.age = age;
   
        int year = new Date().getYear() + 1900;
        String lastId =year + "/0";             
        File sFile = new File("Student.txt");
        try{
            if(sFile.exists()){
                ArrayList<Student> Students = new ArrayList<>() ; 
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(sFile));
                Students = (ArrayList<Student>)ifstream.readObject();
                ifstream.close();
                lastId =  Students.get(Students.size()-1).getId();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
        int index = lastId.indexOf("/"); 
        String value = lastId.substring(index+1); 
        int number =  Integer.parseInt(value);
        
        this.id = year + "/" + (++number);
        this.parent = parent;
        System.out.println("student is created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Subject> getSubjects() {
        return Subjects;
    }

    public void setSubjects(ArrayList<Subject> Subjects) {
        this.Subjects = Subjects;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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

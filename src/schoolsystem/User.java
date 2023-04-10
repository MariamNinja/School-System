/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 77
 */
public  class User implements Serializable{
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;

    public User(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }
    
    public static void login(String userName , String password){
        
        if(userName.equals("Admin") && password.equals("Admin")){
            System.out.println("logged in as an Admin");
        }
        
        boolean loggedIn = false;
        
        File sFile = new File("Student.txt");
        ArrayList<Student> Students = new ArrayList<>() ; 
        //Teachers
        File tFile = new File("Teachers.txt");
        ArrayList<Teacher> Teachers = new ArrayList<>() ; 
        //Parents
        File pFile = new File("Parents.txt");
        ArrayList<Parent> Parents = new ArrayList<>() ; 
        
        try{
            if(sFile.exists()){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(sFile));
                Students = (ArrayList<Student>)ifstream.readObject();
                ifstream.close();
                for (Student s : Students) {
                    if(s.getUserName().equals(userName) && s.getPassword().equals(password)){
                        loggedIn=true;
                        System.out.println("logged in as a student");
                    }
                }
            }
            if(tFile.exists()){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                Teachers = (ArrayList<Teacher>)ifstream.readObject();
                ifstream.close();
                for (Teacher t : Teachers) {
                    if(t.getUserName().equals(userName) && t.getPassword().equals(password)){
                        loggedIn=true;
                        System.out.println("logged in as a teacher ");
                    }
                } 
            }
            if(pFile.exists()){   
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(pFile));
                Parents = (ArrayList<Parent>)ifstream.readObject();
                ifstream.close();
                for (Parent p : Parents) {
                    if(p.getUserName().equals(userName) && p.getPassword().equals(password)){
                        loggedIn =true;
                        System.out.println("logged in as a parent ");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } 
        
        if(!loggedIn){
            System.out.println("wrong username or password");
        }
    }
   
    public void publish(){
    }
    
    public void chat(){
        
    }
}

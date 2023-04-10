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
import java.util.Scanner;

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
    private static Scanner in = new Scanner(System.in);

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
        
        boolean loggedIn = false;
        
        if(userName.equals("Admin") && password.equals("Admin")){
            loggedIn =true;
            Admin admin = new Admin();
        }      
        
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
    
    public static void CreateStudent(){
        System.out.println("Enter userName: ");
        String userName = in.next();
        System.out.println("Enter Password: ");
        String password = in.next();
        System.out.println("Enter first Name: ");
        String firstName = in.next();
        System.out.println("Enter last Name: ");
        String lastName = in.next();
        System.out.println("Enter email: ");
        String email = in.next();
        System.out.println("Enter age: ");
        int age = in.nextInt();
        
        boolean found =false;
        
        //students
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
                    if(s.getUserName().equals(userName)){
                        System.out.println("userName is taken s");
                        found = true;
                    }
                }   
            }
            if(tFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                Teachers = (ArrayList<Teacher>)ifstream.readObject();
                ifstream.close();

                for (Teacher t : Teachers) {
                    if(t.getUserName().equals(userName)){
                        System.out.println("userName is taken t");
                        found = true;
                    }
                }   
            }
            if(pFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(pFile));
                Parents = (ArrayList<Parent>)ifstream.readObject();
                ifstream.close();

                for (Parent p : Parents) {
                    if(p.getUserName().equals(userName)){
                        System.out.println("userName is taken p");
                        found = true;
                    }
                }   
            }
            
            if(!found){
                Student newStudent = new Student( age,  null,  userName,  password,  firstName,  lastName,  email);
                ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(sFile));
                Students.add(newStudent);
                ofstream.writeObject(Students);
                ofstream.close(); 
            } 
            
        }catch(IOException ex){
            System.out.println(ex);
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        } 
    }
                
    public static void CreateParent(){
        System.out.println("Enter parent userName: ");
        String userName = in.next();
        System.out.println("Enter parent Password: ");
        String password = in.next();
        System.out.println("Enter parent first Name: ");
        String firstName = in.next();
        System.out.println("Enter parent last Name: ");
        String lastName = in.next();
        System.out.println("Enter parent email: ");
        String email = in.next();  
        
        boolean found =false;
        
        //students
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
                    if(s.getUserName().equals(userName)){
                        System.out.println("userName is taken s");
                        found = true;
                    }
                }   
            }
            if(tFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                Teachers = (ArrayList<Teacher>)ifstream.readObject();
                ifstream.close();

                for (Teacher t : Teachers) {
                    if(t.getUserName().equals(userName)){
                        System.out.println("userName is taken t");
                        found = true;
                    }
                }   
            }
            if(pFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(pFile));
                Parents = (ArrayList<Parent>)ifstream.readObject();
                ifstream.close();

                for (Parent p : Parents) {
                    if(p.getUserName().equals(userName)){
                        System.out.println("userName is taken p");
                        found = true;
                    }
                }   
            }
            
            if(!found){
                ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(pFile));
                Parent newparent =new Parent( userName, password, firstName, lastName, email);
                Parents.add(newparent);
                ofstream.writeObject(Parents);
                ofstream.close(); 
            } 
            
        }catch(IOException ex){
            System.out.println(ex);
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }        
    }
    
    public static void CreateTeacher(){
        System.out.println("Enter teacher userName: ");
        String userName = in.next();
        System.out.println("Enter teacher Password: ");
        String password = in.next();
        System.out.println("Enter teacher first Name: ");
        String firstName = in.next();
        System.out.println("Enter teacher last Name: ");
        String lastName = in.next();
        System.out.println("Enter teacher email: ");
        String email = in.next();
        
        boolean found =false;
        
        //students
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
                    if(s.getUserName().equals(userName)){
                        System.out.println("userName is taken s");
                        found = true;
                    }
                }   
            }
            if(tFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                Teachers = (ArrayList<Teacher>)ifstream.readObject();
                ifstream.close();

                for (Teacher t : Teachers) {
                    if(t.getUserName().equals(userName)){
                        System.out.println("userName is taken t");
                        found = true;
                    }
                }   
            }
            if(pFile.exists() && !found){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(pFile));
                Parents = (ArrayList<Parent>)ifstream.readObject();
                ifstream.close();

                for (Parent p : Parents) {
                    if(p.getUserName().equals(userName)){
                        System.out.println("userName is taken p");
                        found = true;
                    }
                }   
            }
            
            if(!found){
                ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(tFile));
                Teacher newteacher = new Teacher(userName,  password,  firstName,  lastName,  email);
                Teachers.add(newteacher);
                ofstream.writeObject(Teachers);
                ofstream.close(); 
            } 
            
        }catch(IOException ex){
            System.out.println(ex);
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }  
       
    }
   
    public void publish(){
    }
    
    public void chat(){
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 77
 */
public class SchoolSystem {

    private static Scanner in = new Scanner(System.in);
    
    private static void CreateStudent(){
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
                ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(sFile));
                Student newStudent = new Student( age,  null,  userName,  password,  firstName,  lastName,  email);
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
                
    private static void CreateParent(){
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
    
    private static void CreateTeacher(){
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

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*           1. Login                    *");
        System.out.println("*           2. Register                 *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        int choice = in.nextInt();
        switch(choice){
            case 1 : 
                System.out.println("Enter userName: ");
                String userName = in.next();
                System.out.println("Enter Passworc: ");
                String password = in.next();
                break;
            case 2:
                System.out.println("*****************************************");
                System.out.println("*                                       *");
                System.out.println("*           1. Student                  *");
                System.out.println("*           2. Parent                   *");
                System.out.println("*           3. Teacher                  *");
                System.out.println("*                                       *");
                System.out.println("*****************************************");
                choice = in.nextInt();
                switch(choice){
                    case 1:
                        CreateStudent();
                        break;
                    case 2:
                        CreateParent();
                        break;
                    case 3:
                        CreateTeacher();
                        break;
                }
        }
        
        // display files
        //------------------------------
        
        
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
                    System.out.println(s);
                }
            }
            System.out.println("-----------------------------------------");
            if(tFile.exists()){
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                Teachers = (ArrayList<Teacher>)ifstream.readObject();
                ifstream.close();
                for (Teacher t : Teachers) {
                    System.out.println(t);
                } 
            }
            System.out.println("-----------------------------------------");
            if(pFile.exists()){   
                ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(pFile));
                Parents = (ArrayList<Parent>)ifstream.readObject();
                ifstream.close();
                for (Parent p : Parents) {
                    System.out.println(p);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
        
    }
    
}

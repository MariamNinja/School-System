/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 77
 */
public class Admin  {
    
    private static Scanner in = new Scanner(System.in);
    
        private void EditStudent(){
            File sFile = new File("Student.txt");
            ArrayList<Student> Students = new ArrayList<>() ; 

            try{
                if(sFile.exists()){
                    ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(sFile));
                    Students = (ArrayList<Student>)ifstream.readObject();
                    ifstream.close();
                    for (Student s : Students) {
                        System.out.println(s);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        private void EditParent(){
            File pFile = new File("Parents.txt");
            ArrayList<Parent> Parents = new ArrayList<>() ; 

            try{
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

        private void EditTeacher(){
            File tFile = new File("Teachers.txt");
            ArrayList<Teacher> Teachers = new ArrayList<>() ; 

            try{
                if(tFile.exists()){
                    ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(tFile));
                    Teachers = (ArrayList<Teacher>)ifstream.readObject();
                    ifstream.close();
                    for (Teacher t : Teachers) {
                        System.out.println(t);
                    } 
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
    
    public Admin() {
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*           1. Create Account           *");
        System.out.println("*           2. Edit Account             *");
        System.out.println("*           3. Display Accounts         *");
        System.out.println("*           4. Subject                  *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        int choice = in.nextInt();
        switch(choice){
            case 1:
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
                        User.CreateStudent();
                        break;
                    case 2:
                        User.CreateParent();
                        break;
                    case 3:
                        User.CreateTeacher();
                        break;
                }
                break;
            case 2 :
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
                        EditStudent();
                        break;
                    case 2:
                        EditParent();
                        break;
                    case 3:
                        EditTeacher();
                        break;
                }
                break;
        }
    }
}

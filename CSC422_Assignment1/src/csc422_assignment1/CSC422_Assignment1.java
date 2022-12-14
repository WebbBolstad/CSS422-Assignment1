/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422_assignment1;

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
 * @author webbb
 */
public class CSC422_Assignment1 {
    
    private static ArrayList<Pet> petList = new ArrayList<>();
    private static final String fileName = "petList";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            petList = (ArrayList) in.readObject();
            mainMenu();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CSC422_Assignment1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(CSC422_Assignment1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private static void mainMenu(){
        try (Scanner kb = new Scanner(System.in)) {
            System.out.printf("What would you like to do? \n"
                    + "1) View all pets \n"
                    + "2) Add more pets \n"
                    + "3) Update an existing pet \n"
                    + "4) Remove an existing pet \n"
                    + "5) Search pets by name \n"
                    + "6) Search pets by age \n"
                    + "7) Exit Program \n");
            
            int choice = kb.nextInt();
            
            switch(choice){
                case 1: viewAllPets();
                case 2: addPet();
                case 3: updatePet();
                case 4: removePet();
                case 5: 
                    System.out.println("Enter a name to search:");
                    String name = kb.next();
                    searchByName(name);
                case 6:
                    System.out.println("Enter an age to search:");
                    int age = kb.nextInt();
                    searchByAge(age);
                case 7: 
                default: 
                    saveList();
                    System.exit(0);
            }
        }
    }
    
    
     private static void viewAllPets(){
        
        System.out.printf("+-----------------------+\n"
                + "| ID | NAME       | AGE |\n"
                + "+-----------------------+\n");
        
        for(int i=0; i<petList.size(); i++){
            System.out.printf("| %2d | %-10s | %3d |\n", i, petList.get(i).getName(), petList.get(i).getAge());
        }
        
        System.out.print("+-----------------------+\n"
                + petList.size() + " rows in set.\n");
        
        mainMenu();
    }

     
    private static void addPet(){
        try (Scanner kb = new Scanner(System.in)){
            boolean loop = true;
            
            while (loop ==true){
                System.out.print("add pet (name, age): ");
                String petName = kb.next();
                int petAge = Integer.parseInt(kb.next());
            
                if (petName.equalsIgnoreCase("done")){ loop = false; }
                if (petList.size() >= 5){ 
                    System.out.println("You cannot have more than 5 pets in your list"); 
                    loop = false;
                }
                if (petAge > 20 || petAge <1){ 
                    System.out.println("Pet age must be between 1-20");
                    loop = false;
                }
            
                if (loop == true) { petList.add(new Pet(petName, petAge)); }
            }
            mainMenu();
        }
    }
    
    
    private static void updatePet(){
         try (Scanner kb = new Scanner(System.in)) {
            System.out.printf("+-----------------------+\n"
                + "| ID | NAME       | AGE |\n"
                + "+-----------------------+\n");
        
            for(int i=0; i<petList.size(); i++){
                System.out.printf("| %2d | %-10s | %3d |\n", i, petList.get(i).getName(), petList.get(i).getAge());
            }
        
            System.out.print("+-----------------------+\n"
                + petList.size() + " rows in set.\n");
            
            System.out.println("Enter the pet ID to update: ");
            int id = kb.nextInt();
            if (id < 0 || id >= petList.size()){
                System.out.println("Please enter an Id that matches a pet on the list");
                updatePet();
            }
            
            System.out.println("Enter new name and age:");
            String newName = kb.next();
            int newAge = Integer.parseInt(kb.next());
            
            System.out.printf("%s %d changed to %s %d \n", petList.get(id).getName(), petList.get(id).getAge(), newName, newAge);
            petList.get(id).setName(newName);
            petList.get(id).setAge(newAge);
            
            mainMenu();
        }
    }

    
    private static void removePet(){
        try (Scanner kb = new Scanner(System.in)) {
            System.out.printf("+-----------------------+\n"
                + "| ID | NAME       | AGE |\n"
                + "+-----------------------+\n");
        
            for(int i=0; i<petList.size(); i++){
                System.out.printf("| %2d | %-10s | %3d |\n", i, petList.get(i).getName(), petList.get(i).getAge());
            }
        
            System.out.print("+-----------------------+\n"
                + petList.size() + " rows in set.\n");
            
            System.out.println("Enter the pet ID to remove: ");
            int id = kb.nextInt();
            if (id < 0 || id >= petList.size()){
                System.out.println("Please enter an Id that matches a pet on the list");
                removePet();
            }
            
            System.out.println(petList.get(id).getName() + " has been removed from the list");
            petList.remove(id);
            
            mainMenu();
        }
    }

    
    private static void searchByName(String name){
        System.out.printf("+-----------------------+\n"
                + "| ID | NAME       | AGE |\n"
                + "+-----------------------+\n");
        
        int counter = 0;
        for(int i=0; i<petList.size(); i++){
            if (petList.get(i).getName().equalsIgnoreCase(name)) { 
                System.out.printf("| %2d | %-10s | %3d |\n", i, petList.get(i).getName(), petList.get(i).getAge()); 
                counter++;
            }
        }
        
        System.out.print("+-----------------------+\n"
                + counter + " rows in set.\n");
        
        mainMenu();
    }

    
    private static void searchByAge(int age){
        System.out.printf("+-----------------------+\n"
                + "| ID | NAME       | AGE |\n"
                + "+-----------------------+\n");
        
        int counter = 0;
        for(int i=0; i<petList.size(); i++){
            if (petList.get(i).getAge() == age) { 
                System.out.printf("| %2d | %-10s | %3d |\n", i, petList.get(i).getName(), petList.get(i).getAge());
                counter++;
            }
        }
        
        System.out.print("+-----------------------+\n"
                + counter + " rows in set.\n");
        
        mainMenu();
    }

    private static void saveList(){
        
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(petList);
        } catch (IOException ex) {
            Logger.getLogger(CSC422_Assignment1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(CSC422_Assignment1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}

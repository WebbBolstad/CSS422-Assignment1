/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422_assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author webbb
 */
public class CSC422_Assignment1 {
    
    private static ArrayList<Pet> petList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainMenu();
    }
    
    
    private static void mainMenu() {
        try (Scanner kb = new Scanner(System.in)) {
            System.out.printf("What would you like to do? \n"
                    + "1) View all pets \n"
                    + "2) Add more pets \n"
                    + "3) Update an existing pet \n"
                    + "4) Remove and existing pet \n"
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
                default: System.exit(0);
            }
        }
    }
    
    
     private static void viewAllPets() {
        
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

     
    private static void addPet() {
        try (Scanner kb = new Scanner(System.in)){
            boolean loop = true;
            while (loop ==true){
                System.out.print("add pet (name, age): ");
                String petName = kb.next();
                int petAge = Integer.parseInt(kb.next());
            
                if (petName.equalsIgnoreCase("done")){ loop = false; }
            
                if (loop == true) { petList.add(new Pet(petName, petAge)); }
            }
            mainMenu();
        }
    }
    
    
    private static void updatePet() {
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
            
            System.out.println("Enter new name and age:");
            String newName = kb.next();
            int newAge = Integer.parseInt(kb.next());
            
            System.out.printf("%s %d changed to %s %d \n", petList.get(id).getName(), petList.get(id).getAge(), newName, newAge);
            petList.get(id).setName(newName);
            petList.get(id).setAge(newAge);
            
            mainMenu();
        }
    }

    
    private static void removePet() {
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
            
            System.out.println(petList.get(id).getName() + " has been removed from the list");
            petList.remove(id);
            
            mainMenu();
        }
    }

    
    private static void searchByName(String name) {
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

    
    private static void searchByAge(int age) {
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
}

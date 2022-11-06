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
                    + "3) Exit Program \n");
            
            int choice = kb.nextInt();
            
            switch(choice){
                case 1: viewAllPets();
                case 2: addPet();
                case 3: System.exit(0);
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
}

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
                case 3: break;
            }
        }
    }

    private static void viewAllPets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void addPet() {
        try (Scanner kb = new Scanner(System.in)){
            boolean loop = true;
            while (loop == true){
                System.out.println("Add pet (name, age):");
                String petName = kb.next();
                int petAge = Integer.parseInt(kb.next());
                
                if (petName.equalsIgnoreCase("done")){ 
                    loop = false;
                    break;}
                petList.add(new Pet(petName, petAge));
            }
        }
        mainMenu();
    }
}

package com.company;

import com.company.controllers.MedController;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final MedController controller;
    private final Scanner scanner;

    public MyApplication(MedController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all medicines");
            System.out.println("2. Get medicine by id");
            System.out.println("3. Create medicines");
            System.out.println("4. get medicine by name");
            System.out.println("5. Remove the medicines by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllMedMenu();
                } else if (option == 2) {
                    getMedById();
                } else if (option == 3) {
                    createMedMenu();
                }
                else if (option==4){
                    getMedByNameMenu();
                }
                else if (option==5){
                    removeMedById();
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllMedMenu() {
        String response = controller.getAllMeds();
        System.out.println(response);
    }

    public void getMedById() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        try{
            String response = controller.getMed(id);
            System.out.println(response);
        } catch (InputMismatchException e){
            System.out.println("Input must be integer");
            scanner.nextLine();
        }

    }

    public void createMedMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        String price = scanner.next();
        System.out.println("Please enter expiration");
        String expiration = scanner.next();
        System.out.println("Please enter manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Please enter does need the recept? (true/false)");
        boolean byrecept = Boolean.parseBoolean(scanner.next());

        String response = controller.createMed(name, Integer.parseInt(price), Date.valueOf(expiration),manufacturer,byrecept);
        System.out.println(response);
    }
    public void getMedByNameMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        String response = controller.getMedByName(name);
        System.out.println(response);
    }

    public void removeMedById(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        try{
            controller.removeMedById(id);
            //System.out.println(response);
        } catch (InputMismatchException e){
            System.out.println("Input must be integer");
            scanner.nextLine();
        }
    }
}
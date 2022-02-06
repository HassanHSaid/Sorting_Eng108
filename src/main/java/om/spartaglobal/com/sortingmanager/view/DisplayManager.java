package om.spartaglobal.com.sortingmanager.view;

import om.spartaglobal.com.sortingmanager.controller.SortManager;

import java.util.Scanner;

public class DisplayManager {
    public void start(){
        //Create Scanner object and take unsorted values from the user
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter integer values you want to sort and separate each with space:");
        String numbers = input.nextLine();
        //creating controller object and calling sort function
        SortManager controller = new SortManager();
        System.out.println(controller.sort(numbers));
    }
}

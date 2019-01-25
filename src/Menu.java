import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private static void printOptions(){
        System.out.println("Pelase choose an option:\n" +
                "1. \n" +
                "2. \n" +
                "3. \n" +
                "4. Exit \n");
    }

    private static void sayHello(){
        System.out.println("\nWellcome to the app\n");
    }

    private static void menu(){
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

    }

    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<String, Integer>();


    }
}

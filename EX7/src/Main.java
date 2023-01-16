import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);
        //7.Write a menu driven Java program with following option:
        //a. Accept elements of an array
        // b. Display elements of an array
        // c. Search the element within array
        // d. Sort the array the size of the array should be entered by the user.
        ///InputMismatchException
        int user_input = 1;
        boolean end = true;
        try {
            System.out.println("enter a length of array");
            user_input = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number !!");
        }
        int[] arr = new int[user_input];
        while (end) {

            System.out.println("a. Accept elements of an array\n" +
                    "         b. Display elements of an array\n" +
                    "         c. Search the element within array\n" +
                    "         d. Sort the array the size of the array should be entered by the user\n" +
                    "          e.stop"
            );
            String choce_menu = input.nextLine();
            switch (choce_menu) {
                case "a":
                    if (choce_menu.equals("a")) {
                        for (int i = 0; i < user_input; i++) {
                            System.out.println("enter a element");
                            arr[i] = input.nextInt();
                        }
                    }
                    break;
                case "b":
                    if (choce_menu.equals("b")) {
                        System.out.println("elements of an array" + " " + Arrays.toString(arr));
                    }
                    break;
                case "c":  if(choce_menu.equals("c")){
                    try {
                        System.out.println("Enter a number to search if it is in the array or not ");
                        int search = input.nextInt();
                        System.out.println("the number in array"+" "+ arr[search]);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("ERORR");
                    }
                }
                    break;

            }

            if (choce_menu.equals("e")) {
                end = false;
            }

        }
    }
}

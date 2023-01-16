import javax.jnlp.UnavailableServiceException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        String[][] table =  {
                {" ","|"," ","|"," "},
                {"-","+","-","+","-"},
                {" ","|"," ","|"," "},
                {"-","+","-","+","-"},
                {" ","|"," ","|"," "},
        };
        displaytable( table);
        boolean play =true;


        while (play) {
            int user_play=1 ;
            int computer_choice =1;

            try {
                System.out.println("Where would you like to play: (1-9):");
                user_play = input.nextInt();
                if(!checkposition(table, user_play)) throw new IllegalArgumentException("Invalid") ;
            } catch ( InputMismatchException ex) {
                System.out.println("please Enter A valid number");
            }


            // play( table  , user_play ,"zzzzz"); //IllegalArgumentException

            play( table  , user_play ,"user");

            displaytable( table);


            try {
                computer_choice = random.nextInt(9)+1;
                if(!checkposition(table, computer_choice)) {
                    throw new IllegalArgumentException("Invalid") ;
                }
            }catch (IllegalArgumentException e){
                System.out.println("move");
            }




            System.out.println("cmputer chose: "+""+computer_choice);
            //play( table  ,  computer_choice , "xxxxxxxxx"  );
            play( table  ,  computer_choice , "computer"  );

            displaytable( table);

            boolean wins =check_winner(table);
            if(wins){
                play =false;
            }





        }






    }

    public static void displaytable(String[][] table) {
        for (String[] rows : table) {
            for (String j : rows) {
                System.out.print(j );
            }
            System.out.println("");
        }
    }
    public static boolean checkposition(String[][] table , int position ) throws IllegalArgumentException {

        switch (position) {
            case 1:
                return (table[0][0].equals(" "));

            case 2:
                return (table[0][2].equals(" "));
            case 3:
                return (table[0][4].equals(" "));

            case 4:
                return (table[2][0].equals(" "));

            case 5:
                return (table[2][2].equals(" "));
            case 6:
                return (table[2][4].equals(" "));

            case 7:
                return (table[4][0].equals(" "));
            case 8:
                return (table[4][2].equals(" "));
            case 9:
                return (table[4][4].equals(" "));

            default:
                return false;
        }

    }



    public static void play(String table [][] , int position ,String players  ) throws IllegalArgumentException {
        String player_chose="x";
        try{
            if(players.equals("user")) {
                player_chose ="x";
            } else if (players.equals("computer")) {
                player_chose ="o";
            }
            else{
                throw new IllegalArgumentException(" only user or computer can play !");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Enter user or computer");
        }

        switch (position){
            case 1:
                table[0][0] = player_chose ; break;

            case 2:
                table[0][2] = player_chose ; break;

            case 3:
                table[0][4] = player_chose ; break;

            case 4:
                table[2][0] =player_chose ; break;
            case 5:
                table[2][2]=player_chose ; break;
            case 6:
                table[2][4]=player_chose ; break;
            case 7:
                table[4][0]=player_chose ; break;
            case 8:
                table[4][2]=player_chose ; break;
            case 9:
                table[4][4]=player_chose ; break;

        }

    }


    public static boolean check_winner(String[][]table  ){
        if(table[0][0].equals("x")&&table[0][2].equals("x")&& table[0][4].equals("x") || table[2][0].equals("x") && table[2][2].equals("x") && table[2][4].equals("x")){
            System.out.println("user wins !");
            return true;

        }

        else if(table[4][0].equals("x")&&table[4][2].equals("x")&& table[4][4].equals("x")|| table[0][0].equals("x")&& table[2][0].equals("x")&&table[4][0].equals("x")){
            System.out.println("user wins !");
            return true;

        }

        else if(table[0][2].equals("x") &&table[2][2].equals("x") && table[4][2].equals("x")|| table[0][4].equals("x") && table[2][4].equals("x") &&table[4][4].equals("x") ){
            System.out.println("user wins !");
            return true;

        }

        else if(table[0][0].equals("x") &&table[2][2].equals("x")&& table[4][4].equals("x")|| table[0][4].equals("x") && table[2][2].equals("x") &&table[4][0].equals("x") ){
            System.out.println("user wins !");
            return true;

        }


        else if (table[0][0].equals("o")&&table[0][2].equals("o")&& table[0][4].equals("o") || table[2][0].equals("o") && table[2][2].equals("o")&& table[2][4].equals("o")){
            System.out.println("cmputer wins !");
            return true;

        }

        else if(table[4][0].equals("o")&&table[4][2].equals("o")&& table[4][4].equals("o")|| table[0][0].equals("o") && table[2][0].equals("o") &&table[4][0].equals("o")){
            System.out.println("cmputer wins !");
            return true;

        }

        else if(table[0][2].equals("o")&&table[2][2].equals("o")&& table[4][2].equals("o")|| table[0][4].equals("o") && table[2][4].equals("o") &&table[4][4].equals("o") ){
            System.out.println("cmputer wins !");
            return true;

        }

        else if(table[0][0].equals("o")&&table[2][2].equals("o")&& table[4][4].equals("o")|| table[0][4].equals("o")&& table[2][2].equals("o") &&table[4][0].equals("o")){
            System.out.println("cmputer wins !");
            return true;

        }

        else {
            return false;
        }



    }








}
















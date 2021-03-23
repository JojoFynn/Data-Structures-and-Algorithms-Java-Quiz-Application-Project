

import java.util.Scanner;
import java.io.IOException;



public class Main{
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String[] argums = new String[] {"123"};
        System.out.println("Test Administrator(Enter 1)|Test taker(Enter 2): ");
        int first = input.nextInt();
        if(first==1){
            System.out.println("Set questions(Enter 1)|Access Database of testtakers(Enter 2): ");
            int first_1 = input.nextInt();
            if(first_1==1){
                MultipleChoicetester.main(argums);
            }
            else if(first_1==2){
                Database.main(argums);
            }

        }
        else if(first==2){
            PersonMain.main(argums);
        }
        input.close();

    }
}
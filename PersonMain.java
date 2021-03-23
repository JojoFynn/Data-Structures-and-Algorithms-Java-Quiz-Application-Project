import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class PersonMain{
    public static void main(String[] args) throws IOException{
        Scanner input1 = new Scanner(System.in);
            System.out.print("Welcome");
                System.out.println("Test taker section");
                System.out.println("Name: ");
                String name = input1.nextLine();
                System.out.print("Age: ");
                int age = input1.nextInt();
                System.out.println("(Enter MALE or FEMALE) Gender: ");
                String gen_der = input1.next();
                Person.Gender gender = Person.Gender.valueOf(gen_der);
                System.out.print("E-mail: ");
                String email = input1.next();
                int num = new File("Testtaker").list().length;
                int iD = num+1;
                System.out.println("Your iD for this test is: "+ iD);
                MultipleChoice1 test1 = new MultipleChoice1();
                test1.load("Questions/Questions.sav");
                String[] userQuestions = test1.questions;
                String[][] useroptions = test1.options;
                int num1 = userQuestions.length;
                String[] takeranswers = new String[num1];
                for(int i = 0;i<userQuestions.length;i++){
                    System.out.println(userQuestions[i]);
                    for(int f=0;f<useroptions[i].length;f++){
                        System.out.println(useroptions[i][f]);
        
                    }
                    System.out.println("Enter your answer: ");
                    String userans = input1.next().trim();
                    takeranswers[i] = userans;
                }
                input1.close();
      
               int score = test1.checkAnswer(takeranswers);
                String pass;
                if(score > test1.pass_mark) 
                    pass = "PASS";
                else
                    pass = "FAIL";
                System.out.println();

                //block of code borrowed from stack overflow thread
                //Retrieved from 
                //https://stackoverflow.com/questions/30086741/how-to-use-variables-from-main-method-in-another-class-serialization?rq=1
                //saves instance variables of person object 
                //to a .sav file in the folder Testtaker
                try
                {
                    FileOutputStream saveFile = new FileOutputStream("Testtaker/user"+(num+1)+".sav");
                    ObjectOutputStream save = new ObjectOutputStream(saveFile);
            
                    save.writeObject(name);
                    save.writeObject(age);
                    save.writeObject(gender);
                    save.writeObject(email);
                    save.writeObject(score);
                    save.writeObject(pass);


            
                    save.close();
                }
                catch(Exception exc)
                {
                    exc.printStackTrace();
                }

        
    }
}
        
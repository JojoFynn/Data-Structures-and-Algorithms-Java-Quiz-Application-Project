import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;


public class MultipleChoicetester{
    public static void main(String[] args) {
        
        //takes user specifications for number of questions and options plus pass mark
        Scanner input1 = new Scanner(System.in);
        input1.nextLine();
        System.out.print("Number of questions in the test: ");
        int a = Integer.parseInt(input1.nextLine());
        System.out.print("Number of options per question: ");
        int b =Integer.parseInt(input1.nextLine());
        System.out.print("Pass mark for the test: ");
        int c = Integer.parseInt(input1.nextLine());
        MultipleChoice1 yourtest = new MultipleChoice1(a,b,c);

        //takes user questions, answers and options temporarily stores them in arrays
        String[] userQuestions = new String[a]; 
        String [] useranswers = new String[a];
        String[][] useroptions = new String[a][b];
        for(int i=0;i<a;i++){
            System.out.println("Enter your question: ");
            String q = input1.nextLine().trim();
            userQuestions[i] = q;
            System.out.println("Enter your answer to the question: ");
            String ans = input1.nextLine().trim();
            useranswers[i] = ans;
            System.out.println("Enter your multiple choice answers");
            for(int g=0;g<b;g++){
                System.out.print("Option "+(g+1)+": ");
                String op = input1.nextLine().trim();
                useroptions[i][g] = op;  
            }
        }
        //sets instance variables of the yourtest instance of the question class
        yourtest.setQuestion(userQuestions);
        yourtest.setanswer(useranswers);
        yourtest.setoptions(useroptions);

        //prints the questions and the options user has set 
        for(int i = 0;i<userQuestions.length;i++){
            System.out.println(userQuestions[i]);
            for(int f=0;f<useroptions[i].length;f++){
                System.out.println(useroptions[i][f]);

            }
        
        }

        input1.close();

        //number of files in the file folder
        int num = new File("Questions").list().length;

                //block of code borrowed from stack overflow thread
                //Retrieved from 
                //https://stackoverflow.com/questions/30086741/how-to-use-variables-from-main-method-in-another-class-serialization?rq=1
                //saves instance variables of question object 
                //to a .sav file in the folder Question
        try
        {
            FileOutputStream saveFile = new FileOutputStream("Questions/question"+(num+1)+".sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
    
            save.writeObject(userQuestions);
            save.writeObject(useranswers);
            save.writeObject(useroptions);
            save.writeObject(c);
    
            save.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }

    }
    

}
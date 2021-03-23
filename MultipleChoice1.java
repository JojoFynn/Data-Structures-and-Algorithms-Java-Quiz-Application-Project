import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class MultipleChoice1{

    public String[] questions;
    public String[] answer;
    public String[][] options;
    public int numOptions;
    public int numQuestions;
    public int pass_mark;

    //constructor accepting 3 parameters and specifying the sizes of the three
    // arrays fro questions answers and options
    public MultipleChoice1(int numQuestions, int numOptions, int pass_mark){
        this.numQuestions = numQuestions;
        this.numOptions = numOptions;
        this.pass_mark = pass_mark;
        questions = new String[numQuestions];
        answer = new String[numQuestions];
        options = new String[numQuestions][numOptions];
        
    }
    public MultipleChoice1(){}

    //setter methods
    public void setQuestion(String[] yourQuestion){
        questions = yourQuestion;
    }

    public void setanswer(String[] youranswers){
        answer = youranswers;
    }

    public void setoptions(String[][] youroptions){
        options = youroptions;
    }

    //computes test-takers score after test
    public int checkAnswer(String[] takeranswers){
        int score=0;
        for(int i = 0;i< takeranswers.length;i++){
            if(answer[i].equals(takeranswers[i])){
                score++;
            }
             
        }
        return score;
    }

     //load method borrowed from stack overflow thread
    //imports question object data from .sav file and assigns it to 
    //question object instance variables.
    //Retrieved from 
    //https://stackoverflow.com/questions/30086741/how-to-use-variables-from-main-method-in-another-class-serialization?rq=1
    public void load(String filename) throws IOException {
		try (FileInputStream saveFile = new FileInputStream(filename);
				ObjectInputStream save = new ObjectInputStream(saveFile)) {
			try {
				questions = (String[]) save.readObject();
                answer = (String[]) save.readObject();
                options = (String[][]) save.readObject();
                pass_mark = (int) save.readObject();
                
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  }


}

    
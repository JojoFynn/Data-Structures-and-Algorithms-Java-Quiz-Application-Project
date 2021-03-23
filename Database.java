import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Database{

    
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        TreeMap<Integer, Person> tree_map = new TreeMap<Integer, Person>();//treeMap
        String[] files = new File("Testtaker").list();//List of files in Testtaker folder
        //loads all .sav files in the Testtaker folder into the treeMap
        for(int i = 0;i<files.length;i++){
            Person test1 = new Person();
            test1.load("Testtaker/"+files[i]);
            tree_map.put(i+1,test1);
        }

        System.out.println("How many queries do you want to make?");
        int num_queries = input.nextInt();
        for(int i=0;i<num_queries;i++){
            System.out.println("Enter iD of candidate to retrieve their information: ");
            int iD = input.nextInt();
            System.out.println(tree_map.get(iD));
        }
        input.close();

    }
}
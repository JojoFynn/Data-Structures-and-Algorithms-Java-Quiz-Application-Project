
//package transport;

 // Class instance variables modified to meet the demands of our application
/*
 * File: Person.java
 * Project: transport
 * File Created: Thursday, 5th September 2019 10:13:52 AM
 * Author: Jojoe Ainoo>
 * Email: jojoeainoo@gmail.com
 * Version: 1.0
 * Brief: 
 * -----
 * Last Modified: Thursday, 5th September 2019 11:16:02 AM
 * Modified By: Jojoe Ainoo>
 * -----
 * Copyright ©2019 Jojoe Ainoo>
 */


import java.util.Random;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

// This is Person Class with three Instance Variables (Name, Age, Gender)
public class Person {

    // Static method to create enum type Gender for genders of Persosn
    public static enum Gender { // Gender data type takes either: MALE or FEMALE
        MALE, FEMALE
    };

    private String name; // name instance variable of person
    private int age; // age instance variable of person
    private Gender gender; // gender instance variable of person
    private String email;//email instance variable
    public int score;//score of test taker
    public String pass_fail;//status of user after test completion
    /*
     * @brief Default Constructor Method to Initialize Class
     * 
     * @body Use of "this" keyword to Invoke Second constructor of Class with
     * default Name and Age Assigning instance variables to default values and
     * Gender to random gender
     *
     * @return void
     */
    public Person() {
        // this("No name Yet", 0, GENDER.FEMALE); // Invoking second constructor of the
        // class with default Name and Age
        Gender rand = randomGender();      // Call to randomGender method to generate random Genders
        this.name = "No name yet"; // Default name
        this.age = 0; // Default age
        this.gender = rand; // Random gender
        this.email = null;
        this.score = 0;
        this.pass_fail = null;

    }

    /*
     * @brief Second Constructor that allows Name, Age & Gender of Person to be set
     *
     * @param name String // Name of Person
     * 
     * @param age int // Age of Person
     * 
     * @param gender Gender // Enum gender data type (MALE /FEMALE)
     *
     * @return voscore
     */
    public Person(String name, int age, Gender gender, String email, int score,String pass_fail) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.score = score;
        this.pass_fail = pass_fail;
    }

    /*
     * @brief Accessor Method to get Name of Person
     *
     * @return name String // Returns name of Person
     */
    public String getName() {
        return name;
    }

    /*
     * @brief Accessor Method to get Age of the Person
     *
     * @return age int // Returns age of Person
     */
    public int getAge() {
        return age;
    }

    /*
     * @brief Accessor Method to get Gender of the Person
     * 
     * @return gender Gender // Returns gender of Person
     */
    public Gender getGender() {
        return this.gender;
    }

    public String getemail(){
        return this.email;
    }
    /*
     * @brief Mutator Method to set the Name of the Person given Full name
     *
     * @param name String // Full name of Person
     * 
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * @brief Mutator Method to set the Name of the Person
     *
     * @param first String // last name of person
     * 
     * @param last String // Last name of person
     * 
     * @body concatenating first and last name as name of person
     * 
     * @return void
     */
    
    public void setAge(int newage){
      this.age = newage;

    }
    public void setName(String first, String last) {
        this.name = first + " " + last;
    }

    public void setemail(String email){
        this.email = email;
    }

    // public void set exam_status(int score){
    //     if(score > )
    // }
    /*
     * @brief Mutator Method to increment the age by 1
     * 
     * @body age++ to increment age by 1
     * 
     * @return void
     */

    /*
     * @brief Simple Display Method to Print Details of Person Class
     * 
     * @body print statement of instance variables
     * 
     * @return void
     */

    public void displayPersonInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

    /*
     * @brief Method to generate random genders based on random numbers
     * 
     * @body generates a random number between 0 to 11 and assigns either MAlE or
     * FEMALE to particular range.
     * 
     * @return Gender
     */
    public Gender randomGender() {

        Random rand = new Random(); // Initialize random object
        int randInt = rand.nextInt(10); // Get random integer from 0 to 9

        if (randInt >= 5) {
            return Gender.MALE; // All Males fall within Random Numbers equal or above 5
        } else {
            return Gender.FEMALE; // All females fall within Random Numbers belowe 5
        }

    }

    /*
     * @brief equals method that checks if two person's are equal
     * 
     * @param Person anotherPerson // Person object
     * 
     * @body checks if a person object's details matches another Person's details
     * passed as a parameter to the function. Returns true if match is equal
     * 
     * @return boolean
     */

    public boolean equals(Person anotherPerson) {

        if (this.name.equals(anotherPerson.name) && this.age == anotherPerson.age
                && this.gender.equals(anotherPerson.gender)) {
            return true;
        } else {
            return false;
        }

    }
    //load method borrowed from stack overflow thread
    //imports person object data from .sav file and assigns it to 
    // person object instance variables.
    //Retrieved from 
    //https://stackoverflow.com/questions/30086741/how-to-use-variables-from-main-method-in-another-class-serialization?rq=1
    public void load(String filename) throws IOException {
		try (FileInputStream saveFile = new FileInputStream(filename);
				ObjectInputStream save = new ObjectInputStream(saveFile)) {
			try {
				name = (String) save.readObject();
                age = (int) save.readObject();
                gender = (Gender) save.readObject();
                email = (String) save.readObject();
                score = (int) save.readObject();
                pass_fail = (String) save.readObject();
                
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
      }
      
      public String toString() 
      { 
          return " Name:" + this.name + " "
              + "Age:" + this.age + " "
              + "Gender:"+ this.gender + " " + "Score:" + this.score +" " + "email address:"+ this.email+
              " "+"Status: "+this.pass_fail; 
      }
}

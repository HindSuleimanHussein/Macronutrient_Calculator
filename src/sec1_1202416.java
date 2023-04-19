import java.util.*;
public class sec1_1202416{ // An error would come up if I did "1202416_sec1", so I did "sec1_1202416"

    public static void main(String[] args){
        int max_Age=0, max_ID=0, sum_Grams=0, sum_Calories=0; //initializing integers that I'll need outside the loop
        int numberOfPeople=0; // initializing the integer that I'll need outside the loop and will be used to count the people
        double maxProteinEnergy=0; // initializing double that I'll need outside the loop
        Scanner in = new Scanner(System.in); // doing an instance from the scanner class
        int user_Answer;

        System.out.println("Would you like to check or continue checking your nutrient values? Press any integer To Continue or -1 To Stop"); // asking user to enter any integer and when they enter -1 the loop will stop

        while(true) { // while the user enters any integer except for -1
            user_Answer = in.nextInt();
            if (user_Answer == -1) { // if the user entered -1
                break; // then leave the loop
            }

            System.out.print("Enter " + (numberOfPeople+1) + "'s ID: "); // numberOfPeople is for the user to know which ID they're at (Example: they'll be at the fifth person's ID, the fifth time they go through the loop)
            int person_ID= in.nextInt(); // getting the person's ID
            if(person_ID == -1) {// if the user enter -1
                break; // then leave the loop
            }

            System.out.print("Enter " + (numberOfPeople+1) + "'s Age: "); // numberOfPeople is for the user to know which person's age they're at (Example: they'll be at the fifth person's age, the fifth time they go through the loop)
            int person_Age= in.nextInt(); // getting the person's age
            if(person_Age == -1) {// if the user enter -1
                break; // then leave the loop
            }


            System.out.print("Please enter the amount of carbohydrate in grams: ");
            int carbInGrams = in.nextInt(); // get the carbohydrates in grams
            if(carbInGrams == -1) {// if the user enter -1
                break; // then leave the loop
            }

            System.out.print("Please enter the amount of fat in grams: ");
            int fatInGrams = in.nextInt(); // get the fat in grams
            if(fatInGrams == -1) {// if the user enter -1
                break; // then leave the loop
            }


            System.out.print("Please enter the amount of proteins in grams: ");
            int proteinGrams = in.nextInt(); // get the proteins in grams
            if(proteinGrams == -1) {// if the user enter -1
                break; // then leave the loop
            }


            int grams= sumOfGrams(carbInGrams, fatInGrams, proteinGrams); // 1) call for the method that sums the grams, 2) send the three macronutrients to it, so it can sum them,  3) and put the result in the integer variable named grams
            System.out.println("Total Grams: " + grams); // print the sum of grams
            sum_Grams+=grams; // everytime you go through the loop, you'll add the grams to each other (this is for the average)

            int calories= sumOfCalories(carbInGrams, fatInGrams, proteinGrams); // 1) call the method that sums the calories, 2) send the three macronutrients to it, 3) and put the result in the integer variable named calories
            System.out.println("Total Calories: " + calories); // print the sum of calories
            sum_Calories+=calories; //everytime you go through the loop, you'll add the calories to each other (this is for the average)


            double percentage_Carbohydrate = percentOfCarbohydrates(carbInGrams, calories); // 1) call for the method that can find the carbohydrate percentage 2) send the carbohydrates in grams and the sum of calories to it, 3) and put the result in a double variable named percentage_Carbohydrate
            double percentage_Fat = percentOfFat(fatInGrams, calories); // 1) call for the method that can find the fat percentage 2) send the fat in grams and sum of calories to it, 3) and put the result in a double variable named percentage_Fat
            double percentage_Proteins = percentOfProteins(proteinGrams, calories); // 1) call for the method that can find the protein's percentage 2) send the proteins in grams and sum of calories to it, 3) and put the result in a double variable named percentage_Proteins

            System.out.println("Percent of calories from each macronutrient: "); // letting user know that they'll be looking at the percent of calories

            System.out.printf("Carbohydrates: %.1f%%", percentage_Carbohydrate); // printing the percent of carbohydrates
            System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect

            System.out.printf("Fat: %.1f%%", percentage_Fat); // printing the percent of fat
            System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect

            System.out.printf("Proteins: %.1f%%", percentage_Proteins); // printing the percent of proteins
            System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect


            double protein_Energy = proteinToEnergy(carbInGrams, fatInGrams, proteinGrams); // 1) called the method that will find the protein:energy ratio 2) sent the macronutrients in grams, 3) and put the result in a double variable named protein_Energy
            System.out.printf("Protein:Energy Ratio : %.1f", protein_Energy); // print the protein:Energy Ratio
            System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect

            if(maxProteinEnergy<protein_Energy){ // everytime you go through the loop, if the n protein:energy is greater than the n+1 protein:energy
                maxProteinEnergy=protein_Energy; // then the n protein:energy will equal to the maximumProteinEnergy
                max_Age=person_Age; // and the age of person n will be equal to the max_Age
                max_ID=person_ID; // and the ID of person n will be equal to the max_ID
            }

            numberOfPeople++; // after every loop, the numberOfPeople will increase so the user knows which person they are at

            System.out.println("Would you like to check or continue checking your nutrient values? Press 1 To Continue or -1 To Stop"); // asking again to see if user would like to continue or not
        }

        double average_Grams= avgOfGrams(sum_Grams, numberOfPeople); // 1) call for the method that finds the average of grams 2) send the sum of grams and amount of people, 3) and put the result in a double variable named average_Grams
        System.out.printf("Average Grams: %.1f", average_Grams); // print the average of grams
        System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect

        double average_Calories = avgOfCalories(sum_Calories, numberOfPeople); // 1) call for the method that finds the average of calories 2) send the sum of calories and amount of people, 3) and put the result in a double variable named average_Calories
        System.out.printf("Average Calories: %.1f", average_Calories); // print the average of calories
        System.out.println(); // printing a new line, so it looks neater, and the two printf(s) don't connect

        System.out.printf("The Maximum Protein to Energy ratio is: %.1f", maxProteinEnergy); // print the maximum protein:energy ratio
        System.out.print(" with The ID: " + max_ID); // print the ID of the person with maximum protein:energy ration
        System.out.print(" and Aged: " + max_Age); // print the age of the person with maximum protein:energy ration
    }

    public static int sumOfGrams(int carbohydrate, int fat, int proteins){
        return carbohydrate+fat+proteins; // method returns the sum of each macronutrient in grams
    }

    public static int sumOfCalories(int carbohydrate, int fat, int proteins){
        int carbohydrateInCalories = carbohydrate*4; // converting the carbohydrates from grams to calories
        int fatInCalories=fat*9; // converting the fats from grams to calories
        int proteinsInCalories=proteins*4; // converting the proteins from grams to calories
        return carbohydrateInCalories+fatInCalories+proteinsInCalories; // returns the sum of each macronutrient in calories
    }

    public static double percentOfCarbohydrates(int carbohydrate, int calories){
        int carbohydrateInCalories = carbohydrate*4; // converting the carbohydrates from grams to calories
        return (double) carbohydrateInCalories*100/calories; // returning the percentage of carbohydrates in double
    }

    public static double percentOfFat(int fat, int calories){
        int fatInCalories = fat*9; // converting the fat from grams to calories
        return (double) fatInCalories*100/calories; // returning the percentage of fats in double
    }

    public static double percentOfProteins(int proteins, int calories){
        int proteinsInCal = proteins*4; // converting the proteins from grams to calories
        return (double) proteinsInCal*100/calories; // returning the percentage of proteins in double
    }

    public static double proteinToEnergy(int carbohydrate, int fat, int proteins){
        return (double) proteins/(carbohydrate+fat); // method that returns the protein:energy ratio
    }

    public static double avgOfGrams(int sum, int count){
        return (double) sum/count; // method that returns the average of grams
    }

    public static double avgOfCalories(int sum, int count){
        return (double) sum/count; // method that returns the average of calories

    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarRecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author julia
 */
public class Vehicles {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Call method 3.A
        Vehicles.LineByLine();

        //Call method 3.B
        Vehicles.AudiData();

        //Call method 3.C
        Vehicles.MissingMileage();
    }

    //A. Write a Java method that reads the vehicles.txt file line by line and prints the content of
    //the file to standard output.
    public static void LineByLine() throws IOException, InterruptedException {
        BufferedReader reader = null;

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        try {
            //Read Vehicles.txt
            reader = new BufferedReader(new FileReader(dir + "/data/Vehicles.txt"));

            String currLine;//variable for current line

            System.out.println("\n------------------------------------------------------------------ QUESTION 3.A ---------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------ Printing Vehicles Records from Vehicles.txt, line by line --------------------------------------------------------------------");
            //While current line being read is not null, print it
            while ((currLine = reader.readLine()) != null) {

                //Print line
                System.out.println(currLine);

                //Wait half a second before printing the next line
                Thread.sleep(500);

            }
            //Catch exception
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (reader != null) {
                //Close BufferedReader
                reader.close();
            }
        }
    }

    //B. Select one scenario from the list below and write a piece of Java method that saves the
    //corresponding vehicle data to a separate file.
    //STUDENT ID = X21177244
    //SCENARIO 2 (last digit 3 or 4) = All Vehicules whose brand is Audi
    public static void AudiData() throws IOException, InterruptedException {
        BufferedReader reader = null;
        PrintWriter pwriter = null;

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {

            //Read Vehicles.txt
            reader = new BufferedReader(new FileReader(dir + "/data/vehicles.txt"));

            //Write Audi.txt
            pwriter = new PrintWriter(new FileWriter(dir + "/data/Audi.txt"));

            System.out.println("\n------------------------------------------------------------------ QUESTION 3.B ---------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------ Creating Audi.txt file with all the Audi records ---------------------------------------------------------------------------------------------");

            String currLine;//variable for current line

            //While current line is not null,
            while ((currLine = reader.readLine()) != null) {
                //If the current line contains "Audi" print the line in the console and write the line in the Audi.txt
                if (currLine.contains("Audi")) {
                    System.out.println(currLine + " ----> Audi vehicle record copied to Audi.txt");
                    pwriter.println(currLine);

                }

            }
            //Catch exception
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                //Close BufferedReader
                reader.close();
            }
            if (pwriter != null) {
                //Close PrintWriter
                pwriter.close();
            }
        }
    }

    //C. Write a Java method that writes all the vehicles with missing mileage information to a
    //file called Missing_Mileage.txt
    public static void MissingMileage() throws IOException, InterruptedException {

        System.out.println("\n------------------------------------------------------------------ QUESTION 3.C ---------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------ Creating Missing_Mileage.txt file with all the vechicles with missing mileage ---------------------------------------------------------------------------------------------");

        BufferedReader reader = null;
        PrintWriter pwriter = null;
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            //Read Vehicles.txt
            reader = new BufferedReader(new FileReader(dir + "/data/Vehicles.txt"));

            //Create Missing_Mileage.txt
            pwriter = new PrintWriter(new FileWriter(dir + "/data/Missing_Mileage.txt"));

            String currLine;

            //While current line is not empty
            while ((currLine = reader.readLine()) != null) {

                //If current line contains ", , ", it means the mileage is missing
                //Then print the line in the output and write the line to the Missing_Mileage.txt
                if (currLine.contains(", ,")) {
                    System.out.println(currLine + " ----> Vehicle with missing mileage information copied to Missing_Mileage.txt");
                    pwriter.println(currLine);
                }
            }

            //Catch exceptions
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                //Close BufferedReader
                reader.close();
            }
            if (pwriter != null) {
                //Close PrintWriter
                pwriter.close();
            }

        }
    }

}

/**
 * Application creating as competition organise by samouczekprogramisty.pl
 * If application is counting right values then author can win invitation for IT conference.
 */
package mno.sp.competition.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import mno.sp.competition.view.View;

/**
 *
 * @author Mariusz Nowak
 * @version 0.0
 */
public class Main {

    /**
     * Application creating as competition organise by samouczekprogramisty.pl
     * If application is counting right values then author can win invitation
     * for IT conference.
     *
     * Application is counting how many papers are needed to wrap boxes. Number
     * and dimensions are coming from input file.
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     *
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String decision;                                //To keep decision about continue from user
        Scanner scanner = new Scanner(System.in);       //To get interaction from user`
        View view = new View();                         //Object of Viev class to show user messages
        String filePath;                                //To keep filepath from user
        BufferedReader fileReader = null;               //To reading data from input file    
        int index1, index2, a, b, c, adm, bdm, cdm, small;  //Aux tags to keep temporary data
        long sum = 0;                                   //to keep final sum
        String str1, str2, str3;                        //Aux tags to keep temporary data

        view.helloUser();                                //Hello massage to user.

        do {                                            //Main loop keeping application alive
            view.incentiveWord();                       //Incentive message to user.
            filePath = scanner.nextLine();              //Read file path
            try {
                fileReader = new BufferedReader(new FileReader(filePath));  //Create file reader
                String readString = fileReader.readLine();                  //Reading first line from file
                while (readString != null) {                                //Loop to reading data from file till eof and counting
                    index1 = readString.indexOf("x");                       //Find first x
                    index2 = readString.lastIndexOf("x");                   //Find second x
                    str1 = readString.substring(0, index1);                 //Extract first number
                    str2 = readString.substring(index1 + 1, index2);        //Extract second number
                    str3 = readString.substring(index2 + 1);                //Extract third number 
                    str1 = str1.replaceAll("[^0-9]", "");                   //Rremove unnecessary characters
                    str2 = str2.replaceAll("[^0-9]", "");                   //Rremove unnecessary characters
                    str3 = str3.replaceAll("[^0-9]", "");                   //Rremove unnecessary characters
                    a = Integer.parseInt(str1);                             //Confert first number to integer
                    b = Integer.parseInt(str2);                             //Confert second number to integer
                    c = Integer.parseInt(str3);                             //Confert third number to integer
                    adm = a * b;                                            //Calculate area of first wall
                    bdm = b * c;                                            //Calculate area of second wall
                    cdm = a * c;                                            //Calculate area of third wall

                    //find the smallest wall
                    small = adm;
                    if (small > bdm) {
                        small = bdm;
                    }
                    if (small > cdm) {
                        small = cdm;
                    }

                    sum += ((2 * adm) + (2 * bdm) + (2 * cdm) + small);     //calculate required paper
                    readString = fileReader.readLine();                     //Try to read next line from file
                }
            } finally {
                if (fileReader != null) {
                    fileReader.close();
                }
            }
            view.finalSum(sum);                                             //Show final sum for user
            view.continueQuestion();                                        //Question to user about continuing.
            decision = scanner.nextLine();                                  //Read information from user.
            view.clearScreen();
        } while (decision.equals("t") || decision.equals("T"));             //Decision to continue program

        view.goodbye();                                                     //Goodbye message to user.
    }
}

/*
* This application simulates the entire schoolyear in two schools of county
* This version is tested by netbeans 8.2
 */
package school;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;



public class School {

    public static void main(String[] args) throws IOException {
        
        //Init county
        new County();
        System.out.println("Simulointi valmis");
    }

}

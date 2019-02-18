/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.util.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

final class LocalSchool {

    public LocalSchool() {
        createClasses(); 
        SimulateOneDay();
    }
    String name = "";
    ArrayList<Schoolclass> classes = new ArrayList<>();

    void SimulateOneDay() {

        classes.stream().forEach((item) -> {
            System.out.println("Luokka");
            item.browsePupils();
          
        });

    }

    void createClasses() {
        for (int i = 0; i < 6; i++) {
            classes.add(new Schoolclass());
        }
    }

}

/**
 *
 * @author antto
 */
class County {

    LocalSchool school = new LocalSchool();

    public County() {
       
        school.createClasses();
    }
}

public class School {

    /**
     * @param args the command line arguments
     */
    static Boolean checkIfInHoliday(LocalDate cur, LocalDate start, LocalDate end) {
        return cur.isAfter(start) && cur.isBefore(end);
    }

    public static void main(String[] args) {
        new County();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

final class LocalSchool {

    public LocalSchool() {
        createClasses();

    }

    ArrayList<Schoolclass> classes = new ArrayList<>();

    void SimulateOneDay(LocalDate curDate,String dayOfWeekSchool) {
        Details.curDay++;
        classes.stream().forEach((curClass) -> {
            curClass.SimulateOneDay(curDate,dayOfWeekSchool);
        });

    }

    void createClasses() {
        for (int i = 0; i < 6; i++) {

            Schoolclass class1 = new Schoolclass();
            class1.setClassName(Details.classNames[i]);
            class1.addPupils();

            classes.add(class1);
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

        LocalDate SchoolStart = LocalDate.of(2014, Month.SEPTEMBER, 4);
        LocalDate SchoolEnd = LocalDate.of(2015, Month.MAY, 31);

        while(SchoolStart.isBefore(SchoolEnd) || SchoolStart.equals(SchoolEnd) ) {
          
            String dayOfWeekSchool = SchoolStart.getDayOfWeek().toString();
            school.SimulateOneDay(SchoolStart,dayOfWeekSchool);
              SchoolStart = SchoolStart.plusDays(1);
        }
        

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

final class LocalSchool {

    String schoolname = "";

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public LocalSchool() {
        createClasses();

    }

    ArrayList<Schoolclass> classes = new ArrayList<>();

    void SimulateOneDay(LocalDate curDate, String dayOfWeekSchool) {
        Details.curDay++;
        classes.stream().forEach((curClass) -> {
            curClass.SimulateOneDay(curDate, dayOfWeekSchool);
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

    void printAbsent(String schoolname) {

        classes.stream().forEach((curClass) -> {

            curClass.printAbsent(schoolname);

        });

    }

}

/**
 *
 * @author antto
 */
class County {

    ArrayList<LocalSchool> schools = new ArrayList<>();

    public County() throws IOException {
        
        //destroys if file exists 
        File file = new File("absent.csv");
        if (file.exists()) {
            file.delete();
        }
        try (FileWriter myWriter = new FileWriter("absent.csv")) {
            myWriter.append("Student;CLASS;School;Date;Reason\n");
        }
        
        LocalSchool school = new LocalSchool();
        school.setSchoolname("School 1");
        schools.add(school);
        LocalSchool school1 = new LocalSchool();
        school1.setSchoolname("School 2");
        schools.add(school1);

        LocalDate SchoolStart = Details.startDay;
        LocalDate SchoolEnd = LocalDate.of(2018, Month.MAY, 31);

        while (SchoolStart.isBefore(SchoolEnd) || SchoolStart.equals(SchoolEnd)) {

            for (LocalSchool _school : schools) {
                String dayOfWeekSchool = SchoolStart.getDayOfWeek().toString();
                _school.SimulateOneDay(SchoolStart, dayOfWeekSchool);

            }

            SchoolStart = SchoolStart.plusDays(1);

        }

        schools.stream().forEach((_item) -> {
            _item.printAbsent(_item.getSchoolname());

        });

    }
}

public class School {

    public static void main(String[] args) throws IOException {
        
        //Init county
        new County();
        System.out.println("Simulointi valmis");
    }

}

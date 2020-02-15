/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.time.LocalDate;
import java.util.ArrayList;

public  class LocalSchool {

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
    
    //This method creates 6 schoolclasses
    
    void createClasses() {
        for (String className : Details.classNames) {
            Schoolclass class1 = new Schoolclass();
            class1.setClassName(className);
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

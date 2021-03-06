/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author antto
 *
 *
 */
//Singleton
class Schoolclass {

    public Schoolclass() {

    }
    protected String className = "";

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public void printAbsent(String schoolname) {
      
        pupils.stream().forEach((pupil) -> {
            
            try {
                pupil.printAbsent(className,schoolname);
            } catch (IOException ex) {
                
            }
        });
    }

    ArrayList<Pupil> pupils = new ArrayList<>();
    //This simulates always one day ahead.
    public void SimulateOneDay(LocalDate curDate, String dayOfWeekSchool) {

        pupils.stream().forEach((pupil) -> {
            pupil.SimulateOneDay(curDate, className, dayOfWeekSchool);
        });

    }

    
    public void addPupils() {
        for (int i = 0; i < Details.classSize; i++) {
            Pupil pupil = new Pupil();
            pupils.add(pupil);

        }
    }

}

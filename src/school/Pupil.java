/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author antto
 */
class Details {

    static public int id = 0;
    static public int classId2 = 0;
    static public String[] classNames = {"1A", "1B", "2A", "2B", "3A", "3B"};
    static public int curDay = 0;

}

class Away {

    LocalDate awayDate;

    public LocalDate getAwayDate() {
        return awayDate;
    }

    public void setAwayDate(LocalDate awayDate) {
        this.awayDate = awayDate;
    }

    public Boolean getIsAway() {
        return isAway;
    }

    public void setIsAway(Boolean isAway) {
        this.isAway = isAway;
    }
    Boolean isAway = null;

}

class Pupil {

    ArrayList<Away> notAtClass = new ArrayList<>();

    void addDay() {
        //TODO CHECK, if he/she is at  class.

    }

    public void SimulateOneDay(LocalDate curDate, String className, String dayOfWeekSchool) {

        if (false == curDate.equals(LocalDate.of(2014, 12, 6)) && dayOfWeekSchool.equals("SUNDAY") == false && dayOfWeekSchool.equals("SATURDAY") == false) {
            Boolean awayYesterday = false;
            if (notAtClass.size() < 3) {
                awayYesterday = false;
            } else {

                awayYesterday = notAtClass.get(notAtClass.size() - 2).getIsAway();

                if (awayYesterday == null) {

                    int cur = notAtClass.size() - 2;

                    while (cur > -1 && notAtClass.get(cur).getIsAway() == null) {
                        cur--;
                    }
                    if (cur > 0) {
                        awayYesterday = notAtClass.get(cur).getIsAway();
                    } else {
                        awayYesterday = true;
                    }

                }

            }

            Boolean isAway = typepupil.isAwayProb(awayYesterday, curDate.getDayOfWeek().toString());

            Away away = new Away();
            away.setIsAway(isAway);
            away.setAwayDate(curDate);
            notAtClass.add(away);

        } else {
            Away away = new Away();
            
            away.setAwayDate(curDate);

            notAtClass.add(away);
        }
    }

    public Pupil() {

        this.id = Details.id;

        Details.id++;

        int rand1 = (int) Math.round(100 * Math.random());

        typepupil = new PupilTypeA();
        if (rand1 > -1 && rand1 < 65) {
            typepupil = new PupilTypeA();

        } else if (rand1 > 64 && rand1 < 90) {
            typepupil = new PupilTypeB();

        } else if (rand1 > 89 && rand1 < 101) {
            typepupil = new PupilTypeC();

        }

    }

    int id = 0;
    pupilType typepupil = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void printAbsent(String className, String schoolname) throws IOException {

        try (FileWriter myWriter = new FileWriter("absent.csv", true)) {
            for (Away away : notAtClass) {
                if (away.isAway != null && away.isAway == true) {
                    
                    //Set Reason
                    int prob = (int) (Math.random() * 3);
                    
                    String reason = "";
                    switch (prob) {
                        case 0:
                            reason = "SAIRAS";
                            break;
                        case 1:
                            reason = "MUU";
                            break;
                        case 2:
                            reason = "Luvaton";
                            break;
                        default:
                            break;
                    }
                    
                    myWriter.append(id + ";" + className + ";" + schoolname + ";" + away.getAwayDate() + ";" + reason + ";\n");
                }
            }
        }

    }

}

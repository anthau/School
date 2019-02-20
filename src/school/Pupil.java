/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

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

class Pupil {

    ArrayList<Boolean> notAtClass = new ArrayList<>();

    void addDay() {
        //TODO CHECK, if he/she is at  class.

    }

    public void SimulateOneDay(LocalDate curDate, String className, String dayOfWeekSchool) {

        if (false == curDate.equals(LocalDate.of(2014, 12, 6)) && dayOfWeekSchool.equals("SUNDAY") == false && dayOfWeekSchool.equals("SATURDAY") == false) {
            Boolean awayYesterday = false;
            if (notAtClass.size() < 3) {
                awayYesterday = false;
            } else {
                awayYesterday = notAtClass.get(notAtClass.size() - 2);
                if (awayYesterday == null) {

                    int cur = notAtClass.size() - 2;

                    while (cur > -1 && notAtClass.get(cur) == null) {
                        cur--;
                    }
                    if (cur > 0) {
                        awayYesterday = notAtClass.get(cur);
                    } else {
                        awayYesterday = true;
                    }
                }

            }

            Boolean isAway = typepupil.isAwayProb(awayYesterday, curDate.getDayOfWeek().toString());

            int luku = (int) (2 * Math.random());
            if (luku == 0) {
                isAway = true;
            }
            notAtClass.add(isAway);
            System.out.println(className + "  Pupil=" + id + " day=" + Details.curDay + " " + notAtClass.size() + " " + isAway + " day=" + curDate.toString());
        } else {
            System.out.println(className + "  Pupil=" + id + " freeday" + curDate.toString());
            notAtClass.add(null);
        }
    }

    public Pupil() {

        this.id = Details.id;

        System.out.println("simulate pupil=" + id);
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

}

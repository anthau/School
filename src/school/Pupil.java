/*
@author Antto Hautamäki
 */
package school;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


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
   
    }
    
    //Checks if it is a holiday, when you don't count awaydata
    Boolean isHoliday(LocalDate curDate)  {
        
         LocalDate xmasHoliday=LocalDate.of(2017, Month.DECEMBER, 22);
         LocalDate xmasHolidayEnd=LocalDate.of(2018, Month.JANUARY, 3);
         
         LocalDate easterHoliday=LocalDate.of(2018, Month.MARCH, 29);
         LocalDate easterHolidayEnd=LocalDate.of(2018, Month.APRIL, 3);
         
         Boolean isHoliday= (curDate.isAfter(xmasHoliday.minusDays(1))
                 && curDate.isBefore(xmasHolidayEnd.plusDays(1))
                 || curDate.isAfter(easterHoliday)  
                 && curDate.isBefore(easterHolidayEnd) );

         return isHoliday;
    }

    public void SimulateOneDay(LocalDate curDate, 
            String className, String dayOfWeekSchool) {

        if ( isHoliday(curDate)==false 
                && false == curDate.equals(LocalDate.of(2014, 12, 6))
                && dayOfWeekSchool.equals("SUNDAY") == false
                && dayOfWeekSchool.equals("SATURDAY") == false) {
           
            Boolean awayYesterday=false;
     
            if (notAtClass.size() < 3) {
                awayYesterday = false;
            } else {

                awayYesterday =
                        notAtClass.get(notAtClass.size() - 2).getIsAway();

                if (awayYesterday == null) {

                    int cur = notAtClass.size() - 2;

                    while (cur > -1 &&
                            notAtClass.get(cur).getIsAway() == null) {
                        cur--;
                    }
                    if (cur > 0) {
                        awayYesterday = notAtClass.get(cur).getIsAway();
                    } else {
                        awayYesterday = true;
                    }

                }

            }

            Boolean isAway = typepupil.isAwayProb(awayYesterday,
                    curDate.getDayOfWeek().toString());

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
/*If Pupil away, then add the reason */
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
                    
                    //Writes data to csv
                    myWriter.append(id + ";" + className + ";" 
                            + schoolname + ";" + away.getAwayDate()
                            + ";" + reason + ";\n");
                }
            }
        }

    }

}

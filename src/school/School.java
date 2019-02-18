/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.util.Date;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author antto
 */
public class School {

    /**
     * @param args the command line arguments
     */
    static Boolean checkIfInHoliday(LocalDate cur, LocalDate start, LocalDate end) {

        if(cur.isAfter(start) &&cur.isBefore(end))  {
          
                return true;
           
        }
        return false;
    
    }

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Hello");
        LocalDate[] days = new LocalDate[365];
        Boolean[] isfree = new Boolean[365];
        LocalDate curDay = null;
        ; // Create a date object
    
        for (int day = 0; day < 365; day++) {
            curDay = LocalDate.of(2017, 9, 4).plusDays(day);
            days[day] = curDay;
            Boolean isHoliday=checkIfInHoliday(curDay, LocalDate.of(2017, 12, 22), LocalDate.of(2018, 01, 03)) || checkIfInHoliday(curDay, LocalDate.of(2018, 03, 30), LocalDate.of(2018, 04, 02));
            //TODO Make holidays no teaching 
            if (curDay.equals(LocalDate.of(2017, 12, 6)) == true || curDay.getDayOfWeek().toString().equals("SATURDAY") || curDay.getDayOfWeek().toString().equals("SUNDAY") || isHoliday==true) {
             System.out.println("loma");

            } else {
                //Check work
            }

            //System.out.println(days[day]);
        }

    }

}

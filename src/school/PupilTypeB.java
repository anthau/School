/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

/**
 *
 * @author antto
 */
public class PupilTypeB extends pupilType {

    @Override
    public Boolean isAwayProb(Boolean yesterdayAway, String weekday) {
        int prob = (int) (Math.random() * 100);
        if (weekday.equals("MONDAY") || weekday.equals("FRIDAY")) {

            return prob>-1 && prob<30;
        }
        else 
               return prob>-1 && prob<10;
      
    }

}

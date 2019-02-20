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
public class PupilTypeA extends pupilType {

    @Override
    public Boolean isAwayProb(Boolean yesterdayAway, String weekday) {
        int prob = (int) (Math.random() * 100);
        if (yesterdayAway == null || yesterdayAway == false) {

            return prob == 1;
        }

        return prob > -1 && prob < 75;
    }

}

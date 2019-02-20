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
public class PupilTypeC extends pupilType {

    @Override
    public Boolean isAwayProb(Boolean yesterdayAway, String weekday) {
        int prob = (int) (100 * Math.random());
        if (yesterdayAway == false) {
            return prob > -1 && prob < 20;
        } else {
            return prob > -1 && prob < 40;
        }

    }

}

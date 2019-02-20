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
abstract class pupilType {
    String weekDay="";
    Boolean yesterdayOut=false;

    public abstract Boolean isAwayProb(Boolean yesterdayAway,String weekday); // abstract method
}
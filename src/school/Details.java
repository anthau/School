/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * author antto Hautamäki
 */
/*
Singleton, which contains certain universal data such as the filename
*/
class Details {
    static public int id = 0;
    static public int classId2 = 0;
    static public int classSize=20;
    static public String[] classNames = {"1A", "1B", "2A", "2B", "3A", "3B"};
    static public int curDay = 0;
    static public LocalDate startDay= LocalDate.of(2014, Month.SEPTEMBER, 4); 
    static String filename="absent.csv";
}

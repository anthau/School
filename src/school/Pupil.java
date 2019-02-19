/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.util.ArrayList;

/**
 *
 * @author antto
 */
class Details  {
    static public int id=0;
     static public int classId2=0;
     static public String[] classNames = {"1A", "1B", "2A", "2B","3A","3B"};
}

class Pupil {

     ArrayList<Boolean> notAtClass = new ArrayList<>();
     void addDay()  {
         //TODO CHECK, if he/she is at  class.
         
     }
     void SimulateOneDay()   {
         System.out.println("day1");
       
     }
    public Pupil() {

            this.id=Details.id;
         
        System.out.println("simulate pupil=" + id);
                 Details.id++;
       
       
        int rand1 = (int) Math.round(100 * Math.random());
        
        
        if (rand1 > -1 && rand1 < 65) {
              typepupil=new PupilTypeA();
         
        }

        if (rand1 > 64 && rand1 < 90) {
                typepupil=new PupilTypeB();
           
            
        }
        if (rand1 > 89 && rand1 < 100) {
                typepupil=new PupilTypeC();
           
        }
    
    }

    int id=0;
    pupilType typepupil = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

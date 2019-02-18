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
class Pupil {

     ArrayList<Boolean> notAtClass = new ArrayList<>();
     void addDay()  {
         //TODO CHECK, if he/she is at  class.
         
     }
    public Pupil() {
      
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

    int id;
    pupilType typepupil = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

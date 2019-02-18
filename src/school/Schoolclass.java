/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.util.ArrayList;

import java.util.Vector;

/**
 *
 * @author antto
 */
 class Schoolclass  {

    public Schoolclass() {
         addPupils();
    }
    private String Name = "";

    ArrayList<Pupil> pupils = new ArrayList<>();
    public void browsePupils()  {
        for(Pupil pupil :pupils)  {
            System.out.println("Pupil" + pupil);
        }
        
    }

    private void addPupils() {

        for (int i = 0; i < 20; i++) {
            pupils.add(new Pupil());

        }
    }

}

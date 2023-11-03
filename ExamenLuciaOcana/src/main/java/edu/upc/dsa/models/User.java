package edu.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    int id;
    AtomicInteger nextID = new AtomicInteger();
    int puntosAcumulados;

    //Constructures
    //----------------------------------------------------
    public User(){this.id = nextID.incrementAndGet();}
    public User(int puntos){
        this();
        this.id=nextID.incrementAndGet();
        this.puntosAcumulados=puntos;
    }
    //----------------------------------------------------

    //Gets and Sets

    public int GetIdUser(){
        return this.id;
    }
    public int GetPoints(){
        return this.puntosAcumulados;
    }

    public void SetPoints(int points){
        this.puntosAcumulados=points;
    }

}
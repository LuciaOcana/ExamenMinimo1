package edu.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    int id;
    AtomicInteger nextID = new AtomicInteger();
    String description;
    int numLevels; //Indica el numero de niveles que tiene el juego registrado.


    //Constructores
    //----------------------------------------------------
    public Game(){
        this.id=nextID.incrementAndGet();
    }
    public Game(String descripcion, int numNiveles){
        this();
        this.id=nextID.incrementAndGet();
        this.description=descripcion;
        this.numLevels=numNiveles;

    }
    //----------------------------------------------------

    //Sets and Gets

    public int GetGameId(){
        return this.id;
    }
    public String GetDescription(){
        return this.description;
    }
    //Dame el nivel actual
    public int GetNumLevels(){
        return this.numLevels;
    }

    public void SetDescription(String Description){
        this.description=Description;
    }
    public void SetLevels (int numNiveles){
        this.numLevels=numNiveles;
    }

}

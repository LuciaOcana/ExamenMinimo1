package edu.upc.dsa.models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Partida {
    int idPartida;
    AtomicInteger nextID = new AtomicInteger(); //Asignamos un id a la partida empezada.
    int idUsuario;
    //El primer nivel siempre empezará siendo 1
    int nivelActual;
    int puntosPartida;
    String fechaCambioNivel;
    int ultimoNivel;
    List<String> date;
    int endPartida=0;

    //Constructores
    //----------------------------------------------------
    public Partida(){
        this.idPartida=nextID.incrementAndGet();
    }
    public Partida(int idUser,String fecha){
        this();
        this.idPartida=nextID.incrementAndGet();
        this.idUsuario=idUser;
        this.nivelActual=1;
        date.add(fecha);
    }
    //----------------------------------------------------

    public int GetIdPartida(){
        return idPartida;
    }
    public int GetIdUsuario(){
        return idUsuario;
    }
    public int GetNivelActual(){
        return this.nivelActual;
    }
    public int GetPuntosPartida(){
        return this.puntosPartida;
    }
    public String GetFechaCambioNivel(){
        return this.fechaCambioNivel;
    }

    public void SetIdUsuario(int idUser){
        this.idUsuario=idUser;
    }
    public void SetNivelActual(int nivel){
        this.nivelActual=nivel;
    }
    public void SetPuntosPartida(int puntos){
        this.puntosPartida=puntos;
    }
    public void SetFechaCambioNivel(String fechaNL){
        this.fechaCambioNivel=fechaNL;
    }
    public void SetUltimoNivel(int ultimoLevel){
        this.ultimoNivel=ultimoLevel;
    }
    //Metodo para avanzar nivel
    public void avanzarNivel(int idU,String dateNextLevel, int points) {

        if (idU==idUsuario) {
            date.add(dateNextLevel);
            if (nivelActual == 1) {
                // Sumar 50 puntos al avanzar al primer nivel
                puntosPartida += 50;
            } else if (nivelActual == ultimoNivel) {
                // Sumar 100 puntos al llegar al último nivel
                puntosPartida =puntosPartida+points+ 100;
                //Final de la partida
                endPartida=1;
            } else if (nivelActual != ultimoNivel && endPartida==0) {
                puntosPartida = puntosPartida + points;
                //Si el nivel es diferente al ultimo entonces sumamos +1 al nivel --> nivel siguiente
                nivelActual++;
            }
        }
    }

}
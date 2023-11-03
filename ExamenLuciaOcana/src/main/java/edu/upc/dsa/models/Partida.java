package edu.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Partida {
    int idPartida;
    AtomicInteger nextID = new AtomicInteger(); //Asignamos un id a la partida empezada.
    int idUsuario;
    int nivelActual;
    int puntosPartida;
    String fechaInicioPartida;
    String fechaCambioNivel;
    int ultimoNivel;

    //Constructores
    //----------------------------------------------------
    public Partida(){
        this.idPartida=nextID.incrementAndGet();
    }
    public Partida(int idUser, int nivel, int puntos, String fechaInicio, String fechaNextLevel){
        this();
        this.idPartida=nextID.incrementAndGet();
        this.idUsuario=idUser;
        this.nivelActual=nivel;
        this.puntosPartida=puntos;
        this.fechaInicioPartida=fechaInicio;
        this.fechaCambioNivel=fechaNextLevel;
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
    public String GetFechaInicioPartida(){
        return this.fechaInicioPartida;
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
    public void SetFechaInicioPartida(String fechaI){
        this.fechaInicioPartida=fechaI;
    }
    public void SetFechaCambioNivel(String fechaNL){
        this.fechaCambioNivel=fechaNL;
    }
    public void SetUltimoNivel(int ultimoLevel){
        this.ultimoNivel=ultimoLevel;
    }
    //Metodo para avanzar nivel
    public void avanzarNivel() {
        nivelActual++;

        if (nivelActual == 1) {
            // Sumar 50 puntos al avanzar al primer nivel
            puntosPartida += 50;
        } else if (nivelActual == ultimoNivel) {
            // Sumar 100 puntos al llegar al último nivel
            puntosPartida += 100;
        }
    }

}
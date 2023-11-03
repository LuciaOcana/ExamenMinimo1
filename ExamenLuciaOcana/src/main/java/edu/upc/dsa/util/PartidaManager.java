package edu.upc.dsa.util;

import edu.upc.dsa.models.Partida;
import java.util.List;
public interface PartidaManager {
    public Partida addPartida(int idU, int level, int puntos, String fechaI, String fechaF);
    public Partida addPartida(Partida p);
    public Partida getPartida(int id);
    public List<Partida> findAllPartidas();
    public void deletePartida(int id);
    public Partida updatePartida(Partida p);
    public Partida ultimoNivel(Partida p,int nivel);

    public int size();

}

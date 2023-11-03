package edu.upc.dsa.util;

import edu.upc.dsa.models.Game;
import edu.upc.dsa.models.Partida;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
public class PartidaManagerImpl implements PartidaManager {
    private static PartidaManager instance;
    protected List<Partida> partidas;
    final static Logger logger = Logger.getLogger(PartidaManagerImpl.class);

    private PartidaManagerImpl() {
        this.partidas = new LinkedList<>();
    }

    public static PartidaManager getInstance() {
        if (instance==null) instance = new PartidaManagerImpl();
        return instance;
    }


    @Override
    public Partida addPartida(int idU, int level, int puntos, String fechaI, String fechaF) {
        return this.addPartida(new Partida(idU, level, puntos,fechaI,fechaF));
    }

    @Override
    public Partida addPartida(Partida p) {
        logger.info("new Game " + p);

        this.partidas.add (p);
        logger.info("new Game added");
        return p;
    }

    @Override
    public Partida getPartida(int id) {
        logger.info("getPartida(" + id + ")");

        for (Partida p : this.partidas) {
            String idS = Integer.toString(p.GetIdPartida());
            if (idS.equals(id)) {
                logger.info("getPartida(" + id + "): " + p);

                return p;
            }
        }
        return null;
    }

    @Override
    public List<Partida> findAllPartidas() {
        return this.partidas;
    }

    @Override
    public void deletePartida(int id) {
        Partida p = this.getPartida(id);
        if (p==null) {
            logger.warn("not found " + p);
        }
        else logger.info(p+" deleted ");

        this.partidas.remove(p);
    }

    @Override
    public Partida updatePartida(Partida p) {
        Partida ps = this.getPartida(p.GetIdPartida());

        if (ps!=null) {
            logger.info(p+" rebut!!!! ");
            //Set description y set levels
            ps.SetPuntosPartida(p.GetPuntosPartida());
            ps.SetPuntosPartida(p.GetPuntosPartida());
            ps.SetFechaInicioPartida(p.GetFechaInicioPartida());
            ps.SetFechaCambioNivel(p.GetFechaCambioNivel());

            logger.info(ps+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return ps;
    }

    @Override
    public Partida ultimoNivel(Partida p, int level) {
        p.SetUltimoNivel(level);
        return p;
    }

    @Override
    public int size() {
        int ret = this.partidas.size();
        logger.info("size " + ret);

        return ret;
    }
}


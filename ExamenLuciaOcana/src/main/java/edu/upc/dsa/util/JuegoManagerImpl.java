package edu.upc.dsa.util;

import edu.upc.dsa.models.Game;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Game> games;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);

    private JuegoManagerImpl() {
        this.games = new LinkedList<>();
    }

    public static JuegoManager getInstance() {
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }
    @Override
    public Game addGame(String description, int numLevels) {
        return this.addGame(new Game(description, numLevels));
    }

    @Override
    public Game addGame(Game game) {
        logger.info("new Game " + game);

        this.games.add (game);
        logger.info("new Game added");
        return game;
    }

    @Override
    public Game getGame(int id) {
        logger.info("getGame(" + id + ")");

        for (Game g : this.games) {
            String idS = Integer.toString(g.GetGameId());
            if (idS.equals(id)) {
                logger.info("getGame(" + id + "): " + g);

                return g;
            }
        }
        return null;
    }

    @Override
    public List<Game> findAllGames() {
        return this.games;
    }

    @Override
    public void deleteGame(int id) {
        Game g = this.getGame(id);
        if (g==null) {
            logger.warn("not found " + g);
        }
        else logger.info(g+" deleted ");

        this.games.remove(g);
    }

    @Override
    public Game updateGame(Game newGame) {
        Game g = this.getGame(newGame.GetGameId());

        if (g!=null) {
            logger.info(newGame+" rebut!!!! ");
            //Set description y set levels
            g.SetDescription(newGame.GetDescription());
            g.SetLevels(newGame.GetNumLevels());

            logger.info(g+" updated ");
        }
        else {
            logger.warn("not found "+newGame);
        }
        return g;
    }

    @Override
    public int size() {
        int ret = this.games.size();
        logger.info("size " + ret);

        return ret;
    }

}
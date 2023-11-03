package edu.upc.dsa.util;

import edu.upc.dsa.models.Game;

import java.util.List;
public interface JuegoManager {

    public Game addGame(String description, int numLevels);
    public Game addGame(Game game);
    public Game getGame(int id);
    public List<Game> findAllGames();
    public void deleteGame(int id);
    public Game updateGame(Game newGame);

    public int size();

}

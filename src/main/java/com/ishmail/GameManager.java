package com.ishmail;

import com.ishmail.model.Game;
import java.util.List;

public interface GameManager {
    void add(Game game);
    void remove(Game game);
    List<Game> getGames();
    void update(Game game);
}

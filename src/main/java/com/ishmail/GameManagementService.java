package com.ishmail;

import com.ishmail.model.Game;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameManagementService implements GameManager {

    // made public static so it is accessible in the NameValidator Class
    public static List<Game> games = new ArrayList<>();

    // iterate through the list of games and increment quantity by one everytime the same game is added
    @Override
    public void add(@Observes @AddEvent Game game) {
        int newQuantity = 0;
        for(Game g: games) {
            if(g.getName().equals(game.getName())) {
                newQuantity = g.getQuantity();
            }
        }
        games.removeIf(next -> next.getName().equals(game.getName()));
        games.add(new Game(game.getName(), game.getPrice(),newQuantity + 1, game.getDeveloper()));
    }

    // Used to remove a game from the list
    @Override
    public void remove(@Observes @RemoveEvent Game game) {
        games.remove(game);
        }

    // Update quantity of game in the list
    @Override
    public void update(@Observes @UpdateEvent Game game) {
        int originalQuantity = 0;
        double price = 0;
        Game.Developer developer = null;
        for(Game g: games) {
            if(g.getName().equals(game.getName())) {
                originalQuantity = g.getQuantity();
                price = g.getPrice();
                developer = g.getDeveloper();
            }
        }
        int newQuantity = originalQuantity + game.getQuantity();
        if (newQuantity < 0) {
            newQuantity = 0;
        }
        games.removeIf(next -> next.getName().equals(game.getName()));
        games.add(new Game(game.getName(), price, newQuantity, developer));
    }

    @Override
    public List<Game> getGames() {
        return games;
    }
}

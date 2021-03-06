package com.ishmail;

import com.ishmail.interceptor.Logged;
import com.ishmail.model.Game;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model // meta annotation that contains @RequestScoped and @Named
public class GameBean {

    // Class variables
    private String name;
    private double price;
    private int quantity;
    private String developer;
    private int newQuantity;
    private String currentName;
    private Game game;
    private Game.Developer defaultDeveloper = Game.Developer.CAPCOM;


    @Inject // through CDI will ensure service is properly instantiated and injected
    @AddEvent // AddEvent of type Game
    private Event<Game> gameAddEvent;


    @Inject // through CDI will ensure service is properly instantiated and injected
    @RemoveEvent // RemoveEvent of type Game
    private Event<Game> gameRemoveEvent;


    @Inject // through CDI will ensure service is properly instantiated and injected
    @UpdateEvent // UpdateEvent of type Game
    private Event<Game> gameUpdateEvent;

    @Inject // through CDI will ensure service is properly instantiated and injected
    private GameManager gameManagementService;

    public List<Game> getGames() {
        return gameManagementService.getGames();
    }

    @Logged // used to track method as it is being called
    // using AddEvent to add a new game to the list
    public void addGame() {
        if (developer.equals("FROMSOFTWARE")) {
            defaultDeveloper = Game.Developer.FROMSOFTWARE;
        }
        if (developer.equals("SEGA")) {
            defaultDeveloper = Game.Developer.SEGA;
        }
        game = new Game(name, price, quantity, defaultDeveloper);
        gameAddEvent.fire(game);
    }

    @Logged // used to track method as it is being called
    // using RemoveEvent to remove an existing game from the list
    public void removeGame(Game game) {
        gameRemoveEvent.fire(game);
    }

    @Logged // used to track method as it is being called
    // using UpdateEvent to update quantity of an existing game
    public void updateQuantity() {
        game = new Game(currentName, price, newQuantity, defaultDeveloper);
        gameUpdateEvent.fire(game);
    }

    // Accessors and Mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int updateQuantity) {
        this.newQuantity = updateQuantity;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game.Developer getDefaultDeveloper() {
        return defaultDeveloper;
    }

    public void setDefaultDeveloper(Game.Developer defaultDeveloper) {
        this.defaultDeveloper = defaultDeveloper;
    }

}

package model;

public class Game {

    boolean locked;
    int cash;
    int maxPlayers;
    int curPlayers;
    String name;
    int cards;
    boolean fairPlay;
    boolean throwNeighbors;
    boolean passingCards;
    int speed;

    public Game(boolean locked, int cash, int maxPlayers, int curPlayers, String name, int cards, boolean fairPlay, boolean throwNeighbors, boolean passingCards, int speed) {
        this.locked = locked;
        this.cash = cash;
        this.maxPlayers = maxPlayers;
        this.curPlayers = curPlayers;
        this.name = name;
        this.cards = cards;
        this.fairPlay = fairPlay;
        this.throwNeighbors = throwNeighbors;
        this.passingCards = passingCards;
        this.speed = speed;
    }

    public Game() { }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getCurPlayers() {
        return curPlayers;
    }

    public void setCurPlayers(int curPlayers) {
        this.curPlayers = curPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    public boolean isFairPlay() {
        return fairPlay;
    }

    public void setFairPlay(boolean fairPlay) {
        this.fairPlay = fairPlay;
    }

    public boolean isThrowNeighbors() {
        return throwNeighbors;
    }

    public void setThrowNeighbors(boolean throwNeighbors) {
        this.throwNeighbors = throwNeighbors;
    }

    public boolean isPassingCards() {
        return passingCards;
    }

    public void setPassingCards(boolean passingCards) {
        this.passingCards = passingCards;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

package model;

import java.util.HashMap;
import java.util.Map;

public class GameC {

    private String roomName;
    private boolean _private;
    private String money;
    private int maxPlayerCount;
    private int currentPlayerCount;
    private String speed;
    private int cards;
    private String canThrow;
    private boolean fairPlay;
    private boolean passOn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isPrivate() {
        return _private;
    }

    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    public int getCurrentPlayerCount() {
        return currentPlayerCount;
    }

    public void setCurrentPlayerCount(int currentPlayerCount) {
        this.currentPlayerCount = currentPlayerCount;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    public String getCanThrow() {
        return canThrow;
    }

    public void setCanThrow(String canThrow) {
        this.canThrow = canThrow;
    }

    public boolean isFairPlay() {
        return fairPlay;
    }

    public void setFairPlay(boolean fairPlay) {
        this.fairPlay = fairPlay;
    }

    public boolean isPassOn() {
        return passOn;
    }

    public void setPassOn(boolean passOn) {
        this.passOn = passOn;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package it.develhope.CustomQueries02.entities;

public enum StatusEnum {
    ONTIME,
    DELAYED,
    CANCELLED;

    public static StatusEnum getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }


}

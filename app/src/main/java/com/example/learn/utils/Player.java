package com.example.learn.utils;

public class Player {
    private String idPlayer;
    private String strPlayer;
    private String strTeam;
    private String strNationality;
    private String strPosition;
    private String strThumb;

    // Constructor
    public Player(String idPlayer, String strPlayer, String strTeam, String strNationality, String strPosition, String strThumb) {
        this.idPlayer = idPlayer;
        this.strPlayer = strPlayer;
        this.strTeam = strTeam;
        this.strNationality = strNationality;
        this.strPosition = strPosition;
        this.strThumb = strThumb;
    }

    // Getters
    public String getIdPlayer() {
        return idPlayer;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public String getStrThumb() {
        return strThumb;
    }
}

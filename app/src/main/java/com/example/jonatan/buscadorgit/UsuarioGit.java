package com.example.jonatan.buscadorgit;

/**
 * Created by Jonatan on 07/07/2018.
 * Esta clase representara un usuario con los datos devueltos por la API de GitHub en forma
 * de array de items (Ver clase 'SearchResult')
 */

public class UsuarioGit {
    private String login;
    private String avatar_url;
    private Double score;

    public UsuarioGit(){}

    public UsuarioGit(String login, String avatar_url, Double score){
        this.login = login;
        this.avatar_url = avatar_url;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

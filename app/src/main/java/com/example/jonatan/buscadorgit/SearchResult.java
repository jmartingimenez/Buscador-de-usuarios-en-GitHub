package com.example.jonatan.buscadorgit;

import java.util.List;

/**
 * Created by Jonatan on 07/07/2018.
 * Esta clase se mapea con el JSON devuelto por la API de GitHub
 */

public class SearchResult {
    private Integer total_count;
    private List<UsuarioGit> items;

    public SearchResult(){}

    public SearchResult(Integer total_count, List<UsuarioGit> items){
        this.total_count = total_count;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<UsuarioGit> getItems() {
        return items;
    }

    public void setItems(List<UsuarioGit> items) {
        this.items = items;
    }
}
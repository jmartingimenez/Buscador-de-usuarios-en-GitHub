package com.example.jonatan.buscadorgit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jonatan on 07/07/2018.
 * Singleton
 */

public class GitServiceClient {
    private GitServiceClient(){}

    private static GitService sInstance;

    public static GitService getInstance(){
        if(sInstance == null)
            sInstance = createInstance();
        return sInstance;
    }

    private static GitService createInstance() {
        /*Crea un adaptador retrofit con una url de base y permite convertir el JSON
        * devuelto a objetos java*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(GitService.class);
    }

    /*Resultados de retrofit son tipos Call<T>. Devuelve un lo que este en el
     convert-type (xml, json) y lo convierte en <T>. La API de github devuelve
     JSON. Call representa una llamada a la API*/
    public interface GitService{
        @GET("search/users")
        Call<SearchResult> searchUsuarios(@Query("q") String query);
    }
}

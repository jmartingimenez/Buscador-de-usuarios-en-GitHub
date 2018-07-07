package com.example.jonatan.buscadorgit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Cuando se presiona el botón de buscar capturo el texto del usuario, previo a
        * revisar que no dejara el input vacio, seteo el RecyclerView y luego intento
        * conectar con la API de GitHub. Si sale bien la llamada, paso la lista devuelta por
        * la API al adaptador. Caso contrario, inicio el adaptador, pero sin la lista. Le
        * agrege un constructor vacio que va poner datos dummy*/
        findViewById(R.id.btnBuscar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = (EditText) findViewById(R.id.etBuscar);
                String textoBuscado = editText.getText().toString();

                if(textoBuscado.isEmpty()){
                    Toast.makeText(MainActivity.this, "Escriba algo antes",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                rv = (RecyclerView) findViewById(R.id.recyclerView);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false));

                GitServiceClient.getInstance().searchUsuarios(textoBuscado)
                        .enqueue(new Callback<SearchResult>() {
                            @Override
                            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                                Toast.makeText(MainActivity.this,
                                        "Devueltos: " + response.body().getTotal_count(),
                                        Toast.LENGTH_SHORT).show();

                                rv.setAdapter(new UsuarioGitAdapter(response.body().getItems()));
                            }

                            @Override
                            public void onFailure(Call<SearchResult> call, Throwable t) {
                                Toast.makeText(MainActivity.this,
                                        "Fallo en la busqueda:" + t.getLocalizedMessage(),
                                        Toast.LENGTH_LONG).show();
                                Log.d("ErrorAPI", "===="+t.getLocalizedMessage());

                                /*Constructor vacio para que se llenen datos dummy para
                                * probar el RecyclerView*/
                                rv.setAdapter(new UsuarioGitAdapter());
                            }
                        });
            }
        });
    }
}

package com.movilespascual.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instanciar Usuario
        usuario = findViewById(R.id.user);

        //datos es el nombre del archivo, Context.MODE_PRIVATE es par decirle que solo en esta app
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        usuario.setText(preferencias.getString("usuarios",""));
    }

    public void guardar(View view){
        //Recupera los datos del archivo datos
        SharedPreferences preference = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //El metodo Editor permite editar la información, preference.edit(), nos pemrite en si editar
        SharedPreferences.Editor objetoEditor = preference.edit();
        objetoEditor.putStringSet("usuarios", usuario.getText().toString());
        objetoEditor.commit();

    }
}
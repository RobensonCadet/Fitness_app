package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1,spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spinClientes);
        spin2 = (Spinner)findViewById(R.id.spinPlanes);

        text = (TextView)findViewById(R.id.tv);
        edit = (EditText)findViewById(R.id.et1);


        //Recibo el arreglo desde el menu.
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular( View v)
    {
        Planes plan = new Planes();

        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());
        int xtreme = Integer.parseInt(plan.getXtreme());
        int mind = Integer.parseInt(plan.getMindfullness());

        int resultado = saldo - xtreme;
        int resultadoDos = saldo -mind;

        if(cliente.equals("Roberto") && planes.equals("Xtreme"))
        {
            text.setText("El valor de Xtreme es: " + resultado);
        }

        if(cliente.equals("Roberto") && planes.equals("Mindfullness"))
        {
            text.setText("El valor de midfullness es: " + resultadoDos);
        }

    }
}
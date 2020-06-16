package com.udemy.postodegasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    private EditText valorGasolina, valorAlcool;
    private double valor1, valor2;
    private Button comparacao;
    private TextView resultado;
    private android.content.Context Context;

    //private String valor1, valor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorAlcool = findViewById(R.id.precoAlcool);
        valorGasolina = findViewById(R.id.precoGasolina);
        comparacao = findViewById(R.id.comparacao);
        resultado = findViewById(R.id.resultado);

        comparacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //comparacao();
                calcularPreco();
            }
        });

    }
    // feito por mim
    public void comparacao() {
        String valor1 = valorAlcool.getText().toString();
        String valor2 = valorGasolina.getText().toString();
        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast toast = Toast.makeText(MainActivity.this, "Favor preencher o campo vazio", Toast.LENGTH_LONG);
            toast.show();
        } else if (valor1 != " " && valor2 != " " && valor1 != null && valor2 != null) {
            double valorGasolina = parseDouble(valor1);
            double valorAlcool = parseDouble(valor2);
            Double media = valorAlcool / valorGasolina;
            if(media >= 0.7){
                resultado.setText("o melhor combustivel é gasolina");
            } else {
                resultado.setText("a melhor opção para o teu carro é alcool");
            }

        };

    }

    public void calcularPreco() {
        String valor1 = valorAlcool.getText().toString();
        String valor2 = valorGasolina.getText().toString();

        Boolean camposvalidados = validarCampos(valor1, valor2);
        if (camposvalidados) {
            double precoAlcool = parseDouble(valor1);
            double precoGasolina = parseDouble(valor2);
            double media = precoAlcool / precoGasolina;
            if (media >= 0.7) {
                resultado.setText("eh melhor usar gasolina");

            } else {
                resultado.setText("eh melhor usar alcool");
            }

        }
    }

    public Boolean validarCampos(String prcAlool, String prcGasolina){
        boolean camposValidados = true;
        String Campo = "preenchido";

        if(prcAlool == null || prcAlool.equals("") || prcGasolina == null || prcGasolina.equals("")){
            camposValidados = false;
            Toast toast = Toast.makeText(MainActivity.this, "Favor preencher o campo vazio", Toast.LENGTH_LONG);
            toast.show();
        }
        return camposValidados;
    }

}
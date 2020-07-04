package com.example.calculogastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Agragra elementos para conectarlos a la vista
    private EditText editNombre;
    private EditText editPLL;
    private EditText editPS;
    private EditText editKM;
    private EditText editHS;
    private EditText editCosto;
    private EditText editTLL;
    private  EditText editCTV;
    private Button btnCalcularTotal;
    private Button btnCalcularTiempo;
private Button btnSalir;

    private void Iniciar(){
        editNombre=(EditText)findViewById(R.id.editNombre);
        editPS=(EditText)findViewById(R.id.editPS);
        editPLL=(EditText)findViewById(R.id.editPLL);
        editHS=(EditText)findViewById(R.id.editHS);
        editCosto=(EditText)findViewById(R.id.editCosto);
        editKM=(EditText)findViewById(R.id.editKM);
        editTLL=(EditText)findViewById(R.id.editTLL);
        editCTV=(EditText)findViewById(R.id.editCTV);

        //Iniciar Boton
        btnCalcularTiempo=(Button)findViewById(R.id.btnCalcularTiempo);
        btnCalcularTotal=(Button)findViewById(R.id.btnCalcularTotal);
        btnSalir=(Button)findViewById(R.id.btnSalir);

        //Eventos de Botones
        btnCalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CalcularTotal();}
        });
        btnCalcularTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CalcularTiempo();}{}
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Limpiar();}{ }
        });
    }

    private void CalcularTotal() {
        int cc= Integer.parseInt(editCosto.getText().toString());
        int dkm= Integer.parseInt(editKM.getText().toString());

        int rendimiento=16;
        int CostoTotoal= (dkm/ rendimiento)* cc;

        editCTV.setText(String.valueOf("$"+ CostoTotoal +".00"));
    }

    private void CalcularTiempo() {
        int dkm= Integer.parseInt(editKM.getText().toString());

        int Seg=(dkm*3600)/100;
        int Hra= Seg/3600;
        int Min= (Seg-Hra*3600)/60;
        int SR= Seg-Hra *3600- Min*60;

        editTLL.setText(String.valueOf(Hra + " Hora " + Min + " Minutos "+ SR + " Segundos"));
    }

    private void Limpiar(){
        editNombre.setText(" ");
        editPLL.setText(" ");
         editPS.setText(" ");
         editKM.setText(" ");
         editHS.setText(" ");
        editCosto.setText(" ");
        editTLL.setText(" ");
        editCTV.setText(" ");
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }
}
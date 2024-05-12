package com.fateczl.professor_app_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fateczl.professor_app_android.model.ProfessorHorista;
import com.fateczl.professor_app_android.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private EditText nTempoAnos;
    private EditText nSalario;
    private EditText nHoras;
    private EditText nValorHorista;
    private Button btnCalc;
    private TextView saida;

    ProfessorHorista horista=new ProfessorHorista();
    ProfessorTitular titular=new ProfessorTitular();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbTitular=findViewById(R.id.rbTitular);

        rbHorista=findViewById(R.id.rbHorista);

        nTempoAnos=findViewById(R.id.nTempoAnos);
        nSalario=findViewById(R.id.nSalario);
        nHoras=findViewById(R.id.nHoras);
        nValorHorista=findViewById((R.id.nValorHora));
        nHoras.setVisibility(View.INVISIBLE);
        nValorHorista.setVisibility(View.INVISIBLE);
        btnCalc=findViewById(R.id.btnCalcular);
        saida=findViewById(R.id.tvSaida);

        nTempoAnos.setVisibility(View.INVISIBLE);
        nSalario.setVisibility(View.INVISIBLE);
        nHoras.setVisibility(View.INVISIBLE);
        nValorHorista.setVisibility(View.INVISIBLE);

        rbTitular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nTempoAnos.setVisibility(View.VISIBLE);
                    nSalario.setVisibility(View.VISIBLE);
                    btnCalc.setOnClickListener(op -> calcTitular());
                }else{
                    nTempoAnos.setVisibility(View.INVISIBLE);
                    nSalario.setVisibility(View.INVISIBLE);
                    saida.setText(" ");
                }

            }
        });

        rbHorista.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nHoras.setVisibility(View.VISIBLE);
                    nValorHorista.setVisibility(View.VISIBLE);
                    btnCalc.setOnClickListener(op -> calcHorista());
                }else{
                    nHoras.setVisibility(View.INVISIBLE);
                    nValorHorista.setVisibility(View.INVISIBLE);
                    saida.setText(" ");
                }
            }
        });
    }

    private void calcHorista() {
        String texto;
        texto = nHoras.getText().toString();
        horista.setHorasAula(Integer.parseInt(texto));
        texto=nValorHorista.getText().toString();
        horista.setValorHoraAula(Double.parseDouble(texto));
        Double total=horista.getValorHoraAula()*horista.getHorasAula();
        saida.setText(total.toString());
    }

    private void calcTitular() {
        String texto;

        texto=nSalario.getText().toString();
        titular.setSalario(Double.parseDouble(texto));

        texto=nTempoAnos.getText().toString();
        titular.setAnosInstituicao(Integer.parseInt(texto));
        double bonus= (titular.getAnosInstituicao()/5)*0.05;

        Double total=titular.getSalario()*(bonus+1);
        saida.setText(total.toString());
    }
}
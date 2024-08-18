package devandroid.marcell.appgaseta1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.marcell.appgaseta1.R;
import devandroid.marcell.appgaseta1.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

//    UtilGasEta utilGasEta = new UtilGasEta();
    EditText edtTxtGasolina;
    EditText edtTxtEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

//        utilGasEta.metodoNaoEstatico();

//        UtilGasEta.metodoStatico();

        edtTxtEtanol = findViewById(R.id.edtTxtEtanol);
        edtTxtGasolina = findViewById(R.id.edtTxtGasolina);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtTxtEtanol.setText("");
                edtTxtGasolina.setText("");

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorPreco(5.12, 3.39),
                Toast.LENGTH_LONG).show();
    }
}

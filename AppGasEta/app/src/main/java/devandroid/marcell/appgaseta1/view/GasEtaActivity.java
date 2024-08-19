package devandroid.marcell.appgaseta1.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.marcell.appgaseta1.R;
import devandroid.marcell.appgaseta1.apoio.UtilGasEta;
import devandroid.marcell.appgaseta1.controller.CombustivelController;
import devandroid.marcell.appgaseta1.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    CombustivelController controller;


    EditText edtTxtGasolina;
    EditText edtTxtEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);
        controller = new CombustivelController(GasEtaActivity.this);

        dados = controller.getListaDeDados();

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
                boolean isDadosOk = true;

                if (TextUtils.isEmpty(edtTxtEtanol.getText())) {
                    edtTxtEtanol.setError(" Obrigatório");
                    edtTxtEtanol.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(edtTxtGasolina.getText())) {
                    edtTxtGasolina.setError(" Obrigatório");
                    edtTxtGasolina.requestFocus();
                    isDadosOk = false;
                }

                if (isDadosOk) {

                    precoEtanol = Double.parseDouble(edtTxtEtanol.getText().toString());
                    precoGasolina = Double.parseDouble(edtTxtGasolina.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorPreco(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);
                    btnSalvar.setEnabled(true);
                    btnLimpar.setEnabled(true);

                } else {
                    Toast.makeText(GasEtaActivity.this, "Digite os dados obrigatórios", Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                    btnLimpar.setEnabled(false);
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelEtanol.setNomeDoCombustivel("Etanol");

                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorPreco(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorPreco(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);



            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtTxtEtanol.setText("");
                edtTxtGasolina.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();

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

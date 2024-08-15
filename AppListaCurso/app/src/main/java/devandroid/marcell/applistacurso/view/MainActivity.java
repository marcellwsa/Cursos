package devandroid.marcell.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.marcell.applistacurso.R;
import devandroid.marcell.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    String dadosPessoa;

    EditText edtTxtPrimeiroNome;
    EditText edtTxtSobrenome;
    EditText edtTxtNomeCursoDesejado;
    EditText edtTxtTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

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

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Marcell");
        pessoa.setSobrenome("Almeida");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("81999141577");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += "Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        edtTxtPrimeiroNome = findViewById(R.id.edtTxtPrimeiroNome);
        edtTxtSobrenome = findViewById(R.id.edtTxtSobrenome);
        edtTxtNomeCursoDesejado = findViewById(R.id.edtTxtNomeCursoDesejado);
        edtTxtTelefoneContato = findViewById(R.id.edtTxtTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        edtTxtPrimeiroNome.setText(pessoa.getPrimeiroNome());
        edtTxtSobrenome.setText(pessoa.getSobrenome());
        edtTxtNomeCursoDesejado.setText(pessoa.getCursoDesejado());
        edtTxtTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTxtPrimeiroNome.setText("");
                edtTxtSobrenome.setText("");
                edtTxtNomeCursoDesejado.setText("");
                edtTxtTelefoneContato.setText("");
            }
        });


        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(edtTxtPrimeiroNome.getText().toString());
                pessoa.setSobrenome(edtTxtSobrenome.getText().toString());
                pessoa.setCursoDesejado(edtTxtNomeCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(edtTxtTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo", Toast.LENGTH_LONG).show();
            }
        });

//        Log.i("PooAndroid", pessoa.toString());

//        int parada = 0;


    }
}
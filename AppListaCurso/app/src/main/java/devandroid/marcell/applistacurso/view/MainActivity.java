package devandroid.marcell.applistacurso.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.marcell.applistacurso.R;
import devandroid.marcell.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    //teste

    Pessoa pessoa;

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

    }
}
package pe.edu.idat.appprietobrigitte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import pe.edu.idat.appprietobrigitte.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnformulario.setOnClickListener(this);
        binding.btnlistado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnformulario){
            startActivity(new Intent(MainActivity.this, RegistroActivity.class));
        } else if (v.getId() == R.id.btnlistado) {
            startActivity(new Intent(MainActivity.this, ListadoActivity.class));
        }

    }
}
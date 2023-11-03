package pe.edu.idat.appprietobrigitte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import pe.edu.idat.appprietobrigitte.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityRegistroBinding binding;

    private List<String> sintomas = new ArrayList<>();
    private List<String> servicios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnresolver.setOnClickListener(this);
        binding.cbninguno.setOnClickListener(this);
        binding.cbtos.setOnClickListener(this);
        binding.cbgarganta.setOnClickListener(this);
        binding.cbcongestion.setOnClickListener(this);
        binding.cbfiebre.setOnClickListener(this);
        binding.cbcable.setOnClickListener(this);
        binding.cbinternet.setOnClickListener(this);
        binding.cbdisminunicion.setOnClickListener(this);
        binding.cbluz.setOnClickListener(this);
        binding.cbagua.setOnClickListener(this);
    }

    private String fiebre(){
        String genero="";
        if (binding.rgfiebre.getCheckedRadioButtonId() == R.id.rbsi){
            genero = binding.rbsi.getText().toString();
        }else {
            genero = binding.rbno.getText().toString();
        }
        return genero;
    }

    private String vivesolo(){
        String genero="";
        if (binding.rgsolo.getCheckedRadioButtonId() == R.id.rbsi2){
            genero = binding.rbsi2.getText().toString();
        }else {
            genero = binding.rbno2.getText().toString();
        }
        return genero;
    }

    private String adultocasa(){
        String genero="";
        if (binding.rgmayor.getCheckedRadioButtonId() == R.id.rbsi3){
            genero = binding.rbsi3.getText().toString();
        }else {
            genero = binding.rbno3.getText().toString();
        }
        return genero;
    }

    private void agregarQuitarServicios(View view, String servicio){
        boolean checked = ((CheckBox)view).isChecked();
        if (checked){
            servicios.add(servicio);
        }else
            servicios.remove(servicio);
    }

    private void agregarQuitarSintomas(View view, String sintoma){
        boolean checked = ((CheckBox)view).isChecked();
        if (checked){
            sintomas.add(sintoma);
        }else
            sintomas.remove(sintoma);
    }

    private Boolean validarfiebre(){
        boolean respuesta = true;
        if (binding.rgfiebre.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }

    private Boolean validarsolo(){
        boolean respuesta = true;
        if (binding.rgsolo.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }

    private Boolean validarmayor(){
        boolean respuesta = true;
        if (binding.rgmayor.getCheckedRadioButtonId() == -1){
            respuesta = false;
        }
        return respuesta;
    }

    private Boolean validarServicios() {
        boolean respuesta = false;
        if (binding.cbluz.isChecked() || binding.cbagua.isChecked() || binding.cbcable.isChecked()|| binding.cbinternet.isChecked()){
            respuesta = true;
        }
        return respuesta;
    }

    private Boolean validarSintomas() {
        boolean respuesta = false;
        if (binding.cbdisminunicion.isChecked() || binding.cbtos.isChecked() || binding.cbgarganta.isChecked()|| binding.cbcongestion.isChecked()
                || binding.cbfiebre.isChecked()|| binding.cbninguno.isChecked()){
            respuesta = true;
        }
        return respuesta;
    }

    private Boolean validarFormulario(){
        boolean respuesta = false;
        String mensaje = "";
        if (!validarSintomas()){
            mensaje="Escoja al menos un sintoma";
        } else if (!validarfiebre()){
            mensaje="Rellene la segunda pregunta";
        } else if (!validarsolo()) {
            mensaje="Rellene la tercera pregunta";
        } else if (!validarmayor()) {
            mensaje="Rellene la cuarta pregunta";
        } else if (!validarServicios()) {
            mensaje = "Escoja al menos un servicio";
        }else
            respuesta = true;

        if (!respuesta){
            Snackbar.make(binding.getRoot(),mensaje, Toast.LENGTH_LONG).show();
        }
        return respuesta;
    }

    private void registrarPersona(){
        if (validarFormulario()){
            StringBuilder infoPersona = new StringBuilder();
            infoPersona.append(sintomas.toString());
            infoPersona.append(fiebre()+"-");
            infoPersona.append(vivesolo()+"-");
            infoPersona.append(adultocasa()+"-");
            Snackbar.make(binding.getRoot(),"Cuestionario registrado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
            setearControles();
        }
    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.cbdisminunicion){
            agregarQuitarSintomas(v,"Disminución gusto y olfato");
        } else if (v.getId() ==R.id.cbtos) {
            agregarQuitarSintomas(v,"Tos");
        } else if (v.getId() ==R.id.cbgarganta) {
            agregarQuitarSintomas(v,"Dolor de garganta");
        } else if (v.getId() ==R.id.cbcongestion) {
            agregarQuitarSintomas(v,"Congestión Nasal");
        } else if (v.getId() ==R.id.cbfiebre) {
            agregarQuitarSintomas(v,"Fiebre");
        } else if (v.getId() ==R.id.cbninguno) {
            agregarQuitarSintomas(v,"Ninguno");
        } else if (v.getId() ==R.id.cbluz) {
            agregarQuitarServicios(v,"Luz");
        } else if (v.getId() ==R.id.cbagua) {
            agregarQuitarSintomas(v,"Agua");
        } else if (v.getId() ==R.id.cbcable) {
            agregarQuitarSintomas(v,"Cable");
        } else if (v.getId() ==R.id.cbinternet) {
            agregarQuitarSintomas(v,"Internet");
        } else if (v.getId()==R.id.btnresolver) {
            registrarPersona();
    }

}
    private void setearControles(){
        binding.cbagua.setChecked(false); //checkbox
        binding.cbluz.setChecked(false);
        binding.cbinternet.setChecked(false);
        binding.cbcable.setChecked(false);
        servicios.clear();
        sintomas.clear();
        binding.cbdisminunicion.setChecked(false); //checkbox
        binding.cbtos.setChecked(false);
        binding.cbgarganta.setChecked(false);
        binding.cbcongestion.setChecked(false);
        binding.cbfiebre.setChecked(false);
        binding.cbninguno.setChecked(false);
        binding.rgmayor.clearCheck();
        binding.rgsolo.clearCheck();
        binding.rgfiebre.clearCheck();
    }

}
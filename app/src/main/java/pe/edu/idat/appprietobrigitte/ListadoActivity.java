package pe.edu.idat.appprietobrigitte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import pe.edu.idat.appprietobrigitte.databinding.ActivityListadoBinding;

public class ListadoActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityListadoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] libros = {
                "Libro 1: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 2: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 3: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 4: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 5: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 6: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 7: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 8: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 9: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015",
                "Libro 10: "+"\n"+"- Titulo: Como lavarse correctamente las manos\n- Descripción: 5 tips para...\n- Fecha de publicación: 10-02-2015"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, libros);
        binding.lvlibros.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
    }
}
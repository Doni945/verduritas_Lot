package danilo.moreno.verduritassa;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaCultivosActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCultivos;
    private CultivoAdapter cultivoAdapter;
    private List<Cultivo> cultivoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cultivos);

        // Inicializar RecyclerView
        recyclerViewCultivos = findViewById(R.id.recyclerViewCultivos);
        recyclerViewCultivos.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar la lista de cultivos
        cultivoList = new ArrayList<>();
        cargarDatos();

        // Configurar el adaptador
        cultivoAdapter = new CultivoAdapter(cultivoList);
        recyclerViewCultivos.setAdapter(cultivoAdapter);
    }

    private void cargarDatos() {
        cultivoList.add(new Cultivo("Tomates", "01/10/2024", "Tomatera"));
        cultivoList.add(new Cultivo("Zanahorias", "15/09/2024", "Zanahoria"));
        cultivoList.add(new Cultivo("Lechugas", "05/11/2024", "Lechuga"));
        // Agrega más cultivos aquí
    }
}
package danilo.moreno.verduritassa;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Referenciar el TableLayout
        tableLayout = findViewById(R.id.tableLayout);

        // Referenciar el botón de refrescar
        ImageView refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(v -> {
            Toast.makeText(this, "Actualizando cosechas...", Toast.LENGTH_SHORT).show();
        });

        // Referenciar el botón "+"
        ImageView addCosechaButton = findViewById(R.id.addCosechaButton);
        addCosechaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "Añadir nueva cosecha", Toast.LENGTH_SHORT).show();
                // Agregar una nueva fila como ejemplo
                agregarFila("Nueva Cosecha", "20-11-2024");
            }
        });

        // Inicializar las filas con datos
        agregarFila("Tomatín", "12-12-2024");
        agregarFila("Tomy", "12-12-2024");
        agregarFila("Lechuguín", "12-12-2024");
    }

    // Método para agregar una fila a la tabla
    private void agregarFila(String nombre, String fecha) {
        TableRow row = new TableRow(this);

        // Crear TextView para el nombre
        TextView nameTextView = new TextView(this);
        nameTextView.setText(nombre);
        nameTextView.setPadding(16, 16, 16, 16);
        row.addView(nameTextView);

        // Crear TextView para la fecha
        TextView dateTextView = new TextView(this);
        dateTextView.setText(fecha);
        dateTextView.setPadding(16, 16, 16, 16);
        row.addView(dateTextView);

        // Crear ImageView para acciones
        ImageView settingsIcon = new ImageView(this);
        settingsIcon.setImageResource(R.drawable.sett);
        settingsIcon.setPadding(16, 16, 16, 16);
        settingsIcon.setOnClickListener(v -> {
            Toast.makeText(this, "Opciones de " + nombre, Toast.LENGTH_SHORT).show();
        });
        row.addView(settingsIcon);

        // Agregar fila al TableLayout
        tableLayout.addView(row);
    }
}


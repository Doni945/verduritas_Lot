package danilo.moreno.verduritassa;

import android.content.Intent;
import android.os.Bundle;
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

        // Referencias a los elementos del layout
        tableLayout = findViewById(R.id.tableLayout);
        ImageView backButton = findViewById(R.id.backButton); // Referencia al botón de retroceso
        ImageView addCosechaButton = findViewById(R.id.addCosechaButton); // Referencia al botón de agregar cultivos

        // Configurar botón de retroceso
        if (backButton != null) {
            backButton.setOnClickListener(v -> {
                // Crear un Intent para regresar al MainActivity
                Intent intent = new Intent(Home.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Finalizar esta actividad
            });
        } else {
            Toast.makeText(this, "Error: Botón de retroceso no encontrado.", Toast.LENGTH_SHORT).show();
        }

        // Configurar botón para agregar cultivos
        if (addCosechaButton != null) {
            addCosechaButton.setOnClickListener(v -> {
                Toast.makeText(this, "Añadiendo nuevo cultivo...", Toast.LENGTH_SHORT).show();
                agregarFila("Nuevo Cultivo", "01-01-2025"); // Agregar un cultivo de ejemplo
            });
        } else {
            Toast.makeText(this, "Error: Botón de añadir cultivo no encontrado.", Toast.LENGTH_SHORT).show();
        }

        // Cargar datos iniciales en la tabla
        cargarDatosIniciales();
    }

    // Método para cargar datos iniciales en la tabla
    private void cargarDatosIniciales() {
        agregarFila("Tomatín", "12-12-2024");
        agregarFila("Tomy", "12-12-2024");
        agregarFila("Lechuguín", "12-12-2024");
    }

    // Método para agregar una fila a la tabla
    private void agregarFila(String nombre, String fecha) {
        // Crear una nueva fila para la tabla
        TableRow row = new TableRow(this);

        // Crear TextView para mostrar el nombre del cultivo
        TextView nameTextView = new TextView(this);
        nameTextView.setText(nombre);
        nameTextView.setPadding(16, 16, 16, 16);
        nameTextView.setTextSize(16); // Ajustar tamaño del texto
        row.addView(nameTextView);

        // Crear TextView para mostrar la fecha del cultivo
        TextView dateTextView = new TextView(this);
        dateTextView.setText(fecha);
        dateTextView.setPadding(16, 16, 16, 16);
        dateTextView.setTextSize(16); // Ajustar tamaño del texto
        row.addView(dateTextView);

        // Crear ImageView para acciones (configuración)
        ImageView settingsIcon = new ImageView(this);
        settingsIcon.setImageResource(R.drawable.sett); // Usa el ícono correspondiente
        settingsIcon.setPadding(8, 8, 8, 8);
        settingsIcon.setLayoutParams(new TableRow.LayoutParams(64, 64)); // Ajustar tamaño del ícono
        settingsIcon.setOnClickListener(v -> {
            Toast.makeText(this, "Opciones para: " + nombre, Toast.LENGTH_SHORT).show();
        });
        row.addView(settingsIcon);

        // Agregar la fila al TableLayout
        tableLayout.addView(row);
    }
}



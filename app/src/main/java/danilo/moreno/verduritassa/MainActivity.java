package danilo.moreno.verduritassa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Recuperar los elementos del layout
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        Button ingresar = findViewById(R.id.ingresar);
        TextView registrar = findViewById(R.id.registrar);

        // Listener para el botón de ingresar
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString().trim();
                String userPass = pass.getText().toString().trim();

                // Validar que los campos no estén vacíos
                if (userEmail.isEmpty() || userPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    // Intentar iniciar sesión con Firebase Auth
                    mAuth.signInWithEmailAndPassword(userEmail, userPass)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Si el inicio de sesión es exitoso, redirigir al Home
                                        Intent intent = new Intent(MainActivity.this, Home.class);
                                        startActivity(intent);
                                        finish(); // Finaliza la actividad actual para evitar volver con "Atrás"
                                    } else {
                                        // Si el inicio de sesión falla
                                        Toast.makeText(MainActivity.this, "Error de autenticación", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        // Listener para el TextView de registrar (navegar a RegistroActivity)
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el correo ingresado
                String userEmail = email.getText().toString().trim();

                // Crear intent para navegar a RegistroActivity
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);

                // Pasar el correo electrónico solo si no está vacío
                if (!userEmail.isEmpty()) {
                    intent.putExtra("email", userEmail); // Pasa el correo al registro
                }

                // Iniciar RegistroActivity sin requerir un correo obligatorio
                startActivity(intent);
            }
        });
    }
}

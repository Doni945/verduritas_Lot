package danilo.moreno.verduritassa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class RegistroActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, nameEditText, countryEditText, genderEditText;
    private Button registerButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Inicializar FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Inicializar vistas
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        countryEditText = findViewById(R.id.countryEditText);
        genderEditText = findViewById(R.id.genderEditText);
        registerButton = findViewById(R.id.registerButton);

        // Configurar el listener para el botón de registro
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String name = nameEditText.getText().toString().trim();
                String country = countryEditText.getText().toString().trim();
                String gender = genderEditText.getText().toString().trim();

                // Validar que todos los campos estén llenos
                if (email.isEmpty() || password.isEmpty() || name.isEmpty() || country.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(RegistroActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Intentar registrar al usuario en Firebase
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegistroActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    // Registro exitoso
                                    Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                                    // Aquí puedes redirigir a otra actividad si es necesario
                                    // Intent intent = new Intent(RegistroActivity.this, HomeActivity.class);
                                    // startActivity(intent);
                                    // finish(); // Finalizar la actividad de registro
                                } else {
                                    // Si ocurre un error durante el registro, mostramos el error específico
                                    Exception exception = task.getException();
                                    if (exception instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(RegistroActivity.this, "Este correo electrónico ya está registrado", Toast.LENGTH_LONG).show();
                                    } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                                        Toast.makeText(RegistroActivity.this, "Correo electrónico no válido", Toast.LENGTH_LONG).show();
                                    } else if (exception instanceof FirebaseAuthWeakPasswordException) {
                                        Toast.makeText(RegistroActivity.this, "La contraseña es demasiado débil", Toast.LENGTH_LONG).show();
                                    } else {
                                        // Aquí mostramos cualquier otro error que Firebase pueda estar devolviendo
                                        Toast.makeText(RegistroActivity.this, "Error en el registro: " + exception.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}


package com.example.appcine;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton loginButton;
    private TextView forgotPasswordText;
    private TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Appliquer les insets pour edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        signupText = findViewById(R.id.signupText);
    }

    private void setupClickListeners() {
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                // Ici vous ajouterez votre logique de connexion
                performLogin(email, password);
            }
        });

        forgotPasswordText.setOnClickListener(v -> {
            Toast.makeText(this, "Fonctionnalité mot de passe oublié", Toast.LENGTH_SHORT).show();
            // Ajouter la navigation vers l'écran de réinitialisation
        });

        signupText.setOnClickListener(v -> {
            Toast.makeText(this, "Créer un nouveau compte", Toast.LENGTH_SHORT).show();
            // Ajouter la navigation vers l'écran d'inscription
        });
    }

    private void performLogin(String email, String password) {
        // Implémentez votre logique de connexion ici
        // Exemple : appel API, vérification en base de données, etc.

        // Pour l'exemple, on simule une connexion réussie
        if (email.equals("test@example.com") && password.equals("password")) {
            Toast.makeText(this, "Connexion réussie!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
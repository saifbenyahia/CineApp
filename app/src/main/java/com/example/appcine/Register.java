package com.example.appcine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    private TextInputEditText fullNameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText confirmPasswordEditText;
    private MaterialCheckBox termsCheckbox;
    private MaterialButton registerButton;
    private TextView termsText;
    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        fullNameEditText = findViewById(R.id.fullNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        termsCheckbox = findViewById(R.id.termsCheckbox);
        registerButton = findViewById(R.id.registerButton);
        termsText = findViewById(R.id.termsText);
        loginText = findViewById(R.id.loginText);
    }

    private void setupClickListeners() {
        registerButton.setOnClickListener(v -> {
            String fullName = fullNameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            if (validateInput(fullName, email, password, confirmPassword)) {
                performRegistration(fullName, email, password);
            }
        });

        termsText.setOnClickListener(v -> {
            Toast.makeText(this, "Conditions d'utilisation", Toast.LENGTH_SHORT).show();
            // Navigation vers les conditions d'utilisation
        });

        loginText.setOnClickListener(v -> {
            // Retour à la page de login
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean validateInput(String fullName, String email, String password, String confirmPassword) {
        if (fullName.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir votre nom complet", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir votre email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir un mot de passe", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!termsCheckbox.isChecked()) {
            Toast.makeText(this, "Veuillez accepter les conditions d'utilisation", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void performRegistration(String fullName, String email, String password) {
        // Implémentez votre logique d'inscription ici
        // Exemple : appel API, création de compte en base de données, etc.

        // Simulation d'inscription réussie
        Toast.makeText(this, "Inscription réussie!", Toast.LENGTH_SHORT).show();

        // Redirection vers la page de login
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
package com.example.signup

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declare variables for your views
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var termsCheckBox: CheckBox
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize your views
        nameEditText = findViewById(R.id.name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text)
        termsCheckBox = findViewById(R.id.checkbox_terms)
        signUpButton = findViewById(R.id.buttonbg)

        // Initially hide the Sign Up button
        signUpButton.isEnabled = false
        signUpButton.alpha = 0.5f  // Make it look disabled

        // Set up listeners to check inputs and enable the Sign Up button
        nameEditText.setOnKeyListener { _, _, _ ->
            updateSignUpButtonState()
            false // Return false to indicate the event is not consumed
        }
        emailEditText.setOnKeyListener { _, _, _ ->
            updateSignUpButtonState()
            false // Return false to indicate the event is not consumed
        }
        passwordEditText.setOnKeyListener { _, _, _ ->
            updateSignUpButtonState()
            false // Return false to indicate the event is not consumed
        }
        confirmPasswordEditText.setOnKeyListener { _, _, _ ->
            updateSignUpButtonState()
            false // Return false to indicate the event is not consumed
        }

        termsCheckBox.setOnCheckedChangeListener { _, _ -> updateSignUpButtonState() }

        // Set a click listener for the sign-up button
        signUpButton.setOnClickListener {
            if (validateInputs()) {
                // Handle sign-up logic here
                Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up WindowInsets for edge-to-edge experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Function to validate inputs
    private fun validateInputs(): Boolean {
        if (nameEditText.text.isEmpty()) {
            nameEditText.error = "Name is required"
            return false
        }
        if (emailEditText.text.isEmpty()) {
            emailEditText.error = "Email is required"
            return false
        }
        if (passwordEditText.text.isEmpty()) {
            passwordEditText.error = "Password is required"
            return false
        }
        if (confirmPasswordEditText.text.isEmpty()) {
            confirmPasswordEditText.error = "Confirm Password is required"
            return false
        }
        if (passwordEditText.text.toString() != confirmPasswordEditText.text.toString()) {
            confirmPasswordEditText.error = "Passwords do not match"
            return false
        }
        if (!termsCheckBox.isChecked) {
            Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Function to update the Sign Up button state
    private fun updateSignUpButtonState() {
        val isAllFilled = nameEditText.text.isNotEmpty() &&
                emailEditText.text.isNotEmpty() &&
                passwordEditText.text.isNotEmpty() &&
                confirmPasswordEditText.text.isNotEmpty()

        // Enable the Sign Up button only if all fields are filled and terms are accepted
        signUpButton.isEnabled = isAllFilled && termsCheckBox.isChecked
        signUpButton.alpha = if (signUpButton.isEnabled) 1f else 0.5f // Change opacity based on state
    }
}

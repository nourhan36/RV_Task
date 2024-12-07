package com.example.rv_task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rv_task.Constants.Companion.USERNAME_KEY
import com.example.rv_task.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            val isUsernameValid = validateUsername(username)
            val isPasswordValid = validatePasswordInput(password)

            if (isUsernameValid && isPasswordValid) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(USERNAME_KEY, username)
                startActivity(intent)
                finish()
            }

        }
    }

    private fun validateUsername(username: String): Boolean {
        return if (username.isEmpty()) {
            showError(binding.etUsername, binding.tvUsernameError, "Username is required")
            false
        } else {
            hideError(binding.etUsername, binding.tvUsernameError)
            true
        }
    }

    private fun validatePasswordInput(password: String): Boolean {
        return when {
            password.isEmpty() -> {
                showError(binding.etPassword, binding.tvPasswordError, "Password is required")
                false
            }

            !isValidPassword(password) -> {
                showError(
                    binding.etPassword,
                    binding.tvPasswordError,
                    "Password must have 8+ chars, letters & numbers"
                )
                false
            }

            else -> {
                hideError(binding.etPassword, binding.tvPasswordError)
                true
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d).{8,}$")
        return passwordRegex.matches(password)
    }

    private fun showError(input: View, errorView: View, errorMessage: String) {
        input.setBackgroundResource(R.drawable.rounded_edittext_error)
        if (errorView is TextView) {
            errorView.text = errorMessage
            errorView.visibility = View.VISIBLE
        }
    }

    private fun hideError(input: View, errorView: View) {
        input.setBackgroundResource(R.drawable.rounded_et)
        errorView.visibility = View.GONE
    }
}

package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    ImageView buttonSwitch;
    Button buttonLogin;
    private boolean passwordIsShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findObject();
        initButtonLogin();

        buttonSwitch.setOnClickListener(this::onClick);

    }

    private void initButtonLogin() {
        editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextPassword.getText().toString().trim().isEmpty()) {
                    if (s.toString().isEmpty()) {
                        disableButtonLogin();
                    }
                } else {
                    if (s.toString().isEmpty()) {
                        disableButtonLogin();
                    } else {
                        enableButtonLogin();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextUsername.getText().toString().trim().isEmpty()) {
                    if (s.toString().isEmpty()) {
                        disableButtonLogin();
                    }
                } else {
                    if (s.toString().isEmpty()) {
                        disableButtonLogin();
                    } else {
                        enableButtonLogin();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void enableButtonLogin() {
        buttonLogin.setTextColor(this.getResources().getColor(R.color.white));
        buttonLogin.setBackground(this.getResources().getDrawable(R.drawable.button_login));
        buttonLogin.setEnabled(true);
    }

    private void disableButtonLogin() {
        buttonLogin.setTextColor(this.getResources().getColor(R.color.disabled_text));
        buttonLogin.setBackground(this.getResources().getDrawable(R.drawable.button_disable));
        buttonLogin.setEnabled(false);
    }

    private void findObject() {
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSwitch = findViewById(R.id.buttonSwitch);
        buttonLogin = findViewById(R.id.buttonLogin);
    }


    private void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSwitch:
                if (passwordIsShow){
                    hidePassword();
                } else {
                    showPassword();
                }
                break;
        }
    }

    private void showPassword() {
        buttonSwitch.setImageDrawable(this.getResources().getDrawable(R.drawable.seen_icon));
        ImageViewCompat.setImageTintList(buttonSwitch,getColorStateList(R.color.accent));
        editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        editTextPassword.setSelection(editTextPassword.getText().length());
        passwordIsShow = true;
    }

    private void hidePassword() {
        buttonSwitch.setImageDrawable(this.getResources().getDrawable(R.drawable.hide_icon));
        ImageViewCompat.setImageTintList(buttonSwitch,getColorStateList(R.color.disabled_color));
        editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editTextPassword.setSelection(editTextPassword.getText().length());
        passwordIsShow = false;
    }

}
package com.example.demologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText editText,editText2;
    Button button;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button20);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_email = editText.getText().toString();
                String text_pass = editText2.getText().toString();

                if(TextUtils.isEmpty(text_email) || TextUtils.isEmpty(text_pass) ){
                    Toast.makeText(SignUpActivity.this, "Please Enter Some Value", Toast.LENGTH_SHORT).show();
                }
                else if(text_pass.length()<6){
                    Toast.makeText(SignUpActivity.this, "Password must be atleast 6 characters", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser(text_email, text_pass);
                }
            }
        });
    }

    private void registerUser(String text_email, String text_pass) {
        auth.createUserWithEmailAndPassword(text_email, text_pass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "You have Registerd Succesfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, AboutActivity.class));
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {
    Button back;
    TextInputEditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        String gottenGreet = bundle.getString("message");
        TextView greetingFromMain = findViewById(R.id.textView);
        greetingFromMain.setText(gottenGreet);
        back = findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent toMainActivity = new Intent(SecondActivity.this, MainActivity.class);
                //startActivity(toMainActivity);
                inputName = findViewById(R.id.textInputEditText);
                String strName = String.valueOf(inputName.getText());
                Intent intent = new Intent();
                intent.putExtra("editTextValue", strName);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
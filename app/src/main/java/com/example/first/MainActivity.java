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

public class MainActivity extends AppCompatActivity {
    Button next;
    TextInputEditText greet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                greet = findViewById(R.id.textGreet);
                String strGreet = String.valueOf(greet.getText());
                toSecondActivity.putExtra("message",strGreet);
                startActivityForResult(toSecondActivity,1);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String Name = data.getStringExtra("editTextValue");
                TextView greetingFromMain = findViewById(R.id.nameTextView);
                greetingFromMain.setText(Name);
            }
        }
    }
}
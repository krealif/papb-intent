package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView jenisTxt, menuTxt;
    EditText jumlahInput;
    Button sendBtn;
    public static final String JUMLAH_KEY = "JUMLAH_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        jenisTxt = findViewById(R.id.jenis_txt);
        menuTxt = findViewById(R.id.menu_txt);
        jumlahInput = findViewById(R.id.jumlah_input);
        sendBtn = findViewById(R.id.send_btn);

        final Intent intent = getIntent();
        String jenis = intent.getStringExtra(MainActivity.JENIS_KEY);
        String menu = intent.getStringExtra(MainActivity.MENU_KEY);
        jenisTxt.setText(jenis);
        menuTxt.setText(menu);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String jumlah = jumlahInput.getText().toString();
                intent.putExtra(JUMLAH_KEY, jumlah);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
package com.example.activityintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText menuInput;
    Button makananBtn, minumanBtn;
    TextView jumlahTxt;
    public static final String MENU_KEY = "MENU_DATA";
    public static final String JENIS_KEY = "JENIS_DATA";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        String jumlah = result.getData().getStringExtra(SecondActivity.JUMLAH_KEY);
                        jumlahTxt.setText(jumlah);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuInput = findViewById(R.id.menu_input);
        makananBtn = findViewById(R.id.makanan_btn);
        minumanBtn = findViewById(R.id.minuman_btn);
        jumlahTxt = findViewById(R.id.jumlah_txt);

        makananBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMenu(view);
            }
        });

        minumanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMenu(view);
            }
        });

    }

    private void sendMenu(View view) {
        Intent intent;
        String jenis, menu;

        intent = new Intent(view.getContext(), SecondActivity.class);
        jenis = ((Button)view).getText().toString();
        menu = menuInput.getText().toString();
        intent.putExtra(JENIS_KEY, jenis);
        intent.putExtra(MENU_KEY, menu);
        launcher.launch(intent);


    }
}
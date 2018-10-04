package com.example.mili.share_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private final String SHARED_PREFERENCE = "MILI";
    private final String NAME="name";
    private final String PASS="password";
    private final String AGE="age";
    private final String SINGLE="is_single";
    private final String WEIGHT="weight";
    private final String TAG = getClass().getSimpleName();
    Button btnSave, btnLay, btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLay = findViewById(R.id.btnLay);
        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              add();
            }
        });

        btnLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lay();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(NAME);
                Lay();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove();
                Lay();
            }
        });
    }

    public void add(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        edit.putString(NAME,"Trần Thị Mi Li");
        edit.putInt(AGE,21);
        edit.putBoolean(SINGLE,false);
        edit.putLong(WEIGHT,48);

        edit.apply();
        Toast.makeText(MainActivity.this,"added",Toast.LENGTH_SHORT).show();
    }

    private void Lay(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME,"NULL");
        int age = sharedPreferences.getInt(AGE,20);
        boolean alon = sharedPreferences.getBoolean(SINGLE,false);
        long weight = sharedPreferences.getLong(WEIGHT,48);
        String adress = sharedPreferences.getString("ADRESS","Ho chi minh");

        Log.d(TAG,"MILI:" +name+ "\n" +age +"\n"+alon+"\n"+weight+"\n"+adress);

    }

    private void remove (String key){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    private void remove(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

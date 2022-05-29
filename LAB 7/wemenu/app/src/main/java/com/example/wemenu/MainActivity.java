package com.example.wemenu;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.eng:
                textView.setText("English");
                sharedPreferences.edit().putString("title","English").apply();
                return true;
            case R.id.Hindi:
                textView.setText("Hindi");
                sharedPreferences.edit().putString("title","Hindi").apply();
                return true;
            default:
                return true;

        }
    }
    //@Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_vs)
                .setTitle("BE CAUTIOUS")
                .setMessage("the road to success isn't always with hardships")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Hello invoked",Toast.LENGTH_SHORT).show();
                    }
                }).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.wemenu",0);
        String pref=sharedPreferences.getString("title","default");
        textView.setText(pref);


    }
}

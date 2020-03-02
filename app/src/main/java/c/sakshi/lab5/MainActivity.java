package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");

        if (!username.equals("")) {
            goToAct2(username);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void buttonClick (View view){

        EditText text = findViewById(R.id.editText);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        String str = text.getText().toString();
        sharedPreferences.edit().putString("username",str).apply();

        goToAct2(str);

    }

    public void goToAct2(String str){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }


}

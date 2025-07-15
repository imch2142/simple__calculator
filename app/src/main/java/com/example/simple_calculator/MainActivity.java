package com.example.simple_calculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.simple_calculator.R;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btn_add,btn_sub,btn_mul,btn_div,btn_mod;
    EditText editTextn1,editTextn2;
    TextView textView;
    int num1,num2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        btn_add =findViewById(R.id.button_add);
        btn_sub=findViewById(R.id.button_sub);
        btn_mul =findViewById(R.id.button_mul);
        btn_div =findViewById(R.id.button_div);
        btn_mod =findViewById(R.id.button_mod);

        editTextn1= findViewById(R.id.number1);
        editTextn2= findViewById(R.id.number2);
        textView=findViewById(R.id.anser);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_mod.setOnClickListener(this);




    }
    public int getIntFromEdittext( EditText editText){

        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter number ",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else
            return Integer.parseInt(editText.getText().toString());
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        num1 = getIntFromEdittext(editTextn1);
        num2 = getIntFromEdittext(editTextn2);

        if (v.getId()==R.id.button_add) {

            textView.setText("Answer = " + (num1 + num2));

        } else if (v.getId()==R.id.button_sub) {
            textView.setText("Answer = " + (num1 - num2));

        }
        else if (v.getId()==R.id.button_mul) {
            textView.setText("Answer = " + (num1 * num2));

        }
        else if (v.getId()==R.id.button_mod) {

            textView.setText("Answer = " + (num1 % num2));

        }
        else if (v.getId()==R.id.button_div) {
            if (num2==0)
                Toast.makeText(this, "Unknown button clicked", Toast.LENGTH_SHORT).show();
            else
                textView.setText("Answer = " + (num1 / num2));


        }else{
            Toast.makeText(this, "Unknown button clicked", Toast.LENGTH_SHORT).show();

        }
    }
}
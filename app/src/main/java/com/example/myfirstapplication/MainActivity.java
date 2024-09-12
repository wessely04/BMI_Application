package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText edtWeight,edtHeight,edtHeightInch;
        TextView result;
        Button btnCalculate;
        LinearLayout main;

        edtWeight=findViewById(R.id.weightEditText);
        edtHeight=findViewById(R.id.heightEditText);
        edtHeightInch=findViewById(R.id.heightInchesEditText);
        result=findViewById(R.id.result);
        btnCalculate=findViewById(R.id.CalculationBMI);
        main=findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         int weight=Integer.parseInt(edtWeight.getText().toString());
         int height=Integer.parseInt(edtHeight.getText().toString());
         int heightInches=Integer.parseInt(edtHeightInch.getText().toString());
               int  totalInches=height*12+heightInches;
               double totalCm=totalInches*2.53;
               double totalMetre=totalCm/100;
               double bmi=weight/(totalMetre*totalMetre);
               if(bmi>25) {
                   result.setText(R.string.you_re_over_weight);
                   main.setBackgroundColor(getResources().getColor(R.color.red));
               }
               else if(bmi<18){
                   result.setText("You're under weight");
                   main.setBackgroundColor(getResources().getColor(R.color.yellow));
               }
               else{
                   result.setText("You're Healthy");
                   main.setBackgroundColor(getResources().getColor(R.color.green));
               }

            }
        });
    }
}
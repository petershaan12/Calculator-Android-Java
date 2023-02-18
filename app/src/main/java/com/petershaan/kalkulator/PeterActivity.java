package com.petershaan.kalkulator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import androidx.appcompat.app.AppCompatActivity;

public final class PeterActivity extends AppCompatActivity {
    EditText psEditText;
    String psProcess;

    private Button psButton0, psButton1, psButton2, psButton3, psButton4, psButton5, psButton6, psButton7,
            psButton8, psButton9, psButtonAdd, psButtonMultiply, psButtonSubs, psButtonDivision, psButtonPoint, psButtonPercent,
            psButtonEqual, psButtonDelete, psButtonC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peter);

        //menaruh semua id ke variabel
        psEditText = findViewById(R.id.psEditText);
        psButton0 = findViewById(R.id.psBtn_0);
        psButton1 = findViewById(R.id.psBtn_1);
        psButton2 = findViewById(R.id.psBtn_2);
        psButton3 = findViewById(R.id.psBtn_3);
        psButton4 = findViewById(R.id.psBtn_4);
        psButton5 = findViewById(R.id.psBtn_5);
        psButton6 = findViewById(R.id.psBtn_6);
        psButton7 = findViewById(R.id.psBtn_7);
        psButton8 = findViewById(R.id.psBtn_8);
        psButton9 = findViewById(R.id.psBtn_9);
        psButtonAdd = findViewById(R.id.psBtnTambah);
        psButtonMultiply = findViewById(R.id.psBtnKali);
        psButtonDivision = findViewById(R.id.psBtnBagi);
        psButtonSubs = findViewById(R.id.psBtnKurang);
        psButtonPoint = findViewById(R.id.psBtnTitik);
        psButtonEqual = findViewById(R.id.psBtnHasil);
        psButtonPercent = findViewById(R.id.psBtnPersen);
        psButtonDelete = findViewById(R.id.psBtnDelete);
        psButtonC = findViewById(R.id.psBtnC);

        psButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psProcess.substring(0,psProcess.length()-1);
                psEditText.setText(psProcess);
            }
        });

        psButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psEditText.setText("");
            }
        });


        psButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "0");
            }
        });

        psButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "1");
            }
        });

        psButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "2");
            }
        });

        psButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "3");
            }
        });

        psButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "4");
            }
        });

        psButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "5");
            }
        });

        psButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "6");
            }
        });


        psButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "7");
            }
        });

        psButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "8");
            }
        });

        psButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "9");
            }
        });

        psButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "+");
            }
        });


        psButtonSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "-");
            }
        });

        psButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "×");
            }
        });

        psButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "÷");
            }
        });

        psButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + ".");
            }
        });

        psButtonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psEditText.setText(psProcess + "%");
            }
        });

        //Mengerjalkan semua perhitungan dengan library rhino
        psButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psProcess = psEditText.getText().toString();
                psProcess = psProcess.replaceAll("×","*");
                psProcess = psProcess.replaceAll("%","/100");
                psProcess = psProcess.replaceAll("÷","/");
                String finalResult = "";

                try {
                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,psProcess,"javascript",1,null).toString();
                    if(finalResult.endsWith(".0")){
                        finalResult = finalResult.replace(".0","");
                    }
                }catch (Exception e){
                    finalResult="0";
                }

                psEditText.setText(finalResult);
            }
        });

    }

}
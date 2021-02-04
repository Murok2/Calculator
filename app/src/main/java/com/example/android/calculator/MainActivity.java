package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    EditText obj1,obj2;
    Double num1, num2, answer;
    String answerStr, obj1Str, obj2Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getValue(){
        obj1=findViewById(R.id.editText);
        obj2=findViewById(R.id.editText2);

        obj1Str=obj1.getText().toString();
        obj2Str=obj2.getText().toString();
    }

    public void plusBtn(View view){
        getValue();
        if(obj2Str.isEmpty() || obj1Str.isEmpty()){
            emptyToast();
        }
        else {
            num1=Double.parseDouble(obj1Str);
            num2=Double.parseDouble(obj2Str);
            answer=num1+num2;
            answerStr=String.valueOf(answer);
            sendTonext();
        }

    }
    public void minusBtn (View view){
        getValue();
        if(obj2Str.isEmpty() || obj1Str.isEmpty()){
            emptyToast();
        }
        else {
            num1=Double.parseDouble(obj1Str);
            num2=Double.parseDouble(obj2Str);
            answer=num1-num2;
            answerStr=String.valueOf(answer);
            sendTonext();
        }

    }
    public void timesBtn(View view){
        getValue();
        if(obj2Str.isEmpty() || obj1Str.isEmpty()){
            emptyToast();
        }
        else {
            num1=Double.parseDouble(obj1Str);
            num2=Double.parseDouble(obj2Str);
            answer=num1*num2;
            answerStr=String.valueOf(answer);
            sendTonext();
        }
    }
    public void divideBtn(View view){
        getValue();
        if(!obj2Str.isEmpty()){
            num2=Double.parseDouble(obj2Str);

        }
        if(obj2Str.isEmpty() || obj1Str.isEmpty()){
            emptyToast();
        }
        else if(num2==0){
            zeroToast();

        }
        else {
            num1=Double.parseDouble(obj1Str);
            answer=num1/num2;
            answerStr=String.valueOf(answer);
            sendTonext();

        }
    }

    public void sendTonext(){
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("Answer", answerStr);
        startActivity(intent);

    }





    public void emptyToast(){
        Context context = getApplicationContext();
        CharSequence text = "Please first enter Number";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void zeroToast(){
        Context context = getApplicationContext();
        CharSequence text = "You can't divide by 0";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void clear(View view){
        getValue();
        obj1.setText("");
        obj2.setText("");
    }
}

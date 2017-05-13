package com.example.wxy.calculatethecopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int bs = 1;//抄写遍数
    int days = 3;//剩余天数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);//结果输出View
        TextView editText = (TextView) findViewById(R.id.edittext);//遍数输入View
        TextView editText1 = (TextView) findViewById(R.id.edittext1);//天数输入View
        Button button = (Button) findViewById(R.id.button);//确认按钮
        Button button_add = (Button) findViewById(R.id.button_add);//增加按钮
        Button button_less = (Button) findViewById(R.id.button_less);//减少按钮
        Button button_add1 = (Button) findViewById(R.id.button_add1);//增加按钮
        Button button_less1 = (Button) findViewById(R.id.button_less1);//减少按钮

        button_add.setOnClickListener(this);//增加逻辑计算
        button_less.setOnClickListener(this);//减少逻辑计算
        button_add1.setOnClickListener(this);//增加逻辑计算
        button_less1.setOnClickListener(this);//减少逻辑计算
        button.setOnClickListener(this);//确认逻辑计算
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.text);//结果输出View
        TextView editText = (TextView) findViewById(R.id.edittext);//遍数输入View
        TextView editText1 = (TextView) findViewById(R.id.edittext1);//天数输入View

        float zs;
        final int YB = 4000;//一遍的字数
        final int SP = 40;//每分钟抄写字数

        switch (v.getId()) {
            case R.id.button_add:
                bs ++;
                editText.setText(String.valueOf(bs));
                break;
            case R.id.button_less:
                if (bs > 1)
                    bs --;
                else
                    Toast.makeText(MainActivity.this, "已达到下限",
                            Toast.LENGTH_SHORT).show();
                editText.setText(String.valueOf(bs));
                break;
            case R.id.button_add1:
                days ++;
                editText1.setText(String.valueOf(days));
                break;
            case R.id.button_less1:
                if (days > 1)
                    days --;
                else
                    Toast.makeText(MainActivity.this, "已达到下限",
                            Toast.LENGTH_SHORT).show();
                editText1.setText(String.valueOf(days));
                break;
            case  R.id.button:
                zs = bs *YB;
                zs /= SP;
                zs /= 60;
                zs /= days;
                textView.setText("每天需要抄写约" + String.valueOf(zs) + "小时");
                break;
            default:
                break;
        }
    }
}

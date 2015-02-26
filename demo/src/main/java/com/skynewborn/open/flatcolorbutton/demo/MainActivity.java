package com.skynewborn.open.flatcolorbutton.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.skynewborn.open.flatcolorbutton.ColorButton;
import com.skynewborn.open.flatcolorbutton.ExtendedColorButton;


public class MainActivity extends ActionBarActivity {

    ColorButton mButton1;
    ExtendedColorButton mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (ColorButton) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof ColorButton) {
                    Toast.makeText(v.getContext(), ((ColorButton) v).getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        mButton2 = (ExtendedColorButton) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof ExtendedColorButton) {
                    Toast.makeText(v.getContext(), ((ExtendedColorButton) v).getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        final CheckBox cbEnable = (CheckBox) findViewById(R.id.cb_enable_buttons);
        cbEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mButton1.setEnabled(isChecked);
                mButton2.setEnabled(isChecked);
            }
        });
    }

}

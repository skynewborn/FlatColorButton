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
    ColorButton mButton3;

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CharSequence text = null;
            if (v instanceof ColorButton) {
                text = ((ColorButton) v).getText();
            } else if (v instanceof ExtendedColorButton) {
                text = ((ExtendedColorButton) v).getText();
            }
            if (text != null) {
                Toast.makeText(v.getContext(), text + " clicked", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (ColorButton) findViewById(R.id.button1);
        mButton1.setOnClickListener(mOnClickListener);
        mButton2 = (ExtendedColorButton) findViewById(R.id.button2);
        mButton2.setOnClickListener(mOnClickListener);
        mButton3 = (ColorButton) findViewById(R.id.button3);
        mButton3.setOnClickListener(mOnClickListener);

        final CheckBox cbEnable = (CheckBox) findViewById(R.id.cb_enable_buttons);
        cbEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mButton1.setEnabled(isChecked);
                mButton2.setEnabled(isChecked);
                mButton3.setEnabled(isChecked);
            }
        });
    }

}

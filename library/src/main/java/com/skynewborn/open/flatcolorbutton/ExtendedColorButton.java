/*
 * Copyright (C) 2014 skynewborn@github.com. All rights reserved.
 */
package com.skynewborn.open.flatcolorbutton;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Extended version of {@link ColorButton}.<br/>
 *
 * {@link ColorButton} extends from {@link android.widget.TextView}, so in some cases
 * when it is used with a compound drawable and centered gravity, the drawable's position
 * would be out of control. This class is intended to handle the dilemma mentioned above,
 * at the cost of adding an extra hierarchy to the widget's view tree.
 * 
 * @author skynewborn
 * @since 2015-1-13
 */
public class ExtendedColorButton extends LinearLayout implements IColorButton {
    
    private ColorDrawableBuilder mHelper = new ColorDrawableBuilder();
    private TextView mTextView;

    /**
     * @param context
     */
    public ExtendedColorButton(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ExtendedColorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ExtendedColorButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setGravity(Gravity.CENTER);
        mTextView = new TextView(getContext());
        mTextView.setGravity(Gravity.CENTER);
        addView(mTextView);
        
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ColorButton);
            
            mHelper.setBackgroundColor(a.getColor(R.styleable.ColorButton_colorDefault, Color.BLACK));
            mHelper.setFocusBackgroundColor(a.getColor(R.styleable.ColorButton_colorFocused, Color.TRANSPARENT));
            mHelper.setDisableBackgroundColor(a.getColor(R.styleable.ColorButton_colorDisabled, Color.TRANSPARENT));
            mHelper.setBorderColor(a.getColor(R.styleable.ColorButton_borderColor, Color.TRANSPARENT));
            mHelper.setDisableBorderColor(a.getColor(R.styleable.ColorButton_borderColorDisabled, Color.TRANSPARENT));
            mHelper.setBorderWidth(a.getDimensionPixelSize(R.styleable.ColorButton_borderWidth, 0));
            mHelper.setRadius(a.getDimension(R.styleable.ColorButton_radius, 0));
            
            CharSequence text = a.getText(R.styleable.ColorButton_android_text);
            if (text != null) {
                setText(text);
            }
            ColorStateList textColor = a.getColorStateList(R.styleable.ColorButton_android_textColor);
            if (textColor != null) {
                setTextColor(textColor);
            }
            int textSize = a.getDimensionPixelSize(R.styleable.ColorButton_android_textSize, 0);
            if (textSize != 0) {
                setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            Drawable left = a.getDrawable(R.styleable.ColorButton_android_drawableLeft);
            Drawable right = a.getDrawable(R.styleable.ColorButton_android_drawableRight);
            Drawable top = a.getDrawable(R.styleable.ColorButton_android_drawableTop);
            Drawable bottom = a.getDrawable(R.styleable.ColorButton_android_drawableBottom);
            mTextView.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
            int padding = a.getDimensionPixelSize(R.styleable.ColorButton_android_drawablePadding, 0);
            mTextView.setCompoundDrawablePadding(padding);
            
            a.recycle();
        }
        setupBackground();
    }

    private void setupBackground() {
        mHelper.setAsBackground(this);
    }

    public void setText(int resId) {
        mTextView.setText(resId);
    }
    
    public void setText(CharSequence text) {
        mTextView.setText(text);
    }
    
    public void setTextColor(int color) {
        mTextView.setTextColor(color);
    }
    
    public void setTextColor(ColorStateList colors) {
        mTextView.setTextColor(colors);
    }
    
    public void setTextSize(float size) {
        mTextView.setTextSize(size);
    }
    
    public void setTextSize(int unit, float size) {
        mTextView.setTextSize(unit, size);
    }
    
    public CharSequence getText() {
        return mTextView.getText();
    }

    @Override
    public void setDefaultColor(int color) {
        mHelper.setBackgroundColor(color);
        setupBackground();
    }

    @Override
    public void setFocusedColor(int color) {
        mHelper.setFocusBackgroundColor(color);
        setupBackground();
    }

    @Override
    public void setDisabledColor(int color) {
        mHelper.setDisableBackgroundColor(color);
        setupBackground();
    }

    @Override
    public void setBorderColor(int color) {
        mHelper.setBorderColor(color);
        setupBackground();
    }

    @Override
    public void setDisabledBorderColor(int color) {
        mHelper.setDisableBorderColor(color);
        setupBackground();
    }

    @Override
    public void setBorderWidth(int width) {
        mHelper.setBorderWidth(width);
        setupBackground();
    }

    @Override
    public void setRadius(int radius) {
        mHelper.setRadius(radius);
        setupBackground();
    }
}

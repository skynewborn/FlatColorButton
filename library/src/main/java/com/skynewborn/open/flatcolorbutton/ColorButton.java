/*
 * Copyright (C) 2014 skynewborn@github.com. All rights reserved.
 */
package com.skynewborn.open.flatcolorbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * A flat, pure color style button widget. Various attributes are supported, including
 * normal/pressed/disabled color, border size & color, corner size, etc.
 * 
 * @author skynewborn
 * @since 2014-8-26
 */
public class ColorButton extends TextView implements IColorButton {
    
    private ColorDrawableBuilder mHelper = new ColorDrawableBuilder();

    /**
     * @param context
     */
    public ColorButton(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ColorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public ColorButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ColorButton);
            mHelper.setBackgroundColor(a.getColor(R.styleable.ColorButton_colorDefault, Color.BLACK));
            mHelper.setFocusBackgroundColor(a.getColor(R.styleable.ColorButton_colorFocused, Color.TRANSPARENT));
            mHelper.setDisableBackgroundColor(a.getColor(R.styleable.ColorButton_colorDisabled, Color.TRANSPARENT));
            mHelper.setBorderColor(a.getColor(R.styleable.ColorButton_borderColor, Color.TRANSPARENT));
            mHelper.setDisableBorderColor(a.getColor(R.styleable.ColorButton_borderColorDisabled, Color.TRANSPARENT));
            mHelper.setBorderWidth(a.getDimensionPixelSize(R.styleable.ColorButton_borderWidth, 0));
            mHelper.setRadius(a.getDimension(R.styleable.ColorButton_radius, 0));
            a.recycle();
        }
        setupBackground();
    }

    private void setupBackground() {
        mHelper.setAsBackground(this);
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

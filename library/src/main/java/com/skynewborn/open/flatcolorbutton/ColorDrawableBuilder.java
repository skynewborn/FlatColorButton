/*
 * Copyright (C) 2014 skynewborn@github.com. All rights reserved.
 */
package com.skynewborn.open.flatcolorbutton;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;

/**
 * Helper class for creating color drawable with states, border, radius, etc.
 * 
 * @author skynewborn
 * @since 2014-12-17
 */
public class ColorDrawableBuilder {
    private static final int[] STATE_PRESSED = {
        android.R.attr.state_enabled,
        android.R.attr.state_pressed
    };
    private static final int[] STATE_FOCUSED = {
        android.R.attr.state_enabled,
        android.R.attr.state_focused
    };
    private static final int[] STATE_NORMAL = {
        android.R.attr.state_enabled,
    };
    private static final int[] STATE_DISABLED = {
        -android.R.attr.state_enabled,
    };

    // Background attributes
    private int mDefaultBackgroundColor = Color.BLACK;
    private int mFocusBackgroundColor = 0;
    private int mDisableBackgroundColor = 0;
    // Border attributes
    private int mBorderColor = Color.TRANSPARENT;
    private int mDisableBorderColor = Color.TRANSPARENT;
    private int mBorderWidth = 0;
    // Radius attributes
    private float mRadius = 0f;
    
    public ColorDrawableBuilder() {
    }

    public ColorDrawableBuilder setBackgroundColor(int color) {
        mDefaultBackgroundColor = color;
        return this;
    }

    public ColorDrawableBuilder setFocusBackgroundColor(int color) {
        mFocusBackgroundColor = color;
        return this;
    }
    
    public ColorDrawableBuilder setDisableBackgroundColor(int color) {
        mDisableBackgroundColor = color;
        return this;
    }

    public ColorDrawableBuilder setBorderColor(int color) {
        mBorderColor = color;
        return this;
    }
    
    public ColorDrawableBuilder setDisableBorderColor(int color) {
        mDisableBorderColor = color;
        return this;
    }

    public ColorDrawableBuilder setBorderWidth(int width) {
        mBorderWidth = width;
        return this;
    }

    public ColorDrawableBuilder setRadius(float radius) {
        mRadius = radius;
        return this;
    }
    
    private Drawable getDrawableForState(int color, boolean enabled) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(mRadius);
        drawable.setColor(color);
        if (!enabled && mDisableBorderColor != 0) {
            drawable.setStroke(mBorderWidth, mDisableBorderColor);
        } else if (mBorderColor != 0) {
            drawable.setStroke(mBorderWidth, mBorderColor);
        }
        return drawable;
    }

    public Drawable build() {
        // Default Drawable
        Drawable normal = getDrawableForState(mDefaultBackgroundColor, true);

        StateListDrawable states = new StateListDrawable();

        if (mFocusBackgroundColor != 0) {
            // Focus/Pressed Drawable
            Drawable focused = getDrawableForState(mFocusBackgroundColor, true);
            states.addState(STATE_PRESSED, focused);
            states.addState(STATE_FOCUSED, focused);
        }
        states.addState(STATE_NORMAL, normal);
        if (mDisableBackgroundColor != 0 || mDisableBorderColor != 0) {
            Drawable disabled = getDrawableForState(mDisableBackgroundColor, false);
            states.addState(STATE_DISABLED, disabled);
        } else {
            states.addState(new int[] {}, normal);
        }
        
        return states;
    }

    /**
     * Set the drawable created by this helper as a view's background.
     * @param view
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public void setAsBackground(View view) {
        if (view != null) {
            Drawable d = build();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(d);
            } else {
                view.setBackgroundDrawable(d);
            }
        }
    }
}

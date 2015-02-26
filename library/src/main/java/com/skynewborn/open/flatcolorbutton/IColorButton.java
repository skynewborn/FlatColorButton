/*
 * Copyright (C) 2014 skynewborn@github.com. All rights reserved.
 */
package com.skynewborn.open.flatcolorbutton;

/**
 * Interface for flat color button's common methods.
 * @author skynewborn
 * @since 2015-02-18
 */
interface IColorButton {
    /**
     * Set the button's background color in normal/default state.
     * @param color
     */
    public void setDefaultColor(int color);

    /**
     * Set the button's background color in focused/pressed state.
     * @param color
     */
    public void setFocusedColor(int color);

    /**
     * Set the button's background color in disabled state.
     * @param color
     */
    public void setDisabledColor(int color);

    /**
     * Set the button's border color in normal/default state.
     * @param color
     */
    public void setBorderColor(int color);

    /**
     * Set the button's border color in normal/default state.
     * @param color
     */
    public void setDisabledBorderColor(int color);

    /**
     * Set the button's border width. Default is 0, meaning no border.
     * @param width
     */
    public void setBorderWidth(int width);

    /**
     * Set the button's corner radius. Default is 0.
     * @param radius
     */
    public void setRadius(int radius);
}

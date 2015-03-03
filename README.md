FlatColorButton
==================
[![Build Status](https://travis-ci.org/skynewborn/FlatColorButton.svg?branch=master)](https://travis-ci.org/skynewborn/FlatColorButton)

FlatColorButton is a library which simplifies the creation and use of flat-designed button widgets with pure color as the background.

![Example Image][1]

Browse the [source code of demo application][2] for an example to start with.

Including in your project
-------------------------

//TODO upload to maven central
    
Just import the library's code as an Android Library module (in Android Studio), and add it as a dependency to your project.


Usage
-----

Using the library is quite simple. All you need to do is to add a widget to the layout XML file:

	<com.skynewborn.open.flatcolorbutton.ColorButton
		android:id="@+id/button1"
		android:text="Color Button"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:padding="10dip"
		android:textColor="#fff"
		android:textSize="20sp"
		lib:colorDefault="#009688"
		lib:colorFocused="#00796b"
		lib:colorDisabled="#b6b6b6"
		lib:borderWidth="1dip"
		lib:borderColor="#8bc34a"
		lib:borderColorDisabled="#727272"
		lib:radius="3dip"/>

where `lib` prefix should be defined as `xmlns:lib="http://schemas.android.com/apk/res-auto"`. Then you can use it just like a button in your Activity, Fragment, custom views, etc.

Two types of widget are provided in this library: `ColorButton` and `ExtendedColorButton`.

`ColorButton` is extended from `TextView`, which is powerful enough in most cases; However, in certain cases, for example, if you need to show an icon to the left of a button's text, with a fixed distance, a `TextView` won't do when the button's `layout_width` is set to `match_parent`.

`ExtendedColorButton` is provided to satisfy the needs of those "certain cases" mentioned above: it wraps a `TextView` with a `FrameLayout`, making it possible to center the whole icon and text, at the cost of adding an extra layer to the view hierarchy. `ExtendedColorButton` is designed as a drop-in replacement of the `ColorButton`, so the most commonly used APIs and XML attributes are identical.

See the [source code of demo application][2] for a complete overview of the features supported by the library.

Known Issues
------------

N/A.

If you encounter any issue while using the library, please fire an issue report.

Acknowledge
-----------
[FancyButtons][3] by El Mehdi Sakout for the inspiration of building a StateListDrawable in code.

License
-----------

    Copyright 2015 skynewborn@github.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




 [1]: https://raw.github.com/skynewborn/FlatColorButton/master/art/readme.png
 [2]: https://github.com/skynewborn/FlatColorButton/tree/master/demo
 [3]: https://github.com/medyo/fancybuttons

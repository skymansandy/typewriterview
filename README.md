# TypeWriterView

[ ![Download](https://api.bintray.com/packages/skymansandy/Test/typewriterview/images/download.svg) ](https://bintray.com/skymansandy/Test/typewriterview/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FloatingLabelEditText-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6727)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![MinSDK](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/james602152002/FloatingLabelEditText.svg)](https://jitpack.io/#james602152002/FloatingLabelEditText)
[![Build Status](https://travis-ci.org/james602152002/FloatingLabelEditText.svg?branch=master)](https://travis-ci.org/james602152002/FloatingLabelEditText)
[![codecov](https://codecov.io/gh/james602152002/FloatingLabelEditText/branch/master/graph/badge.svg)](https://codecov.io/gh/james602152002/FloatingLabelEditText)

A simple Android library for typewriter like effects

## Features:

 - Animate contents of textview as if it were typed by a TypeWriter
 - Set Animation Text appearance duration
 - Set TypeWriter sound effect (With or without sound)
 - Set all the usual attributes of TextView and style your view.
 
## Demonstration
 
 |Demo TypeWriterView|
 |:---:|
 |![](../art/demoTypeWriterView.gif)|
 
# Usage
## Dependency:
 
 ```
 dependencies {
   compile 'in.codeshuffle:typewriterview:1.0.5'
 }
 ```
 
 ## Property
 ```xml
 <in.codeshuffle.typewriterview.TypeWriterView
        android:id="@+id/typeWriterView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:textStyle="bold" />           
 ```
 
 ## Method
 ```java
 public void setting(){
    //set focus status color
    setHighlightColor(int color);
    //set divider color when you are not in focus status
    setDivider_color(int divider_color);
    //set error status color
    setError_color(int error_color);
    //set label text and hint
    setLabel(CharSequence hint);
    //set thickness of divider
    setThickness(int thickness);
    //set label horizontal and vertical margin
    setLabelMargins(int horizontal_margin, int vertical_margin);
    //ser error text horizontal margin
    setErrorMargin(int horizontal_margin);
    //set divider vertical margin
    setDivider_vertical_margin(int divider_vertical_margin);
    //set floating label text size
    setLabel_text_size(float label_text_size);
    //set error text size
    setError_text_size(float error_text_size);
    //set floating label animation duration(unit：ms)
    setAnimDuration(int ANIM_DURATION);
    //set error sliding text animation duration(unit：ms)
    setErrorAnimDuration(int ERROR_ANIM_DURATION);
    //enable error mode
    setError_enabled();
    //disable error mode
    setError_disabled();
    //enable multiline mode(default disabled)
    setMultiline_mode(boolean enable);
    //enable clear button mode(default disabled)
    enableClearBtn(boolean enable);
    //set clear button size
    setClear_btn_size(int clear_btn_size);
    //set clear button color
    setClear_btn_color(int clear_btn_color);
    //set clear button horizontal margin
    setClear_btn_horizontal_margin(int clear_btn_horizontal_margin);
    //customize your clear button by ttf
    customizeClearBtn(Typeface typeface, String uni_code, int color, int clear_btn_size);
    //customize png or VectorDrawable clear button
    customizeClearBtn(int drawableId, int clear_btn_width);
    //Even your edit text doesn't have focus, your clear button still show at right.
    showClearButtonWithoutFocus();
    //display your current and max text length(default invisible)
    showMaxTextLength(boolean show);
    //set text length display color(default highlight_color)
    setText_length_display_color(int text_length_display_color);
    //set error below
    setError(CharSequence error);
 }
 
 ```
 ## Validation Mode Usage
  ```java
     public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     
         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             //Init your floating label edit text.
             FloatingLabelEditText label = findViewById(R.id.label);
             //set error message and your regex.
             label.addValidator(new RegexValidator("long error hint", "\\d+"));
             label.addValidator(new RegexValidator("You input letters.", "[A-Za-z]+$"));
         }
    }
     
  ```
  
  ```
     In validation mode, FloatingLabelEditText will check your regex by TextWatcher.
     When your input matches, this widget will show error message below.
  ```
 
 ## Proguard
 
 You don't need use proguard at all.
 
 ## Donate
 
 If you like this widget, you could praise me some protein powder below lol
 
 ## Note
 
 ```
 - The function animateText() when called multiple times on same view, is tweaked to display all the strings concatenated. Use with care, Synchronously.
 - Music effect of typewriter doesn't stop if app is minimized while text is being animated.
 ```
 
 License
 -------
 
     Copyright 2018 SkyManSandy
 
     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.

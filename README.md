# TypeWriterView

[ ![Download](https://api.bintray.com/packages/skymansandy/Test/typewriterview/images/download.svg) ](https://bintray.com/skymansandy/Test/typewriterview/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FloatingLabelEditText-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6727)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![MinSDK](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/james602152002/FloatingLabelEditText.svg)](https://jitpack.io/#james602152002/FloatingLabelEditText)
[![Build Status](https://travis-ci.org/james602152002/FloatingLabelEditText.svg?branch=master)](https://travis-ci.org/james602152002/FloatingLabelEditText)
[![codecov](https://codecov.io/gh/james602152002/FloatingLabelEditText/branch/master/graph/badge.svg)](https://codecov.io/gh/james602152002/FloatingLabelEditText)

Android library for typewriter like effects

## Feature:

 - Set text size by code. (Include floating label, hint text, and error text)
 - Set color of hint, divider and error status by code.
 - Customize your clear button by code.
 - Support sliding text when error text length too long.
 - Ellipsize when floating label text length too long.
 - You can set floating label text by ForegroundColorSpan.
 
# Usage
## Dependency:
 
 ```
 allprojects {
 	repositories {
 		...
 		maven { url 'https://jitpack.io' }
 	}
 }
 ```
 
 ```
 dependencies {
 	compile 'com.github.james602152002:FloatingLabelEditText:1.3.1'
 }
 ```
 
 ## Property
 ```xml
 <com.james602152002.floatinglabeledittext.FloatingLabelEditText
           //set focus status color
           app:j_fle_colorHighlight="#0000FF" 
           //set divider color when you are not in focus status
           app:j_fle_colorDivider="#FF00FF"
           //set error status color
           app:j_fle_colorError="#0000FF"
           //set label text and hint
           app:j_fle_hint="label"
           //set thickness of divider
           app:j_fle_thickness="2dp"
           //set label horizontal margin
           app:j_fle_label_horizontal_margin="2dp"
           //set label vertical margin
           app:j_fle_label_vertical_margin="2dp"
           //ser error text horizontal margin
           app:j_fle_error_horizontal_margin="2dp"
           //set divider vertical margin
           app:j_fle_divider_vertical_margin="2dp"
           //set floating label text size
           app:j_fle_label_textSize="14sp"
           //set error text size
           app:j_fle_error_textSize="14sp"
           //set floating label animation duration(unit：ms)
           app:j_fle_float_anim_duration="800"
           //set error sliding text animation duration(unit：ms)
           app:j_fle_error_anim_duration="8000"
           //validate error mode disable(default enabled)
           app:j_fle_error_disable="true"
           //enable multiline mode(default disabled)
           app:j_fle_multiline_mode_enable="true"
           //enable clear button mode(default disabled)
           app:j_fle_enable_clear_btn="true"
           //set clear button size
           app:j_fle_clear_btn_size="10dp"
           //set clear button color
           app:j_fle_clear_btn_color="#FF0000"
           //set clear button horizontal margin
           app:j_fle_clear_btn_horizontal_margin="2dp"
           //set clear button drawable or vector drawable id
           app:j_fle_clear_btn_id = "@drawable/icon"
           //Even your edit text doesn't have focus, your clear button still show at right.(default invisible)
           app:j_fle_show_clear_btn_without_focus="true"
           //display your current and max text length(default invisible)
           app:j_fle_show_text_length="true"
           //set text length display color(default highlight_color)
           app:j_fle_text_length_display_color="#00FFFF"
           />
           
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
 
 |WeChat|AliPay|
 |:---:|:---:|
 |![](../art/weixin_green.jpg)|![](../art/zhifubao_blue.jpg)|
 
 ## Suggestion
 
 ```
 Floating label text length not allow longer than widget width.
 User need clear UI to know your widget's title and format, 
 so you need to abbreviate your label text.
 ```
 
 License
 -------
 
     Copyright 2018 james602152002
 
     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.

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
 
 ## XML Usage
 ```xml
 <in.codeshuffle.typewriterview.TypeWriterView
        android:id="@+id/typeWriterView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:textStyle="bold" />           
 ```
 
 ## Java Usage
 ```java
         //Create Object and refer to layout view
         TypeWriterView typeWriterView=(TypeWriterView)findViewById(R.id.typeWriterView);
         
         //Setting each character animation delay
         typeWriterView.setDelay(int);
         
         //Setting music effect On/Off
         typeWriterView.setWithMusic(boolean);
          
         //Animating Text
         typeWriterView.animateText(string);
         
         //Remove Animation. This is required to be called when you want to minimize the app while animation is going on. Call this in onPause() or onStop()
         typeWriterView.removeAnimation();
 ```  
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
<<<<<<< HEAD

=======
>>>>>>> b51ad052157eae24073eae9c573d0c677dc10299

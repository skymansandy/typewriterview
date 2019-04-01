# TypeWriterView

[ ![Download](https://api.bintray.com/packages/skymansandy/Test/typewriterview/images/download.svg) ](https://bintray.com/skymansandy/Test/typewriterview/_latestVersion)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![MinSDK](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![](https://jitpack.io/v/skymansandy/typewriterview.svg)](https://jitpack.io/#skymansandy/typewriterview)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TypeWriterView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6996)
[![Build Status](https://travis-ci.org/skymansandy/typewriterview.svg?branch=master)](https://travis-ci.org/skymansandy/typewriterview)

## A simple Android library for typewriter like effects


## Features:

 - Animate contents of textview as if it were typed by a TypeWriter
 - Set Animation Text appearance duration
 - Set TypeWriter sound effect (With or without sound)
 - Set Typing animation listeners (4 available)
 - Set all the usual attributes of TextView and style your view.
 
 
# Demonstration
|Demo TypeWriterView|
|:---:|
|![](art/demoTypeWriterView.gif)|

 
# Usage
## Dependency:
 
 ```
 dependencies {
      implementation 'in.codeshuffle:typewriterview:1.1.0'
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
 
 ### Listeners available
          
Implement the given interface and override these stuff:

```java

          //Implement this to your class
          yourClass extends someBaseClass implements TypeWriterListener
          
          //then listen to callbacks
          typeWriterView.setTypeWriterListener(this)
            
          //animation starts with animateText()
          onTypingStart(String text);
          
          //animation typed one character (for each character)
          onCharacterTyped(String text, int position);

          //Animation is removed using removeAnimation()
          onTypingRemoved(String text);
          
          //Animation ends printing entire text
          onTypingEnd(String text);
  ``` 
 
 ## Note
 ```
 - The function animateText() if called with another string when already an animation is going on, will have no effect!!
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

## Support on Beerpay
Hey dude! Help me out for a couple of :beers:!

[![Beerpay](https://beerpay.io/skymansandy/typewriterview/badge.svg?style=beer-square)](https://beerpay.io/skymansandy/typewriterview)  [![Beerpay](https://beerpay.io/skymansandy/typewriterview/make-wish.svg?style=flat-square)](https://beerpay.io/skymansandy/typewriterview?focus=wish)
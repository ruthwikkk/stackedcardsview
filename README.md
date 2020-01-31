# StackedCardsView#

StackedCardsView is an android library to create stacked cards like effect on normal ViewGroups.

![preview](https://github.com/ruthwikkk/stackedcardsview/blob/master/screenshot_1.jpg)

## Add to project ##
1. Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
``` 
2. Add the dependency:

```groovy
implementation 'com.github.ruthwikkk:stackedcardsview:{latest_version}'
```
  Find the latest version [here](https://github.com/ruthwikkk/stackedcardsview/releases)
   
    

 ## Usage##
 1. Add it to your layout:
 ```xml
  <com.ruthwikkk.widget.stackedcards.StackedCardsView
        android:layout_width="150dp"
        android:layout_height="120dp"
        android:padding="10dp"
        app:scv_scaleFactor="0.1"
        app:scv_cardRadius="8dp"
        app:scv_cardPosition="right">

    </com.ruthwikkk.widget.stackedcards.StackedCardsView>
```


# PlayAnimations
A demo of various animation in latest PlayGames app using the Transition framework of Android.

Minimum SDK>21. This is not a backport of Transition Framework. This demo works above Lollipop only.

http://blog.naman-dwivedi.in/transition-framework-android

[Google Play](https://play.google.com/store/apps/details?id=com.naman14.playanimations) | [Youtube](https://www.youtube.com/watch?v=qXtL5AhA3V0)

![alt tag](https://raw.githubusercontent.com/naman14/PlayAnimations/master/art/demo.gif)

#Usage
When launching another activity,specify the views where you want to  perform transition and pass it as a bundle. The launching activity and the launched activity should have common views to perform transition on that pair of views.

```java
 Intent intent=new Intent(mContext, DetailActivity.class);
 ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.getInstance(),   Pair.create((View) cover, "cover"));
 mContext.startActivity(intent,options.toBundle());
```
Specify the attribute android:transitionName="cover" in both the view of two activities.Transition framework will look for the views with same transitionName attribute and will apply the auto transition on them.

We will specify the transition in our theme. Add this attribute to your v21 theme
```xml
<item name="android:windowSharedElementEnterTransition">@transition/shared_element</item>
```

We will define our own custom Transition instead of the default Transition.
#####res/transition/shared_element.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- --A set of transitions on two views performed together <!-- -->
<transitionSet
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:transitionOrdering="together"
    android:duration="240">

    <transitionSet   >
    <!-- --A custom transition defined in PlayTransition class <!-- -->
        <transition
            class="com.naman14.playanimations.PlayTransition"/>
        <targets>
         <!-- --We are excluding the second view from the custom transition <!-- -->
            <target android:excludeId="@id/icon" /> />
        </targets>
        </transitionSet>
<!-- --We have left this one upto transition Framework <!-- -->
    <autoTransition/>

</transitionSet>
```

[PlayTransition.java](https://github.com/naman14/PlayAnimations/blob/master/app/src/main/java/com/naman14/playanimations/PlayTransition.java)

# License
>(c) 2015 Naman Dwivedi 

>PlayAnimations is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. 

>This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. 

>You should have received a copy of the GNU General Public License along with this app. If not, see <http://www.gnu.org/licenses/>. 

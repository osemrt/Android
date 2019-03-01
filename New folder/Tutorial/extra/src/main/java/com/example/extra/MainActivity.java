package com.example.extra;


/*

----------------------------------------------------------------------------------------------------
    ■ Activities
    1# every app has 1 main activity and other activities
    2# An app can start any Activity belonging to itself or other apps subject to certain conditions
    3# When a new Activity starts, the previous Activity is stopped mode after calling the onPause()
     and onStop(), it is added to a stack known as BackStack
----------------------------------------------------------------------------------------------------
    ■ A context allows us:
    to access an application all resources
    to interact with other application components by sending messages
    to access an application Environmental information
----------------------------------------------------------------------------------------------------
    ■ a xml file format:
    <?xml version="..." encoding="..."?>
    <file_type>
        .
        .
        .

    </file_type>
----------------------------------------------------------------------------------------------------
    ■ every app in android has three folders:
    1# Java files
    2# Resources
        .drawable -> images and other stuff
        .layout   -> appearance [xml files]
        .values   -> fixed things [xml files]
            .colors
            .strings
            .styles
        .others   -> your customized folders [xml files]

    3# Configuration Files

    Note: drawable is a common folder and is used by the devices has whatever its screen size is.

----------------------------------------------------------------------------------------------------
    ■ UI controls form View, Invisible containers that contain View are called ViewGroup
      eg. for ViewGroup can be all layouts
    ■ do not use pixels as units
----------------------------------------------------------------------------------------------------
    ■ xmlns:android="http://schemas.android.com/apk/res/android"
    When using prefixes in XML, a namespace for the prefix must be defined.
    The namespace can be defined by an xmlns attribute in the start tag of an element.
    Why are URLs in XML namespaces?
    It's just a convention. URIs (which is what they are, not really URLs) are a convenient
    and globally-familiar way of identifying resources. On the other hand, .NET-style identifiers
    are familiar and recognisable to, well, .NET developers - there's rather more to XML than .NET.
----------------------------------------------------------------------------------------------------
    ■ What is a callback method?
       Android OS calls certain methods on your Activity class to notify whether your app is running
       currently or not! Just like JVM calling public static void main
    ■ General guidelines
    1# Do not do heavy processing or network consuming operations when user is currently away from
       your app
    2# App should not crash when another app is started
    3# Do not lose the user's progress or session data
    .
    .
----------------------------------------------------------------------------------------------------
    ■ about logcat
    used for debugging purposes
    Print different messages to Logcat using android.util.Log class
    Logging uses a lot memory and cpu!
    You can log messages from real devices too

----------------------------------------------------------------------------------------------------
    ■ about orientation
    to keep your activity in a fix size, write it to activity properties inside of the manifest
    android:screenOrientation="..."
----------------------------------------------------------------------------------------------------
    ■ 5 ways to handle button click
    1# Activity Implementing OnClickListener
    2# With an inner class in the activity that implements onClickListener
    3# Using an interface variable
    4#
    5#
----------------------------------------------------------------------------------------------------
    ■ Activity save state
    Although you change the orientation of the app, the data is still there but we have said that
    the activity is destroyed by Android whenever you change the orientation of the activity, then
    how will these data be stored?

    Activity object is held in memory when app is paused or stopped unless system explicitly destroys
    it. The state of the activity is stored with a method called as onSaveInstanceState(), when you
    want to get the stored instance, you must onRestoreInstanceState() but all state is deleted
    whenever the activity goes to destroy(), in the other words, you cannot restore data!
    (You cannot restore state after a back button is pressed)

    there is a bundle parameter in the onCreate() method inside the onCreate method if you remember
    the same bundle is passed to your on restore instance state which means you can either use the
    onCreate method to get the data back or you can use the on restore instance state to get the data

    There are two types information, one is database information and other one is temporary!
    these two methods do not support the database information.
----------------------------------------------------------------------------------------------------
    ■ Bundles
    Bundles are generally used to pass data between activities, it is a mapping of string values
    to different parcelable types.

    You can pass the data with an intent:
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("key1", value1);
        intent.putExtra("key2", value2);

    You can receive the extras in a bundle:
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("key1");




----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------


 */

public class MainActivity {
}

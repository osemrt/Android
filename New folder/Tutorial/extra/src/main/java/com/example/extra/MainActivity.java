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
    ■ Screen size?
    Physical size measured along diagonal
    4 general size: small, normal, large, extra-large
    ■ Screen resolution?
    Number of pixels on the screen
    and do not work with screen resolution
    work only with screen size and screen density for cross device support
    ■ Scaled pixels?
    A virtual pixel scaled according to density and user font preference
    ■ Screen density?
    Number of pixels in an inch known as dpi(dots per inch)or ppi(pixels per inch)
    4 general densities: ldpi, mdpi, hdpi, xhdpi
    and every android device has a different density
    ■ Android User Interface Measurement Units
    mm -> based on physical screen size
    in -> based on physical screen size
    pt -> 1/72 of inch based on physical screen size
    dp -> based on 160 dpi screen and scaled appropriately for other devices
    sp -> for fonts based on user font preference
    px -> based on physical screen size
----------------------------------------------------------------------------------------------------
    ■ About UI terminology
    px = one physical dot on screen represents a pixel
    dp = density-independent pixels (pixel unit that is independent )
    sp = scaled pixel
    dpi = dots per inch
----------------------------------------------------------------------------------------------------
    ■ Fragments
    There are two ways that are either statically or dynamically to create a fragment.
    It has its own lifecycle. It can be added or removed while the activity runs.
    Statically: you add xml file before runtime!
    Dynamically: you add one or more activities to fragment in the runtime.

    Combine several fragments in a single Activity
    Reuse the same Fragment across several Activities
    Make better use of larger screen space on tablets
    Support different layouts on portrait and landscape modes

    Uses of fragments
    1) Flexible user interfaces across different screen sizes
    2) Fixed/Scrolling/Swipe tab displays
    3) Dialog boxes
    4) Action Bar customization with the list and tab modes


    Creating a fragment
    1) Extend Fragment class
    2) Provide appearance in XML/Java
    3) Override onCrateView to link the appearance
    4) Use the Fragment in XML/Java


              Activity         |      Fragment       |   onAttach() is called after Fragment is
    ===========================|=====================|   associated with its Activity gets a
     1)   onCrate()            |                     |   reference to the Activity object which
     2)                        |     onAttach()      |   can be used as Context.
     3)   onAttachFragment()   |                     |
     4)                        |     onCreate()      |   onCrate() do not use onCreate() to access
     5)                        |    onCrateView()    |   View hierarchy because Activity's onCreate()
     6)                        |  onActivityCrated() |   may/may not be finished. Crate background
     7)   onStart()            |                     |   threads here for long running operations
     8)                        |      onStart()      |
     9)   onResume()           |                     |   onCreateView() you are expected to return
    10)                        |     onResume()      |   a View hierarchy for your fragment

                                                         onActivityCreated() called after Activity
                                                         onCrate() has completed execution. Use this
                                                         method to access/modify UI elements.


              Activity         |      Fragment       |   onSaveInstanceState() use this to save
    ===========================|=====================|   information inside a Bundle object
     1)                        |      onPause()      |
     2)    onPause()           |                     |   onDestroyView called after the fragment
     3)                        |  onSaveInstance()   |   View hierarchy is no longer accessible
     4)  onSaveInstance()      |                     |
     5)                        |  onStop()           |
     6)    onStop()            |                     |
     7)                        |  onDestroyView()    |
     8)                        |  onDestroy()        |
     9)                        |  onDetach()         |
    10)     onDestroy()        |                     |


    onAttach

    onCrate

    onCreateView

    onStartActivity

    onStart

    onResume

    onPause

    onStop

    onDeployView

    onDeploy

    onDetach




    FragmentManager     -> Use method from Activity to get FragmentManager
    FragmentTransaction -> user beginTransaction() and add/remove/replace

    Every activity has its own FragmentManager accessible through getFragmentManger()
    It maintains references to all fragments inside the Activity.
    Use findFragmentById() or findFragmentByTag() to get reference to a particular fragment

    Activity back stack is managed by ActivityManager
    Fragment back stack is managed by FragmentManager

    You can use Fragments on older devices using a Support Library from 1.6 to 2.3

    Transaction types:
    -> Add
    -> Remove
    -> Replace
    -> Attach
    -> Detach
    -> Show
    -> Hide


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

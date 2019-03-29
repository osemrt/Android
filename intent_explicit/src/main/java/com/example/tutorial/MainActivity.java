package com.example.tutorial;

import android.content.Intent;

/**
 *  Use an intent to start a new Activity
 *  Intents are used to start services
 *  BroadcastReceiver is done through intents
 *
 *  there are people who respond to events right your battery goes low your airplane mode was turned on your network is unavailable all these kinds of
 *  notifications when your whenever your system generates notifications like that your broadcast receiver handles them but it doesn't mean that you can't generate
 *  notifications you can also create your own notifications and let broadcast receivers handle them for example you can say something like Facebook profile
 *  updated and the broadcast receiver can do something about it so here example there is a system notification that comes up saying the battery is
 *  slowly 50 percent remaining now that event is converted into an intent object with a specific action category and data and that is given to your package
 *  manager now what your package manager is going to do in case of broadcast receivers is that it's going to call every broadcast receiver whose intent
 *  filter matches the actions category and data that your intent has generated right that is the action category data on the left side which was generated
 *  inside your intent and the broadcast is even on the right side whose intent filter matches with it it's going to call every broadcast receiver like so
 *
 *  There are two types activities:
 *      >Implicit
 *      You do not know the activity name in that usage of the intent you want to call
 *      this type of intent only works within the same application.
 *
 *      >Explicit
 *      When you know the name of the activity you want to call
 *      for cross-application connectivity
 *
 *
 *  Way_1
 *  Intent intent = new Intent(Context context, Class class);
 *  startActivity(intent);
 *
 *  context = room service!
 *  1 - <class_name>.this;
 *  2 - this;
 *  3 - getApplicationContext(); (common)!
 *
 *  Way_2
 *  Intent intent = new Intent();
 *  intent.setClassName(String packageName, String className);
 *
 *
 */

public class MainActivity {

}

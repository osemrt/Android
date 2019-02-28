package com.example.intent2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.util.ArrayList;


/**
 *  Implicit Intent
 *
 *  Broadcast Receiver:
 *
 *  One or more <action> to indicate what actions can be handled by your component
 *  One or more <category> to indicate what grouping does your component support
 *  <data> to indicate what data can be handled by your component
 *
 *  for every application that you install,
 *  every app all the activities,
 *  what are they intent filters they have,
 *  what actions categories and data,
 *  they can handle this list is maintained by your package manager
 *
 *  when someone says that I have an intent with this action, this category, this data can you do something about this the package manager is going
 *  to take that intent it's going to compare it with the list of activities and the list of services it has and check the intent filter for each with this information
 *  and when it finds no-one it says no apps can perform this. action when it does find someone it's going to start that activity directly and and it when it finds
 *  more than one person who can handle that intent then it's going to go ahead and give you this list where it says complete action using A, B, C so this is what
 *  your intent resolution process is all about this process is actually called intent resolution in Android and this is only for activities and services broadcast
 *  receivers have a different way of dealing with the same thing.
 *
 *  there are two ways to set an action to any intent
 *  1 - Intent intent = new Intent(); intent.setAction(<action_name>);
 *  2 - Intent intent = new Intent(Intent.<action_name>);
 *
 *
 *
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMap(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:41.00853212, 28.81610"));
        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);
    }

    public void launchMarket(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.google.android.youtube"));
        Intent chooser = Intent.createChooser(intent, "Launch Market");
        startActivity(chooser);

    }
    public void sendMail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");
        String[] receivers = {"ozm6378@gmail.com", "osemrt@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, receivers);
        intent.putExtra(Intent.EXTRA_SUBJECT, "hi, this was sent from my app!");
        intent.putExtra(Intent.EXTRA_TEXT, "email message");

        Intent chooser = Intent.createChooser(intent, "Send Mail");
        startActivity(chooser);

    }

    //from drawable folder
    public void sendImage(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, "android.resource://com.example.intent2/" + R.drawable.ic_launcher_background);
        intent.putExtra(Intent.EXTRA_TEXT, "Hey I attached this image!");
        Intent chooser = Intent.createChooser(intent , "Attach Image");
        startActivity(chooser);
    }
    public void sendImages(View view){
        File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String[] listOfPictures = pictures.list();

        ArrayList<Uri> uris = new ArrayList<>();
        for(String picture : listOfPictures){
            uris.add(Uri.parse("file://" + pictures.toString() + "/" + picture));
        }

        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uris);
        Intent chooser = Intent.createChooser(intent, "Send Multiple Images");
        startActivity(intent);

    }
    public void runWithoutChooser(View view){
        //if you do not assign any chooser to your application, then it can crash
        // and it will directly go to the default application
        // use a chooser to prevent this, it asks the user that which application do you want to open




    }



}

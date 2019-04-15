package com.example.contact_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        Log.d("DB Count: ", Integer.toString(databaseHandler.getContactsCount()));

        Log.d("Insert: ", "Inserting...");
        // databaseHandler.addContact(new Contact("John", "12312312"));
        // databaseHandler.addContact(new Contact("Bread", "511512311"));
        // databaseHandler.addContact(new Contact("Megan", "738217387"));

        // Contact c = databaseHandler.getContact(11);
        // c.setName("osemrt");
        // databaseHandler.updateContact(c);

        // Contact c2 = databaseHandler.getContact(30);
        // databaseHandler.delete(c2);

        Log.d("Reading: ", "Reading all contacts...");
        List<Contact> contacts = databaseHandler.getAllContact();

        for (Contact contact : contacts)
            Log.d("Contact: ", contact.toString());

        Log.d("Contact: ", databaseHandler.getContact(43).toString());
        Log.d("DB Count: ", Integer.toString(databaseHandler.getContactsCount()));


    }
}

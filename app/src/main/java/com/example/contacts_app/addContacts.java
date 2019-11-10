package com.example.contacts_app;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class addContacts extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_contact);

    }

        public void addbutton (View v)
        {
            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            EditText efirst = (EditText)findViewById(R.id.Empty1);

            EditText pnum = (EditText)findViewById(R.id.empty3);
            EditText email = (EditText)findViewById(R.id.empty4);



            intent
                    .putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())

                    .putExtra(ContactsContract.Intents.Insert.PHONE,pnum.getText())

                    .putExtra(ContactsContract.Intents.Insert.NAME,efirst.getText() );

            startActivity(intent);
        }
    }

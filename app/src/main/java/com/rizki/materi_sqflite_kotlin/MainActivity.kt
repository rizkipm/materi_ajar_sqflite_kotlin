package com.rizki.materi_sqflite_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rizki.materi_sqflite_kotlin.helper.DBHelper
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {


    private lateinit var  addName : Button
    private lateinit var  printName : Button
    private lateinit var  enterAge : EditText
    private lateinit var  enterName : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        addName = findViewById(R.id.addName)
        printName = findViewById(R.id.printName)
        enterAge = findViewById(R.id.enterAge)
        enterName = findViewById(R.id.enterName)

        // below code is to add on click
        // listener to our add name button
        addName.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)

            // creating variables for values
            // in name and age edit texts
            val name = enterName.text.toString()
            val age = enterAge.text.toString()

            // calling method to add
            // name to our database
            db.addName(name, age)

            // Toast to message on the screen
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            enterName.text.clear()
            enterAge.text.clear()
        }

        // below code is to add on  click
        // listener to our print name button
        printName.setOnClickListener {

            // creating a DBHelper class
            // and passing context to it
            val db = DBHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
//            Attributes.Name(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
//            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
//
//            // moving our cursor to next
//            // position and appending values
//            while (cursor.moveToNext()) {
//                Attributes.Name(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
//                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
//            }

            // at last we close our cursor
            cursor.close()
        }

    }
}
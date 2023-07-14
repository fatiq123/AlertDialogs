package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    private lateinit var btnAlert1: Button
    private lateinit var btnAlert2: Button
    private lateinit var btnAlert3: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAlert1 = findViewById(R.id.btnAlert1)
        btnAlert2 = findViewById(R.id.btnAlert2)
        btnAlert3 = findViewById(R.id.btnAlert3)


        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr.Ali to your contact's list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _,_ ->
                Toast.makeText(this,"You added Mr.poop to your contact list",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ _,_ ->
                Toast.makeText(this,"You didn't add Mr.poop to your contact list",Toast.LENGTH_SHORT).show()
            }
            .create()


        btnAlert1.setOnClickListener {
            addContactDialog.show()
        }



        val options = arrayOf("First choice", "Second choice", "Third choice")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0){dialog, which ->
                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _,_ ->
                Toast.makeText(this,"You accepted the SingleChoiceDialog",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this,"You declined the SingleChoiceDialog",Toast.LENGTH_SHORT).show()
            }
            .create()

        btnAlert2.setOnClickListener {
            singleChoiceDialog.show()
        }




        // there is another way for .setMultiChoiceItems by philip lackner

        val option = arrayOf("Option 1", "Option 2", "Option 3", "Option 4")
        val checkedItems = booleanArrayOf(false, false, false, false)   // false means that no one is selected when app starts

        val multipleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose options")
            .setMultiChoiceItems(option, checkedItems) { dialog, which, isChecked ->
                checkedItems[which] = isChecked
            }
            .setPositiveButton("OK") { dialog, which ->
                // Handle OK button click
                // You can access the selected items using the `checkedItems` array
                for (i in checkedItems.indices) {
                    if (checkedItems[i]) {
                        val selectedOption = option[i]
                         // Do something with the selected option
                        Toast.makeText(this,"You selected the $selectedOption", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Handle Cancel button click
                Toast.makeText(this,"You canceled the MultipleChoiceDialog",Toast.LENGTH_SHORT).show()
             }
            .create()



        btnAlert3.setOnClickListener {
            multipleChoiceDialog.show()
        }
    }
}
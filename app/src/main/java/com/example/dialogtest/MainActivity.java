package com.example.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { DialogTest1(); } });
        button2.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { DialogTest2(); } });
        button3.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { DialogTest3(); } });
    }

    private void DialogTest1() {
        // Instantiate
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set characteristics
        builder.setMessage(R.string.Message)
                .setTitle(R.string.Title);

        builder.setPositiveButton(R.string.Positive, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // OK button was clicked
            }
        });
        builder.setNegativeButton(R.string.Negative, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Cancel button was clicked
            }
        });
        // Get AlertDialog
        AlertDialog dialog = builder.create();

        // Show dialog
        dialog.show();
    }

    private void DialogTest2() {
        // Instantiate
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set characteristics
        builder.setMessage(R.string.Message)
                .setTitle(R.string.Title);

        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Yes button was clicked
            }
        });
        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // No button was clicked
            }
        });
        // Get AlertDialog
        AlertDialog dialog = builder.create();

        // Show dialog
        dialog.show();
    }

    private void DialogTest3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.Title);
        builder.setNegativeButton(R.string.Negative, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, "You selected Cancel", Toast.LENGTH_SHORT).show();
           }
        });
        final String dialog_options[] = { "Apple", "Orange", "Banana", "Pear" };
        builder.setItems(dialog_options, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which ==1){
                    Toast.makeText(MainActivity.this, "You selected 1" , Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "You selected " + dialog_options[which], Toast.LENGTH_SHORT).show();
                }
            }
        });
       AlertDialog dialog = builder.create();
       dialog.show();
    }

}
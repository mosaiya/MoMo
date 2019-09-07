package com.example.momo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Loginmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginnButton = findViewById(R.id.Loginbutton);
        loginnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailEditText = findViewById(R.id.email);
                EditText passwordEditText = findViewById(R.id.password);
                CheckBox rememberPasswordCheckbox = findViewById(R.id.checkpass);

                rememberPasswordCheckbox.isChecked();

                String inputemail = emailEditText.getText().toString();
                int value ;
                try {
                   value= Integer.parseInt(inputemail);
                }catch (Exception e){
                    value=-1;
                }

                String inputpassword = passwordEditText.getText().toString();

                Auth auth = new Auth(inputemail, inputpassword);
                boolean result = auth.check();
                if (result) {
                    if (rememberPasswordCheckbox.isChecked()) {
                        Toast.makeText(Loginmain.this, "คุณเลือกจำรหัสผ่าน", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Loginmain.this, "คุณไม่จำรหัสผ่าน", Toast.LENGTH_SHORT).show();
                    }
                          Toast.makeText(Loginmain.this,R.string.loginS, Toast.LENGTH_SHORT).show();

                } else {
                    new AlertDialog.Builder(Loginmain.this)
                            .setTitle("Error")
                            .setMessage("Invalid email or password")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();
                }

            }
        });
    }
}

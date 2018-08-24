package com.durga.balaji66.validationforbothemailandphone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String regexStr = "^[0-9]*$";
    private EditText mUsername;
    private Button mValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();

    }

    public void initializeViews() {
        mUsername = (EditText) findViewById(R.id.editText);
        mValidate = (Button) findViewById(R.id.button);
    }

    public void initializeListeners() {
        mValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                /**
                 * Here we are checking entered text is email or phone number
                 */
                if (mUsername.getText().toString().trim().matches(regexStr)) {
                    if (mUsername.getText().toString().length() == 10) {
                        Toast.makeText(getApplicationContext(), "Valid Mobile Number", Toast.LENGTH_LONG).show();
                    } else if (mUsername.getText().toString().length() > 10) {
                        Toast.makeText(getApplicationContext(), "You entered more than 10 digit", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "You entered less than 10 digits", Toast.LENGTH_LONG).show();
                    }
                } else {
                    CharSequence email = mUsername.getText().toString();
                    /**
                     * Here we are checking entered mail is valid or not
                     */
                    if (isValidEmail(email)) {
                        String last = (String) email;
                        last = last.substring(last.length() - 4);
                        if (!last.equals(".com")) {
                            Toast.makeText(getApplicationContext(), "InValid Email ", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Valid Email ", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "InValid Email ", Toast.LENGTH_LONG).show();
                    }

                }

                break;
        }
    }

    /**
     * Here we are checking Correct email format or not
     *
     * @param target
     * @return
     */
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}

package com.example.intensproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    private EditText mReply;
    private Button btnKirimSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        // Retrieve the message from the intent using the EXTRA_MESSAGE key
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        // Find the TextView by its ID
        TextView textView = findViewById(R.id.text_message);

        // Set the text of the TextView to the retrieved message
        textView.setText(message);

        mReply = findViewById(R.id.editText_second);
        btnKirimSecond = findViewById(R.id.button_second);

        btnKirimSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = mReply.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}
package com.software.rmh.noted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputScreen extends AppCompatActivity {

	EditText editText;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_screen);

		editText = (EditText) findViewById(R.id.userInput);
		editText.requestFocus();

		button = (Button) findViewById(R.id.enterNoteButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String input = editText.getText().toString();
				Note note = new Note(input);
			}
		});
	}
}

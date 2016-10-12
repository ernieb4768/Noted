package com.software.rmh.noted;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private FloatingActionButton fab;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.placeholder, new RecyclerFragment(), "Recycler");
		ft.commit();


		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.placeholder, new InputFragment(), "Input");
				ft.commit();
			}
		});
	}

	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public static class InputFragment extends Fragment {

		private View rootView;
		private EditText editText;
		private Button button;

		public InputFragment(){

		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			super.onCreateView(inflater, container, savedInstanceState);
			rootView = inflater.inflate(R.layout.activity_input_screen, container, false);

			editText = (EditText) rootView.findViewById(R.id.userInput);
			button = (Button) rootView.findViewById(R.id.enterNoteButton);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Toast.makeText(getActivity().getApplicationContext(), "Note added! " + getUserInput(), Toast.LENGTH_SHORT).show();
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.placeholder, RecyclerFragment.newInstance(getUserInput()), "Recycler");
					ft.commit();
				}
			});

			return rootView;
		}

		private String getUserInput(){
			String input;
			input = editText.getText().toString();
			return input;
		}
	}
}

package com.software.rmh.noted;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	public ArrayList<String> notes = new ArrayList<>();

	public RecyclerFragment() {
		// Required empty public constructor
	}

	public static RecyclerFragment newInstance(String note){
		RecyclerFragment recyclerFragment = new RecyclerFragment();
		Bundle args = new Bundle();
		args.putString("NOTE", note);
		recyclerFragment.setArguments(args);
		return recyclerFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if(getArguments() != null){
			notes.add(getArguments().getString("NOTE"));
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

		recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
		layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
		adapter = new CustomAdapter(notes);
		recyclerView.setLayoutManager(layoutManager);
		Log.d("RecyclerView", "Setting the adapter #1...");
		recyclerView.setAdapter(adapter);

		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		adapter = new CustomAdapter(notes);
		Log.d("RecyclerView", "Setting the adapter #2...");
		recyclerView.setAdapter(adapter);
	}
}

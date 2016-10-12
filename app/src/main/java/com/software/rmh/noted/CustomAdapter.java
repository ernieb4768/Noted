package com.software.rmh.noted;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by RMH on 9/26/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

	private ArrayList<String> dataSet;

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		if(dataSet != null){
			holder.textView.setText(dataSet.get(position));
		} else {
			holder.textView.setText(R.string.welcome_message);
		}

	}

	@Override
	public int getItemCount() {
		return dataSet.size();
	}

	public static class	ViewHolder extends RecyclerView.ViewHolder {
		public CardView cardView;
		public TextView textView;
		public ViewHolder(CardView v){
			super(v);
			cardView = v;
			textView = (TextView) cardView.findViewById(R.id.inputTextView);
		}
	}

	public CustomAdapter(ArrayList<String> dataSet){
		this.dataSet = dataSet;
	}

}

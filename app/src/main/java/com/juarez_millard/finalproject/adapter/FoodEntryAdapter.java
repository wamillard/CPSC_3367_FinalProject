package com.juarez_millard.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.juarez_millard.finalproject.R;
import com.juarez_millard.finalproject.model.Food;
import com.juarez_millard.finalproject.model.FoodEntry;

import java.util.HashMap;

public class FoodEntryAdapter extends RecyclerView.Adapter
{
	private HashMap<Integer, FoodEntry> mFoodEntry;
	private Context mContext;
	private OnFoodEntryClickListener mOnFoodEntryClickListener;

	public FoodEntryAdapter(Context ctx, HashMap inventoryList)
	{
		this.mFoodEntry = inventoryList;
		this.mContext = ctx;
	}

	public interface OnFoodEntryClickListener
	{
		void onFoodEntryClick(View view, FoodEntry fEntry, Integer position);
	}

	public void setOnFoodEntryClickListener(final OnFoodEntryClickListener mFoodEntryClickListener)
	{
		this.mOnFoodEntryClickListener = mFoodEntryClickListener;
	}


	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		RecyclerView.ViewHolder vh;
		View foodEntryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_item_view, parent, false);

		vh = new FoodEntryViewHolder(foodEntryView);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
	{
		FoodEntryViewHolder viewHolder = (FoodEntryViewHolder) holder;
		FoodEntry p = mFoodEntry.get(position);
		viewHolder.mfName.setText(p.getfName());
		viewHolder.mQTYStocked.setText(p.getQTYstocked().toString());
		viewHolder.mQTYPar.setText(p.getQTYpar().toString());
		viewHolder.mUoM.setText(p.getUoM());

	}

	@Override
	public int getItemCount()
	{
		return this.mFoodEntry.size();
	}

	public class FoodEntryViewHolder extends RecyclerView.ViewHolder
	{

		public TextView mfName;
		public TextInputLayout mLayoutQTY;
		public TextInputEditText mQTYStocked;
		public TextView mQTYPar;
		public TextView mUoM;
		public View lyt_parent;

		public FoodEntryViewHolder(View v)
		{
			super(v);
			mfName = v.findViewById(R.id.txtV_item_name);
			mLayoutQTY = v.findViewById(R.id.layoutQTY);
			mQTYStocked = v.findViewById(R.id.txtV_item_qty);
			mQTYPar = v.findViewById(R.id.txtV_item_par);
			mUoM = v.findViewById(R.id.txtV_UoM);
			lyt_parent = v.findViewById(R.id.lyt_pantry_view);

			mLayoutQTY.setStartIconOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Integer currQTY = Integer.parseInt(mQTYStocked.getText().toString());
					if (currQTY >= 1)
					{
						currQTY = currQTY - 1;
						mQTYStocked.setText(currQTY.toString());
					}
				}
			});

			mLayoutQTY.setEndIconOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Integer currQTY = Integer.parseInt(mQTYStocked.getText().toString());
					currQTY = currQTY + 1;
					mQTYStocked.setText(currQTY.toString());
				}
			});

			lyt_parent.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					mOnFoodEntryClickListener.onFoodEntryClick(view, mFoodEntry.get(getLayoutPosition()), getLayoutPosition());
				}
			});
		}


	}

}

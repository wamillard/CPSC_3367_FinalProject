package com.juarez_millard.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.juarez_millard.finalproject.R;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.PantryContents;

import java.util.ArrayList;
import java.util.List;

public class PantryContentsAdapter extends RecyclerView.Adapter
{
	private List<PantryContents> mInventory=new ArrayList<>();
	private List<Food> mFood=new ArrayList<>();
	private OnInventoryItemClickListener mOnInventoryItemClickListener;

	public void updateInventory(List<PantryContents> pantryContents,List<Food> foodList)
	{
		this.mInventory=pantryContents;
		this.mFood=foodList;
		notifyDataSetChanged();
	}


	public interface OnInventoryItemClickListener
	{
		void onInventoryItemClick(View view, PantryContents fInventory, Integer position);
	}

	public void setOnInventoryItemClickListener(final OnInventoryItemClickListener mInventoryItemClickListener)
	{
		this.mOnInventoryItemClickListener = mInventoryItemClickListener;
	}


	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		RecyclerView.ViewHolder vh;
		View foodEntryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_item_view, parent, false);

		return new InventoryViewHolder(foodEntryView);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
	{
		InventoryViewHolder viewHolder = (InventoryViewHolder) holder;
		PantryContents p = mInventory.get(position);
		Food f=mFood.get(p.getfID());
		viewHolder.mfName.setText(f.getfName());
		viewHolder.mQTYStocked.setText(p.getQTYstocked());
		viewHolder.mQTYPar.setText(p.getQTYpar());
		viewHolder.mUoM.setText(f.getUoM());

	}

	@Override
	public int getItemCount()
	{
		return this.mInventory.size();
	}

	public class InventoryViewHolder extends RecyclerView.ViewHolder
	{

		public TextView mfName;
		public TextInputLayout mLayoutQTY;
		public TextInputEditText mQTYStocked;
		public TextView mQTYPar;
		public TextView mUoM;
		public View lyt_parent;

		public InventoryViewHolder(View v)
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
					mOnInventoryItemClickListener.onInventoryItemClick(view, mInventory.get(getLayoutPosition()), getLayoutPosition());
				}
			});
		}


	}

}

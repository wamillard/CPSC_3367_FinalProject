package com.juarez_millard.finalproject.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.loader.ResourcesLoader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juarez_millard.finalproject.R;
import com.juarez_millard.finalproject.model.Pantry;

import java.util.HashMap;

public class PantryAdapter extends RecyclerView.Adapter
{
	private HashMap<Integer, Pantry> mPantry;
	private Context mContext;
	private OnPantryClickListener mOnPantryClickListener;

	public PantryAdapter(Context ctx, HashMap pantryList)
	{
		this.mPantry=pantryList;
		this.mContext=ctx;
	}


	public interface OnPantryClickListener
	{
		void onPantryClick(View view, Pantry pantry, Integer position);
	}

	public void setOnPantryClickListener(final OnPantryClickListener mPantryClickListener)
	{
		this.mOnPantryClickListener = mPantryClickListener;
	}


	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		RecyclerView.ViewHolder vh;
		View pantryView= LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_name_list_layout,parent,false);

		vh=new PantryViewHolder(pantryView);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
	{
		PantryViewHolder viewHolder= (PantryViewHolder) holder;
		Pantry p=mPantry.get(position);
		viewHolder.mPantryName.setText(p.getpName());
		viewHolder.mPantryCount.setText(p.getpCount().toString());
		viewHolder.mPantryRoom.setText(p.getpRoom());

		StringBuilder pantry_icon_path= new StringBuilder("@drawable/ic_pantry_").append(p.getpIcon().toString());
		viewHolder.mpIcon.setImageResource(mContext.getResources().getIdentifier(pantry_icon_path.toString(),"id", mContext.getPackageName()));



	}

	@Override
	public int getItemCount()
	{
		return this.mPantry.size();
	}

	public class PantryViewHolder extends RecyclerView.ViewHolder
	{
		public TextView mPantryName;
		public TextView mPantryCount;
		public TextView mPantryRoom;
		public ImageView mpIcon;
		public View lyt_parent;

		public PantryViewHolder(View v)
		{
			super(v);
			mPantryName=v.findViewById(R.id.txtV_pantryname);
			mPantryCount=v.findViewById(R.id.txtV_pantrycount);
			mPantryRoom=v.findViewById(R.id.txtV_pantryRoom);
			mpIcon=v.findViewById(R.id.imgV_pantryicon);
			lyt_parent=v.findViewById(R.id.lyt_pantry_parent);

			lyt_parent.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					mOnPantryClickListener.onPantryClick(view, mPantry.get(getLayoutPosition()),getLayoutPosition());
				}
			});
		}


	}

}

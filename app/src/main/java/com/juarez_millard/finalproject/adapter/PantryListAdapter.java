package com.juarez_millard.finalproject.adapter;

import static org.chromium.base.ContextUtils.getApplicationContext;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juarez_millard.finalproject.R;
import com.juarez_millard.finalproject.activity.OnPantryClickListener;
import com.juarez_millard.finalproject.db.entity.Pantry;

import java.util.ArrayList;
import java.util.List;


public class PantryListAdapter extends RecyclerView.Adapter
{
	private List<Pantry> mPantry=new ArrayList<>();
	private OnPantryClickListener mOnPantryClickListener;

	public void updatePantryList(List<Pantry> pantries)
	{
		this.mPantry=pantries;
		notifyDataSetChanged();
	}


	public void setOnPantryClickListener(final OnPantryClickListener onPantryClickListener)
	{
		this.mOnPantryClickListener = onPantryClickListener;
	}


	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View pantryView= LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_name_list_layout,parent,false);
		return new PantryViewHolder(pantryView);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
	{
		PantryViewHolder viewHolder= (PantryViewHolder) holder;
		Pantry p=mPantry.get(position);
		viewHolder.mPantryName.setText(p.getpName());
		viewHolder.mPantryCount.setText(p.getpCount());
		viewHolder.mPantryRoom.setText(p.getpRoom());

		StringBuilder pantry_icon_path= new StringBuilder("@drawable/ic_pantry_").append(p.getpIcon());
		viewHolder.mpIcon.setImageResource(Resources.getSystem().getIdentifier(pantry_icon_path.toString(),"id",getApplicationContext().getPackageName()));

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

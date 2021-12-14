package com.juarez_millard.finalproject.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juarez_millard.finalproject.adapter.PantryContentsAdapter;
import com.juarez_millard.finalproject.databinding.ActivityPantryBinding;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.PantryContents;
import com.juarez_millard.finalproject.db.entity.Pantry;

import java.util.List;
import java.util.Set;


public class PantryActivity extends MainActivity
{
	private ActivityPantryBinding mBinding;
	public List<PantryContents> inventory;
	public List<Food> foodList;
	public Pantry currentPantry;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mBinding = ActivityPantryBinding.inflate(getLayoutInflater());
		setContentView(mBinding.getRoot());
		Intent pantryOpened=getIntent();

		currentPantry=(Pantry) pantryOpened.getParcelableExtra("Pantry");

		this.mBinding.btnBack.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Pass inventory to dataManager to replace data
				startActivity(new Intent(PantryActivity.this,MainActivity.class));
			}
		});

		TextView currPantry=findViewById(this.mBinding.txtVPantryName.getId());

		currPantry.setText(currentPantry.getpName());

//		inventory=dataManager.readPantryContents(this,currentPantry.getpID());
//		Set<Integer> idList=inventory.keySet();
//		inventory=dataManager.getFoodDetails(this,inventory);

		RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
//		PantryContentsAdapter mAdapter=new PantryContentsAdapter(this,inventory);

//		mAdapter.setOnPantryContentsClickListener(new PantryContentsAdapter.OnPantryContentsClickListener()
//		{
//			@Override
//			public void onPantryContentsClick(View view, PantryContents fEntry, Integer position)
//			{
//				//Edit PantryContents
//				Integer pause=0;
//			}
//		});

		RecyclerView mainRecyclerView= this.mBinding.recyclerVPantryContents;
		mainRecyclerView.setLayoutManager(layoutManager);
//		mainRecyclerView.setAdapter(mAdapter);

	}

	protected void onDestroy()
	{
		super.onDestroy();
		saveInventory();
	}

	protected void onStop()
	{
		super.onStop();
		saveInventory();
	}

	protected void onPause()
	{
		super.onPause();
		saveInventory();
	}

	private void saveInventory()
	{

	}
}
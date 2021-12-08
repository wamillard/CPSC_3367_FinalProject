package com.juarez_millard.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juarez_millard.finalproject.adapter.FoodEntryAdapter;
import com.juarez_millard.finalproject.databinding.ActivityPantryBinding;
import com.juarez_millard.finalproject.model.FoodEntry;
import com.juarez_millard.finalproject.model.Pantry;
import com.juarez_millard.finalproject.utility.DataManager;

import java.util.HashMap;
import java.util.List;


public class PantryActivity extends MainActivity
{
	private ActivityPantryBinding mBinding;
	private DataManager dataManager=new DataManager();
	public HashMap inventory; // (fID, FoodEntry)
	public Pantry currentPantry;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mBinding = ActivityPantryBinding.inflate(getLayoutInflater());
		setContentView(mBinding.getRoot());
		Intent pantryOpened=getIntent();
		List<Integer> pantryDetails;

		currentPantry=(Pantry) pantryOpened.getParcelableExtra("Pantry");

		TextView currPantry=findViewById(this.mBinding.txtVPantryName.getId());

		currPantry.setText(currentPantry.pName);

		inventory=dataManager.readFoodEntry(this,currentPantry.getpID());


		RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
		FoodEntryAdapter mAdapter=new FoodEntryAdapter(this,inventory);
		mAdapter.setOnFoodEntryClickListener(new FoodEntryAdapter.OnFoodEntryClickListener()
		{
			@Override
			public void onFoodEntryClick(View view, FoodEntry fEntry, Integer position)
			{

			}

		});

		RecyclerView mainRecyclerView= this.mBinding.recyclerVPantryContents;
		mainRecyclerView.setLayoutManager(layoutManager);
		mainRecyclerView.setAdapter(mAdapter);

	}
}
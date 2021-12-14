package com.juarez_millard.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.juarez_millard.finalproject.databinding.AdditemLayoutBinding;
import com.juarez_millard.finalproject.utility.DataManager;

public class AddItemActivity extends AppCompatActivity
{
	private AdditemLayoutBinding mBinding;
	private DataManager dm=new DataManager();
	public Integer prevpID;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mBinding=AdditemLayoutBinding.inflate(getLayoutInflater());
		setContentView(mBinding.getRoot());
		Intent prevPantry=getIntent();
		prevpID=prevPantry.getParcelableExtra("PantryID");


	}
}
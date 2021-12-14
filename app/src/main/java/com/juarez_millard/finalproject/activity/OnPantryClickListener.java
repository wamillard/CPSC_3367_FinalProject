package com.juarez_millard.finalproject.activity;

import android.view.View;

import com.juarez_millard.finalproject.db.entity.Pantry;

public interface OnPantryClickListener
{
	void onPantryClick(View view, Pantry pantry, Integer position);
}

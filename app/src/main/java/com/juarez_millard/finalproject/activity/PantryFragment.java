package com.juarez_millard.finalproject.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juarez_millard.finalproject.R;
import com.juarez_millard.finalproject.adapter.PantryListAdapter;
import com.juarez_millard.finalproject.databinding.PantryListFragmentBinding;
import com.juarez_millard.finalproject.db.PantryDatabase;
import com.juarez_millard.finalproject.db.dao.PantryDao;
import com.juarez_millard.finalproject.db.entity.Pantry;
import com.juarez_millard.finalproject.utility.DataManager;
import com.juarez_millard.finalproject.viewmodel.PantryViewModel;

import java.util.List;

public class PantryFragment extends Fragment implements OnPantryClickListener
{
	private PantryListFragmentBinding mBinding;
	private RecyclerView mRecyclerView;
	private PantryListAdapter mAdapter;
	private PantryViewModel mViewModel;
	private OnPantryClickListener mListener;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);




	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.pantry_list_fragment, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view,savedInstanceState);
		buildRecyclerView(view);

	}

	@Override
	public void onAttach(@NonNull Context ctx)
	{
		super.onAttach(ctx);
		if(ctx instanceof OnPantryClickListener)
		{
			this.mListener=(OnPantryClickListener) ctx;
		}
	}

	private void buildRecyclerView(View parent)
	{
		this.mAdapter=new PantryListAdapter();
		this.mAdapter.setOnPantryClickListener(this);
		this.mRecyclerView=parent.findViewById(R.id.recyclerView_Pantry);
		mViewModel=new ViewModelProvider(this.getActivity()).get(PantryViewModel.class);



		mViewModel.setupDB();

		DataManager dm=new DataManager();

//		mViewModel.populatePantry(dm.editSamplePantry());

//		mViewModel.populateDB(dm.editSamplePantry(),dm.editSampleFood(),dm.editSampleCategory(),dm.editSampleFoodEntry(),dm.editSampleFoodCategory());

		if(mAdapter.getItemCount()>3)
		{
			Fragment currFrag= getParentFragmentManager().findFragmentByTag(this.getTag());

			ImageView pantryicon=currFrag.getView().findViewById(R.id.imgV_pantryicon);
			pantryicon.setVisibility(View.GONE);


//			this.mBinding.imgVPantry.setVisibility(View.GONE);
		}

		mViewModel.getPantryList().observe(getViewLifecycleOwner(), new Observer<List<Pantry>>()
		{
			@Override
			public void onChanged(List<Pantry> pantries)
			{
				mAdapter.updatePantryList(pantries);
			}
		});
		mRecyclerView.setAdapter(mAdapter);
		RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(layoutManager);
	}

	@Override
	public void onPantryClick(View view, Pantry pantry, Integer position)
	{
		mListener.onPantryClick(view, pantry, position);
	}
}
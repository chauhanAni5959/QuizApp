package com.projectankit.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.projectankit.quizapp.AdapterClass.HomeAdapter;
import com.projectankit.quizapp.databinding.FragmentHomeBinding;
import com.projectankit.quizapp.modelClass.HomeModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
    HomeAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {

//        for creating this
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("Category 1", "Des 1"));
        list.add(new HomeModel("Category 2", "Des 2"));
        list.add(new HomeModel("Category 3", "Des 3"));
        list.add(new HomeModel("Category 4", "Des 4"));
        list.add(new HomeModel("Category 5", "Des 5"));


//        to set the data into page
        adapter = new HomeAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);

    }
}
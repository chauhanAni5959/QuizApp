package com.projectankit.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectankit.quizapp.AdapterClass.SubAdapter;
import com.projectankit.quizapp.databinding.FragmentHomeBinding;
import com.projectankit.quizapp.databinding.FragmentSubBinding;
import com.projectankit.quizapp.modelClass.HomeModel;

import java.util.ArrayList;


public class SubFragment extends Fragment {

    FragmentSubBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
    SubAdapter adapter;
    String title;
    public SubFragment() {
        // Required empty public constructor
    }
    public SubFragment(String title) {
        // Required empty public constructor
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSubBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {


        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();

        switch (title) {
            case "Category 1":
                list.add(new HomeModel("Sub1 Category 1", "Des 1"));
                list.add(new HomeModel("Sub2 Category 1", "Des 1"));
                list.add(new HomeModel("Sub3 Category 1", "Des 1"));
                list.add(new HomeModel("Sub4 Category 1", "Des 1"));
                list.add(new HomeModel("Sub5 Category 1", "Des 1"));

                break;
            case "Category 2":
                list.add(new HomeModel("Sub1 Category 2", "Des 2"));
                list.add(new HomeModel("Sub2 Category 2", "Des 2"));
                list.add(new HomeModel("Sub3 Category 2", "Des 2"));
                list.add(new HomeModel("Sub4 Category 2", "Des 2"));
                list.add(new HomeModel("Sub5 Category 2", "Des 2"));

                break;
            case "Category 3":
                list.add(new HomeModel("Sub1 Category 3", "Des 3"));
                list.add(new HomeModel("Sub2 Category 3", "Des 3"));
                list.add(new HomeModel("Sub3 Category 3", "Des 3"));
                list.add(new HomeModel("Sub4 Category 3", "Des 3"));
                list.add(new HomeModel("Sub5 Category 3", "Des 3"));

                break;
            case "Category 4":
                list.add(new HomeModel("Sub1 Category 4", "Des 4"));
                list.add(new HomeModel("Sub2 Category 4", "Des 4"));
                list.add(new HomeModel("Sub3 Category 4", "Des 4"));
                list.add(new HomeModel("Sub4 Category 4", "Des 4"));
                list.add(new HomeModel("Sub5 Category 4", "Des 4"));


                break;
            case "Category 5":
                list.add(new HomeModel("Sub1 Category 5", "Des 5"));
                list.add(new HomeModel("Sub2 Category 5", "Des 5"));
                list.add(new HomeModel("Sub3 Category 5", "Des 5"));
                list.add(new HomeModel("Sub4 Category 5", "Des  6"));
                list.add(new HomeModel("Sub5 Category 5", "Des 5"));

                break;
        }


//        to set the data into page
        adapter = new SubAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);
    }
}
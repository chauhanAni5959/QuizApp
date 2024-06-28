package com.projectankit.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectankit.quizapp.databinding.FragmentResultBinding;


public class ResultFragment extends Fragment {

    FragmentResultBinding binding;
    int right , allQuestions;
    public ResultFragment() {
        // Required empty public constructor
    }

    public ResultFragment(int right , int allQuestions){
            this.right = right;
            this.allQuestions = allQuestions;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(getLayoutInflater());

         String rightScore = String.valueOf(right);
         String wrongScore = String.valueOf(allQuestions - right);
         String totalScore = String.valueOf(allQuestions);

         binding.correct.setText(rightScore +" Correct");
         binding.incorrect.setText(wrongScore + " Incorrect");
         binding.score.setText("You get  the " + rightScore + " out of " + totalScore);
        return binding.getRoot();
    }
}
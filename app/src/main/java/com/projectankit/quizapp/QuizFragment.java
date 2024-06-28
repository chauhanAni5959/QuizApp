package com.projectankit.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectankit.quizapp.databinding.FragmentQuizBinding;
import com.projectankit.quizapp.modelClass.HomeModel;
import com.projectankit.quizapp.modelClass.QuizModel;

import java.util.ArrayList;
import java.util.Objects;


public class QuizFragment extends Fragment {
    FragmentQuizBinding binding;
    ArrayList<QuizModel> list = new ArrayList<>();
    private int position  = 0;
    int right = 0;
    private static String answer = null;
    int allQuestions;
    String listSize;
    String positionNo;

    QuizModel quizModel;
    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     binding = FragmentQuizBinding.inflate(getLayoutInflater());
     LoadQuestions();
     EnableOption();
     ClearOption();
     binding.nextBtn.setOnClickListener(v->{
         position++;
         LoadQuestions();
         EnableOption();
         ClearOption();
         CheckNext();

     });

        return binding.getRoot();
    }

    private void CheckNext() {

        if(position == allQuestions){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new ResultFragment(right, allQuestions)).commit();
            list.clear();
            position = 0;

        }
    }

    private void ClearOption() {

        binding.option1.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option1.setTextColor(getContext().getColor(R.color.black));
        binding.option2.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option2.setTextColor(getContext().getColor(R.color.black));
        binding.option3.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option3.setTextColor(getContext().getColor(R.color.black));
        binding.option4.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option4.setTextColor(getContext().getColor(R.color.black));
        binding.nextBtn.setBackgroundResource(R.drawable.disable_btn);
    }

    private void EnableOption() {

        binding.option1.setEnabled(true);
        binding.option2.setEnabled(true);
        binding.option3.setEnabled(true);
        binding.option4.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void LoadQuestions() {

        list.add(new QuizModel("Question 1","op 1","op 2","op 3","op 4","op 1"));
        list.add(new QuizModel("Question 2","op 1","op 2","op 3","op 4","op 2"));
        list.add(new QuizModel("Question 3","op 1","op 2","op 3","op 4","op 3"));
        list.add(new QuizModel("Question 4","op 1","op 2","op 3","op 4","op 4"));
        list.add(new QuizModel("question 5","op 1","op 2","op 3","op 4","op 1"));

        allQuestions = 5;
        listSize  = String.valueOf(allQuestions);
        binding.totalQ.setText("/" + listSize);


        if(position != allQuestions){
            positionNo = String.valueOf(position+1);
            binding.qNo.setText(positionNo);
        }else{
            positionNo = String.valueOf(position);
            binding.qNo.setText(positionNo); 
        }

        quizModel = list.get(position); 
        answer = quizModel.getCorrectAns();
        binding.questionCont.setText(quizModel.getQuestions());
        binding.option1.setText(quizModel.getOp1());
        binding.option2.setText(quizModel.getOp2());
        binding.option3.setText(quizModel.getOp3());
        binding.option4.setText(quizModel.getOp4());
        
        optionChekup();
    }

    private void optionChekup() {

        binding.option1.setOnClickListener(v->{


            if(Objects.equals(quizModel.getOp1(), quizModel.getCorrectAns())){
                right++;
                binding.option1.setBackgroundResource(R.drawable.right_bg);
                binding.option1.setTextColor(getContext().getColor(R.color.white));
            }
            else{
                ShowRightAnswer();
                binding.option1.setBackgroundResource(R.drawable.wrong_bg);
                binding.option1.setTextColor(getContext().getColor(R.color.white));

            }

            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });

        binding.option2.setOnClickListener(v->{


            if(Objects.equals(quizModel.getOp2(), quizModel.getCorrectAns())){
                right++;
                binding.option2.setBackgroundResource(R.drawable.right_bg);
                binding.option2.setTextColor(getContext().getColor(R.color.white));

            }
            else{
                ShowRightAnswer();
                binding.option2.setBackgroundResource(R.drawable.wrong_bg);
                binding.option2.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);

        });
        binding.option3.setOnClickListener(v->{


            if(Objects.equals(quizModel.getOp3(), quizModel.getCorrectAns())){
                right++;
                binding.option3.setBackgroundResource(R.drawable.right_bg);
                binding.option3.setTextColor(getContext().getColor(R.color.white));

            }
            else{
                ShowRightAnswer();
                binding.option3.setBackgroundResource(R.drawable.wrong_bg);
                binding.option3.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);

        });

        binding.option4.setOnClickListener(v->{


            if(Objects.equals(quizModel.getOp4(), quizModel.getCorrectAns())){
                right++;
                binding.option4.setBackgroundResource(R.drawable.right_bg);
                binding.option4.setTextColor(getContext().getColor(R.color.white));

            }
            else{
                ShowRightAnswer();
                binding.option4.setBackgroundResource(R.drawable.wrong_bg);
                binding.option4.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);

        });


    }

    private void DisableOption() {
        binding.option1.setEnabled(false);
        binding.option2.setEnabled(false);
        binding.option3.setEnabled(false);
        binding.option4.setEnabled(false);
        binding.nextBtn.setEnabled(true);
    }

    private void ShowRightAnswer() {


        if(Objects.equals(quizModel.getOp1(), quizModel.getCorrectAns())){
            binding.option1.setBackgroundResource(R.drawable.right_bg);
            binding.option1.setTextColor(getContext().getColor(R.color.white));

        }
        else if(Objects.equals(quizModel.getOp2(), quizModel.getCorrectAns())){
            binding.option2.setBackgroundResource(R.drawable.right_bg);
            binding.option2.setTextColor(getContext().getColor(R.color.white));


        }
        else  if(Objects.equals(quizModel.getOp3(), quizModel.getCorrectAns())){
            binding.option3.setBackgroundResource(R.drawable.right_bg);
            binding.option3.setTextColor(getContext().getColor(R.color.white));

        }
        else  if(Objects.equals(quizModel.getOp4(), quizModel.getCorrectAns())){
            binding.option4.setBackgroundResource(R.drawable.right_bg);
            binding.option4.setTextColor(getContext().getColor(R.color.white));

        }

    }
}
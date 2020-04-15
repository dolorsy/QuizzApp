package com.dolor.quizzapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class QuizListFragment extends Fragment {

    QuizListAdapter quizListAdapter = new QuizListAdapter();
    RecyclerView recyclerView;

    public static QuizListFragment newInstance() {
        QuizListFragment fragment = new QuizListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_quiz_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.quiz_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onStart() {
        super.onStart();

        MainActivity.getQuizViewModel().getQuizListLiveData().observe(this,quizModels -> {
            //Here you should Update the UI RecyclerView
            ArrayList<QuizModel> test = (ArrayList<QuizModel>) MainActivity.getQuizViewModel().getQuizListLiveData().getValue();
            quizListAdapter.setList(test);
            recyclerView.setAdapter(quizListAdapter);

        });
        ArrayList<QuizModel> test = (ArrayList<QuizModel>) MainActivity.getQuizViewModel().getQuizListLiveData().getValue();
        quizListAdapter.setList(test);
        recyclerView.setAdapter(quizListAdapter);

    }
}

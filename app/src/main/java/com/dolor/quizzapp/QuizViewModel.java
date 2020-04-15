package com.dolor.quizzapp;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class QuizViewModel extends ViewModel {


    private   MutableLiveData<List<QuizModel>> quizListLiveData = new MutableLiveData<>();
    private MutableLiveData<String> status = new MutableLiveData<>();
    public String DATA_IS_READY = "Data Is Ready";
    public String ERROR_WITH_GETTING_DATA = "Error With Gitting Data";
    public String Error_WITH_CONNECTION = "Error With Connection";


    public  void getQuizListFromDB(Context context){
        List<QuizModel> quizList = new ArrayList<>();
        ParseQuery<ParseObject> quizListQuery;
        quizListQuery  = ParseQuery.getQuery("Courses");
        quizListQuery.findInBackground((objects, e) -> {
            if(e == null){
                for (ParseObject object : objects){
                    quizList.add(new QuizModel(
                            object.getString("ImageURL"),
                            object.getString("courseName"),
                            object.getString("courseDescrib"),
                            object.getString("Level"),
                            Integer.parseInt (String.valueOf(object.getNumber("QuestionsNumber")))

                    ));

                }
                status.setValue(DATA_IS_READY);

            }else{

                //Error While Getting Data
                status.setValue(ERROR_WITH_GETTING_DATA);
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        quizListLiveData.setValue(quizList);
    }

    public MutableLiveData<List<QuizModel>> getQuizListLiveData(){
        return this.quizListLiveData;
    }

    public MutableLiveData<String> getStatusLiveData(){return  this.status;}
}

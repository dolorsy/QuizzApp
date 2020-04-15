package com.dolor.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.parse.Parse;

public class MainActivity extends AppCompatActivity {
    //TODO: (1) You should test the Image Size in your own phone
    //TODO: (2) You should Use a Lot of Font Family in this Project
    //TODO: (3) Maybe you should remind about colors
    //TODO: (4) you should get Some Sleep!!! -_-
    //TODO: (5) Good Night...

    private static QuizViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        myViewModel = new QuizViewModel();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );


    }

    public static QuizViewModel getQuizViewModel(){
        return myViewModel;
    }
}

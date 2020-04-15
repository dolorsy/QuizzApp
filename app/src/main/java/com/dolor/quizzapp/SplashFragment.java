package com.dolor.quizzapp;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class SplashFragment extends Fragment {

TextView progressText;
ProgressBar progressBar;
NavController navController;

    public SplashFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressText = view.findViewById(R.id.progress_text);
        progressBar = view.findViewById(R.id.progressBar);
        navController = Navigation.findNavController(view);

        MainActivity.getQuizViewModel().getQuizListFromDB(getContext());

    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.getQuizViewModel().getStatusLiveData().observe(this,s -> {
           String status = MainActivity.getQuizViewModel().getStatusLiveData().getValue();
            progressText.setText(status);
            if(status == MainActivity.getQuizViewModel().DATA_IS_READY){
                navController.navigate(R.id.action_splashFragment_to_quizListFragment);
            }
        });

//Register a User
     /*   ParseObject userPhone = new ParseObject("UsersPhones");
        userPhone.put("MANUFACTURER", Build.MANUFACTURER);
        userPhone.put("MODEL", Build.MODEL);

        userPhone.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    progressText.setText("Device Registered");
                    navController.navigate(R.id.action_splashFragment_to_quizListFragment);
                }else{
                    Log.d("PARSE_BUG",e.getMessage().toString());
                    progressText.setText("Error with Regestiring the Device");
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        */
    }


}

package com.dolor.quizzapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizViewHolder> {
    //Declare the ArrayList You Want
    private ArrayList<QuizModel> myList = new ArrayList<>();


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //You should Change The Item_Layout for each Adapter You made (R.layout.Item_Layout)
        return new QuizViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quizz_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        //Here you Have to Set The Values of The Views Layout
        //This is The Final Step of Adapter Working
        //You should take a Look at QuizViewHolderClass at the bottom
        // holder.textView.setText(myList.get(position));
        Picasso.get().load(myList.get(position).getImageURL()).resize(256,holder.quizImage.getMeasuredHeight()).centerCrop().into(holder.quizImage);
        holder.quizName.setText(myList.get(position).getName());
        holder.quizDesc.setText(myList.get(position).getDescrib());


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public void setList(ArrayList<QuizModel> myList) {

        this.myList = myList;
        this.myList.add(new QuizModel("no","Test Quiz","No Describ ","High",5));
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder {
        //This Class is a Model of your Item View(Item_Layout)
        //  TextView textView;
        TextView quizName,quizDesc;
        ImageView quizImage;
        Button quizStartButton;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            //Here The initialization of layout Views
            //textView = itemView.findViewById(R.id.textView);

            quizName = itemView.findViewById(R.id.quiz_name_list_name);
            quizImage = itemView.findViewById(R.id.image_list_item);
            quizDesc = itemView.findViewById(R.id.quiz_desc_list_name);
            quizStartButton = itemView.findViewById(R.id.quiz_start_button);

        }
    }
}

package com.androidcai.administrator.piggymath;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseLevelFragment extends Fragment {

    private int modelAnInt;
    private String userNameString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From SharePerfer
        getValueFromSharePerfer();

//        Easy
        easyController();
//        Normal Controller
        normalController();
//        Hard Controller
        HardController();
//        True Answer Page
        TrueAnswer();

    }   // Main Method

    private void TrueAnswer() {

    }

    private void HardController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageHard);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentToPlayGame(2);
            }
        });
    }

    private void normalController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageNormal);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentToPlayGame(1);
            }
        });
    }

    private void easyController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageEasy);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentToPlayGame(0);
            }
        });
    }

    private void sentToPlayGame(int indexLevel) {

        Log.d("10MayV1","Level ==>" + indexLevel);
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentNewGameFragment, NewGameFragment.newGameInstance(indexLevel))
                .addToBackStack(null)
                .commit();
    }

    private void getValueFromSharePerfer() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        modelAnInt = sharedPreferences.getInt("Mode", 0);
        userNameString = sharedPreferences.getString("Username", "");
        Log.d("10MayV1", "Mode ==> " + modelAnInt);
        Log.d("10MayV1", "User ==> " + userNameString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_choose_level, container, false);
        return view;
    }
}

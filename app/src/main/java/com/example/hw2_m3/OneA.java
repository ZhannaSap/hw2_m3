package com.example.hw2_m3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OneA extends Fragment {

private Button minus;
private Button plus;

private Button next;
private TextView result;
private int counter = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initCFlickListener();
    }

    private void initCFlickListener() {
        minus.setOnClickListener(view -> {
            counter--;
            result.setText(String.valueOf(counter));
        });

        plus.setOnClickListener(view -> {
            counter++;
            result.setText(String.valueOf(counter));
        });

        next.setOnClickListener(view -> {
            TwoA twoA = new TwoA();
            Bundle bundle = new Bundle();
            bundle.putString("key_of_result", result.getText().toString());
            twoA.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.container, twoA).addToBackStack(null).commit();

        });
    }

    private void initView() {
        minus = requireActivity().findViewById(R.id.btn_minus_one);
        plus = requireActivity().findViewById(R.id.btn_plus_one);
        next = requireActivity().findViewById(R.id.btn_next);
        result = requireActivity().findViewById(R.id.tv_result);
    }



}
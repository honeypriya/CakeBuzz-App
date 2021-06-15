package com.example.cakebuzz_cakeorderingapp.ui.rateus;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cakebuzz_cakeorderingapp.R;
import com.example.cakebuzz_cakeorderingapp.Register;

public class RateUsFragment extends Fragment {
    Button submitrating;

    private RateUsViewModel mViewModel;

    public static RateUsFragment newInstance() {
        return new RateUsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rateus, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RateUsViewModel.class);
        // TODO: Use the ViewModel
    }

}
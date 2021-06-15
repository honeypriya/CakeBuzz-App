package com.example.cakebuzz_cakeorderingapp.ui.rateus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateUsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RateUsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rate us fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.cakebuzz_cakeorderingapp.ui.logout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LogoutViewModel extends ViewModel {

    private static LiveData<String> mText;

    public LogoutViewModel() {
        mText = new MutableLiveData<>();
        ((MutableLiveData<String>) mText).setValue("This is logout fragment");
    }

    public static LiveData<String> getText() {
        return mText;
    }
}
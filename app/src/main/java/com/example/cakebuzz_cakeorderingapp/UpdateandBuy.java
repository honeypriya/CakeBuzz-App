package com.example.cakebuzz_cakeorderingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cakebuzz_cakeorderingapp.ui.home.HomeFragment;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class UpdateandBuy extends AppCompatActivity implements PaymentResultListener {
Button  buy;
    TextView paytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateand_buy);
        buy= findViewById(R.id.button3);
        paytext=findViewById(R.id.textView3);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makepayment();
            }
        });
    }
    private void makepayment()
    {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_uWOiMTCdCkBnjy");

        checkout.setImage(R.drawable.cakebuzz_logo);
        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "CakeBuzz Payment");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "30000");//300 X 100
            options.put("prefill.email", " ");
            options.put("prefill.contact"," ");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        paytext.setText("Successful payment ID :"+s);
        paytext.setOnClickListener(new View.OnClickListener() {                                     //new acc
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeFragment.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onPaymentError(int i, String s){
    paytext.setText("Failed and cause is :"+s);
    }


}
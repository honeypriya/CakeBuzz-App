package com.example.cakebuzz_cakeorderingapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cakebuzz_cakeorderingapp.ui.home.HomeFragment;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity implements PaymentResultListener {
    DatabaseHandler db;
    ListView list;
    ArrayList<String> listItems;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
       db = new DatabaseHandler(this);
       list=findViewById(R.id.lvorder);
      listItems = new ArrayList<>();

viewdata();
list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = list.getItemAtPosition(i).toString();
        //Intent im = new Intent(getApplicationContext(),UpdateandBuy.class);
//        startActivity(im);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderList.this);
        alertDialogBuilder.setMessage("CHOOSE ONE");
        alertDialogBuilder.setPositiveButton("Buy",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        makepayment();
//                        Intent myIntent = new Intent(Dashboard.this, ViewEnq.class);
//                        Dashboard.this.startActivity(myIntent);
                        Toast.makeText(getApplicationContext(),"Proceeding to payment options" ,Toast.LENGTH_SHORT).show();
                    }
                });
        alertDialogBuilder.setNegativeButton("DELETE",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       deleteName(listItems);
                        Intent myIntent = new Intent(OrderList.this, HomeFragment.class);
                        OrderList.this.startActivity(myIntent);
                        Toast.makeText(getApplicationContext(),"Item successfully deleted",Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
});
    }
    private void viewdata(){

        Cursor cursor = db.viewdata();
        if(cursor.getCount()==0){
            Toast.makeText(OrderList.this, "no data to show", Toast.LENGTH_SHORT).show();

        }
        else
        {
            while(cursor.moveToNext()){
                listItems.add(cursor.getString(3));
            }
            adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItems);
        list.setAdapter(adapter);
        }

    }


    private void deleteName(ArrayList<String> name){


    }


    private void makepayment()
    {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_uWOiMTCdCkBnjy");

        checkout.setImage(R.drawable.cakebuzz_logo);
        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "Cakebuzz Payment");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "30000");//300 X 100
            options.put("prefill.email", "null");
            options.put("prefill.contact","null");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {

       //paytext.setText("Successful payment ID :"+s);
    }

    @Override
    public void onPaymentError(int i, String s) {

        //
        // paytext.setText("Failed and cause is :"+s);
    }
}


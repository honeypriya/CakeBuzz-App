package com.example.cakebuzz_cakeorderingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class description extends AppCompatActivity {
private TextView tv,des,priceview;
    ImageView imageView;
    Button button , viewcart;
    DatabaseHandler mDatabaseHelper;
     EditText msgoncake, occasion , name, phoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        tv= findViewById(R.id.textView);
        des= findViewById(R.id.detailDescription);
        priceview=findViewById(R.id.textView4);
        imageView = findViewById(R.id.detailImage);
        button= findViewById(R.id.insertBtn);
        msgoncake= findViewById(R.id.nameBox);
        occasion= findViewById(R.id.occasion);
        name= findViewById(R.id.name);
        viewcart= findViewById(R.id.viewcart);
        phoneno= findViewById(R.id.phoneno);
        mDatabaseHelper = new DatabaseHandler(this);
        Bundle bundle = getIntent().getExtras();
        if(getIntent().getExtras() != null) {
            //final int image = getIntent().getIntExtra("image", 0);
          //  final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String cakename = getIntent().getExtras().getString("name");
            final String description = getIntent().getExtras().getString("des");
            final String price = getIntent().getExtras().getString("price");
            int resId = bundle.getInt("resId");
            imageView.setImageResource(resId);
            tv.setText(cakename);
            des.setText(description);
            priceview.setText(price);
        }
        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),OrderList.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme= name.getText().toString();
                String phonno= phoneno.getText().toString();
                String cakename = tv.getText().toString();
                String cakdes= des.getText().toString();
                String cakeprice = priceview.getText().toString();
                String msgoncke= msgoncake.getText().toString();
                String occ = occasion.getText().toString();


                if (tv.length() != 0) {
                    AddCakeData(nme , phonno ,cakename ,cakdes, cakeprice, msgoncke, occ );
                   tv.setText("");
                } else {
                    Toast.makeText(description.this, "ERRRRRR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AddCakeData( String name, String phoneno, String cakename, String des, String price , String msgoncake, String occ ) {
        boolean insertData = mDatabaseHelper.addCakeData( name , phoneno,cakename, des, price, msgoncake, occ);
        if (insertData) {
            Toast.makeText(description.this, "Item added to cart", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(description.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

}

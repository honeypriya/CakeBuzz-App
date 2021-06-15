package com.example.cakebuzz_cakeorderingapp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cakebuzz_cakeorderingapp.R;
import com.example.cakebuzz_cakeorderingapp.description;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Activity context;
    Button logout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        final ListView listview = root.findViewById(R.id.listview);
        final SearchView searchView = root.findViewById(R.id.searchView);
        //create data
        ArrayList<Cake> arrayList = new ArrayList<>();
        arrayList.add(new Cake(R.drawable.chocolate, "Chocolate Cake","Price= 300/-"));
        arrayList.add(new Cake(R.drawable.darkforest, "Dark Forest Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.mix_fruit, "Mix Fruit Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.pineapple, "Pineapple Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.redvelvet, "Red Velvet Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.chocochip, "Choco Chip Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.butterscotch, "Butterscotch Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.vanilla, "Vanilla Cake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.cheesecake, "Cheesecake", "Price= 300/-"));
        arrayList.add(new Cake(R.drawable.strawberry, "Strawberry Cake", "Price= 300/-"));
        CakeAdapter cakeAdapter = new CakeAdapter(getActivity(), R.layout.list_row, arrayList);
        listview.setAdapter(cakeAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    String cakename = "Chocolate Cake";
                    String description = "A rich moist chocolate cake with a chocolate butter cream icing.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.chocolate);
                    startActivity(myIntent);
                }
                if (position == 1) {
                    String cakename = "Dark Forest Cake";
                    String description = "TDeliciously moist Black Forest Cake is a cut above the rest with homemade whipped cream, rich chocolate, and sweet spiked cherries.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.darkforest);
                    startActivity(myIntent);
                }
                if (position == 2) {
                    String cakename = "Mix Fruit Cake";
                    String description = "Made with handpicked and fresh fruits blended together to give the delicious taste.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.mix_fruit);
                    startActivity(myIntent);
                }
                if (position == 3) {
                    String cakename = "Pineapple Cake";
                    String description = "Made from scratch with crushed pineapple and topped with cream cheese whipped cream for a light but decadent treat.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.pineapple);
                    startActivity(myIntent);
                }
                if (position == 4) {
                    String cakename = "Red Velvet Cake";
                    String description = "A red, red-brown, crimson, or scarlet-colored chocolate layer cake, layered with ermine icing.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.redvelvet);
                    startActivity(myIntent);
                }
                if (position == 5) {
                    String cakename = "Choco Chip Cake";
                    String description = "A buttery, soft vanilla pound cake gets loaded with chocolate chips, reminiscent of a classic chocolate chip muffin.";
                    String price = "300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.chocochip);
                    startActivity(myIntent);
                }
                if (position == 6) {
                    String cakename = "Butterscotch Cake";
                    String description = "Made from-scratch brown sugar cake topped with butterscotch buttercream made with melted butterscotch chips.";
                    String price = " 300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.butterscotch);
                    startActivity(myIntent);
                }
                if (position == 7) {
                    String cakename = "Vanilla Cake";
                    String description = "This vanilla cake is the result of bringing together the best of Japanese sponge cakes and Western butter.";
                    String price = " 300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.vanilla);
                    startActivity(myIntent);
                }
                if (position == 8) {
                    String cakename = "Cheesecake";
                    String description = "A sweet dessert consisting of one or more layers. The main, and thickest, layer consists of a mixture of a soft, fresh cheese (typically cottage cheese, cream cheese or ricotta), eggs, and sugar.";
                    String price = " 300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.cheesecake);
                    startActivity(myIntent);
                }
                if (position == 9) {
                    String cakename = "Strawberry Cake";
                    String description = "A moist old fashioned cake that is very simple to make. It has great crumbs and a slight tang.";
                    String price = " 300";
                    Intent myIntent = new Intent(view.getContext(), description.class);
                    myIntent.putExtra("name", cakename);
                    myIntent.putExtra("des", description);
                    myIntent.putExtra("price", price);
                    myIntent.putExtra("resId", R.drawable.strawberry);

                }


                // ListView Clicked item index
                // int itemPosition = position;
                // ListView Clicked item value
                // Show Alert
                // Toast.makeText(context.getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
        return root;

    }

}

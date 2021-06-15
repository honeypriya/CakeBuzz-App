package com.example.cakebuzz_cakeorderingapp.ui.home;
public class Cake {
    int Image;
    String Name,Des,Price;

    public Cake(int image, String name, String des){
        Image= image;
        Name= name;
        Des= des;

    }
    public int getImage() {
        return Image;
    }
    public void setImage(int image) {
        this.Image = image;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getDes() {
        return Des;
    }
    public void setDes(String des) {
        this.Des = des;
    }
    public String getPrice( ){
        return Price;
    }
    public void setPrice(String price){
        this.Price=price;
    }

}
package com.example.food_app;

import android.content.Context;
import android.content.SharedPreferences;

public class sharepref {

    Context context;

    sharepref(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String email, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.commit();
    }

    public void regdetail(String name, String number,String ppas,String add) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Registerdetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("number", number);
        editor.putString("pass", ppas);
        editor.putString("address", add);
        editor.commit();
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
    }

    public void viewdata() {
        SharedPreferences s = context.getSharedPreferences("Registerdetails",context.MODE_PRIVATE);

            String g1=s.getString("name","");
            String g2=s.getString("number","");
            String s3 = "name: "+g1+"\n number: "+g2;
            MainActivity.data=s3;




    }

    public void favfood(StringBuilder st) {
        SharedPreferences s = context.getSharedPreferences("fav_food",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = s.edit();
        editor.putString("fav", String.valueOf(st));
        editor.commit();

    }

}

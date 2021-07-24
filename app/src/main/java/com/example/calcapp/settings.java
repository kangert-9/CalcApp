package com.example.calcapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class settings extends AppCompatActivity {
    private static final String AppTheme = "Mytheme";

    protected static final int Mytheme = 0;
    protected static final int AppThemeDarkCodeStyle = 1;
    private String NameSharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Mytheme));
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }
    protected int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }
    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }
    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.Mytheme;
        }
    }

}
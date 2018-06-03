package com.mudaliyar.shekar.mldcc_clone;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME="fcmsharedprefdemo";
    private static final String KEY_ACCESS_TOKEN="token";
    private static Context context;
    private static SharedPrefManager instance;
    private SharedPrefManager(Context c){
        context=c;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(instance == null)
            instance = new SharedPrefManager(context);
        return instance;
    }
    public boolean storeToken(String token){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN,token);
        editor.apply();
        return true;
    }
    public String getToken(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN,null);
    }
}

package com.example.recuitmenttrackerapp1.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {
    public static final String NAME = "HR_APP";
    public static final String USERS= "user";

    public SharedPreference() {
        super();
    }
    public void saveUsers(Context context, List<RegisterUser> users) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonusers = gson.toJson(users);

        editor.putString(USERS, jsonusers);

        editor.commit();
    }
    public void addUsers(Context context, RegisterUser product) {
        List<RegisterUser> users = getUsers(context);
        if (users == null)
            users = new ArrayList<RegisterUser>();
        users.add(product);
        saveUsers(context, users);
    }
    public ArrayList<RegisterUser> getUsers(Context context) {
        SharedPreferences settings;
        List<RegisterUser> users;

        settings = context.getSharedPreferences(NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(USERS)) {
            String jsonusers = settings.getString(USERS, null);
            Gson gson = new Gson();
            RegisterUser[] Items = gson.fromJson(jsonusers,
                    RegisterUser[].class);

            users = Arrays.asList(Items);
            users = new ArrayList<RegisterUser>(users);
        } else
            return null;

        return (ArrayList<RegisterUser>) users;
    }
}

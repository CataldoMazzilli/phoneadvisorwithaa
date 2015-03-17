package com.example.vulpes.phoneadvisorwithaa.activities;

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.adapters.FavouritesPhoneAdapter;
import com.example.vulpes.phoneadvisorwithaa.fragments.MyDialogFragment;
import com.example.vulpes.phoneadvisorwithaa.models.Phone;
import com.example.vulpes.phoneadvisorwithaa.util.PhonesDB;
import com.example.vulpes.phoneadvisorwithaa.util.UserPref_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@EActivity(R.layout.activity_favourites)
@OptionsMenu(R.menu.menu_favourites)
public class FavouritesActivity extends ActionBarActivity implements MyDialogFragment.OnChoiceSelectedListener {

    @Bean
    FavouritesPhoneAdapter adapter;

    @ViewById
    ListView list_favourites_phone;

    @Pref
    UserPref_ userPref_;

    @AfterViews
    void bindAdapter() {
        list_favourites_phone.setAdapter(adapter);
        getPhonesAsync();
    }

    @Background
    void getPhonesAsync() {
        String jsonData = userPref_.preferiti().get();
        PhonesDB myPhoneDB = PhonesDB.getInstance();

        try {
            JSONObject json = new JSONObject(jsonData);
            JSONArray ar = json.getJSONArray("ciao");
            int numbers[] = new int[ar.length()];
            for (int i = 0; i < ar.length(); ++i) {
                numbers[i] = ar.optInt(i);
            }
            updatePhones(myPhoneDB.getPhoneById(numbers));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updatePhones(List<Phone> phones) {
        adapter.updatePhones(phones);
    }

    @Override
    public void onPositiveSelected(boolean positiveSelected, int phoneId) {
        if (positiveSelected) {

            String jsonData = userPref_.preferiti().get();
            PhonesDB myPhoneDB = PhonesDB.getInstance();

            JSONObject object;
            JSONArray ar;
            if (jsonData != "") {
                try {
                    object = new JSONObject(jsonData);
                    ar = object.getJSONArray("ciao");
                    int numbers[] = new int[ar.length()];
                    for (int i = 0; i < ar.length(); ++i) {
                        numbers[i] = ar.optInt(i);
                    }
                    ar = new JSONArray();
                    for (int i = 0; i < numbers.length; i++) {
                        if (phoneId != numbers[i]) ar.put(numbers[i]);
                    }
                    numbers = new int[ar.length()];
                    for (int i = 0; i < ar.length(); ++i) {
                        numbers[i] = ar.optInt(i);
                    }
                    object = new JSONObject();
                    object.put("ciao", ar);
                    userPref_.preferiti().put(object.toString());
                    updatePhones(myPhoneDB.getPhoneById(numbers));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), "no selected",
                    Toast.LENGTH_LONG).show();
        }
    }
}


package com.example.vulpes.phoneadvisorwithaa.activities;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.adapters.PhoneAdapter;
import com.example.vulpes.phoneadvisorwithaa.fragments.MyDialogFragment;
import com.example.vulpes.phoneadvisorwithaa.models.Phone;
import com.example.vulpes.phoneadvisorwithaa.util.PhonesDB;
import com.example.vulpes.phoneadvisorwithaa.util.UserPref_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

@EActivity(R.layout.activity_phone_list)
@OptionsMenu(R.menu.menu_phone_list)
public class PhoneListActivity extends ActionBarActivity implements MyDialogFragment.OnChoiceSelectedListener {

    @Extra
    int brandId;

    @Bean
    PhoneAdapter adapter;

    @ViewById
    ListView list_phone;

    @OptionsMenuItem
    MenuItem action_search_from_phone_list;

    @Pref
    UserPref_ userPref_;

    @AfterViews
    void bindAdapter() {
        list_phone.setAdapter(adapter);
        list_phone.setTextFilterEnabled(true);
        getPhonesAsync();
    }

    @Background
    void getPhonesAsync() {
        PhonesDB myPhoneDB = PhonesDB.getInstance();
        List<Phone> mPhoneList = myPhoneDB.getBrandById(brandId).getmPhoneList();
        updatePhones(mPhoneList);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        SearchView searchView = (SearchView) action_search_from_phone_list.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            private int count = 0;

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()) {
                    adapter.resetData();
                }
                if (s.length() < count) {
                    adapter.resetData();
                }
                count = s.length();
                adapter.getFilter().filter(s.toString());
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    @UiThread
    void updatePhones(List<Phone> phones) {
        adapter.updatePhones(phones);
    }

    @OptionsItem(R.id.action_bookmark_from_phone_list)
    void myMethod() {
        FavouritesActivity_.intent(this).start();
    }

    @OptionsItem(R.id.action_settings)
    void myMethod2() {
    }

    @OptionsItem(R.id.action_search_from_phone_list)
    void myMethod3() {
    }

    @Override
    public void onPositiveSelected(boolean positiveSelected, int phoneId) {
        if (positiveSelected) {
            String jsonData = userPref_.preferiti().get();
            JSONObject object = new JSONObject();
            JSONArray ar = new JSONArray();
            if (jsonData == "") {
                try {
                    ar.put(phoneId);
                    object.put("ciao", ar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    object = new JSONObject(jsonData);
                    ar = object.getJSONArray("ciao");

                    int[] numbers = new int[ar.length()];
                    for (int i = 0; i < ar.length(); ++i) {
                        numbers[i] = ar.optInt(i);
                    }
                    boolean isIn = false;
                    for (int n : numbers) {
                        if (n == phoneId) isIn = true;
                    }
                    if (isIn == false) ar.put(phoneId);

                    object.put("ciao", ar);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            userPref_.preferiti().put(object.toString());

        } else {
            Toast.makeText(getApplicationContext(), "no selected",
                    Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.vulpes.phoneadvisorwithaa.activities;

/**
 * Created by vulpes on 14/01/15.
 */

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.adapters.BrandAdapter;
import com.example.vulpes.phoneadvisorwithaa.models.Brand;
import com.example.vulpes.phoneadvisorwithaa.util.PhonesDB;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_brand)
@OptionsMenu(R.menu.menu_brand)
public class BrandActivity extends ActionBarActivity {

    @Extra
    int brandId;

    @Bean
    BrandAdapter adapter;

    @ViewById
    ListView list_brand;

    @AfterViews
    void bindAdapter() {
        list_brand.setAdapter(adapter);
        getBrandsAsync();
    }

    @Background
    void getBrandsAsync() {
        PhonesDB mPhoneDB = PhonesDB.getInstance();
        List<Brand> mBrandList = mPhoneDB.getAllBrand();
        updateBrands(mBrandList);
    }

    @UiThread
    void updateBrands(List<Brand> brands) {
        adapter.updateBrands(brands);
    }

    @OptionsItem(R.id.action_bookmark)
    void myMethod() {
        FavouritesActivity_.intent(this).start();
    }

    @OptionsItem
    void action_settings() {
    }
}

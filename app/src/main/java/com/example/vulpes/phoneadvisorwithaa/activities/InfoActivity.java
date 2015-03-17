package com.example.vulpes.phoneadvisorwithaa.activities;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.models.BrandInfo;
import com.example.vulpes.phoneadvisorwithaa.util.PhonesDB;
import com.example.vulpes.phoneadvisorwithaa.util.RestClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.activity_info)
@OptionsMenu(R.menu.menu_info)
public class InfoActivity extends ActionBarActivity {

    @ViewById
    TextView infotv;

    @Extra
    int brandId;

    @RestService
    RestClient restClient;

    @AfterViews
    void callGetInfo() {
        getInfo();
    }

    @Background
    void getInfo() {
        BrandInfo brandInfo = null;
        PhonesDB myPhoneDB = PhonesDB.getInstance();
        String brandName = myPhoneDB.getBrandById(brandId).getName();
        if (brandName == "Samsung") brandInfo = restClient.getSamsungBrandInfo();
        else if (brandName == "Sony") brandInfo = restClient.getSonyBrandInfo();
        else if (brandName == "Lg") brandInfo = restClient.getLgBrandInfo();
        else if (brandName == "Apple") brandInfo = restClient.getAppleBrandInfo();
        else if (brandName == "Nokia") brandInfo = restClient.getNokiaBrandInfo();
        else if (brandName == "Huawei") brandInfo = restClient.getHuaweiBrandInfo();
        else if (brandName == "Asus") brandInfo = restClient.getAsusBrandInfo();
        else if (brandName == "Htc") brandInfo = restClient.getHtcBrandInfo();
        else if (brandName == "Motorola") brandInfo = restClient.getMotorolaBrandInfo();

        if (brandInfo != null) updateInfo(brandInfo);
    }

    @UiThread
    void updateInfo(BrandInfo brandInfo) {
        infotv.setText(brandInfo.getInfo());
    }
}

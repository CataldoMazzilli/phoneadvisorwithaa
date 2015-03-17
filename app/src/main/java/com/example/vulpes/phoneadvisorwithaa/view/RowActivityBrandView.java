package com.example.vulpes.phoneadvisorwithaa.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.activities.InfoActivity_;
import com.example.vulpes.phoneadvisorwithaa.activities.PhoneListActivity_;
import com.example.vulpes.phoneadvisorwithaa.models.Brand;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

/**
 * Created by vulpes on 14/01/15.
 */
@EViewGroup(R.layout.view_row_activity_brand)
public class RowActivityBrandView extends RelativeLayout {
    @ViewById
    ImageView logo;

    @ViewById
    TextView brand_name;

    @ViewById
    RelativeLayout selector;

    private Brand brand;

    public RowActivityBrandView(Context context) {
        super(context);
    }

    public void bind(Brand brand) {
        this.brand = brand;

        logo.setImageResource(brand.getImg());
        brand_name.setText(brand.getName());
    }

    @Click(R.id.selector)
    public void click() {
        PhoneListActivity_.intent(getContext()).brandId(brand.getId()).start();
    }

    @LongClick(R.id.selector)
    public void longClick() {
        InfoActivity_.intent(getContext()).brandId(brand.getId()).start();
    }
}
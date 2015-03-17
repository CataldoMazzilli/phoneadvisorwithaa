package com.example.vulpes.phoneadvisorwithaa.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.vulpes.phoneadvisorwithaa.models.Brand;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityBrandView;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityBrandView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vulpes on 14/01/15.
 */

@EBean
public class BrandAdapter extends BaseAdapter {

    List<Brand> mBrandList = new ArrayList<Brand>();

    @RootContext
    Context context;

    public void updateBrands(List<Brand> brands) {
        this.mBrandList = brands;
        this.notifyDataSetInvalidated();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowActivityBrandView rowActivityBrandView;
        if (convertView == null) {
            rowActivityBrandView = RowActivityBrandView_.build(context);
        } else {
            rowActivityBrandView = (RowActivityBrandView) convertView;
        }
        rowActivityBrandView.bind(getItem(position));
        return rowActivityBrandView;
    }

    @Override
    public int getCount() {
        return mBrandList.size();
    }

    @Override
    public Brand getItem(int position) {
        return mBrandList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
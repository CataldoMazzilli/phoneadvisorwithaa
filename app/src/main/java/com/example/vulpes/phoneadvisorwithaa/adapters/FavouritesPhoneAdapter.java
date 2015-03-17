package com.example.vulpes.phoneadvisorwithaa.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.vulpes.phoneadvisorwithaa.models.Phone;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityFavouritesView;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityFavouritesView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vulpes on 21/01/15.
 */
@EBean
public class FavouritesPhoneAdapter extends BaseAdapter {

    List<Phone> mPhoneList = new ArrayList<>();

    @RootContext
    Context context;

    public void updatePhones(List<Phone> phones) {
        this.mPhoneList = phones;
        this.notifyDataSetInvalidated();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowActivityFavouritesView rowActivityFavouritesView;
        if (convertView == null) {
            rowActivityFavouritesView = RowActivityFavouritesView_.build(context);
        } else {
            rowActivityFavouritesView = (RowActivityFavouritesView) convertView;
        }
        rowActivityFavouritesView.bind(getItem(position));
        return rowActivityFavouritesView;
    }

    @Override
    public int getCount() {
        return mPhoneList.size();
    }

    @Override
    public Phone getItem(int position) {
        return mPhoneList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

package com.example.vulpes.phoneadvisorwithaa.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.vulpes.phoneadvisorwithaa.models.Phone;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityPhoneView;
import com.example.vulpes.phoneadvisorwithaa.view.RowActivityPhoneView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vulpes on 15/01/15.
 */
@EBean
public class PhoneAdapter extends BaseAdapter implements Filterable {

    List<Phone> mPhoneList = new ArrayList<>();
    private static List<Phone> origPhoneList;

    @RootContext
    Context context;

    private Filter phoneFilter;

    public void updatePhones(List<Phone> phones) {
        this.mPhoneList = phones;
        if (origPhoneList == null) origPhoneList = phones;
        this.notifyDataSetInvalidated();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowActivityPhoneView rowActivityPhoneView;
        if (convertView == null) rowActivityPhoneView = RowActivityPhoneView_.build(context);
        else rowActivityPhoneView = (RowActivityPhoneView) convertView;

        rowActivityPhoneView.bind(getItem(position));
        return rowActivityPhoneView;
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

    public void resetData() {
        mPhoneList = origPhoneList;
    }

    @Override
    public Filter getFilter() {
        if (phoneFilter == null) phoneFilter = new PhoneFilter();
        return phoneFilter;
    }

    private class PhoneFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {
                results.values = origPhoneList;
                results.count = origPhoneList.size();
            } else {
                ArrayList<Phone> nPhoneList = new ArrayList<Phone>();

                for (Phone p : mPhoneList) {
                    if (p.getName().toLowerCase().contains(constraint.toString().toLowerCase()))
                        nPhoneList.add(p);
                }
                results.values = nPhoneList;
                results.count = nPhoneList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                mPhoneList = (ArrayList<Phone>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}
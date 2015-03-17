package com.example.vulpes.phoneadvisorwithaa.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vulpes.phoneadvisorwithaa.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.TextChange;

/**
 * Created by vulpes on 15/01/15.
 */
@EViewGroup(R.layout.search_layout)
public class SearchLayoutView extends LinearLayout {

    // Container Activity must implement this interface
    public interface OnTextChangedListener {
        public void onTextChanged(CharSequence s, TextView txt_search, int before, int start, int count);
    }

    OnTextChangedListener mListener;

    public SearchLayoutView(Context context) {
        super(context);
    }

    @AfterViews
    void setmListener() {
        mListener = (OnTextChangedListener) getContext();
    }

    @TextChange(R.id.txt_search)
    void onTextChangesOnTxtSearchEditText(CharSequence s, TextView txt_search, int before, int start, int count) {
        mListener.onTextChanged(s, txt_search, before, start, count);
    }
}
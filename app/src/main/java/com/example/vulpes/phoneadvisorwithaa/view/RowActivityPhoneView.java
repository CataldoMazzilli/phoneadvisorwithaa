package com.example.vulpes.phoneadvisorwithaa.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.fragments.MyDialogFragment;
import com.example.vulpes.phoneadvisorwithaa.models.Phone;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by vulpes on 15/01/15.
 */
@EViewGroup(R.layout.view_row_activity_phone)
public class RowActivityPhoneView extends RelativeLayout {
    @ViewById
    ImageView img_row_activity_phone;

    @ViewById
    TextView description_row_activity_phone;

    @ViewById
    RelativeLayout selector;

    private Phone phone;

    public RowActivityPhoneView(Context context) {
        super(context);
    }

    public void bind(Phone phone) {
        this.phone = phone;

        img_row_activity_phone.setImageResource(phone.getImg());
        description_row_activity_phone.setText(phone.getName());
    }

    @Click(R.id.selector)
    public void click() {
        //lancia Dialog
        MyDialogFragment dialog = new MyDialogFragment();

        Bundle args = new Bundle();
        args.putInt("phoneId", phone.getId());
        args.putString("fragTitle", "Add to favourites?");
        dialog.setArguments(args);
        dialog.show(((Activity) getContext()).getFragmentManager(), "firstDialog");
    }
}
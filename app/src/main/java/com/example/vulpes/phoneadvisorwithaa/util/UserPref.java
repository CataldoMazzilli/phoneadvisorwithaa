package com.example.vulpes.phoneadvisorwithaa.util;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by vulpes on 20/01/15.
 */
@SharedPref(SharedPref.Scope.APPLICATION_DEFAULT)
public interface UserPref {

    @DefaultString("")
    String preferiti();
}

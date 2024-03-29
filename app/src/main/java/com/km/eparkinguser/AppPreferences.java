package com.km.eparkinguser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mirza Ahmed Baig on 2019-09-25.
 * Avantari Technologies
 * mirza@avantari.org
 */
class AppPreferences {
    private SharedPreferences _sharedPrefs;
    private SharedPreferences.Editor _prefsEditor;

    private String APP_SHARED_PREFS = "com.km.eparkinguser.preferences";
    private String USER_DETAILS = APP_SHARED_PREFS + ".userdetails";

    AppPreferences(Context context) {
        this._sharedPrefs = context.getSharedPreferences(
                APP_SHARED_PREFS,
                Activity.MODE_PRIVATE
        );
        this._prefsEditor = _sharedPrefs.edit();
        this._prefsEditor.apply();
    }

    String getUserDetails() {
        return _sharedPrefs.getString(USER_DETAILS, null);
    }

    /**
     * User details input format should follow username,email,bikename,licencenumber
     */
    void setUserDetails(String userDetails) {
        _prefsEditor.putString(USER_DETAILS, userDetails);
        _prefsEditor.commit();
    }
}

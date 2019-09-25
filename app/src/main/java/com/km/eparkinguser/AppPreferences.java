package com.km.eparkinguser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mirza Ahmed Baig on 2019-09-25.
 * Avantari Technologies
 * mirza@avantari.org
 */
public class AppPreferences {
    private Context context;
    private SharedPreferences _sharedPrefs;
    private SharedPreferences.Editor _prefsEditor;

    private String APP_SHARED_PREFS = "com.km.eparkinguser.preferences";
    private String USER_DETAILS = APP_SHARED_PREFS + ".userdetails";

    public AppPreferences(Context context) {
        this.context = context;
        this._sharedPrefs = context.getSharedPreferences(
                APP_SHARED_PREFS,
                Activity.MODE_PRIVATE
        );
        this._prefsEditor = _sharedPrefs.edit();
        this._prefsEditor.apply();
    }

    /**
     * User details input format should follow username,email,bikename,licencenumber
     */
    public void setUserDetails(String userDetails) {
        _prefsEditor.putString(USER_DETAILS, userDetails);
        _prefsEditor.commit();
    }

    public String getUserDetails() {
        return _sharedPrefs.getString(USER_DETAILS, null);
    }
}

package com.codegama.weatherforcast.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.codegama.weatherforcast.di.annotation.ApplicationContext;
import com.codegama.weatherforcast.di.annotation.PreferenceInfo;

import javax.inject.Inject;

public class AppPrefManager implements PrefManager {

    private static final String PREF_KEY_PROFILE_NAME = "profileName";
    private static final String PREF_KEY_PROFILE_EMAIL = "profileEmail";
    private static final String PREF_KEY_PROFILE_PIC = "profilePic";

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    @Inject
    AppPrefManager(@ApplicationContext Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getProfileName() {
        return mPrefs.getString(PREF_KEY_PROFILE_NAME, "");
    }

    @Override
    public String getProfileEmail() {
        return mPrefs.getString(PREF_KEY_PROFILE_EMAIL, "");
    }

    @Override
    public String getProfilePic() {
        return mPrefs.getString(PREF_KEY_PROFILE_PIC, "");
    }

    @Override
    public String getName() {
        return mPrefs.getString(PREF_KEY_PROFILE_PIC, "");
    }

}

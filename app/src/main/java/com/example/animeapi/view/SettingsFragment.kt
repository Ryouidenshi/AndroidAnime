package com.example.animeapi.view

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceFragmentCompat
import com.example.animeapi.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val sp = PreferenceManager.getDefaultSharedPreferences(activity)
        sp.registerOnSharedPreferenceChangeListener{ _, _ ->
            val useDarkTheme = sp.getBoolean("use_dark_theme", false)
            AppCompatDelegate.setDefaultNightMode(
                if (useDarkTheme) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }
}
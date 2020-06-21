package com.codegama.weatherforcast.data;


import com.codegama.weatherforcast.data.api.ApiManager;
import com.codegama.weatherforcast.data.db.DbManager;
import com.codegama.weatherforcast.data.pref.PrefManager;

public interface DataManager extends DbManager, ApiManager, PrefManager {

}

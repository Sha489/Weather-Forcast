package com.codegama.weatherforcast.util;


import com.codegama.weatherforcast.BuildConfig;
import com.codegama.weatherforcast.R;

public final class AppConstants {

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final String PREF_NAME = BuildConfig.APPLICATION_ID;
    public static final String DB_NAME = "foodieHubDb";
    public static final long LOCATION_INTERVAL = 5000;
    public static final long FASTEST_LOCATION_INTERVAL = 3000;

    public class Params{

        public static final String LATITUDE = "lat";
        public static final String LONGITUDE = "lon";
        public static final String USER_KEY = "user-key";
        public static final String QUERY = "query";
        public static final String RESTAURANT_ID = "res_id";
        public static final String Q = "q";
        public static final String CITY = "city";
        public static final String STREET = "street";
        public static final String COUNT = "count";
        public static final String START = "start";
        public static final String WEATHER = "weather";


        private Params(){

        }

    }

    private AppConstants() {
    }

    public class ShowCaseUseCases {
        public static final String SPIN_BUTTON = "spin_button";
    }

    public class DI {
        public static final String LAYOUT_MANAGER_VERTICAL = "LAYOUT_MANAGER_VERTICAL";
        public static final String LAYOUT_MANAGER_HORIZONTAL = "LAYOUT_MANAGER_HORIZONTAL";
        public static final String HOME_MENU_ITEMS = "MENU_ITEMS_HOME";
        public static final String MORE_FRAGMENT_OPTIONS = "MORE_FRAGMENT_OPTIONS";
    }

    public class Urls {
        public static final String BASE_URL = "https://api.openweathermap.org";

        public static final String HELP = "https://google.com";
        public static final String ABOUT = "https://google.com";
        public static final String TERMS = "https://google.com";
        public static final String LEGALITY = "https://google.com";
        public static final String PRIVACY = "https://google.com";
    }
}

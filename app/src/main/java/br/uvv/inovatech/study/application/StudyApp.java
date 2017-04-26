package br.uvv.inovatech.study.application;

import android.app.Application;

import com.google.gson.Gson;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class StudyApp extends Application {
    public static final Gson GSON = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
    }

}

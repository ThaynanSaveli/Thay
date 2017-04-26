package br.uvv.inovatech.study.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.uvv.inovatech.study.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void onEnterAppButtonClicked(View view){
        Intent intent = new Intent(this, BuscarGrupoActivity.class);
        startActivity(intent);
    }

}

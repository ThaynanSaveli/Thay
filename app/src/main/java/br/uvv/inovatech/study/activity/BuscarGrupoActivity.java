package br.uvv.inovatech.study.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.uvv.inovatech.study.R;
import br.uvv.inovatech.study.adapter.GrupoEstudoRecyclerAdapter;
import br.uvv.inovatech.study.object.Disciplina;
import br.uvv.inovatech.study.object.GrupoEstudo;

public class BuscarGrupoActivity extends BaseActivity implements GrupoEstudoRecyclerAdapter.ItemClickListener {
    private static final String GRUPO_ESTUDO_LISTA_STATE_TAG = ".GRUPO_ESTUDO_LISTA_TAG";
    private static final String LINEAR_LAYOUT_MANAGER_STATE_TAG = ".LINEAR_LAYOUT_MANAGER_TAG";

    private RecyclerView mGrupoEstudoRecyView;
    private GrupoEstudoRecyclerAdapter mGrupoEstudoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_grupo);

        if(savedInstanceState == null){
            configureRecyclerView(new ArrayList<GrupoEstudo>(), new LinearLayoutManager(this));
        }

        configureActionBar();
    }

    private void configureActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_buscar_grupo, menu);
        menu.findItem(R.id.item_filtro_busca).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_filter)
                        .colorRes(android.R.color.white)
                        .actionBarSize());
        return true;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        List<GrupoEstudo> list = new ArrayList<>();
        if(savedInstanceState.containsKey(GRUPO_ESTUDO_LISTA_STATE_TAG)){
            list = (List<GrupoEstudo>) savedInstanceState.getSerializable(GRUPO_ESTUDO_LISTA_STATE_TAG);
        }
        if(savedInstanceState.containsKey(LINEAR_LAYOUT_MANAGER_STATE_TAG)){
            llm.onRestoreInstanceState(savedInstanceState.getParcelable(LINEAR_LAYOUT_MANAGER_STATE_TAG));
        }
        configureRecyclerView(list, llm);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(GRUPO_ESTUDO_LISTA_STATE_TAG,
                (Serializable) mGrupoEstudoAdapter.getGruposEstudos());
        outState.putParcelable(LINEAR_LAYOUT_MANAGER_STATE_TAG,
                mGrupoEstudoRecyView.getLayoutManager().onSaveInstanceState());
    }

    private void configureRecyclerView(List<GrupoEstudo> gruposEstudos, LinearLayoutManager llm){
        mGrupoEstudoAdapter = new GrupoEstudoRecyclerAdapter(gruposEstudos, this);
        mGrupoEstudoRecyView = (RecyclerView) findViewById(R.id.recyclerview_grupo_estudo);
        mGrupoEstudoRecyView.setLayoutManager(llm);
        mGrupoEstudoRecyView.setAdapter(mGrupoEstudoAdapter);
    }

    public void OnFiltroMenuItemClicked(MenuItem item){
        //TODO
    }

    public void OnReorderMenuItemClicked(MenuItem item){
        //TODO
    }

    @Override
    public void OnItemClicked(GrupoEstudo grupoEstudo) {
        //TODO goto detail page
    }
}

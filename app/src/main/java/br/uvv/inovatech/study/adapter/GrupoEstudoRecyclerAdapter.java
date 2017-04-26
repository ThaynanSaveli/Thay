package br.uvv.inovatech.study.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.uvv.inovatech.study.R;
import br.uvv.inovatech.study.object.GrupoEstudo;
import br.uvv.inovatech.study.util.DateUtils;

public class GrupoEstudoRecyclerAdapter extends RecyclerView.Adapter<GrupoEstudoRecyclerAdapter.GrupoEstudoViewHolder>{
    private List<GrupoEstudo> mGruposEstudos;
    private ItemClickListener mItemClick;

    public GrupoEstudoRecyclerAdapter(List<GrupoEstudo> gruposEstudos){
        mGruposEstudos = gruposEstudos;
        mItemClick = null;
    }

    public GrupoEstudoRecyclerAdapter(List<GrupoEstudo> gruposEstudos, ItemClickListener itemClick){
        mGruposEstudos = gruposEstudos;
        mItemClick = itemClick;
    }

    @Override
    public GrupoEstudoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_grupo_estudo, parent, false);
        return new GrupoEstudoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GrupoEstudoViewHolder holder, final int position) {
        GrupoEstudo grupoEstudo = mGruposEstudos.get(position);
        holder.nomeGrupo.setText(grupoEstudo.nome);
        if(grupoEstudo.quando != null){
            holder.dataHoraGrupo.setText(DateUtils.formatDateToString(grupoEstudo.quando, DateUtils.DATE_FORMAT_DDMMYYY_HHMM));
        }
        if(grupoEstudo.disciplina != null){
            holder.disciplina.setText(grupoEstudo.disciplina.nome);
        }

        holder.cardWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClick != null){
                    mItemClick.OnItemClicked(mGruposEstudos.get(position));
                }
            }
        });
    }

    public List<GrupoEstudo> getGruposEstudos(){
        return mGruposEstudos;
    }

    @Override
    public int getItemCount() {
        return mGruposEstudos.size();
    }

    public class GrupoEstudoViewHolder extends RecyclerView.ViewHolder{
        public CardView cardWrapper;
        public TextView nomeGrupo;
        public TextView disciplina;
        public TextView dataHoraGrupo;

        public GrupoEstudoViewHolder(View itemView) {
            super(itemView);
            cardWrapper = (CardView) itemView.findViewById(R.id.wrapper_grupo_estudo);
            nomeGrupo = (TextView) itemView.findViewById(R.id.nome_grupo_estudo);
            disciplina = (TextView) itemView.findViewById(R.id.disciplina_estudar);
            dataHoraGrupo = (TextView) itemView.findViewById(R.id.data_hora_grupo);
        }
    }

    public interface ItemClickListener{
        void OnItemClicked(GrupoEstudo grupoEstudo);
    }
}

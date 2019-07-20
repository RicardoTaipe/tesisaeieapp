package com.example.tesisaeie.notifications;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tesisaeie.R;

import java.util.ArrayList;
import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioHolder> {
    private List<Anuncio> anuncios;
    private Context context;
    private OnItemClickListener listener;

    interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public AnuncioAdapter(List<Anuncio> anuncios, Context contextr) {
        this.anuncios = anuncios;
        this.context = context;
    }

    public void changeData(List<Anuncio> anunciosRemote){
        if(anunciosRemote == null){
            anuncios = new ArrayList<>(0);
        }else{
            anuncios = anunciosRemote;
        }
        notifyDataSetChanged();
    }

    public OnItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnuncioAdapter.AnuncioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.anuncio_item,viewGroup,false);
        return new AnuncioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioAdapter.AnuncioHolder anuncioHolder, int i) {
        anuncioHolder.title.setText(anuncios.get(i).getTitle());
        anuncioHolder.date.setText(" Publicado: "+ anuncios.get(i).getFormatedDate());
    }

    @Override
    public int getItemCount() {
        if(anuncios.size()>0){
            return anuncios.size();
        }
        return 0;
    }

    public class AnuncioHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,description, date;

        public AnuncioHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v,getAdapterPosition());
        }
    }
}

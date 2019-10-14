package com.example.tesisaeie.lockers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tesisaeie.R;

import java.util.List;

public class LockerAdapter extends RecyclerView.Adapter<LockerAdapter.LockerHolder> {
    private List<Locker> lockers;
    private Context context;

    public LockerAdapter(List<Locker> lockers, Context context) {
        this.lockers = lockers;
        this.context = context;
    }


    @NonNull
    @Override
    public LockerAdapter.LockerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.locker_item, viewGroup,false);
        return new LockerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LockerAdapter.LockerHolder lockerHolder, int position) {
        lockerHolder.description.setText(lockers.get(position).getDescription());
        if(lockers.get(position).getFree()){
            lockerHolder.free.setText("LIBRE");
            lockerHolder.freeImg.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock,0,0,0);
        }else{
            lockerHolder.free.setText("OCUPADO");
            lockerHolder.freeImg.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock,0,0,0);
        }
    }

    @Override
    public int getItemCount() {
        if(lockers.size()>0){
            return lockers.size();
        }
        return 0;
    }

    public class LockerHolder extends RecyclerView.ViewHolder {
        TextView description,free,freeImg;

        public LockerHolder(@NonNull View itemView) {
            super(itemView);
            description=(TextView) itemView.findViewById(R.id.description);
            free=(TextView) itemView.findViewById(R.id.free);
            freeImg=(TextView) itemView.findViewById(R.id.freeImg);
        }
    }
}

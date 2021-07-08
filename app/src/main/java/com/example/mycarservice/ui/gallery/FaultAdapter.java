package com.example.mycarservice.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarservice.R;
import com.example.mycarservice.database.FaultCodes;
import com.example.mycarservice.database.Note;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FaultAdapter extends RecyclerView.Adapter<FaultAdapter.FaultHolder> {
    private List<FaultCodes> notes = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public FaultHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.fault_item,parent,false);

        return new FaultHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FaultHolder holder, int position) {
        FaultCodes current = notes.get(position);
        holder.textViewMilauge.setText(current.getMILAUGE());
        holder.textMalfunction.setText(current.getFAULT_CODES());
        holder.textViewDate.setText(current.getDATE_FROM());
        holder.textViewMalfunctionDescription.setText(current.getFIX_FAULT());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public void setNotes(List<FaultCodes> note) {
        this.notes = note;
        notifyDataSetChanged();


    }

    class FaultHolder extends RecyclerView.ViewHolder {
        private TextView textViewIncuuranceprov;
        private TextView textViewMilauge;
        private TextView textMalfunction;
        private TextView textViewCar_make;
        private TextView textViewDate;
        private TextView textViewFaultCodes;
        private TextView textViewMalfunctionDescription;
        private TextView textViewFixFault;

        private TextView textViewDateTo;

        ;


        public FaultHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewMilauge = itemView.findViewById(R.id.text_slideshow1);
            textMalfunction = itemView.findViewById(R.id.text_description);
            textViewDate = itemView.findViewById(R.id.text_Date);
            textViewMalfunctionDescription = itemView.findViewById(R.id.text_Description);

        }
    }


}

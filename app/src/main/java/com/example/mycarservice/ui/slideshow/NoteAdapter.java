package com.example.mycarservice.ui.slideshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarservice.R;
import com.example.mycarservice.database.Note;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();


    @NonNull
    @NotNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);


        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteHolder holder, int position) {
        Note current = notes.get(position);
        holder.textViewMilauge.setText(current.getMILAUGE());
        holder.textViewServiceShop.setText(current.getSERVICE_SHOP());
        holder.textViewKindOfService.setText(current.getKIND_SERVICE());
        holder.textViewDate.setText(current.getDATE_FROM());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> note) {
        this.notes = note;
        notifyDataSetChanged();


    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewIncuuranceprov;
        private TextView textViewMilauge;
        private TextView textViewServiceShop;
        private TextView textViewCar_make;
        private TextView textViewDate;
        private TextView textViewFaultCodes;
        private TextView textViewKindOfService;
        private TextView textViewFixFault;

        private TextView textViewDateTo;

        ;


        public NoteHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewMilauge = itemView.findViewById(R.id.text_slideshow1);
            textViewServiceShop = itemView.findViewById(R.id.text_description);
            textViewDate=itemView.findViewById(R.id.text_Date);
            textViewKindOfService=itemView.findViewById(R.id.text_Description);

        }
    }


}

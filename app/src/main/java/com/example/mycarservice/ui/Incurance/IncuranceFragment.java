package com.example.mycarservice.ui.Incurance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.mycarservice.database.Note;
import com.example.mycarservice.databinding.FragmentIncuranceBinding;


public class IncuranceFragment extends Fragment {

    private IncuranceViewModel homeViewModel;
    private FragmentIncuranceBinding binding;
    FragmentManager fragManager;

    private EditText textMilauge;
    private EditText textDate;
    private EditText text_view_what;
    private EditText textKind;
    private ImageButton save;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(IncuranceViewModel.class);

        binding = FragmentIncuranceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textMilauge=binding.dateFrom;
        textDate=binding.dateto;

        textKind=binding.Incurancekind;
       // save=binding.buttonsave;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();

            }
        });


        return root;
    }

    private void saveNote() {
        String Milauge = textMilauge.getText().toString();
        String textdate = textDate.getText().toString();
        String textservicehop = textserviceshop.getText().toString();
        String textkind = textKind.getText().toString();
        Note note = new Note("", "textservicehop", ":", "", textdate, "", "textkind", "", 1);
        homeViewModel.insert(note);


        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
    }


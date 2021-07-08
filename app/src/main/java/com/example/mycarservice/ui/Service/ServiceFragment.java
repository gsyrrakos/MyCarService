package com.example.mycarservice.ui.Service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.mycarservice.database.Note;
import com.example.mycarservice.databinding.FragmentServiceBinding;


public class ServiceFragment extends Fragment {
    private ServiceViewModel viewModel;
    private FragmentServiceBinding binding;
    private EditText textMilauge;
    private EditText textDate;
    private EditText textserviceshop;
    private EditText textKind;
    private ImageButton save;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                new ViewModelProvider(this).get(ServiceViewModel.class);

        binding = FragmentServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textMilauge=binding.dateFrom;
        textDate=binding.dateto;
        textserviceshop=binding.serviceshop;
        textKind=binding.Incurancekind;
        save=binding.buttonsave;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();

            }
        });




        return root;
    }


    private void saveNote(){
        String Milauge=textMilauge.getText().toString();
        String textdate=textDate.getText().toString();
        String textservicehop=textserviceshop.getText().toString();
        String textkind=textKind.getText().toString();
        Note note=new Note(textservicehop,Milauge,textdate,textkind,1);
        viewModel.insert(note);







    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

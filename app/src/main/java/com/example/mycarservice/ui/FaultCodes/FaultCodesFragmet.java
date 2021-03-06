package com.example.mycarservice.ui.FaultCodes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycarservice.database.FaultCodes;
import com.example.mycarservice.database.Note;
import com.example.mycarservice.databinding.FragmentFaultcodesBinding;


public class FaultCodesFragmet extends Fragment {
    private FaultCodeViewMOdel viewMOdel;
    private FragmentFaultcodesBinding binding;

    private EditText textMilauge;
    private EditText textDate;
    private EditText textserviceshop;
    private EditText textKind;
    private ImageButton save;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewMOdel =
                new ViewModelProvider(this).get(FaultCodeViewMOdel.class);

        binding = FragmentFaultcodesBinding.inflate(inflater, container, false);
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
        FaultCodes note=new FaultCodes(Milauge,textdate,textservicehop,textkind,1);
        viewMOdel.insert(note);







    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

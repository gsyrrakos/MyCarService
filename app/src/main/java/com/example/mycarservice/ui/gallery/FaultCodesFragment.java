package com.example.mycarservice.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarservice.database.FaultCodes;
import com.example.mycarservice.databinding.FragmentGalleryBinding;

import java.util.List;

public class FaultCodesFragment extends Fragment {

    private FaultCodesRecycleView galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(FaultCodesRecycleView.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView =binding.recycleView;
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setHasFixedSize(true);
        FaultAdapter adapter =new FaultAdapter();
        recyclerView.setAdapter(adapter);


        galleryViewModel.getAllFaults().observe(getViewLifecycleOwner(), new Observer<List<FaultCodes>>() {
            @Override
            public void onChanged(List<FaultCodes> notes) {
                //update recuclerView
                adapter.setNotes(notes);
                Toast.makeText(root.getContext(),"edw",Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.mycarservice.ui.gallery;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycarservice.database.FaultCodes;
import com.example.mycarservice.database.Note;
import com.example.mycarservice.database.NoteRepository;

import java.util.List;

public class FaultCodesRecycleView extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private LiveData<List<FaultCodes>> notes;
    private NoteRepository repository;
    public FaultCodesRecycleView(Application app) {
        super(app);
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        repository=new NoteRepository(app);
        notes=repository.getAllFaults();
    }


    public LiveData<List<FaultCodes>> getAllFaults(){
        return notes;
    }




    public void insert(FaultCodes note){
        repository.insert(note);
    }
    public void update(FaultCodes note){
        repository.update(note);
    }


    public LiveData<String> getText() {
        return mText;
    }
}
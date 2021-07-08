package com.example.mycarservice.ui.FaultCodes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycarservice.database.Note;
import com.example.mycarservice.database.NoteRepository;

import java.util.List;

public class FaultCodeViewMOdel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public FaultCodeViewMOdel(Application application) {
        super(application);

        mText = new MutableLiveData<>();
        repository=new NoteRepository(application);
        allNotes=repository.getAllNotes();
        //mText.setValue("This is slideshow fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> setText() {

        mText.postValue("This is mine job fragment");
        return mText;

    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }




    public void insert(Note note){
        repository.insert(note);
    }
    public void update(Note note){
        repository.update(note);
    }
    public void delete(Note note){
        repository.delete(note);
    }
}

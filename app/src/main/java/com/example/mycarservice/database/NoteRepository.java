package com.example.mycarservice.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private LiveData<List<FaultCodes>> allFaults;


    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();

        allNotes = noteDao.getAllNotes();
        allFaults = noteDao.getAllFaults();


    }

    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);

    }

    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);

    }

    public void deleteAllNotes() {
        new DeleteAllNoteAsyncTask(noteDao).execute();

    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;

    }


    public void insert(FaultCodes note) {
        new InsertFaultAsyncTask(noteDao).execute(note);

    }

    public void update(FaultCodes note) {

        new UpdateFaultCodesAsyncTask(noteDao).execute(note);
    }

    public void delete(FaultCodes note) {
        new DeleteFaultCodesAsyncTask(noteDao).execute(note);

    }

    public void deleteAllFaults() {
        new DeleteAllFaultCodesAsyncTask(noteDao).execute();

    }

    public LiveData<List<FaultCodes>> getAllFaults() {
        return allFaults;

    }


    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }


    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }


    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }


    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private DeleteAllNoteAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }


    private static class InsertFaultAsyncTask extends AsyncTask<FaultCodes, Void, Void> {
        private NoteDao noteDao;

        private InsertFaultAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(FaultCodes... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }


    private static class UpdateFaultCodesAsyncTask extends AsyncTask<FaultCodes, Void, Void> {
        private NoteDao noteDao;

        private UpdateFaultCodesAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(FaultCodes... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }


    private static class DeleteFaultCodesAsyncTask extends AsyncTask<FaultCodes, Void, Void> {
        private NoteDao noteDao;

        private DeleteFaultCodesAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(FaultCodes... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }


    private static class DeleteAllFaultCodesAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private DeleteAllFaultCodesAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllFaults();
            return null;
        }
    }


}

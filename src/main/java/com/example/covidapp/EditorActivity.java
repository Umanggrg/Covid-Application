package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class EditorActivity extends AppCompatActivity {
    EditText edtNote;
    int nodeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        edtNote = findViewById(R.id.edtNote);

        nodeId = this.getIntent().getIntExtra("noteId",-1);

        if (nodeId != -1) {
            edtNote.setText(notes.mNotes.get(nodeId).toString());
        } else {

            notes.mNotes.add("");
            nodeId = notes.mNotes.size() - 1;
            notes.mAdapterNote.notifyDataSetChanged();
        }

        edtNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                notes.mNotes.set(nodeId, String.valueOf(s));
                notes.mAdapterNote.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getSharedPreferences
                        (getPackageName(),MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(notes.mNotes);

                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
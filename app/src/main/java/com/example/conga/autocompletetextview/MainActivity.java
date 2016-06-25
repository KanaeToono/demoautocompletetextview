package com.example.conga.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    private static String TAG = MainActivity.class.getSimpleName();
    private TextView mTextViewSelection;
    private MultiAutoCompleteTextView mAutoCompleteTextView;
    String arr[] ={"cat", "dog" , "apple", "android", "blackberry", "dong ho", "sunday"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addEvents();
    }

    private void initViews() {
        mTextViewSelection = (TextView) findViewById(R.id.selectionTextView);
        mAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.editAuto);

    }

    private void addEvents() {
        mAutoCompleteTextView.addTextChangedListener(this);
        mAutoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr));
        mAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
mTextViewSelection.setText(mAutoCompleteTextView.getText());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

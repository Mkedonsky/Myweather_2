package ru.mkedonsky.myweather;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    private TextView textView,textView4;
    private Switch switch1;
    private RecyclerView recyclerView;
    private String[] listData = new String[] {" Monday +6°"," Tuesday +8°", " Wednesday +8°",
            " Thursday +5°", " Friday +8°", " Saturday +8°", " Sunday +8°"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        setTextFromSecondActivity();
        switchOffTheme();
        initRecyclerView();
        initSeparator();


    }

    private void initViews() {
        textView = findViewById(R.id.textView);
        textView4 = findViewById(R.id.textView4);
        switch1 = findViewById(R.id.switch1);


    }

    private void setTextFromSecondActivity() {
        String text = getIntent().getStringExtra(MainActivity.DATA_KEY);
        textView.setText(text);

    }
    private void switchOffTheme(){
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { String text;
                    if(isChecked) { text = getString(R.string._5);
                    }
                    else { text = getString(R.string._F);
                        }

                    textView4.setText(text);
                    }
                });
    }


    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerDataAdapter adapter = new RecyclerDataAdapter(listData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initSeparator(){
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.separator)));
        recyclerView.addItemDecoration(itemDecoration);

    }

}

package com.perusudroid.recyclermanualscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IListener {

    private RecyclerView recyclerView;
    private List<SampleData> sampleData;
    private SampleAdapter sampleAdapter;
    private CustomLinearLayoutManager layoutManager;
    int moveBy = 0;
    private ImageView ivSelectedPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivSelectedPic = findViewById(R.id.ivSelectedPic);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager
                = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setScrollEnabled(false);
        recyclerView.setLayoutManager(layoutManager);

        sampleData = new ArrayList<>();

        sampleData.add(new SampleData(R.drawable.a));
        sampleData.add(new SampleData(R.drawable.b));
        sampleData.add(new SampleData(R.drawable.c));
        sampleData.add(new SampleData(R.drawable.d));
        sampleData.add(new SampleData(R.drawable.e));
        sampleData.add(new SampleData(R.drawable.f));
        sampleData.add(new SampleData(R.drawable.g));
        sampleData.add(new SampleData(R.drawable.h));
        sampleData.add(new SampleData(R.drawable.i));
        sampleData.add(new SampleData(R.drawable.j));

        sampleAdapter = new SampleAdapter(sampleData, this);
        recyclerView.setAdapter(sampleAdapter);

    }

    public void scrollRecyclerView(View view) {
        switch (view.getId()) {
            case R.id.btnPreviuos:
                if (moveBy < 2) {
                    moveBy = moveBy + 1;
                }
                moveBy = moveBy - 1;
                layoutManager.scrollToPosition(moveBy);
                showPos();
                break;
            case R.id.btnNext:
                if (moveBy < 9) {
                    moveBy = moveBy + 3;
                    layoutManager.scrollToPosition(moveBy);
                    showPos();
                }
                break;
        }
    }

    private void showPos() {
        Toast.makeText(this, "Showing position " + moveBy, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(int position, Object data) {
        ivSelectedPic.setImageResource(((SampleData) data).getPic());
    }
}

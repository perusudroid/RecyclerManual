package com.perusudroid.recyclermanualscroll;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    private List<SampleData> sampleDataList;
    private IListener iListener;

    public SampleAdapter(List<SampleData> sampleDataList, IListener iListener) {
        this.sampleDataList = sampleDataList;
        this.iListener = iListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_shree, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SampleData sampleData = sampleDataList.get(position);
        holder.bindData(sampleData);
    }

    @Override
    public int getItemCount() {
        return sampleDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivPic;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.ivPic);
            ivPic.setOnClickListener(this);
        }

        public void bindData(SampleData sampleData) {
            itemView.setTag(sampleData);
            ivPic.setImageResource(sampleData.getPic());
        }

        @Override
        public void onClick(View view) {
            if (iListener != null) {
                iListener.onClick(getAdapterPosition(), itemView.getTag());
            }
        }
    }
}

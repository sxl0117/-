package com.example.day_10_31.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day_10_31.R;
import com.example.day_10_31.bean.TuiBean;

import java.util.ArrayList;
import java.util.List;

public class TuiAdapter extends RecyclerView.Adapter {
    private List<TuiBean.DataBeanX.DataBean> data = new ArrayList<>();
    private Context context;

    public TuiAdapter(Context context) {
        this.context = context;
    }

    public void addItem(List<TuiBean.DataBeanX.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tui, parent,false);
        return new Tui(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Tui tui = (Tui) holder;
        tui.textView.setText(data.get(position).getTitle());
        tui.textView.setText(data.get(position).getTitle());
        Glide.with(context).load(data.get(position).getBackground()).into(tui.imageView);
        //tui.button.setText(data.get(position).getEnterNum());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class Tui extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView title;
        private Button button;
        public Tui(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_tui);
            textView = view.findViewById(R.id.text_tui);
            title = view.findViewById(R.id.title_tui);
            button = view.findViewById(R.id.btn_tui);
        }
    }
}

package com.example.day_10_31.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_10_31.R;
import com.example.day_10_31.bean.TextBean;

import java.util.ArrayList;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter {
    private List<TextBean.DataBeanX.DataBean> data = new ArrayList<>();
    private Context context;

    public TextAdapter(Context context) {
        this.context = context;
    }

    public void addItem(List<TextBean.DataBeanX.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text, parent, false);
        return new Text_T(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Text_T t = (Text_T) holder;
        t.textView.setText(data.get(position).getAuthor().getName());
        t.title.setText(data.get(position).getFeeds_text()+"");
        Glide.with(context).load(data.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(t.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class Text_T extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView title;

        public Text_T(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_text);
            textView = view.findViewById(R.id.text_text);
            title = view.findViewById(R.id.title_text);
        }
    }
}

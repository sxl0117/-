package com.example.day_10_31.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_10_31.R;
import com.example.day_10_31.bean.TwoShiBean;

import java.util.ArrayList;
import java.util.List;

public class TuAdapter extends RecyclerView.Adapter {
    private List<TwoShiBean.DataBeanX.DataBean> data = new ArrayList<>();
    private Context context;

    public TuAdapter(Context context) {
        this.context = context;
    }

    public void addItem(List<TwoShiBean.DataBeanX.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_tu.setText(data.get(position).getAuthor().getName());
        Glide.with(context).load(data.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.img_tu);
        Glide.with(context).load(data.get(position).getCover()).into(viewHolder.vv_tu);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_tu;
        public TextView text_tu;
        public ImageView vv_tu;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_tu = (ImageView) rootView.findViewById(R.id.img_tu);
            this.text_tu = (TextView) rootView.findViewById(R.id.text_tu);
            this.vv_tu = (ImageView) rootView.findViewById(R.id.vv_tu);
        }

    }
}

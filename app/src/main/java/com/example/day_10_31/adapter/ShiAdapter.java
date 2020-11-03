package com.example.day_10_31.adapter;

import android.content.Context;
import android.net.Uri;
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
import com.example.day_10_31.bean.ShiBean;

import java.util.ArrayList;
import java.util.List;

public class ShiAdapter extends RecyclerView.Adapter {
    private List<ShiBean.DataBeanX.DataBean> data = new ArrayList<>();
    private Context context;

    public ShiAdapter(Context context) {
        this.context = context;
    }

    public void addItem(List<ShiBean.DataBeanX.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_shi.setText(data.get(position).getAuthor().getName());
        viewHolder.title_shi.setText(data.get(position).getFeeds_text());
        viewHolder.text_xiao.setText(data.get(position).getActivityText());
        viewHolder.vv.setVideoURI(Uri.parse(data.get(position).getUrl()));
        viewHolder.vv.requestFocus();
        viewHolder.vv.start();
        Glide.with(context).load(data.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.img_shi);
        Glide.with(context).load(data.get(position).getAuthor().getAvatar()).into(viewHolder.imga_xiao);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_shi;
        public TextView text_shi;
        public TextView title_shi;
        public VideoView vv;
        public ImageView imga_xiao;
        public TextView text_xiao;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_shi = (ImageView) rootView.findViewById(R.id.img_shi);
            this.text_shi = (TextView) rootView.findViewById(R.id.text_shi);
            this.title_shi = (TextView) rootView.findViewById(R.id.title_shi);
            this.vv = (VideoView) rootView.findViewById(R.id.vv);
            this.imga_xiao = (ImageView) rootView.findViewById(R.id.imga_xiao);
            this.text_xiao = (TextView) rootView.findViewById(R.id.text_xiao);
        }

    }
}

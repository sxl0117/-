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
import com.example.day_10_31.bean.XShiBean;

import java.util.ArrayList;
import java.util.List;

public class XshiAdapter extends RecyclerView.Adapter {
    private List<XShiBean.DataBeanX.DataBean> data = new ArrayList<>();
    private Context context;

    public XshiAdapter(Context context) {
        this.context = context;
    }

    public void addItem(List<XShiBean.DataBeanX.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xshi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text_x.setText(data.get(position).getAuthor().getName());
        viewHolder.title_x.setText(data.get(position).getFeeds_text());
        Glide.with(context).load(data.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.img_x);
        viewHolder.vv_x.setVideoURI(Uri.parse(data.get(position).getUrl()));
        viewHolder.vv_x.requestFocus();
        viewHolder.vv_x.start();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_x;
        public TextView text_x;
        public TextView title_x;
        public VideoView vv_x;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_x = (ImageView) rootView.findViewById(R.id.img_x);
            this.text_x = (TextView) rootView.findViewById(R.id.text_x);
            this.title_x = (TextView) rootView.findViewById(R.id.title_x);
            this.vv_x = (VideoView) rootView.findViewById(R.id.vv_x);
        }

    }
}

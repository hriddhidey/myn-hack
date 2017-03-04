package com.example.mi0213.vanyr;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mi0213 on 04/03/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    public List<Data> mData;
    private Context context;
    public static OnItemClickListener itemListener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        itemListener=listener;
    }
    public RecyclerViewAdapter(Context context, List<Data> data){
        mData=data;
        this.context=context;
    }

    private Context getContext() {
        return context;
    }
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View cardView = inflater.inflate(R.layout.item_card, parent, false);

        // Return a new holder instance
        MyViewHolder viewHolder = new MyViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Data data = mData.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.imDisplay.setImageResource(data.getImgRes());

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imDisplay;
        public TextView tvTitle;
        public MyViewHolder(final View itemView) {
            super(itemView);
            imDisplay = (ImageView) itemView.findViewById(R.id.im_display);
            tvTitle=(TextView)itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getLayoutPosition();
                    if(itemListener!=null){
                        itemListener.onItemClick(itemView,position);
                    }
                }
            });
        }
    }
}

package com.example.user.tracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    ArrayList<ManpowerItem> entityArrayList;
    Context context;


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_name, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;

    }
    public CustomAdapter(ArrayList<ManpowerItem> entityArrayList, Context context) {
        this.entityArrayList = entityArrayList;
        this.context=context;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        ManpowerItem  recruitItem=entityArrayList.get(position);

       holder.tv_newstitle.setText(recruitItem.getTitle());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MainActivity.class);
                intent.putExtra("hello",entityArrayList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return entityArrayList.size();

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        LinearLayout linearLayout;
        public TextView tv_newstitle,tv_date;
        public ImageView img;
        public CustomViewHolder(final View itemView) {
            super(itemView);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);
            cardView=(CardView)itemView.findViewById(R.id.card);
            tv_newstitle=(TextView)itemView.findViewById(R.id.title);

        }


    }


}

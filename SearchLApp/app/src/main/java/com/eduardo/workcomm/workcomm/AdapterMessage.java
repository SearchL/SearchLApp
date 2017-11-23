package com.eduardo.workcomm.workcomm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by eduardo on 7/10/17.
 */

public class AdapterMessage extends RecyclerView.Adapter<HolderMessage> {
    private List<Message> messageList = new ArrayList<>();
    private Context c;

    public AdapterMessage(Context c) {
        this.c = c;
    }
    public void addMessage(Message m){
        messageList.add(m);
        notifyItemInserted(messageList.size());
    }

    @Override
    public HolderMessage onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_messages,parent,false);
        return new HolderMessage(v);
    }

    @Override
    public void onBindViewHolder(HolderMessage holder, int position) {
        holder.getName().setText(messageList.get(position).getName());
        holder.getMessage().setText(messageList.get(position).getMessage());
        holder.getTime().setText(messageList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}

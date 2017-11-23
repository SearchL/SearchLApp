package com.eduardo.workcomm.workcomm;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by eduardo on 7/10/17.
 */
public class HolderMessage extends RecyclerView.ViewHolder{
    private CircleImageView photo;
    private TextView name;
    private TextView message;
    private TextView time;
    public HolderMessage(View itemView) {
        super(itemView);
        photo = (CircleImageView)itemView.findViewById(R.id.photo);
        name = (TextView)itemView.findViewById(R.id.C_name);
        message = (TextView)itemView.findViewById(R.id.Cmessage);
        time = (TextView)itemView.findViewById(R.id.time);
    }

    public CircleImageView getPhoto() {
        return photo;
    }

    public void setPhoto(CircleImageView photo) {
        this.photo = photo;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getMessage() {
        return message;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }
}

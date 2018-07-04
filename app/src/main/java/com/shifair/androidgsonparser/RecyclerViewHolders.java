package com.shifair.androidgsonparser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView Title;
    public TextView displayName;
    public TextView profileImage;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        Title = (TextView)itemView.findViewById(R.id.title);
        displayName = (TextView)itemView.findViewById(R.id.display_name);
        profileImage = (TextView)itemView.findViewById(R.id.profile_image);
    }

    @Override
    public void onClick(View view) {

    }
}

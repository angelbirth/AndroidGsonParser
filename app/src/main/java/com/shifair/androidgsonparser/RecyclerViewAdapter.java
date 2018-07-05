package com.shifair.androidgsonparser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shifair.androidgsonparser.model.Item;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders> {

    private List<Item> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        Item item = itemList.get(position);
        holder.txtTitle.setText(item.getTitle());
        holder.txtDisplayName.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitle;
        TextView txtDisplayName;
        TextView profileImage;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.title);
            txtDisplayName = itemView.findViewById(R.id.display_name);
            profileImage = itemView.findViewById(R.id.profile_image);
        }

        @Override
        public void onClick(View view) {

        }
    }

}

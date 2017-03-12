package com.wikitaco.demo.tacolist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.wikitaco.demo.R;
import com.wikitaco.demo.models.Taco;

public class TacoRecyclerAdapter extends FirebaseRecyclerAdapter <Taco, TacoRecyclerAdapter.TacoViewHolder> {

    private Context context;
    private final static int layoutId = R.layout.item_taco;


    public TacoRecyclerAdapter(Context context, DatabaseReference databaseReference) {
        super(Taco.class, layoutId, TacoViewHolder.class, databaseReference);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(TacoViewHolder viewHolder, Taco model, int position) {
        viewHolder.tvTacoName.setText(model.getName());
        viewHolder.rbTacoRating.setRating(model.getRating());
    }

    public static class TacoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTacoName;
        private ImageView ivTacoImg;
        private View view;
        private RatingBar rbTacoRating;

        public TacoViewHolder(View v) {
            super(v);
            tvTacoName = (TextView) v.findViewById(R.id.tvTacoName);
            ivTacoImg = (ImageView) v.findViewById(R.id.ivTacoImg);
            rbTacoRating = (RatingBar) v.findViewById(R.id.rbTacoRating);
            this.view = v;
        }

    }
}

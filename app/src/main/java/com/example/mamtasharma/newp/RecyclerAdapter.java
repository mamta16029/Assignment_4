package com.example.mamtasharma.newp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mamta Sharma on 11/3/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder> {
    private ArrayList<RecyclerData> myList;
    int mLastPosition = 0;
    Context context;
    DBHelper DB;
    //private RemoveClickListner mListner;

    public RecyclerAdapter(ArrayList<RecyclerData> myList, Context context) {
        this.myList = myList;
        this.context=context;
    }

    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, final int position) {
        Log.d("onBindViewHoler ", myList.size() + "");
    //--------------
        RecyclerData RObj=myList.get(position);


        holder.etTitleTextView.setText(RObj.getTitle());
        holder.etDescriptionTextView.setText(RObj.getDescription());
       // holder.crossImage.setImageResource(R.drawable.images);
        mLastPosition =position;
    }
    @Override
    public int getItemCount() {
        return myList.size();
    }
    public void notifyData(ArrayList<RecyclerData> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.myList = myList;
        notifyDataSetChanged();
    }
    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView etTitleTextView;
        private final TextView etDescriptionTextView;
        private View container;

        public RecyclerItemViewHolder( View parent) {
            super(parent);
            etTitleTextView = (TextView) parent.findViewById(R.id.txtTitle);
            etDescriptionTextView = (TextView) parent.findViewById(R.id.txtDescription);
            container = parent.findViewById(R.id.card_view);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,activity_viewPager.class);
                    Bundle bundle=new Bundle();
                    bundle.putParcelableArrayList("list",myList);
                    bundle.putInt("position",getLayoutPosition());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
           /* crossImage.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.OnRemoveClick(getAdapterPosition()
                    );
                }
            });*/
        }

        @Override
        public void onClick(View view) {

        }
    }
}
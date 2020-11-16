package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {
    ArrayList<Superstarid> mSuperstarids;
    ArrayList<Superstarid> mSuperstaridsall;
    public RecyclerAdapter(ArrayList<Superstarid> superstarids) {
        mSuperstarids = superstarids;
        this.mSuperstaridsall = new ArrayList<>(superstarids);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_representation,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Superstarid currentposition = mSuperstarids.get(position);
        holder.Rank.setText(String.valueOf(currentposition.getRank()));
        holder.mImageView.setImageResource(currentposition.getImaged());
        holder.height.setText(String.valueOf(currentposition.getHeight()));
        holder.Name.setText(currentposition.getName());

    }

    @Override
    public int getItemCount() {
        return mSuperstarids.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<Superstarid> filteredlist = new ArrayList();
            if (charSequence==null|| charSequence.length()==0){
                filteredlist.addAll(mSuperstaridsall);
            }else{
                String filterpattern = charSequence.toString().toLowerCase().trim();
                for (Superstarid superstarid :mSuperstaridsall){
                    if(superstarid.getName().toLowerCase().contains(filterpattern));{
                        filteredlist.add(superstarid);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredlist;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
          mSuperstarids.clear();
          mSuperstarids.addAll((List) filterResults.values);
          notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView height,Rank,Name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image);
            height = itemView.findViewById(R.id.Height);
            Rank = itemView.findViewById(R.id.Rank);
            Name = itemView.findViewById(R.id.SuperstarName);


        }
    }
}

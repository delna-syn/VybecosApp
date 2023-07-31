package com.example.vybecosapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vybecosapp.Model.DataAluminiumFoil;
import com.example.vybecosapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KeyChainAdapter  extends RecyclerView.Adapter<KeyChainAdapter.ViewHolder>{
    CustomAdapter.ItemClickListener listener;
    Context context;
    ArrayList<DataAluminiumFoil> dataKeyChains;

    public KeyChainAdapter(ArrayList<DataAluminiumFoil> dataKeyChains,Context context, CustomAdapter.ItemClickListener listener) {
        this.dataKeyChains = dataKeyChains;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KeyChainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_list_item,parent,false);
        KeyChainAdapter.ViewHolder viewHolder = new KeyChainAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeyChainAdapter.ViewHolder holder, int position) {
        DataAluminiumFoil dataAluminiumFoil = dataKeyChains.get(position);
        holder.tvName.setText(dataAluminiumFoil.getName());
        holder.tvSubName.setText(dataAluminiumFoil.getSubName());
        holder.tvRs.setText(R.string.Rs);
        holder.tvRate.setText(dataAluminiumFoil.getRate());
        Picasso.get()
                .load(dataAluminiumFoil.getImage())
                .into(holder.ivImage);
        holder.tvReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(dataKeyChains.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKeyChains !=null ? dataKeyChains.size() : 0;
    }
    @Override
    public int getItemViewType(int position) {
        return dataKeyChains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName , tvSubName , tvRate , tvReview , tvRs;
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSubName = itemView.findViewById(R.id.tvSubName);
            tvRate = itemView.findViewById(R.id.tvRate);
            tvRs = itemView.findViewById(R.id.tvRs);
            tvReview = itemView.findViewById(R.id.tvReview);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
    public interface ItemClickListener {
        void onClick(DataAluminiumFoil item);
    }
}

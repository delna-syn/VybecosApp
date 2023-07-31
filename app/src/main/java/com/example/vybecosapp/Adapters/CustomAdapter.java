package com.example.vybecosapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vybecosapp.Model.DataAluminiumFoil;
import com.example.vybecosapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
   ItemClickListener listener;
   ArrayList<DataAluminiumFoil> dataAluminiumFoils;
   Context context;

   public CustomAdapter(ArrayList<DataAluminiumFoil> dataAluminiumFoils,Context context, ItemClickListener listener) {
      this.dataAluminiumFoils =dataAluminiumFoils;
      this.context = context;
      this.listener = listener;
   }

   @NonNull
   @Override
   public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_list_item,parent,false);
      ViewHolder viewHolder = new ViewHolder(view);
      return viewHolder;
   }

   @Override
   public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
      DataAluminiumFoil dataAluminiumFoil = dataAluminiumFoils.get(position);
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
            listener.onClick(dataAluminiumFoils.get(position));
         }
      });
   }

   @Override
   public int getItemCount() {
      return dataAluminiumFoils !=null ? dataAluminiumFoils.size() : 0;
   }
   @Override
   public int getItemViewType(int position) {
      return dataAluminiumFoils.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      TextView tvName , tvSubName , tvRate , tvReview , tvRs;
      ImageView ivImage;
      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         tvName = itemView.findViewById(R.id.tvName);
         tvSubName = itemView.findViewById(R.id.tvSubName);
         tvRate = itemView.findViewById(R.id.tvRate);
         tvReview = itemView.findViewById(R.id.tvReview);
         ivImage = itemView.findViewById(R.id.ivImage);
         tvRs = itemView.findViewById(R.id.tvRs);
      }
   }
   public interface ItemClickListener {
      void onClick(DataAluminiumFoil item);
   }
}

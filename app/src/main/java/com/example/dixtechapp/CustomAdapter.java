package com.example.dixtechapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
  Context context;
  private Activity activity;
  
  private ArrayList id_serv, nome_serv, desc_serv;
  CustomAdapter(Activity activity, Context context, ArrayList id_serv, ArrayList nome_serv, ArrayList desc_serv,){
    this.context = context;
    this.id_serv = id_serv;
    this.nome_serv = nome_serv;
    this.desc_serv = desc_serv;
  
  }
  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.my_row, parent, false);
    return new MyViewHolder(view);
  }
  
  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
    holder.txt_id_serv.setText(String.valueOf(id_serv.get(position)));
    holder.txt_nome_serv.setText(String.valueOf(nome_serv.get(position)));
    holder.txt_desc_serv.setText(String.valueOf(desc_serv.get(position)));
    holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateServico.class);
                i.putExtra("id", String.valueOf(id_serv.get(position)));
                i.putExtra("nome", String.valueOf(nome_serv.get(position)));
                i.putExtra("desc", String.valueOf(desc_serv.get(position)));
                activity.startActivityForResult(i, 1);
            }
        });
  }
  
  @Override
  public int getItemCount(){
    return id_serv.size();
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView txt_id_serv, txt_nome_serv, txt_desc_serv;
    LinearLayout mainLayout;
    public MyViewHolder(@NonNull View itemView){
      super(itemView);
      txt_id_serv = itemView.findViewById(R.id.txt_id_serv);
      txt_nome_serv= itemView.findViewById(R.id.txt_nome_serv);
      txt_desc_serv= itemView.findViewById(R.id.txt_desc_serv);
      mainLayout = itemView.findViewById(R.id.mainLayout);
    }
  }

}
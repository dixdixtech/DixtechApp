package com.example.dixtechapp;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    
  }
  
  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
    
  }
  
  @Override
  public int getItemCount(){
    return 0;
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder{
    public MyViewHolder(@NonNull View itemView){
      super(itemView);
    }
  }

}

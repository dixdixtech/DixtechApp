package com.example.dixtechapp;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
  Context context;
  private ArrayList id_serv, nome_serv, desc_serv;
  CustomAdapter(Context context, ArrayList id_serv, ArrayList nome_serv, ArrayList desc_serv,){
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
  }
  
  @Override
  public int getItemCount(){
    return id_serv.size();
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView txt_id_serv, txt_nome_serv, txt_desc_serv;
    public MyViewHolder(@NonNull View itemView){
      super(itemView);
      txt_id_serv = itemView.findViewById(R.id.txt_id_serv);
      txt_nome_serv= itemView.findViewById(R.id.txt_nome_serv);
      txt_desc_serv= itemView.findViewById(R.id.txt_desc_serv);
    }
  }

}

package com.example.personlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    // ivar for DataAdapter
    private Context context;
    private int layoutID;
    private Airline[] airlines;
    InterfaceRecycleView recycleViewInterface;

    public DataAdapter(Context context, int layoutID, Airline[] airlines) {
        this.context = context;
        this.layoutID = layoutID;
        this.airlines = airlines;
        this.recycleViewInterface = recycleViewInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and make it a viewholder
        View v = LayoutInflater.from(this.context).inflate(layoutID, parent, false);

        return new ViewHolder(v,recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate viewholder with model data
        holder.name.setText(airlines[position].getName());
        holder.rank.setText(airlines[position].getRanking());


        /// check below!
        String airlineLogo = airlines[position].getLogo();
        Integer id = context.getResources().getIdentifier(airlineLogo, "drawable", context.getPackageName());
        holder.logo.setImageResource(id);
        Log.d("Test image", id.toString());



        //holder.image.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return airlines.length;
    }


    // inner class for ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView logo;
        public TextView rank;

        public ViewHolder(@NonNull View itemView, InterfaceRecycleView recycleViewInterface) {
            super(itemView);

            name  = itemView.findViewById(R.id.textView);
            logo = itemView.findViewById(R.id.imageView);
            rank = itemView.findViewById(R.id.textViewSubtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // call the InterfaceRecycleView method
                    if (recycleViewInterface != null){
                        int posistion = getAdapterPosition();
                        if(posistion != RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(posistion);
                        }

                    }
                }
            });
        }
    }
}

// pull parser?
// max ten
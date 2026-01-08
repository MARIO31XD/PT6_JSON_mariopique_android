package com.example.pt6_mariopique;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ObjectInputStream;
import java.util.List;

public class MyRecyclerViewAdapter extends  RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{


    private List<Equip> mData;
    private String lliga;
    private ImageView imgElement;

    public MyRecyclerViewAdapter(List<Equip> mData, String lliga) {
        this.mData = mData;
        this.lliga = lliga;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View viewElement = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(viewElement);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {


        Equip equip = mData.get(position);
        holder.txtElement.setText(equip.getNom());

        String urlEscut = "https://www.vidalibarraquer.net/android/sports/"
                + lliga + "/"
                + equip.getEscut().toLowerCase() + ".png";

        Glide.with(holder.itemView.getContext())
                .load(urlEscut)
                .into(holder.imgElement);

        holder.itemView.setOnClickListener(v -> {

            android.util.Log.d("Click", "clica l'equip " + equip.getNom());
            Intent intent = new Intent(v.getContext(), DetallActivity.class);
            intent.putExtra("liga", lliga);
            intent.putExtra("codi", equip.getCodi());
            v.getContext().startActivity(intent);
        });
    }

    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtElement;
        private ImageView imgElement;

        public ViewHolder(View itemView) {
            super(itemView);
            txtElement = itemView.findViewById(R.id.textElement);
            imgElement = itemView.findViewById(R.id.imgElement);

        }


        public TextView getTxtElement() {
            return txtElement;
        }
    }

}

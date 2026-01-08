package com.example.pt6_mariopique;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public  class EquipAdapter extends RecyclerView.Adapter<EquipAdapter.ViewHolder> {

    private List<Equip> listaEquipos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Equip equipo);
    }

    public EquipAdapter(List<Equip> listaEquipos, OnItemClickListener listener) {
        this.listaEquipos = listaEquipos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Usamos un diseño sencillo de Android (simple_list_item_1) para no complicar el XML
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Equip equipo = listaEquipos.get(position);
        holder.textView.setText(equipo.getNom());

        // Configuramos el clic
        holder.itemView.setOnClickListener(v -> listener.onItemClick(equipo));
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

}

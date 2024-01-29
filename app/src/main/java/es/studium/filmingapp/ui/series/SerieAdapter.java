package es.studium.filmingapp.ui.series;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.filmingapp.R;

public class SerieAdapter extends RecyclerView.Adapter<SerieViewHolder> {
    List<Serie> items;
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    public SerieAdapter(@NonNull List<Serie> items, @NonNull RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.items = items;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.serie_card, viewGroup, false);
        return new SerieViewHolder(v, recyclerViewOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.titulo.setText(items.get(i).getTitulo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

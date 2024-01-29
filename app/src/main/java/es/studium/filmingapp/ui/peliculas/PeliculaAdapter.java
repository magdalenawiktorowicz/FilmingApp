package es.studium.filmingapp.ui.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaViewHolder> {
    List<Pelicula> items;
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    public PeliculaAdapter(@NonNull List<Pelicula> items, @NonNull RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.items = items;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pelicula_card, viewGroup, false);
        return new PeliculaViewHolder(v, recyclerViewOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.titulo.setText(items.get(i).getTitulo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

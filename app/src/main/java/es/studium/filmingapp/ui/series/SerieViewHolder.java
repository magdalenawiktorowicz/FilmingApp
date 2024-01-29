package es.studium.filmingapp.ui.series;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.filmingapp.R;

public class SerieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imagen;
    TextView titulo;
    private final RecyclerViewOnItemClickListener listener;

    public SerieViewHolder(@NonNull View v, @NonNull RecyclerViewOnItemClickListener listener) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen);
        titulo = (TextView) v.findViewById(R.id.titulo);
        this.listener = listener;
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAbsoluteAdapterPosition());
    }
}

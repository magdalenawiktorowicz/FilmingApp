package es.studium.filmingapp.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentPeliculasBinding;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PeliculasFragment extends Fragment {
    private FragmentPeliculasBinding binding;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PeliculasViewModel peliculasViewModel =
                new ViewModelProvider(this).get(PeliculasViewModel.class);

        List items = new ArrayList();
        items.add(new Pelicula(R.drawable.eightmile, R.string.titulo1));
        items.add(new Pelicula(R.drawable.sevenpounds, R.string.titulo2));
        items.add(new Pelicula(R.drawable.inception, R.string.titulo3));
        items.add(new Pelicula(R.drawable.loveactually, R.string.titulo4));
        items.add(new Pelicula(R.drawable.whenamanlovesawoman, R.string.titulo5));
        items.add(new Pelicula(R.drawable.bladerunner2049, R.string.titulo6));

        binding = FragmentPeliculasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recycler = (RecyclerView) root.findViewById(R.id.myRecyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);

        recycler.setAdapter(new PeliculaAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                Navigation.findNavController(v).navigate(R.id.nav_peliculas_to_peliculas_details, bundle);
            }
        }));
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

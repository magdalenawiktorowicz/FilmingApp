package es.studium.filmingapp.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentSeriesBinding;

public class SeriesFragment extends Fragment {
    private FragmentSeriesBinding binding;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeriesViewModel seriesViewModel =
                new ViewModelProvider(this).get(SeriesViewModel.class);

        List items = new ArrayList();
        items.add(new Serie(R.drawable.dexter, R.string.tituloSerie1));
        items.add(new Serie(R.drawable.peakyblinders, R.string.tituloSerie2));
        items.add(new Serie(R.drawable.theoffice, R.string.tituloSerie3));
        items.add(new Serie(R.drawable.thewitcher, R.string.tituloSerie4));
        items.add(new Serie(R.drawable.blackmirror, R.string.tituloSerie5));

        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recycler = (RecyclerView) root.findViewById(R.id.myRecyclerViewSeries);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);

        recycler.setAdapter(new SerieAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                Navigation.findNavController(v).navigate(R.id.nav_series_to_series_details, bundle);
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

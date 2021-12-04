package com.example.homework41.fragments.homefragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.homework41.R;
import com.example.homework41.adapters.CarAdapter;
import com.example.homework41.databinding.FragmentHomeBinding;
import com.example.homework41.models.Car;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    HomeViewModel model;
    CarAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.addCars();
            }
        });
        initialize();
        getCars();
        itemClick();

    }

    private void itemClick() {
        adapter.onClick(car -> {
            model.select(car);
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.detailFragment);
        });
    }

    private void getCars() {
        model.cars.observe(getViewLifecycleOwner(), new Observer<ArrayList<Car>>() {
            @Override
            public void onChanged(ArrayList<Car> cars) {
                adapter.addCars(cars);
                binding.btnAdd.setVisibility(View.GONE);
            }
        });

    }
    private void initialize() {
        adapter = new CarAdapter();
        binding.rvHome.setAdapter(adapter);
        model = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
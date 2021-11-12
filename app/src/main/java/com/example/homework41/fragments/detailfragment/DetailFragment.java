package com.example.homework41.fragments.detailfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homework41.R;
import com.example.homework41.databinding.FragmentDetailBinding;
import com.example.homework41.fragments.homefragment.HomeViewModel;
import com.example.homework41.models.Car;


public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    HomeViewModel model;
    Car car;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        getSelectedModel();
    }



    private void initialize() {
        model = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
    }

    private void getSelectedModel() {
        model.getSelected().observe(getViewLifecycleOwner(), new Observer<Car>() {
            @Override
            public void onChanged(Car car) {
                binding.imgCar.setImageResource(car.getImage());
            }
        });

    }


}
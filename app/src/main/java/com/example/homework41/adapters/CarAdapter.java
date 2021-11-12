package com.example.homework41.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework41.databinding.CarItemsBinding;
import com.example.homework41.models.Car;
import com.example.homework41.utils.OnItemClickListener;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    ArrayList<Car> list = new ArrayList<>();
    OnItemClickListener onItemClickListener;


    public void addCars(ArrayList<Car> car ){
        list = car;
        notifyDataSetChanged();
    }

    public void onClick(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(CarItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        holder.onFill(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CarItemsBinding binding;

        public ViewHolder(CarItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onFill(Car s){
            binding.txtName.setText(s.getName());
            binding.txtYear.setText(String.valueOf(s.getYear()));
            binding.getRoot().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(s);

                }
            });

        }
    }
}

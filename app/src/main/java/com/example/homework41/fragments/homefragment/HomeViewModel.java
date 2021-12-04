package com.example.homework41.fragments.homefragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework41.R;
import com.example.homework41.models.Car;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {


    public MutableLiveData<ArrayList<Car>> cars = new MutableLiveData<>();
    ArrayList<Car> list = new ArrayList<>();
    public MutableLiveData<Car> selectModel = new MutableLiveData<>();
    public void addCars(){
        list.add(new Car("BMW",2021, R.drawable.bmw));
        list.add(new Car("Mercedes",2020,R.drawable.mers));
        list.add(new Car("Audi",2019,R.drawable.audi));
        cars.setValue(list);
    }
    public void select (Car car){
        selectModel.setValue(car);
    }
    public LiveData<Car> getSelected(){
        return selectModel;
    }


}

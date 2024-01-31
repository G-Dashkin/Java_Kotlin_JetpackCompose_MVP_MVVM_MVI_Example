package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.screens.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.adapters.EmployeeAdapter;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.pojo.api.ApiFactory;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.pojo.api.ApiService;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.pojo.Employee;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1EmployeesListMVP.pojo.EmployeeResponse;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeesListMainActivity extends AppCompatActivity implements EmployeesListView {

    private RecyclerView recyclerViewEmployees;
    private EmployeeAdapter adapter;
    private EmployeeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_list_main);
        presenter = new EmployeeListPresenter(this);
        recyclerViewEmployees = findViewById(R.id.recyclerViewEmployees);
        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<Employee>());
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
        presenter.loadData();
    }

    @Override
    public void showData(List<Employee> employees) {
        adapter.setEmployees(employees);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
}
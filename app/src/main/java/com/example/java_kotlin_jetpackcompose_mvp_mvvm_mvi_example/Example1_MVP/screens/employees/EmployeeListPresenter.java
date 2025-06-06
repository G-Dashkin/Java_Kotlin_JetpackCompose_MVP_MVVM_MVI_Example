package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.screens.employees;


import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.EmployeeResponse;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.api.ApiFactory;
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.api.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListPresenter {

    private CompositeDisposable compositeDisposable;
    private EmployeesListView view;

    public EmployeeListPresenter(EmployeesListView view) {
        this.view = view;
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();

        Disposable disposable = apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        view.showData(employeeResponse.getResponse());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError();
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void disposeDisposable() {
        if(compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}

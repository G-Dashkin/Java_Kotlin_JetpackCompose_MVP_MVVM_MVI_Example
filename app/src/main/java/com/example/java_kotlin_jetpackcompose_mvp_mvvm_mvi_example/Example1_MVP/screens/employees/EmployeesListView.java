package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.screens.employees;

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example1_MVP.pojo.Employee;

import java.util.List;

public interface EmployeesListView {
    void showData(List<Employee> employee);
    void showError();
}

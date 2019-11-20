package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.percistence.DepartmentDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class DepartmentViewEntity extends ViewModel {

    private DepartmentDao dataSource;
    public List idInsertDepartment;
    public int rowCount;

    public DepartmentViewEntity(DepartmentDao dataSource) {
        this.dataSource = dataSource;
        idInsertDepartment = new ArrayList<>();
    }

    public final Flowable getFilterDepartamentos(String description) {

        return dataSource.getFilterDepartamentos(description);
    }

    public final Completable getCountDepartment(String departmentUUID) {
        return Completable.fromAction(() -> rowCount = dataSource.getCountDepartment(departmentUUID));
    }

    public final Flowable getFilterCategory() {

        return dataSource.getFilterCategory();
    }

    public final Completable insertDepartamento(final DepartmentEntity departament) {
        return Completable.fromAction(() -> DepartmentEntity.instance.setId(dataSource.insertDepartamento(departament).intValue()));

    }

    public final Completable insertDepartmentDefault (final ArrayList<DepartmentEntity> department)
    {
        return Completable.fromAction(() -> idInsertDepartment=  dataSource.insertDepartmentDefault(department));
    }

    public final Completable updateDepartamento(final DepartmentEntity departamento) {
        return Completable.fromAction(() -> dataSource.updateDepartamento(departamento));
    }
}

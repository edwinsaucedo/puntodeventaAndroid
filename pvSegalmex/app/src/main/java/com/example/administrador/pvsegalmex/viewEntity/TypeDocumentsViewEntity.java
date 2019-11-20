package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.percistence.TypeDocumentsDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class TypeDocumentsViewEntity extends ViewModel {

    private TypeDocumentsDao dataSource;
    public List idInsertTypeDocument;

    public TypeDocumentsViewEntity(TypeDocumentsDao dataSource){
        this.dataSource = dataSource;
        idInsertTypeDocument = new ArrayList<>();
    }

    public final Flowable getFilterTypeDocuments(String description) {

        return dataSource.getFilterTypeDocuments(description);
    }

    public final Flowable getFilterTypeDoc() {

        return dataSource.getFilterTypeDoc();
    }

    public final Completable insertTypeDocuments(final TypeDocumentsEntity typeDocuments) {
        return Completable.fromAction(() -> TypeDocumentsEntity.instance.setId(dataSource.insertTypeDocuments(typeDocuments).intValue()));

    }

    public final Completable insertTypeDocumentDefault (final ArrayList<TypeDocumentsEntity> typeDocument)
    {
        return Completable.fromAction(() -> idInsertTypeDocument=  dataSource.insertTypeDocumentDefault(typeDocument));

    }

    public final Completable updateTypeDocuments(final TypeDocumentsEntity typeDocuments) {
        return Completable.fromAction(()-> dataSource.updateTypeDocuments(typeDocuments));
    }
}

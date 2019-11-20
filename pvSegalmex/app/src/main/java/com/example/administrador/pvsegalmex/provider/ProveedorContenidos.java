package com.example.administrador.pvsegalmex.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.percistence.DataBase;
import com.example.administrador.pvsegalmex.percistence.SalesDao;

public class ProveedorContenidos extends ContentProvider {

    public static final String AUTHORITY = "com.example.administrador.pvsegalmex.application";

    public static final Uri URI_MENU = Uri.parse("content://" + AUTHORITY + "/" + "Venta");

    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int SALE_ONE_REG = 1;
    private static final int SALE_ALL_REGS = 2;

    static {
        MATCHER.addURI(AUTHORITY, "Venta", SALE_ONE_REG);
        MATCHER.addURI(AUTHORITY, "Venta" + "/*", SALE_ALL_REGS);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        final int code = MATCHER.match(uri);
        if (code == SALE_ONE_REG || code == SALE_ALL_REGS) {
            final Context context = getContext();
            if (context == null) {
                return null;
            }
            SalesDao salesDao = DataBase.getDataBase(context).salesDao();
            final Cursor cursor;
            if (code == SALE_ALL_REGS) {
                cursor = salesDao.selectAll();
            } else {
                cursor = salesDao.selectById(ContentUris.parseId(uri));
            }
            cursor.setNotificationUri(context.getContentResolver(), uri);
            return cursor;
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Override
    public String getType(Uri uri) {
        switch (MATCHER.match(uri)) {
            case SALE_ALL_REGS:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + "Venta";
            case SALE_ONE_REG:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + "Venta";
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
       /* switch (MATCHER.match(uri)) {
            case SALE_ALL_REGS:
                final Context context = getContext();
                if (context == null) {
                    return null;
                }
                final long id = DataBase.getDataBase(context).salesDao().insertSales(SalesEntity.fromContentValues(values));
                context.getContentResolver().notifyChange(uri, null);
                return ContentUris.withAppendedId(uri, id);
            case SALE_ONE_REG:
                throw new IllegalArgumentException("Invalid URI, cannot insert with ID: " + uri);
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }*/
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
       /* switch (MATCHER.match(uri)) {
            case SALE_ALL_REGS:
                throw new IllegalArgumentException("Invalid URI, cannot update without ID" + uri);
            case SALE_ONE_REG:
                final Context context = getContext();
                if (context == null) {
                    return 0;
                }
                final SalesEntity salesEntity = SalesEntity.fromContentValues(values);
                salesEntity.id = ContentUris.parseId(uri);
                final int count = DataBase.getDataBase(context).salesDao().updateSales(salesEntity);
                context.getContentResolver().notifyChange(uri, null);
                return count;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }*/
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

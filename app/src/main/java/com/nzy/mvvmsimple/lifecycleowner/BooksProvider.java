package com.nzy.mvvmsimple.lifecycleowner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author niezhiyang
 * since 2020/6/1
 */
public  class BooksProvider extends ContentProvider {
    private static final String TAG= "BooksProvider";
    @Override
    public boolean onCreate() {
        Log.e(TAG,"------onCreate");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.e(TAG,"------query");
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.e(TAG,"------getType");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.e(TAG,"------insert");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e(TAG,"------delete");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e(TAG,"------update");
        return 0;
    }
}

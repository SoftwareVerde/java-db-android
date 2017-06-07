package com.softwareverde.database.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.softwareverde.database.KeyValueStore;

public class AndroidKeyValueStore implements KeyValueStore {
    protected Context _context;
    protected SharedPreferences _store;
    protected String _schemaName;

    public AndroidKeyValueStore(Context context, String schemaName) {
        _context = context;
        _schemaName = schemaName;
        _store = _context.getSharedPreferences(_schemaName, Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key) {
        return _store.getString(key, "");
    }

    @Override
    public void putString(String key, String value) {
        if (value == null) value = "";

        _store.edit().putString(key, value).apply();
    }

    @Override
    public boolean hasKey(String key) {
        return _store.contains(key);
    }

    @Override
    public void removeKey(String key) {
        _store.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        _store.edit().clear().commit();
    }

    // public void clearAllStores() { }
}

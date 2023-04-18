package com.kbstar.frame;

import java.util.List;

public interface MyDao<K,V> {
    public void insert(V v);
    public void delete(K k);
    public V select(K k);
    public List<K> select();
}

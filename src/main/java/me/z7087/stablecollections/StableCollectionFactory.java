package me.z7087.stablecollections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StableCollectionFactory {
    StableCollectionFactory DEFAULT_IMPL = createDefaultImpl();

    static StableCollectionFactory createDefaultImpl() {
        boolean useJdkImpl = true;
        try {
            //noinspection ResultOfMethodCallIgnored,Since15
            List.of();
        } catch (NoSuchMethodError ignored) {
            useJdkImpl = false;
        }
        return useJdkImpl ? createJdkImpl() : createJ8Impl();
    }

    static StableCollectionFactory createJdkImpl() {
        return new StableCollectionFactoryJdkImpl();
    }

    static StableCollectionFactory createJ8Impl() {
        return new StableCollectionFactoryJ8Impl();
    }

    <E> List<E> ofList();

    <E> List<E> ofList(E e1);

    <E> List<E> ofList(E e1, E e2);

    <E> List<E> ofList(E e1, E e2, E e3);

    <E> List<E> ofList(E e1, E e2, E e3, E e4);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9);

    <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10);

    @SuppressWarnings("unchecked")
    <E> List<E> ofList(E... elements);

    <E> Set<E> ofSet();

    <E> Set<E> ofSet(E e1);

    <E> Set<E> ofSet(E e1, E e2);

    <E> Set<E> ofSet(E e1, E e2, E e3);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9);

    <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10);

    @SuppressWarnings("unchecked")
    <E> Set<E> ofSet(E... elements);

    <K, V> Map<K, V> ofMap();

    <K, V> Map<K, V> ofMap(K k1, V v1);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9);

    <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10);

    @SuppressWarnings("unchecked")
    <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries);

    <K, V> Map.Entry<K, V> entry(K k, V v);
}

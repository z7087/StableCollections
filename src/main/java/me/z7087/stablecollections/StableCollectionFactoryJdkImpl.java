package me.z7087.stablecollections;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("Since15")
final class StableCollectionFactoryJdkImpl implements StableCollectionFactory {
    @Override
    public <E> List<E> ofList() {
        return List.of();
    }

    @Override
    public <E> List<E> ofList(E e1) {
        return List.of(e1);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2) {
        return List.of(e1, e2);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3) {
        return List.of(e1, e2, e3);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4) {
        return List.of(e1, e2, e3, e4);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5) {
        return List.of(e1, e2, e3, e4, e5);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6) {
        return List.of(e1, e2, e3, e4, e5, e6);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return List.of(e1, e2, e3, e4, e5, e6, e7);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return List.of(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    @Override
    public final <E> List<E> ofList(E... elements) {
        return List.of(elements);
    }

    @Override
    public <E> Set<E> ofSet() {
        return Set.of();
    }

    @Override
    public <E> Set<E> ofSet(E e1) {
        return Set.of(e1);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2) {
        return Set.of(e1, e2);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3) {
        return Set.of(e1, e2, e3);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4) {
        return Set.of(e1, e2, e3, e4);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5) {
        return Set.of(e1, e2, e3, e4, e5);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6) {
        return Set.of(e1, e2, e3, e4, e5, e6);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return Set.of(e1, e2, e3, e4, e5, e6, e7);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return Set.of(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return Set.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return Set.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    @Override
    public final <E> Set<E> ofSet(E... elements) {
        return Set.of(elements);
    }

    @Override
    public <K, V> Map<K, V> ofMap() {
        return Map.of();
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1) {
        return Map.of(k1, v1);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2) {
        return Map.of(k1, v1, k2, v2);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        return Map.of(k1, v1, k2, v2, k3, v3);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    @SafeVarargs
    @Override
    public final <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        return Map.ofEntries(entries);
    }

    @Override
    public <K, V> Map.Entry<K, V> entry(K k, V v) {
        return Map.entry(k, v);
    }
}

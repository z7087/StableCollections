package me.z7087.stablecollections;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;

import static org.objectweb.asm.Opcodes.*;


// mostly copied from java.util.ImmutableCollections
// original file header:
/*
 * Copyright (c) 2016, 2025, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

final class StableCollectionFactoryJ8Impl implements StableCollectionFactory {

    private static final MethodHandle MHDefineAnonymousClass;

    static {
        Class<?> unsafeClass;
        Object theUnsafe;
        try {
            unsafeClass = Class.forName("sun.misc.Unsafe");
            final java.lang.reflect.Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            theUnsafe = theUnsafeField.get(null);
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            unsafeClass = null;
            theUnsafe = null;
        }
        MethodHandle _MHDefineAnonymousClass;
        if (theUnsafe != null) {
            try {
                _MHDefineAnonymousClass = MethodHandles.lookup().findVirtual(unsafeClass, "defineAnonymousClass", MethodType.methodType(Class.class, Class.class, byte[].class, Object[].class));
                _MHDefineAnonymousClass = MethodHandles.insertArguments(_MHDefineAnonymousClass, 0, theUnsafe);
            } catch (NoSuchMethodException | IllegalAccessException e) {
                _MHDefineAnonymousClass = null;
            }
        } else {
            _MHDefineAnonymousClass = null;
        }
        if (_MHDefineAnonymousClass != null) {
            MHDefineAnonymousClass = MethodHandles.insertArguments(_MHDefineAnonymousClass, 2, new Object[] { null });
        } else {
            MHDefineAnonymousClass = null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> ofList() {
        return (List<E>) Utilities.EMPTY_LIST;
    }

    @Override
    public <E> List<E> ofList(E e1) {
        return List12.of(e1);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2) {
        return List12.of(e1, e2);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3) {
        return Utilities.listFromTrustedArray(e1, e2, e3);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5, e6);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5, e6, e7);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    @Override
    public <E> List<E> ofList(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return Utilities.listFromTrustedArray(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    @Override
    public final <E> List<E> ofList(E... elements) {
        switch (elements.length) { // implicit null check of elements
            case 0: {
                @SuppressWarnings("unchecked")
                List<E> list = (List<E>) Utilities.EMPTY_LIST;
                return list;
            }
            case 1: {
                return List12.of(elements[0]);
            }
            case 2: {
                return List12.of(elements[0], elements[1]);
            }
            default: {
                return Utilities.listFromArray(elements);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> Set<E> ofSet() {
        return (Set<E>) Utilities.EMPTY_SET;
    }

    @Override
    public <E> Set<E> ofSet(E e1) {
        return Set12.of(e1);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2) {
        return Set12.of(e1, e2);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3) {
        return SetN.of(e1, e2, e3);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4) {
        return SetN.of(e1, e2, e3, e4);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5) {
        return SetN.of(e1, e2, e3, e4, e5);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6) {
        return SetN.of(e1, e2, e3, e4, e5, e6);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return SetN.of(e1, e2, e3, e4, e5, e6, e7);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return SetN.of(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return SetN.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    @Override
    public <E> Set<E> ofSet(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return SetN.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    @Override
    public final <E> Set<E> ofSet(E... elements) {
        switch (elements.length) { // implicit null check of elements
            case 0: {
                @SuppressWarnings("unchecked")
                Set<E> set = (Set<E>) Utilities.EMPTY_SET;
                return set;
            }
            case 1: {
                return Set12.of(elements[0]);
            }
            case 2: {
                return Set12.of(elements[0], elements[1]);
            }
            default: {
                return SetN.of(elements);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Map<K, V> ofMap() {
        return (Map<K, V>) Utilities.EMPTY_MAP;
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1) {
        return Map1.of(k1, v1);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2) {
        return MapN.of(k1, v1, k2, v2);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        return MapN.of(k1, v1, k2, v2, k3, v3);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    @Override
    public <K, V> Map<K, V> ofMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return MapN.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    @SafeVarargs
    @Override
    public final <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        if (entries.length == 0) { // implicit null check of entries array
            @SuppressWarnings("unchecked")
            Map<K, V> map = (Map<K, V>) Utilities.EMPTY_MAP;
            return map;
        } else if (entries.length == 1) {
            // implicit null check of the array slot
            return Map1.of(entries[0].getKey(),
                    entries[0].getValue());
        } else {
            Object[] kva = new Object[entries.length << 1];
            int a = 0;
            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                // implicit null checks of each array slot
                kva[a++] = entry.getKey();
                kva[a++] = entry.getValue();
            }
            return MapN.of(kva);
        }
    }

    @Override
    public <K, V> Map.Entry<K, V> entry(K k, V v) {
        return KeyValueHolder.of(k, v);
    }

    static final class Utilities {
        private Utilities() {}

        static final Object EMPTY = new Object();
        static final ListN<?> EMPTY_LIST = ListN.of(new Object[0]);
        static final SetN<?> EMPTY_SET = SetN.of();
        static final MapN<?,?> EMPTY_MAP = MapN.of();
        static final int EXPAND_FACTOR = 2;
        static final String FORCE_INLINE_ANNOTATION_DESC = "Ljava/lang/invoke/ForceInline;";
        static final String STABLE_ANNOTATION_DESC = "Ljava/lang/invoke/Stable;";

        static Class<?> defineAnonymousClass(Class<?> hostClass, byte[] classBytes) {
            try {
                return (Class<?>) Objects.requireNonNull(MHDefineAnonymousClass).invokeExact(hostClass, classBytes);
            } catch (RuntimeException | Error e) {
                throw e;
            } catch (Throwable t) {
                throw new RuntimeException("Unexpected exception during defining vm anonymous class", t);
            }
        }

        static Class<?> defineStableFieldStorage(Class<?> hostClass,
                                                     String className,
                                                     String superClassName,
                                                     MethodType targetConstructorMT,
                                                     int cutToSuperConstructorIndex) {
            final int paramCount = targetConstructorMT.parameterCount();
            if (cutToSuperConstructorIndex == -1) {
                cutToSuperConstructorIndex = paramCount;
            }
            if (cutToSuperConstructorIndex <= 0) {
                throw new IllegalArgumentException("cutToSuperConstructorIndex must be > 0, but got cutToSuperConstructorIndex=" + cutToSuperConstructorIndex);
            }
            if (cutToSuperConstructorIndex > paramCount) {
                throw new IllegalArgumentException("cutToSuperConstructorIndex must be <= paramCount, but got paramCount=" + paramCount + ", cutToSuperConstructorIndex=" + cutToSuperConstructorIndex);
            }
            final ClassWriter cwStableFieldStorage = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            cwStableFieldStorage.visit(V1_8,
                    ACC_PUBLIC | ACC_FINAL,
                    className,
                    null,
                    superClassName,
                    null
            );
            for (int i = 0; i < cutToSuperConstructorIndex; ++i) {
                final FieldVisitor fvStableField = cwStableFieldStorage.visitField(ACC_PUBLIC | ACC_FINAL, "f" + i, Type.getDescriptor(targetConstructorMT.parameterType(i)), null, null);
                fvStableField.visitAnnotation(STABLE_ANNOTATION_DESC, true).visitEnd();
                fvStableField.visitEnd();
            }
            {
                final MethodVisitor mvInit = cwStableFieldStorage.visitMethod(ACC_PUBLIC, "<init>", targetConstructorMT.toMethodDescriptorString(), null, null);
                mvInit.visitAnnotation(FORCE_INLINE_ANNOTATION_DESC, true).visitEnd();
                mvInit.visitCode();

                {
                    mvInit.visitVarInsn(ALOAD, 0);
                    int loadOpcodeIndex = 1;
                    for (int i = 0; i < cutToSuperConstructorIndex; ++i) {
                        final Class<?> paramType = targetConstructorMT.parameterType(i);
                        if (paramType == long.class) {
                            loadOpcodeIndex += 2;
                        } else if (paramType == float.class) {
                            loadOpcodeIndex += 1;
                        } else if (paramType == double.class) {
                            loadOpcodeIndex += 2;
                        } else if (paramType == int.class || paramType == short.class || paramType == byte.class || paramType == char.class || paramType == boolean.class) {
                            loadOpcodeIndex += 1;
                        } else {
                            loadOpcodeIndex += 1;
                        }
                    }
                    StringBuilder descBuilder = new StringBuilder();
                    descBuilder.append("(");
                    for (int i = cutToSuperConstructorIndex; i < paramCount; ++i) {
                        final Class<?> paramType = targetConstructorMT.parameterType(i);
                        if (paramType == long.class) {
                            mvInit.visitVarInsn(LLOAD, loadOpcodeIndex);
                            loadOpcodeIndex += 2;
                        } else if (paramType == float.class) {
                            mvInit.visitVarInsn(FLOAD, loadOpcodeIndex++);
                        } else if (paramType == double.class) {
                            mvInit.visitVarInsn(DLOAD, loadOpcodeIndex);
                            loadOpcodeIndex += 2;
                        } else if (paramType == int.class || paramType == short.class || paramType == byte.class || paramType == char.class || paramType == boolean.class) {
                            mvInit.visitVarInsn(ILOAD, loadOpcodeIndex++);
                        } else {
                            mvInit.visitVarInsn(ALOAD, loadOpcodeIndex++);
                        }
                        descBuilder.append(Type.getDescriptor(paramType));
                    }
                    descBuilder.append(")V");
                    mvInit.visitMethodInsn(
                            INVOKESPECIAL,
                            superClassName,
                            "<init>",
                            descBuilder.toString(),
                            false
                    );
                }
                {
                    int loadOpcodeIndex = 1;
                    for (int i = 0; i < cutToSuperConstructorIndex; ++i) {
                        mvInit.visitVarInsn(ALOAD, 0);
                        final Class<?> paramType = targetConstructorMT.parameterType(i);
                        if (paramType == long.class) {
                            mvInit.visitVarInsn(LLOAD, loadOpcodeIndex);
                            loadOpcodeIndex += 2;
                        } else if (paramType == float.class) {
                            mvInit.visitVarInsn(FLOAD, loadOpcodeIndex++);
                        } else if (paramType == double.class) {
                            mvInit.visitVarInsn(DLOAD, loadOpcodeIndex);
                            loadOpcodeIndex += 2;
                        } else if (paramType == int.class || paramType == short.class || paramType == byte.class || paramType == char.class || paramType == boolean.class) {
                            mvInit.visitVarInsn(ILOAD, loadOpcodeIndex++);
                        } else {
                            mvInit.visitVarInsn(ALOAD, loadOpcodeIndex++);
                        }
                        mvInit.visitFieldInsn(PUTFIELD, className, "f" + i, Type.getDescriptor(paramType));
                    }
                }

                mvInit.visitInsn(RETURN);
                mvInit.visitMaxs(-1, -1);
                mvInit.visitEnd();
            }

            cwStableFieldStorage.visitEnd();
            return defineAnonymousClass(hostClass, cwStableFieldStorage.toByteArray());
        }

        static MethodHandle constructorForSFS(MethodHandles.Lookup hostClass, Class<?> declaringClass, Class<?> superClass, MethodType constructorMT) {
            try {
                final MethodHandle result = hostClass.findConstructor(declaringClass, constructorMT);
                return result.asType(constructorMT.changeReturnType(superClass));
            } catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException("Unexpected exception during getting stable field storage constructor", e);
            }
        }

        static MethodHandle getterMHForSFS(MethodHandles.Lookup hostClass, int fieldIndex, Class<?> declaringClass, Class<?> superClass, Class<?> fieldType) {
            try {
                final MethodHandle result = hostClass.findGetter(declaringClass, "f" + fieldIndex, fieldType);
                return result.asType(MethodType.methodType(fieldType, superClass));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Unexpected exception during getting stable field storage getter MH", e);
            }
        }

        static MethodHandle getterMHForSFS(MethodHandles.Lookup hostClass, int fieldIndex, Class<?> declaringClass, Class<?> superClass, MethodType constructorMT) {
            return getterMHForSFS(hostClass, fieldIndex, declaringClass, superClass, constructorMT.parameterType(fieldIndex));
        }

        static <T extends Throwable, E extends RuntimeException> E sneakyThrows(Throwable exception) throws T {
            @SuppressWarnings("unchecked")
            final T te = (T) exception;
            throw te;
        }

        @SuppressWarnings("UnusedReturnValue")
        static int checkIndex(int index, int length) {
            if (index < 0 || index >= length) {
                throw new IndexOutOfBoundsException("Index " + index +" out of bounds for length " + length);
            }
            return index;
        }

        /**
         * Creates a {@code Spliterator} with only the specified element
         *
         * @param <T> Type of elements
         * @return A singleton {@code Spliterator}
         */
        static <T> Spliterator<T> singletonSpliterator(final T element) {
            return new Spliterator<T>() {
                long est = 1;

                @Override
                public Spliterator<T> trySplit() {
                    return null;
                }

                @Override
                public boolean tryAdvance(Consumer<? super T> consumer) {
                    Objects.requireNonNull(consumer);
                    if (est > 0) {
                        est--;
                        consumer.accept(element);
                        return true;
                    }
                    return false;
                }

                @Override
                public void forEachRemaining(Consumer<? super T> consumer) {
                    tryAdvance(consumer);
                }

                @Override
                public long estimateSize() {
                    return est;
                }

                @Override
                public int characteristics() {
                    int value = (element != null) ? Spliterator.NONNULL : 0;

                    return value | Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.IMMUTABLE |
                            Spliterator.DISTINCT | Spliterator.ORDERED;
                }
            };
        }

        static UnsupportedOperationException uoe() { return new UnsupportedOperationException(); }

        @SafeVarargs
        static <E> List<E> listFromArray(E... input) {
            @SuppressWarnings("unchecked")
            E[] tmp = (E[])new Object[input.length];
            for (int i = 0; i < input.length; i++) {
                tmp[i] = Objects.requireNonNull(input[i]);
            }
            return ListN.of(tmp);
        }

        @SuppressWarnings("unchecked")
        static <E> List<E> listFromTrustedArray(Object... input) {
            for (Object o : input) { // implicit null check of 'input' array
                Objects.requireNonNull(o);
            }

            switch (input.length) {
                case 0: {
                    return (List<E>) EMPTY_LIST;
                }
                case 1: {
                    return (List<E>) List12.of(input[0]);
                }
                case 2: {
                    return (List<E>) List12.of(input[0], input[1]);
                }
                default: {
                    return (List<E>) ListN.of(input);
                }
            }
        }
    }

    @SuppressWarnings("NullableProblems")
    abstract static class AbstractImmutableCollection<E> extends AbstractCollection<E> {
        // all mutating methods throw UnsupportedOperationException
        @Override public boolean add(E e) { throw Utilities.uoe(); }
        @Override public boolean addAll(Collection<? extends E> c) { throw Utilities.uoe(); }
        @Override public void    clear() { throw Utilities.uoe(); }
        @Override public boolean remove(Object o) { throw Utilities.uoe(); }
        @Override public boolean removeAll(Collection<?> c) { throw Utilities.uoe(); }
        @Override public boolean removeIf(Predicate<? super E> filter) { throw Utilities.uoe(); }
        @Override public boolean retainAll(Collection<?> c) { throw Utilities.uoe(); }
    }

    @SuppressWarnings("NullableProblems")
    abstract static class AbstractImmutableList<E> extends AbstractImmutableCollection<E>
            implements List<E>, RandomAccess {

        // all mutating methods throw UnsupportedOperationException
        @Override public void    add(int index, E element) { throw Utilities.uoe(); }
        @Override public boolean addAll(int index, Collection<? extends E> c) { throw Utilities.uoe(); }
        @Override public E       remove(int index) { throw Utilities.uoe(); }
        @Override public E       removeFirst() { throw Utilities.uoe(); }
        @Override public E       removeLast() { throw Utilities.uoe(); }
        @Override public void    replaceAll(UnaryOperator<E> operator) { throw Utilities.uoe(); }
        @Override public E       set(int index, E element) { throw Utilities.uoe(); }
        @Override public void    sort(Comparator<? super E> c) { throw Utilities.uoe(); }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            int size = size();
            subListRangeCheck(fromIndex, toIndex, size);
            return SubList.fromList(this, fromIndex, toIndex);
        }

        static void subListRangeCheck(int fromIndex, int toIndex, int size) {
            if (fromIndex < 0)
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            if (toIndex > size)
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            if (fromIndex > toIndex)
                throw new IllegalArgumentException("fromIndex(" + fromIndex +
                        ") > toIndex(" + toIndex + ")");
        }

        @Override
        public Iterator<E> iterator() {
            return ListItr.of(this, size());
        }

        @Override
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator(final int index) {
            int size = size();
            if (index < 0 || index > size) {
                throw outOfBounds(index);
            }
            return ListItr.of(this, size, index);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof List)) {
                return false;
            }

            Iterator<?> oit = ((List<?>) o).iterator();
            for (int i = 0, s = size(); i < s; i++) {
                if (!oit.hasNext() || !Objects.equals(get(i), oit.next())) {
                    return false;
                }
            }
            return !oit.hasNext();
        }

        @Override
        public int hashCode() {
            int hash = 1;
            for (int i = 0, s = size(); i < s; i++) {
                hash = 31 * hash + Objects.hashCode(get(i));
            }
            return hash;
        }

        @Override
        public boolean contains(Object o) {
            return indexOf(o) >= 0;
        }

        IndexOutOfBoundsException outOfBounds(int index) {
            return new IndexOutOfBoundsException("Index: " + index + " Size: " + size());
        }
    }

    static abstract class ListItr<E> implements ListIterator<E> {
        private static final MethodHandle MHListItrSFSConstructor;
        private static final MethodHandle MHGetterList;
        private static final MethodHandle MHGetterSize;
        private static final MethodHandle MHGetterIsListIterator;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameListItr = ListItr.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, List.class, int.class, boolean.class, int.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsListItrClass = Utilities.defineStableFieldStorage(ListItr.class,
                        classNameListItr + "$$StableFieldStorage",
                        classNameListItr,
                        constructorMT,
                        3
                        );
                MHListItrSFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsListItrClass,
                        ListItr.class,
                        constructorMT
                );
                MHGetterList = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsListItrClass,
                        ListItr.class,
                        constructorMT
                );
                MHGetterSize = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsListItrClass,
                        ListItr.class,
                        constructorMT
                );
                MHGetterIsListIterator = Utilities.getterMHForSFS(
                        lookup,
                        2,
                        sfsListItrClass,
                        ListItr.class,
                        constructorMT
                );
            } else {
                MHListItrSFSConstructor = MHGetterList = MHGetterSize = MHGetterIsListIterator = null;
            }
        }

        private int cursor;

        private ListItr(int cursor) {
            this.cursor = cursor;
        }

        static <E> ListItr<E> of(List<E> list, int size) {
            try {
                @SuppressWarnings("unchecked")
                final ListItr<E> result = (ListItr<E>) MHListItrSFSConstructor.invokeExact(list, size, false, 0);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        static <E> ListItr<E> of(List<E> list, int size, int index) {
            try {
                @SuppressWarnings("unchecked")
                final ListItr<E> result = (ListItr<E>) MHListItrSFSConstructor.invokeExact(list, size, true, index);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private List<E> _list() {
            try {
                @SuppressWarnings("unchecked")
                final List<E> result = (List<E>) Objects.requireNonNull(MHGetterList).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private int _size() {
            try {
                return (int) Objects.requireNonNull(MHGetterSize).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        @SuppressWarnings("BooleanMethodIsAlwaysInverted")
        private boolean _isListIterator() {
            try {
                return (boolean) Objects.requireNonNull(MHGetterIsListIterator).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public boolean hasNext() {
            return cursor != _size();
        }

        @Override
        public E next() {
            try {
                int i = cursor;
                E next = _list().get(i);
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw Utilities.uoe();
        }

        @Override
        public boolean hasPrevious() {
            if (!_isListIterator()) {
                throw Utilities.uoe();
            }
            return cursor != 0;
        }

        @Override
        public E previous() {
            if (!_isListIterator()) {
                throw Utilities.uoe();
            }
            try {
                int i = cursor - 1;
                E previous = _list().get(i);
                cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public int nextIndex() {
            if (!_isListIterator()) {
                throw Utilities.uoe();
            }
            return cursor;
        }

        @Override
        public int previousIndex() {
            if (!_isListIterator()) {
                throw Utilities.uoe();
            }
            return cursor - 1;
        }

        @Override
        public void set(E e) {
            throw Utilities.uoe();
        }

        @Override
        public void add(E e) {
            throw Utilities.uoe();
        }
    }


    @SuppressWarnings("NullableProblems")
    static abstract class SubList<E> extends AbstractImmutableList<E> implements RandomAccess {
        private static final MethodHandle MHSubListSFSConstructor;
        private static final MethodHandle MHGetterRoot;
        private static final MethodHandle MHGetterOffset;
        private static final MethodHandle MHGetterSize;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameSubList = SubList.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, AbstractImmutableList.class, int.class, int.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsSubListClass = Utilities.defineStableFieldStorage(SubList.class,
                        classNameSubList + "$$StableFieldStorage",
                        classNameSubList,
                        constructorMT,
                        -1
                );
                MHSubListSFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsSubListClass,
                        SubList.class,
                        constructorMT
                );
                MHGetterRoot = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsSubListClass,
                        SubList.class,
                        constructorMT
                );
                MHGetterOffset = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsSubListClass,
                        SubList.class,
                        constructorMT
                );
                MHGetterSize = Utilities.getterMHForSFS(
                        lookup,
                        2,
                        sfsSubListClass,
                        SubList.class,
                        constructorMT
                );
            } else {
                MHSubListSFSConstructor = MHGetterRoot = MHGetterOffset = MHGetterSize = null;
            }
        }

        private SubList() {
        }

        /**
         * Constructs a sublist of another SubList.
         */
        static <E> SubList<E> fromSubList(SubList<E> parent, int fromIndex, int toIndex) {
            try {
                @SuppressWarnings("unchecked")
                final SubList<E> result = (SubList<E>) MHSubListSFSConstructor.invokeExact(parent._root(), parent._offset() + fromIndex, toIndex - fromIndex);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        /**
         * Constructs a sublist of an arbitrary AbstractImmutableList, which is
         * not a SubList itself.
         */
        static <E> SubList<E> fromList(AbstractImmutableList<E> list, int fromIndex, int toIndex) {
            try {
                @SuppressWarnings("unchecked")
                final SubList<E> result = (SubList<E>) MHSubListSFSConstructor.invokeExact(list, fromIndex, toIndex - fromIndex);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        final AbstractImmutableList<E> _root() {
            try {
                @SuppressWarnings("unchecked")
                final AbstractImmutableList<E> result = (AbstractImmutableList<E>) Objects.requireNonNull(MHGetterRoot).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        final int _offset() {
            try {
                return (int) Objects.requireNonNull(MHGetterOffset).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        final int _size() {
            try {
                return (int) Objects.requireNonNull(MHGetterSize).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public E get(int index) {
            Utilities.checkIndex(index, _size());
            return _root().get(_offset() + index);
        }

        @Override
        public int size() {
            return _size();
        }

        @Override
        public Iterator<E> iterator() {
            return ListItr.of(this, size());
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            rangeCheck(index);
            return ListItr.of(this, size(), index);
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, _size());
            return fromSubList(this, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index > _size()) {
                throw outOfBounds(index);
            }
        }

        @SuppressWarnings("BooleanMethodIsAlwaysInverted")
        boolean allowNulls() {
            if (!(_root() instanceof ListN<?>)) return false;
            _root();
            return false;
        }

        @Override
        public int indexOf(Object o) {
            if (!allowNulls() && o == null) {
                throw new NullPointerException();
            }
            for (int i = 0, s = size(); i < s; i++) {
                if (Objects.equals(o, get(i))) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            if (!allowNulls() && o == null) {
                throw new NullPointerException();
            }
            for (int i = size() - 1; i >= 0; i--) {
                if (Objects.equals(o, get(i))) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Object[] toArray() {
            final int size = _size();
            Object[] array = new Object[size];
            for (int i = 0; i < size; i++) {
                array[i] = get(i);
            }
            return array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            final int size = _size();
            T[] array = a.length >= size ? a :
                    (T[])java.lang.reflect.Array
                            .newInstance(a.getClass().getComponentType(), size);
            for (int i = 0; i < size; i++) {
                array[i] = (T)get(i);
            }
            if (array.length > size) {
                array[size] = null; // null-terminate
            }
            return array;
        }
    }

    @SuppressWarnings("NullableProblems")
    static abstract class List12<E> extends AbstractImmutableList<E> {
        private static final MethodHandle MHList12SFSConstructor;
        private static final MethodHandle MHGetterE0;
        private static final MethodHandle MHGetterE1;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameList12 = List12.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object.class, Object.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsList12Class = Utilities.defineStableFieldStorage(List12.class,
                        classNameList12 + "$$StableFieldStorage",
                        classNameList12,
                        constructorMT,
                        -1
                );
                MHList12SFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsList12Class,
                        List12.class,
                        constructorMT
                );
                MHGetterE0 = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsList12Class,
                        List12.class,
                        constructorMT
                );
                MHGetterE1 = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsList12Class,
                        List12.class,
                        constructorMT
                );
            } else {
                MHList12SFSConstructor = MHGetterE0 = MHGetterE1 = null;
            }
        }

        private List12() {
        }

        static <E> List12<E> of(E e0) {
            try {
                @SuppressWarnings("unchecked")
                final List12<E> result = (List12<E>) MHList12SFSConstructor.invokeExact(Objects.requireNonNull(e0), Utilities.EMPTY);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        static <E> List12<E> of(E e0, E e1) {
            try {
                @SuppressWarnings("unchecked")
                final List12<E> result = (List12<E>) MHList12SFSConstructor.invokeExact(Objects.requireNonNull(e0), Objects.requireNonNull(e1));
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private E _e0() {
            try {
                @SuppressWarnings("unchecked")
                final E result = (E) Objects.requireNonNull(MHGetterE0).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private Object _e1() {
            try {
                return (Object) Objects.requireNonNull(MHGetterE1).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public int size() {
            return _e1() != Utilities.EMPTY ? 2 : 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E get(int index) {
            if (index == 0) {
                return _e0();
            } else if (index == 1 && _e1() != Utilities.EMPTY) {
                return (E)_e1();
            }
            throw outOfBounds(index);
        }

        @Override
        public int indexOf(Object o) {
            Objects.requireNonNull(o);
            if (o.equals(_e0())) {
                return 0;
            } else if (_e1() != Utilities.EMPTY && o.equals(_e1())) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public int lastIndexOf(Object o) {
            Objects.requireNonNull(o);
            if (_e1() != Utilities.EMPTY && o.equals(_e1())) {
                return 1;
            } else if (o.equals(_e0())) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public Object[] toArray() {
            if (_e1() == Utilities.EMPTY) {
                return new Object[] { _e0() };
            } else {
                return new Object[] { _e0(), _e1() };
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            T[] array = a.length >= size ? a :
                    (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            array[0] = (T)_e0();
            if (size == 2) {
                array[1] = (T)_e1();
            }
            if (array.length > size) {
                array[size] = null; // null-terminate
            }
            return array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEach(Consumer<? super E> action) {
            action.accept(_e0()); // implicit null check
            if (_e1() != Utilities.EMPTY) {
                action.accept((E) _e1());
            }
        }

        @Override
        public Spliterator<E> spliterator() {
            if (_e1() == Utilities.EMPTY) {
                return Utilities.singletonSpliterator(_e0());
            } else {
                return super.spliterator();
            }
        }
    }

    // rewrite: allowNulls always false
    @SuppressWarnings("NullableProblems")
    static abstract class ListN<E> extends AbstractImmutableList<E> {
        private static final MethodHandle MHListNSFSConstructor;
        private static final MethodHandle MHGetterElements;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameListN = ListN.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object[].class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsListNClass = Utilities.defineStableFieldStorage(ListN.class,
                        classNameListN + "$$StableFieldStorage",
                        classNameListN,
                        constructorMT,
                        -1
                );
                MHListNSFSConstructor = MethodHandles.dropArguments(
                        Utilities.constructorForSFS(
                                lookup,
                                sfsListNClass,
                                ListN.class,
                                constructorMT
                        ),
                        1,
                        boolean.class
                );
                MHGetterElements = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsListNClass,
                        ListN.class,
                        constructorMT
                );
            } else {
                MHListNSFSConstructor = MHGetterElements = null;
            }
        }

        private ListN() {
        }

        static <E> ListN<E> of(E[] elements) {
            try {
                @SuppressWarnings("unchecked")
                final ListN<E> result = (ListN<E>) MHListNSFSConstructor.invokeExact(elements, false);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private E[] _elements() {
            try {
                @SuppressWarnings("unchecked")
                final E[] result = (E[]) Objects.requireNonNull(MHGetterElements).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public boolean isEmpty() {
            return _elements().length == 0;
        }

        @Override
        public int size() {
            return _elements().length;
        }

        @Override
        public E get(int index) {
            return _elements()[index];
        }

        @Override
        public Object[] toArray() {
            return Arrays.copyOf(_elements(), _elements().length);
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = _elements().length;
            if (a.length < size) {
                // Make a new array of a's runtime type, but my contents:
                return (T[]) Arrays.copyOf(_elements(), size, a.getClass());
            }
            //noinspection SuspiciousSystemArraycopy
            System.arraycopy(_elements(), 0, a, 0, size);
            if (a.length > size) {
                a[size] = null; // null-terminate
            }
            return a;
        }

        @Override
        public int indexOf(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            Object[] es = _elements();
            for (int i = 0; i < es.length; i++) {
                if (Objects.equals(o, es[i])) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            Object[] es = _elements();
            for (int i = es.length - 1; i >= 0; i--) {
                if (Objects.equals(o, es[i])) {
                    return i;
                }
            }
            return -1;
        }
    }

    @SuppressWarnings("NullableProblems")
    static abstract class AbstractImmutableSet<E> extends AbstractImmutableCollection<E> implements Set<E> {

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof Set)) {
                return false;
            }

            Collection<?> c = (Collection<?>) o;
            if (c.size() != size()) {
                return false;
            }
            for (Object e : c) {
                if (e == null || !contains(e)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public abstract int hashCode();
    }
    @SuppressWarnings("NullableProblems")
    static abstract class Set12<E> extends AbstractImmutableSet<E> {
        private static final MethodHandle MHSet12SFSConstructor;
        private static final MethodHandle MHGetterE0;
        private static final MethodHandle MHGetterE1;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameSet12 = Set12.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object.class, Object.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsSet12Class = Utilities.defineStableFieldStorage(Set12.class,
                        classNameSet12 + "$$StableFieldStorage",
                        classNameSet12,
                        constructorMT,
                        -1
                );
                MHSet12SFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsSet12Class,
                        Set12.class,
                        constructorMT
                );
                MHGetterE0 = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsSet12Class,
                        Set12.class,
                        constructorMT
                );
                MHGetterE1 = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsSet12Class,
                        Set12.class,
                        constructorMT
                );
            } else {
                MHSet12SFSConstructor = MHGetterE0 = MHGetterE1 = null;
            }
        }

        private Set12() {
        }

        static <E> Set12<E> of(E e0) {
            try {
                @SuppressWarnings("unchecked")
                final Set12<E> result = (Set12<E>) MHSet12SFSConstructor.invokeExact(Objects.requireNonNull(e0), Utilities.EMPTY);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        static <E> Set12<E> of(E e0, E e1) {
            if (e0.equals(Objects.requireNonNull(e1)))
                throw new IllegalArgumentException("duplicate element: " + e0);
            try {
                @SuppressWarnings("unchecked")
                final Set12<E> result = (Set12<E>) MHSet12SFSConstructor.invokeExact(e0, e1);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private E _e0() {
            try {
                @SuppressWarnings("unchecked")
                final E result = (E) Objects.requireNonNull(MHGetterE0).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private Object _e1() {
            try {
                return (Object) Objects.requireNonNull(MHGetterE1).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public int size() {
            return (_e1() == Utilities.EMPTY) ? 1 : 2;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return o.equals(_e0()) || _e1().equals(o); // implicit nullcheck of o
        }

        @Override
        public int hashCode() {
            return _e0().hashCode() + (_e1() == Utilities.EMPTY ? 0 : _e1().hashCode());
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private int idx = (_e1() == Utilities.EMPTY) ? 1 : 2;

                @Override
                public boolean hasNext() {
                    return idx > 0;
                }

                @Override
                @SuppressWarnings("unchecked")
                public E next() {
                    if (idx == 1) {
                        idx = 0;
                        return (_e1() == Utilities.EMPTY) ? _e0() : (E)_e1();
                    } else if (idx == 2) {
                        idx = 1;
                        return _e0();
                    } else {
                        throw new NoSuchElementException();
                    }
                }
            };
        }

        @Override
        public Object[] toArray() {
            if (_e1() == Utilities.EMPTY) {
                return new Object[] { _e0() };
            } else {
                return new Object[] { _e0(), _e1() };
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            T[] array = a.length >= size ? a :
                    (T[])Array.newInstance(a.getClass().getComponentType(), size);
            array[0] = (T)_e0();
            if (size != 1) {
                array[1] = (T) _e1();
            }
            if (array.length > size) {
                array[size] = null; // null-terminate
            }
            return array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEach(Consumer<? super E> action) {
            if (_e1() == Utilities.EMPTY) {
                action.accept(_e0()); // implicit null check
            } else {
                action.accept(_e0()); // implicit null check
                action.accept((E)_e1());
            }
        }

        @Override
        public Spliterator<E> spliterator() {
            if (_e1() == Utilities.EMPTY) {
                return Utilities.singletonSpliterator(_e0());
            } else {
                return super.spliterator();
            }
        }
    }

    @SuppressWarnings("NullableProblems")
    static abstract class SetN<E> extends AbstractImmutableSet<E> {
        private static final MethodHandle MHSetNSFSConstructor;
        private static final MethodHandle MHGetterElements;
        private static final MethodHandle MHGetterSize;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameSetN = SetN.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object[].class, int.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsSetNClass = Utilities.defineStableFieldStorage(SetN.class,
                        classNameSetN + "$$StableFieldStorage",
                        classNameSetN,
                        constructorMT,
                        -1
                );
                MHSetNSFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsSetNClass,
                        SetN.class,
                        constructorMT
                );
                MHGetterElements = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsSetNClass,
                        SetN.class,
                        constructorMT
                );
                MHGetterSize = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsSetNClass,
                        SetN.class,
                        constructorMT
                );
            } else {
                MHSetNSFSConstructor = MHGetterElements = MHGetterSize = null;
            }
        }

        private SetN() {
        }

        @SafeVarargs
        @SuppressWarnings("unchecked")
        static <E> SetN<E> of(E... input) {
            int size = input.length;

            E[] elements = (E[])new Object[Utilities.EXPAND_FACTOR * size];
            for (E e : input) {
                int idx = probe(elements, e);
                if (idx >= 0) {
                    throw new IllegalArgumentException("duplicate element: " + e);
                } else {
                    elements[-(idx + 1)] = e;
                }
            }
            try {
                @SuppressWarnings("unchecked")
                final SetN<E> result = (SetN<E>) MHSetNSFSConstructor.invokeExact(elements, size);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private E[] _elements() {
            try {
                @SuppressWarnings("unchecked")
                final E[] result = (E[]) Objects.requireNonNull(MHGetterElements).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private int _size() {
            try {
                return (int) Objects.requireNonNull(MHGetterSize).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public int size() {
            return _size();
        }

        @Override
        public boolean isEmpty() {
            return _size() == 0;
        }

        @Override
        public boolean contains(Object o) {
            Objects.requireNonNull(o);
            return _size() > 0 && probe(o) >= 0;
        }

        private final class SetNIterator implements Iterator<E> {

            private int remaining;

            private int idx;

            SetNIterator() {
                remaining = _size();
                idx = 0;
            }

            @Override
            public boolean hasNext() {
                return remaining > 0;
            }

            @Override
            public E next() {
                if (remaining > 0) {
                    E element;
                    int idx = this.idx;
                    int len = _elements().length;
                    // step to the next element; skip null elements
                    do {
                        if (--idx < 0) {
                            idx = len - 1;
                        }
                    } while ((element = _elements()[idx]) == null);
                    this.idx = idx;
                    remaining--;
                    return element;
                } else {
                    throw new NoSuchElementException();
                }
            }
        }

        @Override
        public Iterator<E> iterator() {
            return new SetNIterator();
        }

        @Override
        public int hashCode() {
            int h = 0;
            for (E e : _elements()) {
                if (e != null) {
                    h += e.hashCode();
                }
            }
            return h;
        }

        // returns index at which element is present; or if absent,
        // (-i - 1) where i is location where element should be inserted.
        // Callers are relying on this method to perform an implicit nullcheck
        // of pe
        private int probe(Object pe) {
            return probe(this._elements(), pe);
        }
        private static <E> int probe(E[] elements, Object pe) {
            int idx = Math.floorMod(pe.hashCode(), elements.length);
            while (true) {
                E ee = elements[idx];
                if (ee == null) {
                    return -idx - 1;
                } else if (pe.equals(ee)) {
                    return idx;
                } else if (++idx == elements.length) {
                    idx = 0;
                }
            }
        }

        @Override
        public Object[] toArray() {
            final int size = _size();
            Object[] array = new Object[size];
            Iterator<E> it = iterator();
            for (int i = 0; i < size; i++) {
                array[i] = it.next();
            }
            return array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            final int size = _size();
            T[] array = a.length >= size ? a :
                    (T[])Array.newInstance(a.getClass().getComponentType(), size);
            Iterator<E> it = iterator();
            for (int i = 0; i < size; i++) {
                array[i] = (T)it.next();
            }
            if (array.length > size) {
                array[size] = null; // null-terminate
            }
            return array;
        }
    }

    static abstract class KeyValueHolder<K,V> implements Map.Entry<K,V> {
        private static final MethodHandle MHKeyValueHolderSFSConstructor;
        private static final MethodHandle MHGetterKey;
        private static final MethodHandle MHGetterValue;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameKeyValueHolder = KeyValueHolder.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object.class, Object.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsKeyValueHolderClass = Utilities.defineStableFieldStorage(KeyValueHolder.class,
                        classNameKeyValueHolder + "$$StableFieldStorage",
                        classNameKeyValueHolder,
                        constructorMT,
                        -1
                );
                MHKeyValueHolderSFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsKeyValueHolderClass,
                        KeyValueHolder.class,
                        constructorMT
                );
                MHGetterKey = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsKeyValueHolderClass,
                        KeyValueHolder.class,
                        constructorMT
                );
                MHGetterValue = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsKeyValueHolderClass,
                        KeyValueHolder.class,
                        constructorMT
                );
            } else {
                MHKeyValueHolderSFSConstructor = MHGetterKey = MHGetterValue = null;
            }
        }

        private KeyValueHolder() {
        }

        static <K,V> KeyValueHolder<K,V> of(K key, V value) {
            try {
                @SuppressWarnings("unchecked")
                final KeyValueHolder<K,V> result = (KeyValueHolder<K,V>) MHKeyValueHolderSFSConstructor.invokeExact(Objects.requireNonNull(key), Objects.requireNonNull(value));
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private K _key() {
            try {
                @SuppressWarnings("unchecked")
                final K result = (K) Objects.requireNonNull(MHGetterKey).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private V _value() {
            try {
                @SuppressWarnings("unchecked")
                final V result = (V) Objects.requireNonNull(MHGetterValue).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        /**
         * Gets the key from this holder.
         *
         * @return the key
         */
        @Override
        public K getKey() {
            return _key();
        }

        /**
         * Gets the value from this holder.
         *
         * @return the value
         */
        @Override
        public V getValue() {
            return _value();
        }

        /**
         * Throws {@link UnsupportedOperationException}.
         *
         * @param value ignored
         * @return never returns normally
         */
        @Override
        public V setValue(V value) {
            throw Utilities.uoe();
        }

        /**
         * Compares the specified object with this entry for equality.
         * Returns {@code true} if the given object is also a map entry and
         * the two entries' keys and values are equal. Note that key and
         * value are non-null, so equals() can be called safely on them.
         */
        @Override
        public boolean equals(Object o) {
            if (o instanceof Map.Entry<?, ?>) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                return _key().equals(e.getKey()) && _value().equals(e.getValue());
            }
            return false;
        }

        /**
         * Returns the hash code value for this map entry. The hash code
         * is {@code key.hashCode() ^ value.hashCode()}. Note that key and
         * value are non-null, so hashCode() can be called safely on them.
         */
        @Override
        public int hashCode() {
            return _key().hashCode() ^ _value().hashCode();
        }

        /**
         * Returns a String representation of this map entry.  This
         * implementation returns the string representation of this
         * entry's key followed by the equals character ("{@code =}")
         * followed by the string representation of this entry's value.
         *
         * @return a String representation of this map entry
         */
        @Override
        public String toString() {
            return _key() + "=" + _value();
        }
    }

    @SuppressWarnings("NullableProblems")
    abstract static class AbstractImmutableMap<K,V> extends AbstractMap<K,V> {
        @Override public void clear() { throw Utilities.uoe(); }
        @Override public V compute(K key, BiFunction<? super K,? super V,? extends V> rf) { throw Utilities.uoe(); }
        @Override public V computeIfAbsent(K key, Function<? super K,? extends V> mf) { throw Utilities.uoe(); }
        @Override public V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> rf) { throw Utilities.uoe(); }
        @Override public V merge(K key, V value, BiFunction<? super V,? super V,? extends V> rf) { throw Utilities.uoe(); }
        @Override public V put(K key, V value) { throw Utilities.uoe(); }
        @Override public void putAll(Map<? extends K,? extends V> m) { throw Utilities.uoe(); }
        @Override public V putIfAbsent(K key, V value) { throw Utilities.uoe(); }
        @Override public V remove(Object key) { throw Utilities.uoe(); }
        @Override public boolean remove(Object key, Object value) { throw Utilities.uoe(); }
        @Override public V replace(K key, V value) { throw Utilities.uoe(); }
        @Override public boolean replace(K key, V oldValue, V newValue) { throw Utilities.uoe(); }
        @Override public void replaceAll(BiFunction<? super K,? super V,? extends V> f) { throw Utilities.uoe(); }

        /**
         * @implNote {@code null} values are disallowed in these immutable maps,
         * so we can improve upon the default implementation since a
         * {@code null} return from {@code get(key)} always means the default
         * value should be returned.
         */
        @Override
        public V getOrDefault(Object key, V defaultValue) {
            V v;
            return ((v = get(key)) != null)
                    ? v
                    : defaultValue;
        }
    }

    @SuppressWarnings("NullableProblems")
    static abstract class Map1<K,V> extends AbstractImmutableMap<K,V> {
        private static final MethodHandle MHMap1SFSConstructor;
        private static final MethodHandle MHGetterK0;
        private static final MethodHandle MHGetterV0;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameMap1 = Map1.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object.class, Object.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsMap1Class = Utilities.defineStableFieldStorage(Map1.class,
                        classNameMap1 + "$$StableFieldStorage",
                        classNameMap1,
                        constructorMT,
                        -1
                );
                MHMap1SFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsMap1Class,
                        Map1.class,
                        constructorMT
                );
                MHGetterK0 = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsMap1Class,
                        Map1.class,
                        constructorMT
                );
                MHGetterV0 = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsMap1Class,
                        Map1.class,
                        constructorMT
                );
            } else {
                MHMap1SFSConstructor = MHGetterK0 = MHGetterV0 = null;
            }
        }

        private Map1() {
        }

        static <K,V> Map1<K,V> of(K k0, V v0) {
            try {
                @SuppressWarnings("unchecked")
                final Map1<K,V> result = (Map1<K,V>) MHMap1SFSConstructor.invokeExact(Objects.requireNonNull(k0), Objects.requireNonNull(v0));
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private K _k0() {
            try {
                @SuppressWarnings("unchecked")
                final K result = (K) Objects.requireNonNull(MHGetterK0).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private V _v0() {
            try {
                @SuppressWarnings("unchecked")
                final V result = (V) Objects.requireNonNull(MHGetterV0).invokeExact(this);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public Set<Map.Entry<K,V>> entrySet() {
            return Set12.of(KeyValueHolder.of(_k0(), _v0()));
        }

        @Override
        public V get(Object o) {
            return o.equals(_k0()) ? _v0() : null; // implicit nullcheck of o
        }

        @Override
        public boolean containsKey(Object o) {
            return o.equals(_k0()); // implicit nullcheck of o
        }

        @Override
        public boolean containsValue(Object o) {
            return o.equals(_v0()); // implicit nullcheck of o
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public int hashCode() {
            return _k0().hashCode() ^ _v0().hashCode();
        }

        @Override
        public void forEach(BiConsumer<? super K, ? super V> action) {
            action.accept(_k0(), _v0()); // implicit null check
        }
    }

    static abstract class MapN<K,V> extends AbstractImmutableMap<K,V> {
        private static final MethodHandle MHMapNSFSConstructor;
        private static final MethodHandle MHGetterTable;
        private static final MethodHandle MHGetterSize;
        static {
            if (MHDefineAnonymousClass != null) {
                final String classNameMapN = MapN.class.getName().replace('.', '/');
                final MethodType constructorMT = MethodType.methodType(void.class, Object[].class, int.class);
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                final Class<?> sfsMapNClass = Utilities.defineStableFieldStorage(MapN.class,
                        classNameMapN + "$$StableFieldStorage",
                        classNameMapN,
                        constructorMT,
                        -1
                );
                MHMapNSFSConstructor = Utilities.constructorForSFS(
                        lookup,
                        sfsMapNClass,
                        MapN.class,
                        constructorMT
                );
                MHGetterTable = Utilities.getterMHForSFS(
                        lookup,
                        0,
                        sfsMapNClass,
                        MapN.class,
                        constructorMT
                );
                MHGetterSize = Utilities.getterMHForSFS(
                        lookup,
                        1,
                        sfsMapNClass,
                        MapN.class,
                        constructorMT
                );
            } else {
                MHMapNSFSConstructor = MHGetterTable = MHGetterSize = null;
            }
        }

        private MapN() {
        }

        static <K,V> MapN<K,V> of(Object... input) {
            if ((input.length & 1) != 0) {
                throw new InternalError("length is odd");
            }
            int size = input.length >> 1;

            int len = Utilities.EXPAND_FACTOR * input.length;

            len = (len + 1) & ~1; // ensure table is even length
            Object[] table = new Object[len];

            for (int i = 0; i < input.length; i += 2) {
                @SuppressWarnings("unchecked")
                K k = Objects.requireNonNull((K)input[i]);
                @SuppressWarnings("unchecked")
                V v = Objects.requireNonNull((V)input[i+1]);
                int idx = probe(table, k);
                if (idx >= 0) {
                    throw new IllegalArgumentException("duplicate key: " + k);
                } else {
                    int dest = -(idx + 1);
                    table[dest] = k;
                    table[dest+1] = v;
                }
            }
            try {
                @SuppressWarnings("unchecked")
                final MapN<K,V> result = (MapN<K,V>) MHMapNSFSConstructor.invokeExact(table, size);
                return result;
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        private Object[] _table() {
            try {
                return (Object[]) Objects.requireNonNull(MHGetterTable).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }
        private int _size() {
            try {
                return (int) Objects.requireNonNull(MHGetterSize).invokeExact(this);
            } catch (Throwable e) {
                throw Utilities.sneakyThrows(e);
            }
        }

        @Override
        public boolean containsKey(Object o) {
            Objects.requireNonNull(o);
            return _size() > 0 && probe(o) >= 0;
        }

        @SuppressWarnings("PointlessNullCheck")
        @Override
        public boolean containsValue(Object o) {
            Objects.requireNonNull(o);
            final Object[] table = _table();
            for (int i = 1; i < table.length; i += 2) {
                Object v = table[i];
                if (v != null && o.equals(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            final Object[] table = _table();
            for (int i = 0; i < table.length; i += 2) {
                Object k = table[i];
                if (k != null) {
                    hash += k.hashCode() ^ table[i + 1].hashCode();
                }
            }
            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public V get(Object o) {
            if (_size() == 0) {
                Objects.requireNonNull(o);
                return null;
            }
            int i = probe(o);
            if (i >= 0) {
                return (V)_table()[i+1];
            } else {
                return null;
            }
        }

        @Override
        public int size() {
            return _size();
        }

        @Override
        public boolean isEmpty() {
            return _size() == 0;
        }

        class MapNIterator implements Iterator<Map.Entry<K,V>> {

            private int remaining;

            private int idx;

            MapNIterator() {
                remaining = _size();
                idx = 0;
            }

            @Override
            public boolean hasNext() {
                return remaining > 0;
            }

            private int nextIndex() {
                int idx = this.idx;
                if ((idx -= 2) < 0) {
                    idx = _table().length - 2;
                }
                return this.idx = idx;
            }

            @Override
            public Map.Entry<K,V> next() {
                if (remaining > 0) {
                    int idx;
                    while (true) {
                        if (_table()[idx = nextIndex()] != null) break;
                    }
                    @SuppressWarnings("unchecked")
                    Map.Entry<K,V> e =
                            KeyValueHolder.of((K)_table()[idx], (V)_table()[idx+1]);
                    remaining--;
                    return e;
                } else {
                    throw new NoSuchElementException();
                }
            }
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public Set<Map.Entry<K,V>> entrySet() {
            return new AbstractSet<Map.Entry<K,V>>() {
                @Override
                public int size() {
                    return MapN.this._size();
                }

                @Override
                public Iterator<Map.Entry<K,V>> iterator() {
                    return new MapNIterator();
                }
            };
        }

        // returns index at which the probe key is present; or if absent,
        // (-i - 1) where i is location where element should be inserted.
        // Callers are relying on this method to perform an implicit nullcheck
        // of pk.
        private int probe(Object pk) {
            return probe(_table(), pk);
        }

        private static int probe(Object[] table, Object pk) {
            int idx = Math.floorMod(pk.hashCode(), table.length >> 1) << 1;
            while (true) {
                Object ek = table[idx];
                if (ek == null) {
                    return -idx - 1;
                } else if (pk.equals(ek)) {
                    return idx;
                } else if ((idx += 2) == table.length) {
                    idx = 0;
                }
            }
        }
    }
}

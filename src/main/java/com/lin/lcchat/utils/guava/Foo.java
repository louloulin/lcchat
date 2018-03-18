package com.lin.lcchat.utils.guava;


import com.sun.istack.internal.Nullable;

class Foo {
    @Nullable String sortedBy;
    int notSortedBy;

    public Foo(String sortedBy, int notSortedBy) {
        this.sortedBy = sortedBy;
        this.notSortedBy = notSortedBy;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "sortedBy='" + sortedBy + '\'' +
                ", notSortedBy=" + notSortedBy +
                '}';
    }
}

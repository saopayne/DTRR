package com.tracchis.saopayne.dtrr.util;

import android.support.test.espresso.IdlingResource;

public class EspressoIdlingResource {


    private static SimpleIdlingResource mIdlingResource = new SimpleIdlingResource();

    public static void increment() {
        mIdlingResource.increment();
    }

    public static void decrement() {
        mIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return mIdlingResource;
    }
}

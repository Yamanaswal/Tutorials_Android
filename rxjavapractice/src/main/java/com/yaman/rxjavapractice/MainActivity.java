package com.yaman.rxjavapractice;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observable();
        flowable();
        single();
        maybe();
        //Operators: map(), flatMap(),
    }


    private void observable() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Observable<Integer> observable = Observable.fromIterable(numbers);

        Disposable res = observable
                .subscribe(
                next -> {
                    System.out.println("Received: " + next);
                },
                throwable -> {
                    System.err.println("Error: " + throwable);
                },
                () -> {
                    System.out.println("Completed");
                }
        );

        res.dispose();
    }

    /*
     * It is very similar to Observable but it also handles the BackPressure mechanism.
     * Similar to Observable, but designed to handle backpressure, which is a mechanism to
     * handle situations where an Observable is emitting data faster than the subscriber can consume.
     */

    private void flowable() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Disposable res = Flowable.just(numbers).subscribe(
                next -> {
                    System.out.println("Received: " + next);
                },
                throwable -> {
                    System.err.println("Error: " + throwable);
                },
                () -> {
                    System.out.println("Completed");
                });

        res.dispose();
    }


    /**
     * Single type of Observable is used when you have to return a single item
     * Item will be returned when onSuccess will be called, If there is any error occurs
     * then it will call onError
     */
    private void single() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Disposable res = Single.just(numbers).subscribe(
                next -> {
                    System.out.println("Received: " + next);
                },
                throwable -> {
                    System.err.println("Error: " + throwable);
                }
        );

        res.dispose();
    }

    /**
     * Maybe type of Observable is used when you have to return a single optional
     * value as this is mutually exclusive with error, it means it will call either success
     * or error and then onComplete
     */
    private void maybe() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Disposable res = Maybe.just(numbers).subscribe(
                next -> {
                    System.out.println("Received: " + next);
                },
                throwable -> {
                    System.err.println("Error: " + throwable);
                }
        );

        res.dispose();
    }




}
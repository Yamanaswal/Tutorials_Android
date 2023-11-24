package com.yaman.rxjavapractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basic();
    }

    @SuppressLint("CheckResult")
    private void basic() {
//        Observable<String> observable = Observable.create(emitter -> {
//            emitter.onNext("Hello");
//            emitter.onNext("RxJava");
//            emitter.onComplete();
//        });

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(numbers);

        observable.subscribe(
                item -> {
                    System.out.println("Received: " + item);
                },
                throwable -> {
                    System.err.println("Error: " + throwable);
                },
                () -> {
                    System.out.println("Completed");
                }
        );

    }


}
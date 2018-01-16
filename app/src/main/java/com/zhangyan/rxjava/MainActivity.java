package com.zhangyan.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        test1();
//        test2();
//        test3();
    }

    /**
     * 代表观察者只对被观察者的onNext的事件关心
     */
    private void test3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onComplete();
                emitter.onNext(3);


            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "accept: " + integer);
            }
        });
    }

    private void test2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                //当被观察者在onComplete之后的事件将会继续发出，而观察者收到onComplete后不会在继续接受时间
                //当被观察者在onError()之后的事件将会继续发出，而观察者收到onError()后不会在继续接受时间
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");

            }
        });
    }

    private void test1() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i(TAG, "onNext: " + integer);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        };
        observable.subscribe(observer);
    }
}

package com.example.desuev.sberlesson4_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.desuev.sberlesson4_2.API.ViewCallback;


public class BroadcastReceiverForLesson extends BroadcastReceiver {

    private ViewCallback callback;

    public BroadcastReceiverForLesson(){}

    public BroadcastReceiverForLesson(ViewCallback callback){
        this.callback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        callback.onStateChanged(String.valueOf(intent.getStringExtra("STATE")));
    }
}

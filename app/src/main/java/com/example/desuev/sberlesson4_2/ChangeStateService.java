package com.example.desuev.sberlesson4_2;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class ChangeStateService extends IntentService {

    public ChangeStateService() {
        super(ChangeStateService.class.getName());
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent _intent = new Intent("com.example.desuev.sberlesson4.SEND_MESSAGES_FILTER");
        StateManager sm = StateManager.getInstance();
        sm.changeState();
        _intent.putExtra("STATE", String.valueOf(sm.getState()));
        sendBroadcast(_intent);
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, ChangeStateService.class);
        return intent;
    }
}

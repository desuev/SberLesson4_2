package com.example.desuev.sberlesson4_2;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.desuev.sberlesson4_2.API.ViewCallback;

public class MainActivity extends AppCompatActivity {

    private Button changeBtn;
    private TextView stateText;
    private BroadcastReceiverForLesson receiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        init();
    }


    private void initViews(){
        changeBtn = findViewById(R.id.changeBtn);
        stateText = findViewById(R.id.stateText);
    }

    private void initListeners(){
        changeBtn.setOnClickListener(l -> {
            startService(ChangeStateService.newIntent(MainActivity.this));
            Log.i("INFO: ", "BUTTON CLICKED");
        });
    }

    private void init(){
        receiver = new BroadcastReceiverForLesson(new ViewCallbackImpl());
        filter = new IntentFilter("com.example.desuev.sberlesson4.SEND_MESSAGES_FILTER");
    }

    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(receiver, filter,  null, null );
    }

    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(receiver);
    }

    private class ViewCallbackImpl implements ViewCallback {
        @Override
        public void onStateChanged(String newState) {
            String state = null;
            switch (newState){
                case "1":
                    state = "A";
                    break;
                case "2":
                    state = "B";
                    break;
                case "3":
                    state = "C";
                    break;
                case "4":
                    state = "D";
                    break;
                case "5":
                    state = "E";
                    break;
            }
            stateText.setText("Current state is " + state);
        }
    }
}

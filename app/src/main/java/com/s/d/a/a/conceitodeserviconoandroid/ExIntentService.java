package com.s.d.a.a.conceitodeserviconoandroid;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ExIntentService extends IntentService{

    private static final String TAG = "ExempleDeServico";

    @Override
    protected void onHandleIntent(Intent arg0) {
        Log.i(TAG, "Intent Service iniciado!");

    }

    public ExIntentService() {
        super("ExIntentService");
    }
}

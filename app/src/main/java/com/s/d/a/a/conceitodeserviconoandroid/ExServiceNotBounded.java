package com.s.d.a.a.conceitodeserviconoandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ExServiceNotBounded extends Service {
    private static final String TAG = "ExempleDeServico";

    public ExServiceNotBounded() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate ");
    }

    /**
     * Nesse método onStartComand sucessivos cliques no botão iniciar serviço
     * travará a aplicação se o tempo definido de 20segundos p/ a execução da
     * tarefa não for respeitada.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand ");

        for (int i = 0; i < 3; i++) {
            long endTime = System.currentTimeMillis() + 10 * 1000;

            while (System.currentTimeMillis() < endTime) {
                synchronized (this) {
                    try {
                        wait(endTime - System.currentTimeMillis());
                    } catch (Exception e) {}
                }
            }
            Log.i(TAG, "Service running ");
        }
        return Service.START_STICKY;
    }
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand " + startId);

        final int currentId = startId;

        Runnable r = new Runnable() {
            public void run() {

                for (int i = 0; i < 3; i++)
                {
                    //10 segundos
                    long tempoLimite = System.currentTimeMillis() + 10*1000;

                    while (System.currentTimeMillis() < tempoLimite) {
                        synchronized (this) {
                            try {
                                wait(tempoLimite - System.currentTimeMillis());
                            } catch (Exception e) {

                            }
                        }
                    }
                    Log.i(TAG, "Service running " + currentId);
                }
                stopSelf();
            }
        };

        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service OnBind ");
        return null;
    }

    @Override
    public void onDestroy(){
        Log.i(TAG, "Service OnDestroy ");
    }
}

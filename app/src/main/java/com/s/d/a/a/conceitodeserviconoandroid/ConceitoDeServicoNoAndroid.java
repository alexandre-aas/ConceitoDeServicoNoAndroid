package com.s.d.a.a.conceitodeserviconoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ConceitoDeServicoNoAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito_de_servico_no_android);

        //Intent intencao = new Intent(this, ExIntentService.class);
        //startService(intencao);

    }

    public void onClickButtonService (View view){
        Intent intencao = new Intent(this, ExServiceNotBounded.class);
        startService(intencao);
    }
}

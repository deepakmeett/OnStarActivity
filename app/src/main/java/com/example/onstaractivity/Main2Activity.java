package com.example.onstaractivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
public class Main2Activity extends AppCompatActivity {
    TextView textView;
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        textView = findViewById( R.id.tt1 );
        button1 = findViewById( R.id.btt1 );
        button2 = findViewById( R.id.btt2 );
        final Intent intent = getIntent(  );
        final int s1 = intent.getIntExtra( "s1" , 0);
        final int s2 = intent.getIntExtra( "s2" , 0);
        
        textView.setText( "Numbers: " + s1 +", " + s2 );
        
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = s1 + s2;
                
                Intent resultintent = new Intent();
                resultintent.putExtra( "result", result);
                
                setResult( RESULT_OK, resultintent );
                finish();
                
            }
        } );
        
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = s1 - s2;

                Intent resultintent = new Intent();
                resultintent.putExtra( "result", result);

                setResult( RESULT_OK, resultintent );
                finish();
                
            }
        } );
    }
}

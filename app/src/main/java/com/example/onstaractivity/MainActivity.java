package com.example.onstaractivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText1 = findViewById( R.id.ed1 );
        editText2 = findViewById( R.id.ed2 );
        textView = findViewById( R.id.t1 );
        button = findViewById( R.id.bt1 );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt( editText1.getText().toString() );
                int num2 = Integer.parseInt( editText2.getText().toString() );
                Intent intent = new Intent( MainActivity.this, Main2Activity.class );
                intent.putExtra( "s1", num1 );
                intent.putExtra( "s2", num2 );
                startActivityForResult( intent, 1 );
            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int result = data.getIntExtra( "result", 0 );
            textView.setText( "" + result );

        }
        if (resultCode == RESULT_CANCELED) {
            textView.setText( "Nothing" );
        }
    }
}

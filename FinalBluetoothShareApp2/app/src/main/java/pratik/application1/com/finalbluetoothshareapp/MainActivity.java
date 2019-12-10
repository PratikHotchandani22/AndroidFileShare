package pratik.application1.com.finalbluetoothshareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button send;
    Button recieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send = (Button)findViewById(R.id.SendFilesBtn);
        Button recieve = (Button)findViewById(R.id.RecieveFileBtn);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SendFile.class);
                startActivity(i);

            }
        });


        recieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),RecieveFile.class);
                startActivity(i);

            }
        });

    }
}

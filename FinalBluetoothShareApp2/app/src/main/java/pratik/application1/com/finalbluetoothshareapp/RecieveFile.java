package pratik.application1.com.finalbluetoothshareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecieveFile extends AppCompatActivity {


    Button RecieveFilebtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_file);

        final Button RecieveFilebtn = (Button)findViewById(R.id.RecieveFileBtn);
        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
        final TextView textWaiting = (TextView)findViewById(R.id.textWaiting);


        textWaiting.setVisibility(View.GONE);

        RecieveFilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent discoverableIntent =
                        new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(discoverableIntent);
                RecieveFilebtn.setVisibility(View.GONE);
                textWaiting.setVisibility(View.VISIBLE);
            }
        });

    }
}

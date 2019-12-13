package pratik.application1.com.finalbluetoothshareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecieveFile extends AppCompatActivity {


    Intent receivedIntent = getIntent();


    Button RecieveFilebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_file);

        final Button RecieveFilebtn = (Button) findViewById(R.id.RecieveFileBtn);
        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
        final TextView textWaiting = (TextView) findViewById(R.id.textWaiting);
        //ImageView picView = (ImageView) findViewById(R.id.picView);


        textWaiting.setVisibility(View.GONE);

        RecieveFilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bAdapter == null) {
                    Toast.makeText(getApplicationContext(), "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                } else {
                    if (!bAdapter.isEnabled()) {
                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 1);
                        //bAdapter.enable();
                        Intent discoverableIntent =
                                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                        startActivity(discoverableIntent);
                        RecieveFilebtn.setVisibility(View.GONE);
                        textWaiting.setVisibility(View.VISIBLE);




                    } else {
                        Toast.makeText(getApplicationContext(), "Bluetooth Already on, Click on Allow to make it discoverable", Toast.LENGTH_SHORT).show();

                        Intent discoverableIntent =
                                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                        startActivity(discoverableIntent);
                        RecieveFilebtn.setVisibility(View.GONE);
                        textWaiting.setVisibility(View.VISIBLE);
                    }
                }

                Toast.makeText(getApplicationContext(), "Bluetooth Turned ON and Made Discoverable", Toast.LENGTH_SHORT).show();

//                Intent discoverableIntent =
//                        new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
//                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
//                startActivity(discoverableIntent);
//                RecieveFilebtn.setVisibility(View.GONE);
//                textWaiting.setVisibility(View.VISIBLE);


                //trying to check the received file
                //DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//                Uri receivedUri = (Uri)receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
//
//                if (receivedUri != null) {
//                    //set the picture
//                    //RESAMPLE YOUR IMAGE DATA BEFORE DISPLAYING
//                    picView.setImageURI(receivedUri);//just for demonstration
//                }


            }

        });

    }


}




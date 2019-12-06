package pratik.application1.com.bluetoothapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.bluetooth.BluetoothAdapter;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button)findViewById(R.id.btnSend);
        Button btnOff = (Button)findViewById(R.id.btnOff);
        Button btnRecv = (Button)findViewById(R.id.btnRecv);

        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(bAdapter == null)
//                {
//                    Toast.makeText(getApplicationContext(),"Bluetooth Not Supported",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    if(!bAdapter.isEnabled()){
//                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
//                        //bAdapter.enable();
//
//                        Toast.makeText(getApplicationContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(getApplicationContext(),"Bluetooth Already on", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            }
        });


        //btn recieve
        btnRecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(),RecieveActivity.class);
                startActivity(intent);
            }
        });




        //btn send
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SendActivity.class);
                startActivity(intent);
            }
        });



    }
}

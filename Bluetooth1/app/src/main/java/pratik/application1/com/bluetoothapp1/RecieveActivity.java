package pratik.application1.com.bluetoothapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecieveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);

        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
        final Button btnOnRecv = (Button)findViewById(R.id.btnOnRecv);
        final TextView textWaiting = (TextView)findViewById(R.id.textWaiting);

        textWaiting.setVisibility(View.GONE);

        btnOnRecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent discoverableIntent =
                        new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(discoverableIntent);
                btnOnRecv.setVisibility(View.GONE);
                textWaiting.setVisibility(View.VISIBLE);


            }
        });




    }
}

package pratik.application1.com.finalbluetoothshareapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class SendFile extends AppCompatActivity {

    Button selectFiles;
    private String selectedFilePath;

    private static final int PICK_FILE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);


        Button selectFiles = (Button)findViewById(R.id.SelectFileBtn);
        selectFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //sets the select file to all types of files
                intent.setType("*/*");
                //allows to select data and return it
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");

                //starts new activity to select file and return data
                startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_FILE_REQUEST) {
                if (data == null) {
                    //no data present
                    return;
                }


                Uri selectedFileUri = data.getData();
                File file = new File(selectedFileUri.getPath());//create path from uri
                final String[] split = file.getPath().split(":");//split the path.
                String filePath = split[1];//assign it to a string(your choice).
                selectedFilePath = filePath;


                if (selectedFilePath != null && !selectedFilePath.equals("")) {
                    Toast.makeText(this, "file selected to be shared", Toast.LENGTH_SHORT).show();
                    Intent share = new Intent(Intent.ACTION_SEND);

                    // If you want to share a png image only, you can do:
                    // setType("image/png"); OR for jpeg: setType("image/jpeg");
                    share.setType("*/*");

                    // directory
                    share.putExtra(Intent.EXTRA_STREAM, selectedFileUri);

                    share.setPackage("com.android.bluetooth");
                    startActivity(Intent.createChooser(share, "Share File!"));

                } else {
                    Toast.makeText(this, "File can not be shared", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}

package pratik.application1.com.finalbluetoothshareapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.DocumentsProvider;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.DocumentType;

import java.io.File;
import java.util.ArrayList;

public class SendFile extends AppCompatActivity {

    Button selectVideos;
    private String selectedFilePath;

    private static final int PICK_FILE_REQUEST = 1;

    Button selectDocument;
    Button selectImages;


    String[] mimeTypes =
            {"application/msword","application/vnd.openxmlformats-officedocument.wordprocessingml.document", // .doc & .docx
                    "application/vnd.ms-powerpoint","application/vnd.openxmlformats-officedocument.presentationml.presentation", // .ppt & .pptx
                    "application/vnd.ms-excel","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", // .xls & .xlsx
                    "text/plain",
                    "application/pdf",
                    "application/zip"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);


        Button selectVideos = (Button)findViewById(R.id.SendVideosBtn);
        final Button selectDocument  = (Button)findViewById(R.id.SendDocumentsBtn);
        Button selectImages = (Button)findViewById(R.id.SendImagesBtn);


        selectImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intent = new Intent();
//                //sets the select file to all types of files
//                intent.setType("*/*");
//
//                //allows to select data and return it
//                intent.setAction(Intent.ACTION_GET_CONTENT);

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                //starts new activity to select file and return data
                startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);
            }
        });


        selectVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);


            }
        });

        selectDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





//
           Intent intent = new Intent();
////                //sets the select file to all types of files
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("application/pdf");
                //String[] mimetypes = {"application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/msword"};
                //intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
////
////                //allows to select data and return it
            intent.setAction(Intent.ACTION_GET_CONTENT);
////
////
////
////                //allows to select data and return it
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

package com.example.nour.forlearinig;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView vidio;
int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     vidio=findViewById(R.id.videoView);
    }

    public void bt(View view) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, i);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            vidio.setVideoURI(uri);
            vidio.setMediaController(new MediaController(this));
            vidio.requestFocus();
            vidio.start();
        }
    }
}

        /*
        img = findViewById(R.id.img);
    }

    public void bt(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        intent.putExtra("crop","true");
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        intent.putExtra("outputX",200);
        intent.putExtra("outputY",200);
        intent.putExtra("return-data",true);

        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {

            img.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }


    }
}


//take a pic from camera
    public void bt(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {

            img.setImageBitmap((Bitmap)data.getExtras().get("data"));
        }

    }


}

     //take photo from galary

    public void bt(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode == RESULT_OK)
        {
        Uri uri = data.getData();
        img.setImageURI(uri);
        }

    }

  //notifications
    public void notifi(View view) {
        NotificationManager mm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.foood);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("اصحى")
                .setContentText("قوم يا بقرة")
                .setSmallIcon(R.drawable.foood)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .setNumber(1);
        builder.setDefaults(Notification.DEFAULT_SOUND  | Notification.DEFAULT_VIBRATE);
        builder.setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.n));
        builder.setVibrate(new long[]{500,1000,500,1000});
          mm.notify(1,builder.build());


        /*
          //read textfile
          InputStreem input=null
          try
          {
          input=getAsset().open(name)
          int size = input.available();
          byte[] addtxt =new byte(size);
          input.read(addtxt);
          input.close();
          String txt = new String(addtxt);
          textview.settext(txt);
          }cach(){}
          */





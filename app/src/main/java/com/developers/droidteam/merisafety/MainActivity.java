package com.developers.droidteam.merisafety;

import android.*;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_MSG =1880 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.l2,new Mainfragment());
        ft.commit();


        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){

        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(shouldShowRequestPermissionRationale(android.Manifest.permission.SEND_SMS)){
                    Toast.makeText(this, "you need to check permission", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            requestPermissions(new String[]{android.Manifest.permission.SEND_SMS},REQUEST_MSG);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if(requestCode==REQUEST_MSG){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else {
                Toast.makeText(this, "permission was not granted", Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }
}

package com.riya.example.designpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface {

    public static String[] progNames={"Shawn Madness","Chrester Hola","Sharon"};
    public static String[] progDes={"hobokon, Nywork","new jersy, Nywork","abc, Nywork "};
    int image[]={R.drawable.direction,R.drawable.direction,R.drawable.direction};
    int pictures[]={R.drawable.call,R.drawable.call,R.drawable.call};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__recycler);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ListAdapter customAdapter = new ListAdapter(MainActivity.this, progNames,progDes,image,pictures,this);
        recyclerView.setAdapter(customAdapter);
    
        /*ListView lv;
    public static String[] progNames={"Shawn Madness","Chrester Hola","Sharon"};
   // public static String[][] progNames={{"Shawn Madness","hobokon, Nywork"},{"Chrester Hola","new jersy, Nywork"},{"Sharon","abc, Nywork "}};
   public static String[] progDes={"hobokon, Nywork","new jersy, Nywork","abc, Nywork "};
    int image[]={R.drawable.direction,R.drawable.direction,R.drawable.direction};
    int pictures[]={R.drawable.call,R.drawable.call,R.drawable.call};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listvw);

       *//* for(int i=0;i<progNames.length;i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put( "line1", progNames[i][0]);
            item.put( "line2", progNames[i][1]);
          //  item.put( "line3", States_Capitals_Population[i][2]);
           // lv.add( item );
        }*//*
        MyList_Adapter adapter=new MyList_Adapter(this,progNames,progDes,image,pictures);

        lv.setAdapter(adapter);*/
    }



    @Override
    public void onItemClick(int position) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:8910871496"));

        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    @Override
    public void onLongItemClick(int position) {

    }
}

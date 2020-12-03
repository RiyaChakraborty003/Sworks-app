package com.riya.example.designpractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {
    EditText edittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        Button button = findViewById(R.id.button);
        edittext = findViewById(R.id.editText);
        Bundle getData = getIntent().getExtras();
        String name = getData.getString("userName");
        String pwd = getData.getString("userPwd");
      try {


          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg) {


                  String phone_number
                          = edittext.getText().toString();

                  // Getting instance of Intent
                  // with action as ACTION_CALL
                  Intent phone_intent
                          = new Intent(Intent.ACTION_CALL);

                  // Set data of Intent through Uri
                  // by parsing phone number
                  phone_intent
                          .setData(Uri.parse("tel:"
                                  + phone_number));

                  // start Intent
                  if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                      // TODO: Consider calling
                      //    ActivityCompat#requestPermissions
                      // here to request the missing permissions, and then overriding
                      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                      //                                          int[] grantResults)
                      // to handle the case where the user grants the permission. See the documentation
                      // for ActivityCompat#requestPermissions for more details.
                      return;
                  }
                  startActivity(phone_intent);
                /*String phone_number
                        = edittext.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone_number));

                if (ActivityCompat.checkSelfPermission(SecondActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);*/
              }
          });
          // button.setText(getIntent().getStringExtra("ListViewClickedValue"));
      }catch (Exception e){
          
      }
    }
}
//    public static String[] progNames={"Shawn Madness","Chrester Hola","Sharon"};
//    public static String[] progDes={"hobokon, Nywork","new jersy, Nywork","abc, Nywork "};
//    int image[]={R.drawable.direction,R.drawable.direction,R.drawable.direction};
//    int pictures[]={R.drawable.call,R.drawable.call,R.drawable.call};
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main__recycler);
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        // set a LinearLayoutManager with default vertical orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        ListAdapter customAdapter = new ListAdapter(SecondActivity.this, progNames,progDes,image,pictures);
//        recyclerView.setAdapter(customAdapter);

  //  setContentView(R.layout.second_page);


  /*  tab=findViewById(R.id.det);
        tab.setText(getIntent().getStringExtra("ListViewValue"));
    nil=findViewById(R.id.tab);
        nil.setText(getIntent().getStringExtra("ListViewDetailValue"));
    magic=findViewById(R.id.maze);
       magic.setImageResource(getIntent().getIntExtra("img",R.drawable.apple));
*/





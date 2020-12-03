package com.riya.example.designpractice;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private static final int REQUEST_CALL= 100;

    private RecyclerViewClickInterface recyclerViewClickInterface;
    String[] progNames1;
    String[] progDes1;
    int[] image1;
    int[] picture1;


    Context mycontext;


    public ListAdapter(Context context, String[] progNames, String[] progDes, int[] image, int[] picture, RecyclerViewClickInterface recyclerViewClickInterface) {

        mycontext = context;
        progNames1 = progNames;
        progDes1 = progDes;
        image1 = image;
        picture1 = picture;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mycontext).inflate(R.layout.list_item, parent, false);
        // pass the view to View Holder
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(progNames1[position]);
        holder.textView2.setText(progDes1[position]);
        holder.imageView1.setImageResource(R.drawable.direction);
        holder.imageView2.setImageResource(R.drawable.call);

    }

    @Override
    public int getItemCount() {
        return progNames1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView imageView1, imageView2;

        // init the item view's
        public ViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            imageView1 = itemView.findViewById(R.id.navigatin);
            imageView2 = itemView.findViewById(R.id.call);
            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //recyclerViewClickInterface.onItemClick(getAdapterPosition());

//                    Intent intent = new Intent(mycontext, SecondActivity.class);
//                    intent.putExtra("ListViewClickedValue", progNames1.length);
//                   if(progNames1.length==1) {
//intent.putExtra("ListViewClickedValue", "Apple iPhone 7");
//
//                    mycontext.startActivity(intent);
//                }

                    Intent i = new Intent(mycontext, MapPageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("userName", "Name");
                    bundle.putString("userPwd", "Password");
                    i.putExtras(bundle);
                    mycontext.startActivity(i);

                }
           /* itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
                    return true;
                }
            });*/

            });

            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


    makePhoneCall();
    // Intent callIntent = new Intent(Intent.ACTION_CALL);
    // callIntent.setData(Uri.parse("tel:"+629044575));




       /* @Override
        public void onClick(View arg0) {
            // String number=edittext1.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+6290445752));
            mycontext.startActivity(callIntent);
        }*/
    }
});
        }
    /*    @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            //   super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if(requestCode==REQUEST_CALL){
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    makePhoneCall();
                }
                else
                {
                    Toast.makeText(mycontext,"PERMISSION DENIED",Toast.LENGTH_SHORT).show();
                }
            }
        }*/

    }

    private void makePhoneCall(){
        if (ContextCompat.checkSelfPermission(mycontext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //    return;

            ActivityCompat.requestPermissions((Activity) mycontext,new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
        else{
           /* String number;
            if (progNames1.length== 1){
                number="6290445752";}
            else if(progNames1.length==){
                number="7290445752";}
            else{
                 number="8290445752";}

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number));
            mycontext.startActivity(callIntent);*/


          String number="860012312";
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number));
            mycontext.startActivity(callIntent);
        }
    }


}

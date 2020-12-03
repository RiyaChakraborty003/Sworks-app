package com.riya.example.designpractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyList_Adapter extends BaseAdapter {
    Context context;
    String[] progNames;
    String[] progDes;
    int[] image;
    int[] picture;

    public MyList_Adapter(Context context, String[] progNames, String[] progdes, int[] image, int[] pictures) {
        this.context = context;
        this.progNames = progNames;
        this.progDes = progdes;
          this.image=image;
       this.picture=picture;
    }

    @Override
    public int getCount() {
        return progNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("qwerty", "getView: " + i);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView textView1 = rowView.findViewById(R.id.text1);
        TextView textView2 = rowView.findViewById(R.id.text2);
        textView1.setText(progNames[i]);
     //   textView2.setText(progDes.length);
        ImageView imageView1=rowView.findViewById(R.id.call);
        ImageView imageView2=rowView.findViewById(R.id.navigatin);
        imageView1.setImageResource(image[i]);
       // imageView2.setImageResource(image[i]);

      /*  MyList_Adapter myList_adapter = new MyList_Adapter(this, lv,
                R.layout.list_item,
                new String[] { "line1","line2", "line3" },
                new int[] {R.id.text1, R.id.text2});*/
      /*  if(i==0){
            textView1.setText(progNames[0]);
        }
        if(i==1){
            textView2.setText(progDes[1]);
        }*/
        return rowView;
    }

}




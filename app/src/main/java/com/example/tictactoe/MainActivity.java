package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int active=0;

    boolean isActive=true;
    int [][] wonSate={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int [] gateState={2,2,2,2,2,2,2,2,2};

    public void dropIn(View view) {
        ImageView imageView = (ImageView) view;
        int tappedCounter = Integer.parseInt(view.getTag().toString());

        gateState[tappedCounter] = active;//gateStat=[0,1,1,2,0,2,2,2,0];

        if (isActive) {
            if (active == 0) {
                imageView.setImageResource(R.drawable.img_1);
                active = 1;
            } else {
                imageView.setImageResource(R.drawable.img_3);
                active = 0;
            }


            for (int[] winningPosition : wonSate) {
                
                if (gateState[winningPosition[0]] == gateState[winningPosition[1]]
                        && gateState[winningPosition[1]] == gateState[winningPosition[2]]
                        && gateState[winningPosition[0]] != 2)
                {
                    isActive=false;
                     alertBox(active);
                }
            }
        }
    }
    public void alertBox(int active){
        AlertDialog.Builder alerDialog=new AlertDialog.Builder(this);

        if(active==1){
            alerDialog.setTitle("CIRCULE IS WON");
        }else if(active==0){
            alerDialog.setTitle("CROSS IS WON");
        }
        alerDialog.setMessage("Do you want to restart the game");

        alerDialog.setPositiveButton("YES", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(getIntent());
            }
        });
        alerDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alerDialog.show();

    }
}
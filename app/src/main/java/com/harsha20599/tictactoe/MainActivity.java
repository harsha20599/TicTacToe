package com.harsha20599.tictactoe;

import android.content.Intent;
import android.icu.text.IDNA;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // o is blue and 1 is pink

    int userCounter = 0;
    int count  = 0;

    int[] gameState  = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void insert(View view){
        ImageView counter = (ImageView) view;
        TextView heading = (TextView) findViewById(R.id.heading);
        Button btnPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2) {



            gameState[tappedCounter] = userCounter;

            if (userCounter == 0) {

                counter.setImageResource(R.drawable.x);
                counter.animate().rotationBy(360f).setDuration(300);
                userCounter = 1;
                count++;
            } else {

                counter.setImageResource(R.drawable.o);
                count++;
                userCounter = 0;
            }
            for(int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2){
                    if(gameState[winningPosition[0]] == 0){
                        heading.setText("PINK WINS");
                    }
                    else{
                        heading.setText("BLUE WINS");
                    }
                    btnPlayAgain.setVisibility(View.VISIBLE);

                }
            }
            if(count == 9){
                btnPlayAgain.setVisibility(View.VISIBLE);
            }
        }
        System.out.println(count);

    }
    public void playAgain(View view){
        count = 0;
        Button btnPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        btnPlayAgain.setVisibility(View.INVISIBLE);
        TextView heading = (TextView) findViewById(R.id.heading);
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        ImageView image3 = (ImageView) findViewById(R.id.image3);
        ImageView image4 = (ImageView) findViewById(R.id.image4);
        ImageView image5 = (ImageView) findViewById(R.id.image5);
        ImageView image6 = (ImageView) findViewById(R.id.image6);
        ImageView image7 = (ImageView) findViewById(R.id.image7);
        ImageView image8 = (ImageView) findViewById(R.id.image8);
        ImageView image9 = (ImageView) findViewById(R.id.image9);


        ImageView[] images = new ImageView[] {image1,image2,image3,image4,image5,image6,image7,image8,image9};


        LinearLayout row =  (LinearLayout) findViewById(R.id.rowTic);
        for(int i =0;i<images.length;i++){

            images[i].setImageResource(0);
        }

        heading.setText("TIC TAC TOE");



        userCounter = 0;



        for(int i = 0 ; i<gameState.length;i++){
            gameState[i] = 2;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"Created by harsha20599",Toast.LENGTH_SHORT).show();

    }

    int back = 1;
    @Override
    public void onBackPressed(){
        if(back==2)
        {
            super.onBackPressed();
        }
        else{
            Toast.makeText(this,"Press back again to close",Toast.LENGTH_SHORT).show();
            back++;
        }
    }
}

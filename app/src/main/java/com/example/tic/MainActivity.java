package com.example.tic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView playerone,playertwo, playerOneScore, PlayerTwoScore, playerStatus ,playerStatusTwo, type1,type2;
    private int playerOneScorecount, playerTwoScorecount, rountCount;
    boolean activeplayer;
    private Button resetGame;
    private Button[] buttons = new Button[9];

//p1 =0
    // p2 =1
    //empty =2

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},//rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //colums
            {0, 4, 8}, {2, 4, 6}        //cross
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerone =(TextView)findViewById(R.id.playerOne) ;
        playertwo =(TextView)findViewById(R.id.playerTwo) ;

        playerOneScore = (TextView) findViewById(R.id.playerOneScore);
        PlayerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        type1 =(TextView) findViewById(R.id.type1);
        type2 =(TextView) findViewById(R.id.type2);
        playerStatus = (TextView) findViewById(R.id.playerStatus);
        playerStatusTwo = (TextView) findViewById(R.id.playerStatusTwo);
        resetGame = (Button) findViewById(R.id.resetGame);



        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);

        }

        rountCount = 0;
        playerOneScorecount = 0;
        playerTwoScorecount = 0;
        activeplayer = true;


        Bundle b  = getIntent().getExtras();
        String r1 = b.getString("radioOne");
        String r2 = b.getString("radioTwo");
        type1.setText(r1);
        type2.setText(r2);

        String r3 = b.getString("text1");
        String r4 = b.getString("text2");
        playerone.setText(r3 + "          ");
        playertwo.setText("             "+r4);



    }


    @Override
    public void onClick(View v) {

        StringBuilder data3 = new StringBuilder();
        StringBuilder data4 = new StringBuilder();
        Bundle b = getIntent().getExtras();
        String r1 = b.getString("radioOne");
        String r2 = b.getString("radioTwo");

        if (!((Button) v).getText().toString().equals("")) {

            return;
        }

        String buttonID = v.getResources().getResourceName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));

        if (activeplayer) {

            ((Button) v).setText(r1);
            ((Button) v).setTextColor(Color.parseColor("#ffc34a"));
            gameState[gameStatePointer] = 0;

        } else {
            ((Button) v).setText(r2);
            ((Button) v).setTextColor(Color.parseColor("#70ffeA"));
            gameState[gameStatePointer] = 1;
        }
        rountCount++;

        if(checkWinner()){
            if(activeplayer){
                playerOneScorecount++;
                updatePlayerScore();
                Toast.makeText(this, "player One Won", Toast.LENGTH_SHORT).show();
                playAgain();

            }else {
                playerTwoScorecount++;
                updatePlayerScore();
                Toast.makeText(this, "player Two Won", Toast.LENGTH_SHORT).show();
                playAgain();

            }

        }else if (rountCount==9){
            playAgain();
            Toast.makeText(this, "NO Winner", Toast.LENGTH_SHORT).show();

        }else {

            activeplayer = !activeplayer;
        }

        if(playerOneScorecount> playerTwoScorecount){
            playerStatus.setText("player One is Winning");

        }else if (playerTwoScorecount > playerOneScorecount){
            playerStatus.setText("Player two is Winning");
        }



        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
                playerOneScorecount=0;
                playerTwoScorecount=0;
                playerStatus.setText("");
                updatePlayerScore();


            }
        });

    }

    public boolean checkWinner() {

        boolean winnerResult = false;

        for (int[] winningPosion : winningPositions) {
            if (gameState[winningPosion[0]] == gameState[winningPosion[1]] &&
                    gameState[winningPosion[1]] == gameState[winningPosion[2]] &&
                    gameState[winningPosion[0]] != 2) {
                winnerResult = true;
            }
        }
        return winnerResult;
    }
    public void updatePlayerScore() {

        playerOneScore.setText(Integer.toString(playerOneScorecount));
        PlayerTwoScore.setText(Integer.toString(playerTwoScorecount));


    }

    public void playAgain(){
        rountCount = 0;
        activeplayer = true;
        for (int i = 0 ; i<buttons.length; i++){
            gameState[i] = 2 ;
            buttons[i].setText("");
        }

    }

}

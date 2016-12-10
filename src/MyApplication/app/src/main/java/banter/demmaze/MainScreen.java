package banter.demmaze;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button newGame = (Button)findViewById(R.id.bNew);
        Button exit = (Button)findViewById(R.id.bExit);
        newGame.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //check which button was clicked with its id
        switch(v.getId()) {
            case R.id.bExit:
                finish();
                break;
            case R.id.bNew:
                final String[] levels = {"1", "2", "3"};
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Select a Maze");
                builder.setItems(levels, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Intent game = new Intent(MainScreen.this, Game.class);  //create an Intent to launch the Game Activity
                        Maze maze = CreateMaze.getMaze(item+1);         //use helper class for creating the Maze
                        game.putExtra("maze", maze);                     //add the maze to the intent which we'll retrieve in the Maze Activity
                        startActivity(game);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
        }
    }
}

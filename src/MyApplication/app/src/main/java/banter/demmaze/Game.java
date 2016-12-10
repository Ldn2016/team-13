package banter.demmaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Game extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();    //get the intent extras
        Maze maze = (Maze)extras.get("maze");  //retrieve the maze from intent extras
        GameView view = new GameView(this, maze);
        setContentView(view);
    }
}
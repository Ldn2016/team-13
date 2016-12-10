package banter.demmaze;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by ryanchung on 10/12/2016.
 */
public class GameView extends View {

    private int width, height, lineWidth;
    private int mazeSizeX, mazeSizeY;
    float cellWidth, cellHeight;
    float totalCellWidth, totalCellHeight;
    private int mazeFinishX, mazeFinishY;
    private Maze maze;
    private Activity context;
    private Paint line, red, background;

    public GameView(Context context, Maze maze) {
        super(context);
        this.context = (Activity)context;
        this.maze = maze;
        mazeFinishX = maze.getFinalX();
        mazeFinishY = maze.getFinalY();
        mazeSizeX = maze.getSizeX();
        mazeSizeY = maze.getSizeY();
        line = new Paint();
        line.setColor(getResources().getColor(R.color.colorPrimary));
        red = new Paint();
        red.setColor(getResources().getColor(R.color.colorPrimary));
        background = new Paint();
        background.setColor(getResources().getColor(R.color.colorAccent));
        setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

}

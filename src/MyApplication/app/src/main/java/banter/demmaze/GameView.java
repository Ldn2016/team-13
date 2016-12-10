package banter.demmaze;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

public class GameView extends View {

    private int width, height, lineWidth;
    private int mazeSizeX, mazeSizeY;
    private float cellWidth, cellHeight;
    private float totalCellWidth, totalCellHeight;
    private int mazeFinishX, mazeFinishY;
    private Maze maze;
    private Activity context;
    private Paint line, red, background;

    public GameView(Context context, Maze maze) {
        super(context);
        this.context = (Activity)context;
        this.maze = maze;
        this.mazeFinishX = maze.getFinalX();
        this.mazeFinishY = maze.getFinalY();
        this.mazeSizeX = maze.getSizeX();
        this.mazeSizeY = maze.getSizeY();
        this.line = new Paint();
        this.line.setColor(getResources().getColor(R.color.line, context.getTheme()));
        this.red = new Paint();
        this.red.setColor(getResources().getColor(R.color.position, context.getTheme()));
        this.background = new Paint();
        this.background.setColor(getResources().getColor(R.color.game_bg, context.getTheme()));
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = (w < h)?w:h;
        // square mazes
        height = width;
        lineWidth = 2;
        cellWidth = (width - ((float)mazeSizeX*lineWidth)) / mazeSizeX;
        totalCellWidth = cellWidth+lineWidth;
        cellHeight = (height - ((float)mazeSizeY*lineWidth)) / mazeSizeY;
        totalCellHeight = cellHeight+lineWidth;
        red.setTextSize(cellHeight * 0.75f);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //fill in the background
        canvas.drawRect(0, 0, width, height, background);

        boolean[][] hLines = maze.getHorizontalLines();
        boolean[][] vLines = maze.getVerticalLines();
        //iterate over the boolean arrays to draw walls
        for(int i = 0; i < mazeSizeX; i++) {
            for(int j = 0; j < mazeSizeY; j++){
                float x = j * totalCellWidth;
                float y = i * totalCellHeight;
                if(j < mazeSizeX - 1 && vLines[i][j]) {
                    //we'll draw a vertical line
                    canvas.drawLine(x + cellWidth,   //start X
                            y,               //start Y
                            x + cellWidth,   //stop X
                            y + cellHeight,  //stop Y
                            line);
                }
                if(i < mazeSizeY - 1 && hLines[i][j]) {
                    //we'll draw a horizontal line
                    canvas.drawLine(x,               //startX
                            y + cellHeight,  //startY
                            x + cellWidth,   //stopX
                            y + cellHeight,  //stopY
                            line);
                }
            }
        }
        int currentX = maze.getCurrentX(),currentY = maze.getCurrentY();
        //draw the ball
        canvas.drawCircle((currentX * totalCellWidth) + (cellWidth / 2),   //x of center
                (currentY * totalCellHeight) + (cellWidth / 2),  //y of center
                (cellWidth * 0.45f),                           //radius
                red);
        //draw the finishing point indicator
        canvas.drawText("F",
                (mazeFinishX * totalCellWidth) + (cellWidth * 0.25f),
                (mazeFinishY * totalCellHeight) + (cellHeight * 0.75f),
                red);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent evt) {
        boolean moved;
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                moved = maze.move(Maze.UP);
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                moved = maze.move(Maze.DOWN);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                moved = maze.move(Maze.RIGHT);
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                moved = maze.move(Maze.LEFT);
                break;
            default:
                return super.onKeyDown(keyCode,evt);
        }
        if(moved) {
            //the ball was moved so we'll redraw the view
            invalidate();
            if(maze.isGameComplete()) {
                //game completed
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(context.getText(R.string.finished_title));
                LayoutInflater inflater = context.getLayoutInflater();
                View view = inflater.inflate(R.layout.finish, null);
                builder.setView(view);
                View closeButton =view.findViewById(R.id.closeGame);
                closeButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View clicked) {
                        if(clicked.getId() == R.id.closeGame) {
                            context.finish();
                        }
                    }
                });
                AlertDialog finishDialog = builder.create();
                finishDialog.show();
            }
        }
        return true;
    }

}

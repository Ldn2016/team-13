package banter.demmaze;

public class CreateMaze {

    public static Maze getMaze(int mazeNo) {
        if (mazeNo < 1) {
            System.err.println("Can't have a negative maze number");
            System.exit(1);
        }
        Maze maze = null;
        if(mazeNo == 1) {
            maze = new Maze();
            boolean[][] vLines = new boolean[][]{
                    {false,true ,false,false,true ,false,false},
                    {false,true ,false,true ,false,true ,true },
                    {true ,false,false,false,true ,false,false},
                    {true ,false,true ,true ,false,false,true },
                    {true ,false,false,false,true ,true ,false},
                    {false,true ,false,false,true ,false,false},
                    {false,true ,true ,true ,true ,true ,false},
                    {false,false,false,true ,false,false,false}
            };
            boolean[][] hLines = new boolean[][]{
                    {false,false,true ,true ,false,false,true ,false},
                    {false,false,true ,true ,false,true ,false,false},
                    {true ,true ,false,true ,true ,false,true ,true },
                    {false,false,true ,false,true ,true ,false,false},
                    {false,true ,true ,true ,true ,false,true ,true },
                    {true ,true ,false,true ,false,false,true ,false},
                    {false,true ,false,false,false,true ,false,true }
            };
            maze.setVerticalLines(vLines);
            maze.setHorizontalLines(hLines);
            maze.setCurrentPosition(0, 0);
            maze.setFinalPosition(7, 7);
            maze.setSizeX(7);
            maze.setSizeY(7);
        }
        //possible extension of other mazes?
        return maze;
    }

}

class Maze {
    constructor() {
        this.maze = new Array(4);
        for(var i=0;i<4;i++) {
            this.maze[i] = new Array(4);
        }

        this.generateMaze(0,0,4,4);
        console.log(this.maze);
    }


    generateMaze(xMin, yMin, xMax, yMax) {
        let width = xMax - xMin;
        let height = yMax - yMin;

        if (width < 2 || height < 2) {
            return;
        }

        let direction = Math.floor(Math.random() * 2) + 1;
        let line = this.getLine(direction, xMin, yMin, xMax - 1 , yMax - 1);

        let gapMin;
        let gapMax;
        let i;

        if (direction === 1) {
            for (i = 0; i < xMax; i++) {
                this.maze[i][line] = 1;
            }
            gapMin = this.getRandom(xMin, xMax - 1);
            gapMax = this.getRandom(gapMin, xMax - 1);

            for (i = gapMin; i <= gapMax; i++) {
                this.maze[i][line] = 0;
            }

            this.generateMaze(xMin, yMin, line, yMax);
            this.generateMaze(line+1, yMin, xMax, yMax);
        } else {
            for (i = 0; i < yMax; i++) {
                this.maze[line][i] = 1;
            }
            gapMin = this.getRandom(yMin, yMax - 1);
            gapMax = this.getRandom(gapMin, yMax - 1);

            for (i = gapMin; i <= gapMax; i++) {
                this.maze[line][i] = 0;
            }

            this.generateMaze(xMin, yMin, xMax, line);
            this.generateMaze(xMin, line+1, xMax, yMax);
        }
    }


    getLine(direction, x, y, width, height) {

        if (direction === 1) {
            return Math.floor(Math.random() * (width - x + 1)) + x;
        } else {
            return Math.floor(Math.random() * (height - y + 1)) + y;
        }

    }

    getRandom(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
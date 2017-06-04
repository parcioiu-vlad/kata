/**
 * Maze generation using recursive division.
 *
 * It takes an rectangle and split it in two (random direction).
 * The split is represented by a line (wall).
 * After the split, it will add a gap in the wall and then recursively split the resulted rectangles.
 */
class Maze {

    constructor(size, limit) {
        this._size = size;
        this._limit = limit;
        this._maze = new Array(size);
        for(let i=0;i<size;i++) {
            this._maze[i] = new Array(size);
        }
    }

    generateMaze() {
        this.divide(0, 0, this._size, this._size);
    }

    divide(xMin, yMin, xMax, yMax) {
        let width = xMax - xMin;
        let height = yMax - yMin;

        if (width < this._limit || height < this._limit) {
            return;
        }

        //get a random direction (1 - vertical, 2 - horizontal)
        let direction = Math.floor(Math.random() * 2) + 1;

        // based on the direction add the wall and gap
        if (direction === 1) {
            let line = this.getVerticalLine(xMax - 1, xMin);

            this.addVerticalWall(line, xMin, xMax);

            this.addVerticalGap(line, xMin, xMax);

            this.divide(xMin, yMin, xMax, line);
            this.divide(xMin, line+1, xMax, yMax);
        } else {
            let line = this.getHorizontalLine(yMax - 1, yMin);

            this.addHorizontalWall(line, yMin, yMax);

            this.addHorizontalGap(line, yMin, yMax);

            this.divide(xMin, yMin, line, yMax);
            this.divide(line+1, yMin, xMax, yMax);
        }
    }

    getVerticalLine(width, x) {
        return Math.floor(Math.random() * (width - x + 1)) + x;
    }

    getHorizontalLine(height, y) {
        return Math.floor(Math.random() * (height - y + 1)) + y;
    }

    addVerticalWall(line, xMin, xMax) {
        for (let i = xMin; i < xMax; i++) {
            this._maze[i][line] = 1;
        }
    }

    addHorizontalWall(line, yMin, yMax) {
        for (let i = yMin; i < yMax; i++) {
            this._maze[line][i] = 1;
        }
    }

    addVerticalGap(line, xMin, xMax) {
        let gapMin = this.getRandom(xMin, Math.floor(xMax / 2) - 1);
        let gapMax = this.getRandom(gapMin + 1, xMax - 1);

        for (let i = gapMin; i < gapMax; i++) {
            this._maze[i][line] = 0;
        }
    }

    addHorizontalGap(line, yMin, yMax) {
        let gapMin = this.getRandom(yMin, Math.floor(yMax / 2) - 1);
        let gapMax = this.getRandom(gapMin + 1, yMax - 1);

        for (let i = gapMin; i < gapMax; i++) {
            this._maze[line][i] = 0;
        }
    }

    getRandom(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }
}

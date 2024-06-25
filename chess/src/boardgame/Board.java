package boardgame;

public class Board {

    private int rows;
    private int cols;
    private Piece[][] pieces;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new BoardException("Error creating board: There must be at least 1 row and 1 col");
        }
        this.rows = rows;
        this.cols = cols;
        pieces = new Piece[rows][cols];
    }

    public int getRows() {
        return rows;
    }



    public int getCols() {
        return cols;
    }



    public Piece piece(int row, int col) {
        if (!positionExits(row, col)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][col];
    }

    public Piece pieces(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getCol()];
    }
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getCol()] = piece;
        piece.position = position;
    }

    private boolean positionExits(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExits(Position position) {
        return positionExits(position.getRow(), position.getCol());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces(position) != null;
    }
}

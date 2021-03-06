/**
 * Pawn piece for java
 */

public class Pawn extends Piece{
    boolean firstMove = false;

    public Pawn(int x, int y, boolean color){
        super(x, y, color);
    }

    @Override
    public String getAbbr(){
        return "P";
    }

    @Override
    public String getName(){
        return "pawn";
    }

    /**
     * [0][0] demonstrates if there is no object in front of the selected pawn
     * [1][1] demonstrates if there is no object
     */
    @Override
    public int[][] ValidSquares(Tile[][] tiles){
        int[][] validSquares = new int[4][2];
        for(int t = 0; t<validSquares.length; t++){
            validSquares[t][0] = -1; validSquares[t][1] = -1;
        }
        //System.out.println(this.x + " " + this.y);
            if(this.color == true){ //check if pawn is black
                if(isValid(this.x, this.y+1)){
                    if(tiles[this.x][this.y+1].getPiece() == null){ //check square in front of pawn
                        validSquares[0][0] = this.x; validSquares[0][1] = this.y + 1;
                    }
                }

                if(isValid(this.x, this.y+2) && this.y == 1 && firstMove == false && validSquares[0][0] != -1){
                    if(tiles[this.x][this.y+2].getPiece() == null){ //check square in front of pawn
                        validSquares[1][0] = this.x; validSquares[1][1] = this.y + 2;
                    }
                }

                if(isValid(this.x-1, this.y+1)){
                    if(tiles[this.x-1][this.y+1].getPiece() != null){
                        if(tiles[this.x-1][this.y+1].getPiece().getColor() == false){
                            validSquares[2][0] = this.x-1; validSquares[2][1] = this.y+1;
                        }
                    }
                }
                if(isValid(this.x+1, this.y+1)){
                    if(tiles[this.x+1][this.y+1].getPiece() != null){
                        if(tiles[this.x+1][this.y+1].getPiece().getColor() == false){
                            validSquares[3][0] = this.x+1; validSquares[3][1] = this.y+1;
                        }
                    }
                }

            } else { //check if pawn is white
                if(isValid(this.x, this.y-1)){
                    if(tiles[this.x][this.y-1].getPiece() == null){ //check square in front of pawn
                        validSquares[0][0] = this.x; validSquares[0][1] = this.y - 1;
                    }
                }

                if(isValid(this.x, this.y-2) && this.y == 6 && validSquares[0][0] != -1){
                    if(tiles[this.x][this.y-2].getPiece() == null){ //check square in front of pawn
                        validSquares[1][0] = this.x; validSquares[1][1] = this.y - 2;
                    }
                }

                if(isValid(this.x-1, this.y-1)){
                    if(tiles[this.x-1][this.y-1].getPiece() != null){
                        if(tiles[this.x-1][this.y-1].getPiece().getColor() == true){
                            validSquares[2][0] = this.x-1; validSquares[2][1] = this.y-1;
                        }
                    }
                }

                if(isValid(this.x+1, this.y-1)){
                    if(tiles[this.x+1][this.y-1].getPiece() != null){
                        if(tiles[this.x+1][this.y-1].getPiece().getColor() == true){
                            validSquares[3][0] = this.x+1; validSquares[3][1] = this.y-1;
                        }
                    }
                }
            }
        return validSquares;
    }

}
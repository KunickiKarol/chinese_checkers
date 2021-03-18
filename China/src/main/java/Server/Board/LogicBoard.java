package Server.Board;

import Server.Field;

/**
 * servers board for game
 */
public abstract class LogicBoard {

    public Field[][] fields;

    /**
     * fields color getter
     * @param x fields x
     * @param y fields y
     * @return fields x,y's color
     */
    public String getFieldColor(int x, int y){
        return fields[x][y].getColor();
    }

    /**
     * fields color setter
     * @param x fields x
     * @param y fields y
     * @param color new color
     */
    public void setFieldColor(int x, int y,String color) {
        fields[x][y].setColor(color);
    }

    /**
     * @return whats winning color for field x,y
     *
     */
    public String getFieldHause(int x, int y) { return fields[x][y].getColorToWin(); }

    /**
     * decode fast way to sets fields on board
     * @param createTables set of code, have fields
     * @param color whats color to paint
     * @param winningHause code field winningColor
     */
    protected void decoder(int[] createTables, String color, String winningHause) {

            if (createTables[0] == 1) {
                for (int h = 3; h <= createTables.length - 1; h = h + 2) {
                    for (int i = createTables[h]; i < createTables[2]; i++) {
                        fields[i][createTables[h + 1]].setColor(color);
                        fields[i][createTables[h + 1]].setColorToWin(winningHause);
                    }

                }
            } else {
                for (int h = 3; h <= createTables.length - 1; h = h + 2) {
                    for (int i = createTables[h]; i >= createTables[2]; i--) {
                        fields[i][createTables[h + 1]].setColor(color);
                        fields[i][createTables[h + 1]].setColorToWin(winningHause);
                    }
                }
            }
    }

    /**
     * to check all winning fields are captured
     * @param createdTables
     * @param color
     * @param positiveHouse
     * @return
     */
    protected boolean checker(int[] createdTables, String color, int positiveHouse) {

        int counter = 0;

        if (createdTables[0] == 1) {
            for (int h = 3; h <= createdTables.length - 1; h = h + 2) {
                for (int i = createdTables[h]; i < createdTables[2]; i++) {
                    if(fields[i][createdTables[h + 1]].getColor().equals(color)){
                        counter++;
                    }
                }

            }
        } else {
            for (int h = 3; h <= createdTables.length - 1; h = h + 2) {
                for (int i = createdTables[h]; i >= createdTables[2]; i--) {
                    if(fields[i][createdTables[h + 1]].getColor().equals(color)){
                        counter++;
                    }
                }
            }
        }

        if(counter == positiveHouse){
            return true;
        }else {
            return false;
        }
    }



    /**
     * check are all winning fields caputered by sb
     * @return fact
     */
    public abstract String hasSbWon();
}

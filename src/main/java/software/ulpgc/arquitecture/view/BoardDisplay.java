package software.ulpgc.arquitecture.view;

import software.ulpgc.arquitecture.model.Board;


public interface BoardDisplay {

    void show(Board board);

    void on(Clicked clicked);

    record Cell(int x, int y, int l){
        public boolean isAt(int x, int y) {
            return Math.abs(x-this.x)<l && Math.abs(y-this.y)<l;}
    }



    interface Clicked{
        void at(Cell Cell);
    }


}

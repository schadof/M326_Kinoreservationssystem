public class CinemaRoom {

    private Row[] rows;

    public CinemaRoom(Row[] rows){
        this.rows = rows;
    }

    public Row getRow(int index){
        return rows[index];
    }
    public Row[] getAllRows(){
        return rows;
    }
}

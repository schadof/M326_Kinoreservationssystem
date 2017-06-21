public class CinemaRoom {

    private Row[] rows;

    public CinemaRoom(Row[] rows){
        this.rows = rows;
    }

    public Row getRow(int index){
        if (rows == null || rows.length == 0)   return null;
        if (index < 0)                          return  rows[0];
        if (index >= rows.length)               return rows[rows.length-1];
        return rows[index];
    }
    public Row[] getAllRows(){
        return rows;
    }
}

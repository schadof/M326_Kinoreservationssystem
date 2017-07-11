import java.time.Instant;

/**
 * Created by 11mmuellerde on 11.07.2017.
 */
public class PresInfo {
    private String parameters[];
    private int roomNum;
    private Instant date;

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}

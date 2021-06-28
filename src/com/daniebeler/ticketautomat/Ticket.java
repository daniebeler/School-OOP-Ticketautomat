package com.daniebeler.ticketautomat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class Ticket {

    private int id;
    private long timestampStart;
    private long timestampEnd;

    public Ticket(){
        this.id = new Random().nextInt(100);
        this.timestampStart = new Date().getTime();
    }

    public long getTimestampStart() {
        return timestampStart;
    }

    public long getTimestampEnd() {
        return timestampEnd;
    }

    public int getId() {
        return id;
    }

    public void setTimestampEnd(long timestampEnd) {
        this.timestampEnd = timestampEnd;
    }
}

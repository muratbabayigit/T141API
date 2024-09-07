package pojos;

public class PojoHerOkuAppExp {
    private int bookingid;
    private PojoHerokuAppReq booking;


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuAppReq getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuAppReq booking) {
        this.booking = booking;
    }

    public PojoHerOkuAppExp(int bookingid, PojoHerokuAppReq booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerOkuAppExp() {
    }

    @Override
    public String toString() {
        return "PojoHerOkuAppExp{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }


}

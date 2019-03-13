public class Tour implements Comparable<Tour>
{
    private String bandNames;
    private Double ticketPrices;


    public Tour(double ticketPrices, String bandNames) {
        this.ticketPrices = ticketPrices;
        this.bandNames = bandNames;
    }

    public String getBandNames() {
        return bandNames;
    }

    public void setBandNames(String bandNames) {
        this.bandNames = bandNames;
    }

    public double getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(double ticketPrices) {
        this.ticketPrices = ticketPrices;
    }

    @Override
    public int compareTo(Tour o) {
        return ticketPrices.compareTo(o.ticketPrices);
    }
}
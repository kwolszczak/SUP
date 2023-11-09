package pl.kwolszczak.selenium6_1.pages.widgets.datepicker;

class Calendar {
    private int year;
    private int month;
    private String day;

    public Calendar(int year, int month) {
        this(year, month, "");
    }

    public Calendar(int year, int month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}

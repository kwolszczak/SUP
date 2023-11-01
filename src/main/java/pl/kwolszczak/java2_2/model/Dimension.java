package pl.kwolszczak.java2_2.model;

public class Dimension {
    private int highInCM;
    private int widthInCM;
    private int trunkCapacityInLiters;

    public Dimension(int highInCM, int widthInCM, int trunkCapacityInLiters) {
        this.highInCM = highInCM;
        this.widthInCM = widthInCM;
        this.trunkCapacityInLiters = trunkCapacityInLiters;
    }

    public int getTrunkCapacityInLiters() {
        return trunkCapacityInLiters;
    }
}

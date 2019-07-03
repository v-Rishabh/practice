public class Laptop implements Comparable<Laptop> {
    private String Name;
    private int Ram;
    private int Cost;

    Laptop(String Name, int Ram, int Cost) {
        this.Name = Name;
        this.Ram = Ram;
        this.Cost = Cost;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setRam(int Ram) {
        this.Ram = Ram;
    }

    public int getRam() {
        return Ram;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public int getCost() {
        return Cost;
    }

    @Override
    public String toString() {
        return "Laptop [brand = " + Name + " Ram = " + Ram + " Cost = " + Cost + " ]\n";
    }

    @Override
    public int compareTo(Laptop lap2) {
        return this.getName().compareTo(lap2.getName());
    }
}
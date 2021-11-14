import java.util.Objects;

public class Entry {
    private String name;
    private int startTime, duration;

    /*
     *
     * Constructor method
     * Defines initialized object property
     * Takes in the values passed and assign to the instance variable of the object
     * Has no return type
     */
    public Entry(String name, int startTime, int duration) {
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
    }

    /*
     * Accessors return the value of the private variable
     */
    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getStartTime() {
        return startTime;
    }

    /*
     * toString method
     * Overrides the default object toString method
     * Returns the custom defined string representation of the object
     *
     */
    @Override
    public String toString() {
        return startTime + ":00:" + name + "," + duration + "mins";
    }

    /*
     * overlaps method
     * Boolean method checking for entries overlap
     * Returns true if entries overlap
     *
     */
    public boolean overlaps(Entry entry) {
        if (startTime + duration > entry.startTime || startTime > entry.startTime + entry.duration){
            return true;
        }
        return false;
    }


    /*
     * equals method
     * Boolean method checking for entries equality
     * Returns true if entries are similar
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return startTime == entry.startTime && duration == entry.duration && Objects.equals(name, entry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, duration);
    }

    /*
     * clone method
     * Creates an exact duplicate of the object
     * No return value
     *
     */
    public Entry clone() {
        return new Entry(name, startTime, duration);
    }

}

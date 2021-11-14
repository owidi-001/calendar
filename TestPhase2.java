/*
 * A file to get you started with testing Phase 2
 *
 */
public class TestPhase2 {

    public static void main(String[] args) {


        //Reading in a calendar file with good input

        System.out.println("Creating a new calendar by reading from a file");
        Calendar celesteCalendar = new Calendar("calendar1.txt");
        System.out.println(celesteCalendar);
        celesteCalendar.displayEntries(1, 29);
        celesteCalendar.displayEntries(2, 11);

        //Reading in one with bad input
        System.out.println("\nCreating a second calendar by reading from a file");
        Calendar bobCalendar = new Calendar("calendar2.txt");
        System.out.println(bobCalendar);
        bobCalendar.displayEntries(1, 29);
        bobCalendar.displayEntries(2, 11);

    }

}

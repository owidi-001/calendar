import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

    //Instance variable
    private String name;
    private int year;
    private Entry[][][] entries;

    //Class constants
    private static final int[] NB_DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final int NB_HOURS = 24;

    public Calendar(String calender) throws IOException {
        init(calender);
    }

    public Calendar(String name, int year) {
        this.name = name;
        this.year = year;
    }

    //Helper method for the constructors
    private void init(String file) throws IOException {
        String[] cal=readCalender(file);
        Calendar calendar=new Calendar(cal[0],Integer.parseInt(cal[1]));
        for (int i = 2; i < cal.length; i++) {
            calendar.entries.add(cal[i]);
        }

    }

    public static boolean isValidTime(int time) {
        if (time >= 0 && time <= 23) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int month, int day) {
        if (month >= 1 && month <= 12) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day <= 31) {
                    return true;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day <= 30) {
                    return true;
                }
            } else if (month == 2) {
                if (day <= 28) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addEntry(int month, int day, Entry entry) {
        entries[month][day][entry.getStartTime()] = entry;
    }


    public Entry getEntry(int month, int day, int time) {
        try {
            return entries[month][day][time];
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean isConflicting(int month, int day, Entry entry) {
//        for (int i = 0; i < entries.length; i++) {
//            if (entry.getStartTime()==entries[month][day][i].getStartTime() || entries[month][day][i].overlaps(entry)){
//                return true;
//            }
//        }

        return false;
    }

    public void displayEntries(int month, int day) {
        for (Entry entry :
                entries[month][day]) {
            System.out.println(entry);
        }
    }

    public int getDurationOfEntriesOnDay(int month, int day) {
        int totalDuration = 0;
        try {
            for (Entry entry :
                    entries[month][day]) {
                totalDuration += entry.getDuration();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return totalDuration;
    }

    public int getNumEntries(int month, int day) {
        int count = 0;
        try {
            for (Entry entry :
                    entries[month][day]) {
                count += 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int getNumEntries() {
        int count = 0;
        try {
            for (int i = 0; i < entries.length; i++) {
                for (int j = 0; j < entries[i].length; j++) {
                    count += 1;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public boolean deleteEntry(int month, int day, Entry entry) {
        int index = 0;
        try {
            for (Entry entry1 : entries[month][day]) {
                if (entry1.equals(entry)) {
                    for (int i = index; i < entries[month][day].length - 1; i++) {
                        entries[month][day][i] = entries[month][day][i + 1];
                    }
                    return true;
                }
                index += 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteAllOccurences(Entry entry) {
        try {
            for (int i = 0; i < entries.length; i++) {
                for (int j = 0; j < entries[i].length; j++) {
                    for (Entry entry1 :
                            entries[i][j]) {
                        if (entry1 == entry) {
                            this.deleteEntry(i, j, entry);
                        }
                    }

                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ',' + year + ", Number of Entries: " + entries[11][30].length;
    }

    public String[] readCalender(String filename) throws IOException
    {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null)
        {
            lines.add(line);
        }

        bufferedReader.close();

        return lines.toArray(new String[lines.size()]);
    }


}

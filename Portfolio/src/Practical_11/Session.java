package Practical_11;

import java.util.Objects;
import Tools.Search.Searcher;

public class Session {

    private final int id;
    private String location;
    private Talk[] talks; // Capacity 4, ascending order based on startTime
    private int numOfTalks;

    /**
     * Create new session to track talks
     *
     * @param id session id
     * @param location location of session
     */
    public Session(int id, String location){

        this.id = id;
        this.location = location;

        talks = new Talk[4]; // Default size is 4
        numOfTalks = 0; // Initialise size to 0
    }

    /**
     * Add new talk to schedule, inserted in ascending time order
     *
     * @param t talk to add
     */
    public void scheduleTalk(Talk t){
        // If index of t isn't -1 then it's in the array, and this system does not allow duplicates
        if(indexOf(t) > -1){
            return;
        }

        // Need to increase capacity
        if(numOfTalks >= talks.length){
            // Duplicate talks array
            Talk[] temp = talks;
            talks = new Talk[numOfTalks*2];
            // Double capacity
            // Copy original values back
            System.arraycopy(temp, 0, talks, 0, temp.length);
        }

        // Find index t belongs at
        int i = 0;
        for(i = 0;i < numOfTalks; i++){
            // Positive integer = more than, negative = less than
            // Breaks when i is the index of the first element that t is less than
            if(t.compareTo(talks[i]) < 0){
                break;
            }
        }

        // Shuffle elements from target index until last talk, starting from the last talk in the array
        for(int j = numOfTalks-1; j >= i; j--){
            talks[j+1] = talks[j];
        }

        talks[i] = t; // Insert talks correct index
        numOfTalks++; // Increase number of talks
    }

    /**
     * Remove talk from schedule
     *
     * @param t talk to cancel
     */
    public void cancelTalk(Talk t){
        remove(indexOf(t));
    }

    /**
     * Remove talk from schedule, based on ID
     *
     * @param talkID talk to cancel
     */
    public void cancelTalk(int talkID){
        remove(indexOf(talkID));
    }

    /**
     * Remove talk with matching title, based on title
     *
     * @param title title of talk to cancel
     */
    public void cancelTalk(String title){
        remove(indexOf(title));
    }

    /**
     * Remove element from index, remove gap created
     *
     * @param index element removed
     */
    private void remove(int index){
        if(index < 0){ // To prevent OutOfBoundsException
            return;
        }

        // Remove
        talks[index] = null;

        // Shuffle up
        for(int j = index; j < numOfTalks-1; j++){
            talks[j] = talks[j+1];
        }

        talks[numOfTalks-1] = null;

        // Decrement size
        numOfTalks--;
    }

    /**
     * Binary search for t within an array of talks
     *
     * @param t talk to locate
     * @return Index of talk t, returns -1 if element not found
     */
    private int indexOf(Talk t){
        return Searcher.search(t, talks);
    }

    /**
     * @param talkID ID of talk to locate
     * @return Index of talk with talkID, returns -1 if element not found
     */
    private int indexOf(int talkID){
        // TODO: Binary search for t
        // Cannot use Searcher.search as the method cannot use Talk.getID()

        for(int i = 0; i < numOfTalks; i++){

            if(talks[i].getID() == talkID){
                return i;
            }
        }

        return -1;
    }

    /**
     * @param title title of talk to locate
     * @return Index of talk with matching title, returns -1 if element not found
     */
    private int indexOf(String title){
        // TODO: Binary search for t
        // Cannot use Searcher.search as the method cannot use Talk.getTitle()

        for(int i = 0; i < numOfTalks; i++){

            if(Objects.equals(talks[i].getTitle(), title)){ // Null safe equals() as String is an object
                return i;
            }
        }

        return -1;
    }

    public int getID(){
        return id;
    }

    public String getLocation(){
        return location;
    }

    public int getNumOfTalks(){
        return numOfTalks;
    }

    /**
     * @return Scheduled talks formatted as a table
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("Timetable for: ").append(location).append("\n");

        s.append(String.format("%2s | %-48s | %-16s %n", "ID", "Talk", "Start Time"));

        for (Talk t: talks){

            if(t == null){
                break;
            }

            s.append(t);
        }

        return s.toString();
    }
}
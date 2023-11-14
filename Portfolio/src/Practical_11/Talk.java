package Practical_11;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Talk implements Comparable<Talk> {

    private final int id;
    private String speaker;
    private String title;
    private LocalDateTime startTime; // Time zone information not required

    /**
     * Creates new talk
     *
     * @param id talk id
     * @param speaker speaker to give talk
     * @param title title of talk
     * @param startTime start time as string, given in ISO 8601
     */
    public Talk(int id, String speaker, String title, String startTime){

        this.id = id;
        this.speaker = speaker;
        this.title = title;

        // ISO 8601 regex expression
        // Regex generated with: https://regex-generator.olafneumann.org/
        Pattern p = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}(\\.[0-9]+)?([Zz]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?", Pattern.CASE_INSENSITIVE);

        if(!p.matcher(startTime).matches()){
            throw new RuntimeException(startTime + " is an invalid time. Please use format: yyyy-MM-ddThh:mm:ss");
        }

        this.startTime = LocalDateTime.parse(startTime);
    }

    /**
     * Creates new talk
     *
     * @param id talk id
     * @param speaker speaker to give talk
     * @param title title of talk
     * @param startTime LocalDateTime of start time
     */
    public Talk(int id, String speaker, String title, LocalDateTime startTime){

        this.id = id;
        this.speaker = speaker;
        this.title = title;

        this.startTime = startTime;
    }

    /**
     * Change name of speaker giving talk
     *
     * @param speaker new speaker name
     */
    public void setSpeaker(String speaker){
        this.speaker = speaker;
    }

    /**
     * Change title of talk
     *
     * @param title new talk title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Set start time of talk
     *
     * @param time new start time
     */
    public void setStartTime(LocalDateTime time){
        this.startTime = time;
    }

    /**
     * Compare talks by startTime
     *
     * @param t talk to compare to
     */
    @Override
    public int compareTo(Talk t){
        return startTime.compareTo(t.getStartTime());
    }

    // Accessors

    /**
     * @return formats a talk as: "Session ID| Title with Speake | Time (Time Day Month Year)"
     */
    @Override
    public String toString(){
        return String.format("%-2s|%-48s|%-16s%n", id, title + " with " + speaker, getStartTimeString());
    }

    public int getID(){
        return id;
    }

    public String getSpeaker(){
        return speaker;
    }

    public String getTitle(){
        return title;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }

    /**
     * @return human-readable format of talk's start time
     */
    public String getStartTimeString(){
        String s = startTime.getHour() + ":" + startTime.getMinute() + " " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear();

        return String.format("%02d", startTime.getHour()) + ":" + String.format("%02d", startTime.getMinute()) + " "
                + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear();
    }

}
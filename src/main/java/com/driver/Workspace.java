package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;


public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if(calendar.isEmpty()) return 0;
        int count = 1;
        sortMeeting(calendar);
        LocalTime time = calendar.get(0).getEndTime();
        for(int i=0;i<calendar.size()-1;i++){
            if(time.isBefore(calendar.get(i+1).getStartTime())){
                count++;
                time = calendar.get(i+1).getEndTime();
            }
        }
        return count;
    }
    void sortMeeting(ArrayList<Meeting> meeting) {
        meeting.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime().compareTo(m2.getStartTime());
            }
        });
    }
}

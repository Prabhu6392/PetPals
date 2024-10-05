package dao;

import entity.IAdoptable;
import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private List<IAdoptable> participants;

    public AdoptionEvent() {
        participants = new ArrayList<>();
    }

    // Register a participant for the adoption event
    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println("Participant registered for the event.");
    }

    // Host the adoption event
    public void hostEvent() {
        System.out.println("Hosting Adoption Event with " + participants.size() + " participants.");
        for (IAdoptable participant : participants) {
            try {
                participant.adopt();
            } catch (Exception e) {
                System.out.println("Error during adoption process: " + e.getMessage());
            }
        }
    }

    // List all participants in the event
    public void listParticipants() {
        System.out.println("Participants in this event:");
        if (participants.isEmpty()) {
            System.out.println("No participants registered yet.");
        } else {
            for (IAdoptable participant : participants) {
                System.out.println(participant.toString());
            }
        }
    }
}

package part3;

public class CrewMember {
    private final String name;
    private final String position;

    public static final String PILOT = "Pilot";
    public static final String CO_PILOT = "Co-Pilot";
    public static final String CABIN_CREW = "Cabin Crew";

    /**
     * Constructor for CrewMember class.
     *
     * @param name     The name of the crew member.
     * @param position The position of the crew member.
     */
    public CrewMember(String name, String position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Get the name of the crew member.
     *
     * @return The name of the crew member.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the position of the crew member.
     *
     * @return The position of the crew member.
     */
    public String getPosition() {
        return position;
    }

}

import java.util.ArrayList;

/**
 * Created by tomas on 4/27/16.
 */
public class MemberList {
	//Class data.
	ArrayList<Member> members = new ArrayList<Member>();

	ArrayList<Member> showAllMembers(){ return new ArrayList<>();}
    ArrayList<String> showAgeGroups(){
        ArrayList<String> ageGroups = new ArrayList<>();
        ageGroups.add("15-18:  42");
        ageGroups.add("18-25:  10");

        return ageGroups;
    }
}

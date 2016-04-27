import java.util.ArrayList;

/**
 * Created by tomas on 4/27/16.
 */
public class Member {
    private String firstName;
    private String lastName;
    private String address;
    private String email_address;
    private String phoneNr;
    private String birthDate;
    private String passportNr;
    private int driversLicenseNr;
    private Constants.membership_types membership;

    ArrayList<Merchandise> buys = new ArrayList<>();    //Everything the member has bought.
    ArrayList<Equipment> rents = new ArrayList<>();     //Everything the member has rented.

    //DUMMY kan slettes.
    void setMembershipToDAY(){
        membership = Constants.membership_types.DAY;
    }

    ArrayList<Merchandise> shoppingHistory(){
        return new ArrayList<>();
    }
    ArrayList<Equipment> rentingHistory(){
        return new ArrayList<>();
    }
}

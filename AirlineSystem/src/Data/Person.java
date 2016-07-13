package Data;

public class Person {
    private EnumTitle title;
    private String firstName;
    private String lastName;
    private String address;
    private String Id;
    
    private String idPrefix = "P";
    private static int idSuffix = 1;
    
    public Person(EnumTitle title, String firstName, String lastName, String address) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        
        createAndAssignId();
    }
    
    protected void createAndAssignId()
    {
        this.Id = idPrefix + idSuffix++;
    }

    public EnumTitle getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return Id;
    }
}

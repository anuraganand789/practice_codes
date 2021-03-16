@Entity
@Access(AccessType.FIELD)
@Table(name="EMP", schema="HR")
public class Employee{
    public static final String LOCAL_AREA_CODE = "613";

    @Id
    private int id;

    @Transient
    private String phoneNum;

    public int getId() { return id; }
    public void setId(final int id){ this.id = id; }

    public String getPhoneNumber() { return this.phoneNumber; }
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Access(AccessType.PROPERTY)
    @Column(name="PHONE")
    protected String getPhoneNum() {}

    @Basic(fetch=FetchType.LAZY)
    @Column(name="COMM")
    private List<String> comments;
}

public class Contact {
    /**
     * Initialize last name
     */
    private String lastName;
    /**
     * Initialize first name
     */
    private String firstName;
    /**
     * Initialize phone number
     */
    private String phoneNumber;
    /**
     * Initialize address
     */
    private String address;
    /**
     * Initialize city
     */
    private String city;
    /**
     * Initialize zip code
     */
    private String zipCode;

    /**
     * Constructor
     * @param last_Name
     * @param first_Name
     */
    public Contact( String last_Name , String first_Name ){
        firstName = first_Name;
        lastName = last_Name;
    }

    /**
     * Constructor
     * @param last_Name
     * @param first_Name
     * @param phone_Number
     * @param addr
     * @param city_Name
     * @param zip_Code
     */
    public Contact( String last_Name , String first_Name , String phone_Number , String addr , String city_Name , String zip_Code ){
        lastName = last_Name;
        firstName = first_Name;
        phoneNumber = phone_Number;
        address = addr;
        city = city_Name;
        zipCode = zip_Code;
    }

    /**
     * Get address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get zip code
     * @return zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set zip code
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    /**
     * Check if two contacts equal
     * @param o object
     * @return true if equals
     */
    @Override
    public boolean equals( Object o ){
        if( o instanceof Contact ){
            Contact contact2 = (Contact) o;
            return this.lastName.equals( contact2.lastName ) && this.firstName.equals( contact2.firstName );
        }
        return false;
    }

    /**
     * Write contact as a string
     * @return contact as string
     */
    @Override
    public String toString(){
        return ( lastName + "," + firstName + "," + phoneNumber + "," + address + "," + city + "," + zipCode );
    }

    /**
     * Compare two strings
     * @param s Contact
     * @return difference of string
     */
    public int compareTo( Contact s ){
        if ( this.lastName.compareTo( s.lastName ) == 0 ){
            return this.firstName.compareTo( s.firstName );
        }
        return this.lastName.compareTo( s.lastName );
    }
}

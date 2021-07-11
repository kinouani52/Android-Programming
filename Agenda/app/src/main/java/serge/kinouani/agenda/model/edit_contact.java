package serge.kinouani.agenda.model;

public class edit_contact {
    private String contact_name,contact_address,contact_phone;

    public edit_contact(String contact_name, String contact_address, String contact_phone) {
        this.contact_name = contact_name;
        this.contact_address = contact_address;
        this.contact_phone = contact_phone;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}

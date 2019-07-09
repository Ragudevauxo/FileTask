package mod;

public class Modeler {
private String Name;
private String StreetName;
private String City;
private String PostalCode;
private String Phone;
private String EmailAddress;
public Modeler(String name, String streetName, String city, String postalCode, String phone, String emailAddress) {
	
	this.Name = name;
	this.StreetName = streetName;
	this.City = city;
	this.PostalCode = postalCode;
	this.Phone = phone;
	this.EmailAddress = emailAddress;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getStreetName() {
	return StreetName;
}
public void setStreetName(String streetName) {
	StreetName = streetName;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getPostalCode() {
	return PostalCode;
}
public void setPostalCode(String postalCode) {
	PostalCode = postalCode;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmailAddress() {
	return EmailAddress;
}
public void setEmailAddress(String emailAddress) {
	EmailAddress = emailAddress;
}


}

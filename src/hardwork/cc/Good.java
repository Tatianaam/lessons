package hardwork.cc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/*
 * I asked chatGPT to generate me a method with complexity at 30, so I can practice reducing it because
 * at work we are forced to use SonarQube where a check for cyclomatic complexity is enabled, so it can never be higher than 15.
 *
 * Generated "bad" function is in the class, named Bad.
 * Refactored one is in this class. Complexity reduced from 30 to 10.
 *
 * All else blocks removed
 * ActiveUser & InActiveUser classes created based on User (polymorphism)
 * Validations (2 checks or more) moved out to a separate method
 * Null checks & empty checks replaced with isBlank method
 *
 * */
public class Good {

    public void processUserData(InActiveUser user) throws CustomException {
        throw new CustomException("Unable to process Inactive User data");
    }


    public void processUserData(ActiveUser user) throws CustomException {

        if (user == null)
            throw new CustomException("Supplied user is null");

        if (user.getName().isBlank())
            throw new CustomException("Name is not provided");

        if (user.getAge() < 18)
            throw new CustomException("User is underage");

        verifyRoleAndAccessLevel(user);
        validateEmail(user.getEmail());
        validateCountry(user.getCountry());
        validateColor(user.getFavoriteColor());
        validatePhone(user.getPhoneNumber());
        validateAddress(user);

        if (user.getAddress().getAdditionalInfo() == null)
            throw new CustomException("Additional Info is null");


        // Process user data
        // ...

    }

    private void validateEmail(String email) throws CustomException {
        if (email == null)
            throw new CustomException("Providede email is null");

        Pattern p = Pattern.compile("^(.+)@(\\\\S+)$");
        Matcher m = p.matcher(email);

        if (!m.matches())
            throw new CustomException("Invalid email format");
    }

    private void verifyRoleAndAccessLevel(ActiveUser user) throws CustomException {

        if (!user.isAdmin())
            throw new CustomException("User is not Admin");

        if (user.getAccessLevel() <= 5)
            throw new CustomException("Invalid access level");

    }

    private void validateCountry(String country) throws CustomException {
        if (country.isBlank())
            throw new CustomException("Country is not provided");

        if (!country.equalsIgnoreCase("USA"))
            throw new CustomException("Provided country is not USA");
    }

    private void validateColor(String color) throws CustomException {
        if (color.isBlank())
            throw new CustomException("Color is null");


        if (!color.equalsIgnoreCase("Blue"))
            throw new CustomException("Invalid color provided");
    }

    private void validatePhone(String num) throws CustomException {
        if (num.isBlank())
            throw new CustomException("Provided number is null");

        if (!num.startsWith("+1"))
            throw new CustomException("Foreign phone number provided");
    }

    private void validateAddress(User user) throws CustomException {

        if (user.getAddress() == null)
            throw new CustomException("Provided address is null");

        List<String> requiredFields = new ArrayList();

        if (user.getAddress().getStreet().isBlank())
            requiredFields.add("Street");

        if (user.getAddress().getCity().isBlank())
            requiredFields.add("City");

        if (user.getAddress().getState().isBlank())
            requiredFields.add("State");

        if (user.getAddress().getZipCode().isBlank())
            requiredFields.add("Zip");

        if (user.getAddress().getCountry().isBlank())
            requiredFields.add("Country");

        if (user.getAddress().getPhoneNumber().isBlank())
            requiredFields.add("Phone Number");

        if (!requiredFields.isEmpty())
            throw new CustomException(requiredFields.stream().collect(Collectors.joining(",")));

    }
}


class CustomException extends Exception {

    CustomException(String msg) {
        super(msg);
    }

}

class ActiveUser extends User {

    public boolean isActive() {
        return true;
    }

}

class InActiveUser extends User {

    public boolean isActive() {
        return false;
    }

}

abstract class User {

    public abstract boolean isActive();

    private boolean isAdmin;
    private int accessLevel;
    private String email;
    private String name;
    private int age;
    private String country;
    private String favoriteColor;
    private String phoneNumber;
    private Address address;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private String email;
    private String additionalInfo;

    // Constructor, getters, and setters

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}




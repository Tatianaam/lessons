package hardwork.cc;

public class Bad {

    public void processUserData(User user) {
        if (user != null) {
            if (user.isActive()) {
                if (user.isAdmin()) {
                    if (user.getAccessLevel() > 5) {
                        if (user.getEmail() != null && user.getEmail().contains("@")) {
                            if (user.getName() != null && !user.getName().isEmpty()) {
                                if (user.getAge() > 18) {
                                    if (user.getCountry() != null && user.getCountry().equalsIgnoreCase("USA")) {
                                        if (user.getFavoriteColor() != null) {
                                            if (user.getFavoriteColor().equalsIgnoreCase("blue")) {
                                                if (user.getPhoneNumber() != null && user.getPhoneNumber().startsWith("+1")) {
                                                    if (user.getAddress() != null) {
                                                        if (user.getAddress().getStreet() != null && !user.getAddress().getStreet().isEmpty()) {
                                                            if (user.getAddress().getCity() != null && !user.getAddress().getCity().isEmpty()) {
                                                                if (user.getAddress().getState() != null && !user.getAddress().getState().isEmpty()) {
                                                                    if (user.getAddress().getZipCode() != null && !user.getAddress().getZipCode().isEmpty()) {
                                                                        if (user.getAddress().getCountry() != null && !user.getAddress().getCountry().isEmpty()) {
                                                                            if (user.getAddress().getPhoneNumber() != null && !user.getAddress().getPhoneNumber().isEmpty()) {
                                                                                if (user.getAddress().getEmail() != null && user.getAddress().getEmail().contains("@")) {
                                                                                    if (user.getAddress().getAdditionalInfo() != null) {
                                                                                        // Process user data
                                                                                        // ...
                                                                                    } else {
                                                                                        // Handle missing additional info
                                                                                    }
                                                                                } else {
                                                                                    // Handle invalid email in address
                                                                                }
                                                                            } else {
                                                                                // Handle missing phone number in address
                                                                            }
                                                                        } else {
                                                                            // Handle missing country in address
                                                                        }
                                                                    } else {
                                                                        // Handle missing zip code in address
                                                                    }
                                                                } else {
                                                                    // Handle missing state in address
                                                                }
                                                            } else {
                                                                // Handle missing city in address
                                                            }
                                                        } else {
                                                            // Handle missing street in address
                                                        }
                                                    } else {
                                                        // Handle missing address
                                                    }
                                                } else {
                                                    // Handle invalid phone number
                                                }
                                            } else {
                                                // Handle invalid favorite color
                                            }
                                        } else {
                                            // Handle missing favorite color
                                        }
                                    } else {
                                        // Handle invalid country
                                    }
                                } else {
                                    // Handle underage user
                                }
                            } else {
                                // Handle missing name
                            }
                        } else {
                            // Handle invalid email
                        }
                    } else {
                        // Handle insufficient access level
                    }
                } else {
                    // Handle non-admin user
                }

            } else {
                // Handle inactive user
            }
        } else {
            // Handle null user
        }
    }

    class User {
        private boolean isActive;
        private boolean isAdmin;
        private int accessLevel;
        private String email;
        private String name;
        private int age;
        private String country;
        private String favoriteColor;
        private String phoneNumber;
        private Address address;

        // Constructor, getters, and setters

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean isActive) {
            this.isActive = isActive;
        }

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


}

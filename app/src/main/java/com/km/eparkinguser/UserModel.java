package com.km.eparkinguser;

/**
 * Created by Mirza Ahmed Baig on 2019-09-26.
 * Avantari Technologies
 * mirza@avantari.org
 */
public class UserModel {
    private String userName;
    private String userEmail;
    private String vehicleName;
    private String vehicleNumber;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

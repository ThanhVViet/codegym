package com.example.medical.model;

import java.time.LocalDate;
import java.util.List;

public class Medical {
    private int id;
    private String fullName;
    private int yearBirth;
    private String gender;
    private String country;
    private String identification;
    private String vehicle;
    private String numberPlate;
    private String numberSeat;
    private LocalDate startDate;
    private int startDay;
    private int startMonth;
    private int startYear;
    private LocalDate endDate;
    private int endDay;
    private int endMonth;
    private int endYear;
    private String infoWithin14days;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;
    private List<String> symptomsWithin14days;
    private String fever;
    private String cough;
    private String khotho;
    private String dauhong;
    private List<String> historyExposuresWithin14days;
    private String dentrangtrai;
    private String tiepxucgan;

    public Medical() {
    }

    public Medical(String fullName, int yearBirth, String phone) {
        this.fullName = fullName;
        this.yearBirth = yearBirth;
        this.phone = phone;
    }

    public Medical(int id, String fullName, int yearBirth, String gender, String country, String identification, String vehicle, String numberPlate, String numberSeat, LocalDate startDate, int startDay, int startMonth, int startYear, LocalDate endDate, int endDay, int endMonth, int endYear, String infoWithin14days, String city, String district, String ward, String address, String phone, String email, List<String> symptomsWithin14days, String sot, String ho, String khotho, String dauhong, List<String> historyExposuresWithin14days, String dentrangtrai, String tiepxucgan) {
        this.id = id;
        this.fullName = fullName;
        this.yearBirth = yearBirth;
        this.gender = gender;
        this.country = country;
        this.identification = identification;
        this.vehicle = vehicle;
        this.numberPlate = numberPlate;
        this.numberSeat = numberSeat;
        this.startDate = startDate;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDate = endDate;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.infoWithin14days = infoWithin14days;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptomsWithin14days = symptomsWithin14days;
        this.fever = sot;
        this.cough = ho;
        this.khotho = khotho;
        this.dauhong = dauhong;
        this.historyExposuresWithin14days = historyExposuresWithin14days;
        this.dentrangtrai = dentrangtrai;
        this.tiepxucgan = tiepxucgan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getInfoWithin14days() {
        return infoWithin14days;
    }

    public void setInfoWithin14days(String infoWithin14days) {
        this.infoWithin14days = infoWithin14days;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptomsWithin14days() {
        return symptomsWithin14days;
    }

    public void setSymptomsWithin14days(List<String> symptomsWithin14days) {
        this.symptomsWithin14days = symptomsWithin14days;
    }

    public String getSot() {
        return fever;
    }

    public void setSot(String sot) {
        this.fever = sot;
    }

    public String getHo() {
        return cough;
    }

    public void setHo(String ho) {
        this.cough = ho;
    }

    public String getKhotho() {
        return khotho;
    }

    public void setKhotho(String khotho) {
        this.khotho = khotho;
    }

    public String getDauhong() {
        return dauhong;
    }

    public void setDauhong(String dauhong) {
        this.dauhong = dauhong;
    }

    public List<String> getHistoryExposuresWithin14days() {
        return historyExposuresWithin14days;
    }

    public void setHistoryExposuresWithin14days(List<String> historyExposuresWithin14days) {
        this.historyExposuresWithin14days = historyExposuresWithin14days;
    }

    public String getDentrangtrai() {
        return dentrangtrai;
    }

    public void setDentrangtrai(String dentrangtrai) {
        this.dentrangtrai = dentrangtrai;
    }

    public String getTiepxucgan() {
        return tiepxucgan;
    }

    public void setTiepxucgan(String tiepxucgan) {
        this.tiepxucgan = tiepxucgan;
    }
}

package com.khoapham.util;

import java.util.ArrayList;
import java.util.List;

public class AttribueList {
    private static List<Integer> years = new ArrayList<>();
    private static List<String> nations = new ArrayList<>();
    private static List<String> genders = new ArrayList<>();
    private static List<String> vehicles = new ArrayList<>();

    static {
        for (int i = 1980; i < 2020; i++) {
            years.add(i);
        }
        vehicles.add("Tàu bay");
        vehicles.add("Tàu thuyền");
        vehicles.add("Ô tô");
        vehicles.add("Khác");
        genders.add("Chọn");
        genders.add("Nam");
        genders.add("Nữ");
        genders.add("Khác");
        nations.add("Azerbaijan");
        nations.add("Bahrain");
        nations.add("Bangladesh");
        nations.add("Bhutan");
        nations.add("Brunei");
        nations.add("Cambodia");
        nations.add("China");
        nations.add("Cyprus");
        nations.add("Georgia");
        nations.add("India");
        nations.add("Indonesia");
        nations.add("Iran");
        nations.add("Iraq");
        nations.add("Israel");
        nations.add("Japan");
        nations.add("Jordan");
        nations.add("Kazakhstan");
        nations.add("Kuwait");
        nations.add("Kyrgyzstan");
        nations.add("Laos");
        nations.add("Lebanon");
        nations.add("Malaysia");
        nations.add("Maldives");
        nations.add("Mongolia");
        nations.add("Myanmar");
        nations.add("Nepal");
        nations.add("North Korea");
        nations.add("Oman");
        nations.add("Pakistan");
        nations.add("Philippines");
        nations.add("Qatar");
        nations.add("Saudi Arabia");
        nations.add("Singapore");
        nations.add("South Korea");
        nations.add("Sri Lanka");
        nations.add("State of Palestine");
        nations.add("Syria");
        nations.add("Tajikistan");
        nations.add("Thailand");
        nations.add("Timor-Leste");
        nations.add("Turkey");
        nations.add("Turkmenistan");
        nations.add("United Arab Emirates");
        nations.add("Uzbekistan");
        nations.add("Vietnam");
        nations.add("Yemen");
    }

    public static List<Integer> getYearList() {
        return years;
    }
    public static List<String> getNations() {
        return nations;
    }
    public static List<String> getGenders() {
        return genders;
    }
    public static List<String> getVehicles() {
        return vehicles;
    }
}

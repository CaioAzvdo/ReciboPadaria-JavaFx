package com.plcdo.padariarecibo.scenes.util;

public class TestConnection {
    public static void main(String[] args) {
        try {
            ConnectionConfig.getConnection();
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

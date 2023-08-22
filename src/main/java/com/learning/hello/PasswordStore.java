package com.learning.hello;
import java.util.ArrayList;
import java.util.List;

public class PasswordStore {
    private static List<String> passwordList = new ArrayList<>();

    public  void addPassword(String password) {
        passwordList.add(password);
    }

    public static boolean PasswordExist(String password) {
        return !passwordList.contains(password);
    }
}

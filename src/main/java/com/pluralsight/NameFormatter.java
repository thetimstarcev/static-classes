package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {}

    public static String format (String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        String result = lastName + ", ";
        if (prefix != null) {
            result += prefix + " ";
        }
        result += firstName;

        if (middleName != null) {
            result += " " + middleName;
        }
        if (suffix != null) {
            result += ", " + suffix;
        }
        return result;
    }

    public static String format(String fullName) {
        String[] parts = fullName.split(",");
        String name = fullName;
        String suffix = null;
        if (parts.length > 1) {
            name = parts[0].trim();
            suffix = parts[1].trim();
        }
        String[] nameParts = name.split(" ");
        if (nameParts.length == 2) {
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            return format(firstName, lastName);
        } else if (nameParts.length == 3) {
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];
            return format(null, firstName, middleName, lastName, suffix);
        } else if (nameParts.length == 4) {
            String title = nameParts[0];
            String firstName = nameParts[1];
            String middleName = nameParts[2];
            String lastName = nameParts[3];
            return format(title, firstName, middleName, lastName, suffix);
        }
        return fullName;
    }
}



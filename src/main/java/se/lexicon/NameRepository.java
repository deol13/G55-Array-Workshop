package se.lexicon;

import java.sql.Array;
import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        NameRepository.names = Arrays.copyOf(names, names.length);
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        // This creates a new copy without reference to NameRepository.names so NameRepository.names can't be affected by changes made to the copy.
        return Arrays.copyOf(names, names.length);
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        String returnName = null;
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                returnName = name;
                break;
            }
        }
        return returnName;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        fullName = fullName.trim();
        if (find(fullName) != null || fullName.isEmpty()) {
            return false;
        }
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        String[] matchingNames = new String[names.length];
        int matchingNameCount = 0;
        for (String name : names) {
            // I split to be more accurate with my comparison of the first name of each name.
            String[] fullName = name.split(" ");
            // Checking fullname length first to avoid out of range exception
            if (fullName.length > 0 && fullName[0].equals(firstName)) {
                matchingNames[matchingNameCount] = name;
                matchingNameCount++;
            }
        }

        //Remove all the empty indexes.
        int emptyIndexes = names.length - matchingNameCount;
        if (emptyIndexes == 0) {
            return matchingNames;
        }
        return Arrays.copyOf(matchingNames, matchingNames.length - emptyIndexes);
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        String[] matchingNames = new String[names.length];
        int matchingNameCount = 0;
        for (String name : names) {
            // I split to be more accurate with my comparison of the first name of each name.
            String[] fullName = name.split(" ");
            // Checking fullname length first to avoid out of range exception
            if (fullName.length > 1 && fullName[1].equals(lastName)) {
                matchingNames[matchingNameCount] = name;
                matchingNameCount++;
            }
        }

        //Remove all the empty indexes.
        int emptyIndexes = names.length - matchingNameCount;
        if (emptyIndexes == 0) {
            return matchingNames;
        }
        return Arrays.copyOf(matchingNames, matchingNames.length - emptyIndexes);
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        boolean success = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                names[i] = updatedName;
                success = true;
                break;
            }
        }

        return success;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < names.length - 1; i++) {
                names[i] = names[i + 1];
            }
            names = Arrays.copyOf(names, names.length - 1);

            return true;
        }

        return false;
    }


}
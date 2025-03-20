package se.lexicon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    //-------------------------------------GetSize DONE
    @Test
    public void testGetSize() {
        // Test logic here:
        // Scenario: Check the size of an array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});

        // Expected value is 2
        int expected = 2;

        // Actual value
        int actual = NameRepository.getSize();

        // Verify the result
        Assertions.assertEquals(expected, actual);
    }

    //-------------------------------------SetNames DONE
    @Test
    @DisplayName("Send a filled array into SetNames method")
    public void testSetNamesFilledArray() {
        // Test logic here:
        // Scenario: a string array with strings in it sent into a set method
        String[] testNames = {"Erik Svensson", "Mehrdad Javan"};
        NameRepository.clear();

        // Expected strings
        String[] expected = {"Erik Svensson", "Mehrdad Javan"};

        // Actual strings added to names array in NameRepository
        NameRepository.setNames(testNames);
        String[] actual = NameRepository.findAll();

        // Verify the result
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("Send an empty array into SetNames method")
    public void testSetNamesEmptyArray() {
        // Test logic here:
        // Scenario: an empty string array sent into a set method
        String[] testNames = new String[0];
        NameRepository.clear();

        // Expected:
        String[] expected = new String[0];

        // Actual:
        NameRepository.setNames(testNames);
        String[] actual = NameRepository.findAll();

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("Name array in NameRepository is already filled with names")
    public void testSetNamesAnAlreadyExistingArray() {
        // Test logic here:
        // Scenario: a string array with strings in it sent into a set method but the class already contains an array of strings
        NameRepository.setNames(new String[]{"Dennis Olsen", "Matilda Björk", "Ingvar Svensson"});
        String[] testNames = {"Erik Svensson", "Mehrdad Javan"};

        // Expected strings
        String[] expected = {"Erik Svensson", "Mehrdad Javan"};

        // Actual strings added to names array in NameRepository
        NameRepository.setNames(testNames);
        String[] actual = NameRepository.findAll();

        // Verify the result
        Assertions.assertArrayEquals(expected, actual);
    }

    //-------------------------------------Clear DONE
    @Test
    public void testClear() {
        // Test logic here:
        // Scenario: clear an array by initializing the array again
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});

        // Expected:
        String[] expected = new String[0];

        // Actual:
        NameRepository.clear();
        String[] actual = NameRepository.findAll();

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }

    //-------------------------------------FindAll DONE
    @Test
    public void testFindAllFullArray(){
        // Test logic here:
        // Scenario: Return an array with strings in it
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});

        // Expected:
        String[] expected = {"Erik Svensson", "Mehrdad Javan"};

        // Actual:
        String[] actual = NameRepository.findAll();

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindAllEmptyArray(){
        // Test logic here:
        // Scenario: Return an empty array
        NameRepository.clear();

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findAll();

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }

    //-------------------------------------Find DONE
    @Test
    public void testFindSuccessInFindingStringInArrayWithStrings(){
        // Test logic here:
        // Scenario: Successfully finding a specific string in an array with multiple strings
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "Mehrdad Javan";

        // Expected:
        String expected = "Mehrdad Javan";

        // Actual:
        String actual = NameRepository.find(testName);

        // Verify the result:
        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Find should not be case sensitive")
    public void testFindSuccessWithMixLowerAndUpperCases(){
        // Test logic here:
        // Scenario: Successfully finding a specific string in an array when they have different upper/lower cases.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "Mehrdad javan";

        // Expected:
        String expected = "Mehrdad Javan";

        // Actual:
        String actual = NameRepository.find(testName);

        // Verify the result:
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testFindFailureInFindingStringInArrayWithStrings(){
        // Test logic here:
        // Scenario: Array not containing the specific string being searched for
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "Dennis Olsen";

        // Expected:
        String expected = null;

        // Actual:
        String actual = NameRepository.find(testName);

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFindFailureEmptyArray(){
        // Test logic here:
        // Scenario: Trying to find a string in an empty array
        NameRepository.clear();
        String testName = "Mehrdad Javan";

        // Expected:
        String expected = null;

        // Actual:
        String actual = NameRepository.find(testName);

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    //-------------------------------------Add DONE
    @Test
    public void testAddSuccess(){
        // Test logic here:
        // Scenario: Successfully adding string to an array of strings
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "Dennis Olsen";

        // Expected:
        String expectedString = "Dennis Olsen";
        boolean expectedBoolean = true;

        // Actual:
        boolean actualBoolean = NameRepository.add(testName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString,NameRepository.find(expectedString));
    }
    @Test
    public void testAddFailureDuplicateAlreadyExists(){
        // Test logic here:
        // Scenario: Failing in adding a string to an array because of duplicate already exist in array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "Mehrdad Javan";

        // Expected:
        String expectedString = null;
        boolean expectedBoolean = false;

        // Actual:
        boolean actualBoolean = NameRepository.add(testName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    @Test
    public void testAddFailureEmptyString(){
        // Test logic here:
        // Scenario: Failing in adding a string to an array because of the strings is empty
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "";

        // Expected:
        String expectedString = null;
        boolean expectedBoolean = false;

        // Actual:
        boolean actualBoolean = NameRepository.add(testName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    @Test
    public void testAddFailureBlanksOnlyInString(){
        // Test logic here:
        // Scenario: Failing in adding a string to an array because of the string only contains blanks
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testName = "   ";

        // Expected:
        String expectedString = null;
        boolean expectedBoolean = false;

        // Actual:
        boolean actualBoolean = NameRepository.add(testName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }

    //-------------------------------------findByFirstName DONE
    @Test
    public void testFindByFirstNameSuccessSingleMatch(){
        // Test logic here:
        // Scenario: Finding a single match when searching an array trying to find all strings who's first part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen"});
        String firstName = "Mehrdad";

        // Expected:
        String[] expected = {"Mehrdad Javan"};

        // Actual:
        String[] actual = NameRepository.findByFirstName(firstName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindByFirstNameSuccessMultipleMatches(){
        // Test logic here:
        // Scenario: Finding a multiple matches when searching an array trying to find all strings who's first part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Mehrdad Snöman"});
        String firstName = "Mehrdad";

        // Expected:
        String[] expected = {"Mehrdad Javan", "Mehrdad Snöman"};

        // Actual:
        String[] actual = NameRepository.findByFirstName(firstName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindByFirstNameFailureStringNotExistingInArray(){
        // Test logic here:
        // Scenario: Not finding any matches when searching an array trying to find all strings who's first part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Mehrdad Snöman"});
        String firstName = "Knut";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByFirstName(firstName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("findByFirstName is case sensitive")
    public void testFindByFirstFailureNameCaseSensitive(){
        // Test logic here:
        // Scenario: Searching an array trying to find all strings who's first part matches a specific string, but they have different lower and upper cases.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Mehrdad Snöman"});
        String firstName = "mehrdad";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByFirstName(firstName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindByFirstNameFailureEmptyArray(){
        // Test logic here:
        // Scenario: Searching an empty array for matching first part string.
        NameRepository.clear();
        String firstName = "Mehrdad";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByFirstName(firstName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    //-------------------------------------findByLastName DONE
    @Test
    public void testFindByLastNameSuccessSingleMatch(){
        // Test logic here:
        // Scenario: Finding a single match when searching an array trying to find all strings whose second part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen"});
        String lastName = "Javan";

        // Expected:
        String[] expected = {"Mehrdad Javan"};

        // Actual:
        String[] actual = NameRepository.findByLastName(lastName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindByLastNameSuccessMultipleMatches(){
        // Test logic here:
        // Scenario: Finding a multiple matches when searching an array trying to find all strings whose second part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Emil Javan", "Dennis Olsen"});
        String lastName = "Javan";

        // Expected:
        String[] expected = {"Mehrdad Javan", "Emil Javan"};

        // Actual:
        String[] actual = NameRepository.findByLastName(lastName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindByLastNameFailureStringNotExistingInArray(){
        // Test logic here:
        // Scenario: Not finding any matches when searching an array trying to find all strings whose second part matches a specific string.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Mehrdad Snöman"});
        String lastName = "Björkman";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByLastName(lastName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("findByLastName is case sensitive")
    public void testFindByLastNameFailureCaseSensitive(){
        // Test logic here:
        // Scenario: Searching an array trying to find all strings whose second part matches a specific string, but they have different lower and upper cases.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Mehrdad Snöman"});
        String lastName = "javan";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByLastName(lastName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindByLastNameFailureEmptyArray(){
        // Test logic here:
        // Scenario: Searching an empty array for matching second part string.
        NameRepository.clear();
        String lastName = "Javan";

        // Expected:
        String[] expected = new String[0];

        // Actual:
        String[] actual = NameRepository.findByLastName(lastName);

        // Verify the result:
        Assertions.assertArrayEquals(expected, actual);
    }

    //-------------------------------------update
    @Test
    public void testUpdateSuccess() {
        // Test logic here:
        // Scenario: Change the name of a specific string in an array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testOriginalName = "Erik Svensson";
        String testUpdatedName = "Björn Svensson";

        // Expected:
        boolean expectedBoolean = true;
        String expectedString = "Björn Svensson";

        // Actual:
        boolean actualBoolean = NameRepository.update(testOriginalName, testUpdatedName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    @Test
    @DisplayName("Update is case sensitive")
    public void testUpdateFailureStringsCasesDoNotMatch() {
        // Test logic here:
        // Scenario: Change the name of a specific string in an array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testOriginalName = "Erik svensson";
        String testUpdatedName = "Björn Svensson";

        // Expected:
        boolean expectedBoolean = false;
        String expectedString = null;

        // Actual:
        boolean actualBoolean = NameRepository.update(testOriginalName, testUpdatedName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    @Test
    public void testUpdateFailureStringDoNotExistInArray() {
        // Test logic here:
        // Scenario: trying to find a specific string in an array and change it, but it doesn't exist
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        String testOriginalName = "Dennis Olsen";
        String testUpdatedName = "John Olsen";

        // Expected:
        boolean expectedBoolean = false;
        String expectedString = null;

        // Actual:
        boolean actualBoolean = NameRepository.update(testOriginalName, testUpdatedName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    @Test
    public void testUpdateFailureEmptyArray() {
        // Test logic here:
        // Scenario: trying to find a specific string in an array and change it, but the array is empty
        NameRepository.clear();
        String testOriginalName = "Dennis Olsen";
        String testUpdatedName = "John Olsen";

        // Expected:
        boolean expectedBoolean = false;
        String expectedString = null;

        // Actual:
        boolean actualBoolean = NameRepository.update(testOriginalName, testUpdatedName);

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertEquals(expectedString, NameRepository.find(expectedString));
    }
    //-------------------------------------remove DONE
    @Test
    public void testRemoveSuccess(){
        // Test logic here:
        // Scenario: Remove specific string from an array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"});
        String testName = "Dennis Olsen";

        // Expected:
        String[] expectedArray = {"Erik Svensson", "Mehrdad Javan", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"};
        boolean expectedBoolean = true;

        // Actual:
        boolean actualBoolean = NameRepository.remove(testName);
        String[] actualArray = NameRepository.findAll();

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }
    @Test
    @DisplayName("Remove should not be case sensitive")
    public void testRemoveSuccessMixingUpperAndLowerCases(){
        // Test logic here:
        // Scenario: Remove specific string from an array but with first name starts with a lower case.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"});
        String testName = "dennis Olsen";

        // Expected:
        String[] expectedArray = {"Erik Svensson", "Mehrdad Javan", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"};
        boolean expectedBoolean = true;

        // Actual:
        boolean actualBoolean = NameRepository.remove(testName);
        String[] actualArray = NameRepository.findAll();

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }
    @Test
    public void testRemoveFailureStringDoNotExistInArray(){
        // Test logic here:
        // Scenario: Trying to remove a specific string from an array but the string doesn't exist in the array
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"});
        String testName = "Knut nyman";

        // Expected:
        String[] expectedArray = {"Erik Svensson", "Mehrdad Javan", "Dennis Olsen", "Gunilla Hammarby", "Henrik Snöborg", "Charlie Björksman"};
        boolean expectedBoolean = false;

        // Actual:
        boolean actualBoolean = NameRepository.remove(testName);
        String[] actualArray = NameRepository.findAll();

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }
    @Test
    public void testRemoveFailureEmptyArray(){
        // Test logic here:
        // Scenario: Trying to remove a specific string fom an empty array
        NameRepository.clear();
        String testName = "Knut nyman";

        // Expected:
        String[] expectedArray = new String[0];
        boolean expectedBoolean = false;

        // Actual:
        boolean actualBoolean = NameRepository.remove(testName);
        String[] actualArray = NameRepository.findAll();

        // Verify the result:
        Assertions.assertEquals(expectedBoolean, actualBoolean);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    //todo: TEST FOR CASE SENSITIVE ON THOSE THAT DID NOT SPECIFY IT

    // Test logic here:
    // Scenario:

    // Expected:

    // Actual:

    // Verify the result:
}

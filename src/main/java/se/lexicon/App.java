package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        System.out.println("SetName: Erik Svensson, Mehrdad Javan");
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println();

        System.out.println("Size: ");
        System.out.println(NameRepository.getSize());
        System.out.println();

        System.out.println("find: Mehrdad JavanMehrdad Javan");
        System.out.println(NameRepository.find("Mehrdad Javan"));
        System.out.println();

        System.out.println("add: Erik Ivarsson");
        System.out.println(NameRepository.add("Erik Ivarsson"));
        System.out.println();

        System.out.println("findAll: ");
        System.out.println(Arrays.toString(NameRepository.findAll()));
        System.out.println();

        System.out.println("findByFirstName: Mehrdad");
        System.out.println(Arrays.toString(NameRepository.findByFirstName("Mehrdad")));
        System.out.println();

        System.out.println("findByLastName: Ivarsson");
        System.out.println(Arrays.toString(NameRepository.findByLastName("Ivarsson")));
        System.out.println();

        System.out.println("update: Erik Svensson to Erik Torsson");
        System.out.println(NameRepository.update("Erik Svensson", "Erik Torsson"));
        System.out.println(Arrays.toString(NameRepository.findAll()));
        System.out.println();

        System.out.println("remove: Erik Torsson");
        System.out.println(NameRepository.remove("Erik Torsson"));
        System.out.println(Arrays.toString(NameRepository.findAll()));
        System.out.println();

        System.out.println("clear: ");
        NameRepository.clear();
        System.out.println(Arrays.toString(NameRepository.findAll()));
    }
}

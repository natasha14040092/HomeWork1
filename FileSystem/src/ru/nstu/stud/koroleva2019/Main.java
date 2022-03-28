package ru.nstu.stud.koroleva2019;

public class Main {
    public static void main(String[] args) {

        Folder rootFolder = new Folder("root folder");
        Folder subFolder1 = new Folder("subFolder 1", rootFolder);
        Folder subFolder2 = new Folder("subFolder 2", rootFolder);
        Folder subFolder3 = new Folder("subFolder 3", subFolder1);

        System.out.println("Testing getPath():");
        System.out.println(rootFolder.getPath());
        System.out.println(subFolder1.getPath());
        System.out.println(subFolder2.getPath());
        System.out.println(subFolder3.getPath());

        File file1 = new File("file 1.doc", rootFolder);
        File file2 = new File("file 2", subFolder3);
        File file3 = new File("file 3.txt", subFolder2);

        FileSystemNode folderInFile = new Folder("folder", file1);

        System.out.println();
        System.out.println(file1.getPath());
        System.out.println(file2.getPath());
        System.out.println(file3.getPath());

        System.out.println("\nChildren \"rootFolder\":");
        System.out.println(rootFolder.getChildrenString());

        System.out.println("\nTesting getFileExtension():");
        System.out.println(file1.getName() + ": " + file1.getFileExtension());
        System.out.println(file2.getName() + ": " + file2.getFileExtension());
        System.out.println(file3.getName() + ": " + file3.getFileExtension());

        System.out.println("\nTesting create new Folder with children:");
        Folder newRootFolder = new Folder("newRootFolder", file1, subFolder2, subFolder3);
        System.out.println(newRootFolder.getName());
        System.out.println(file1.getPath());
        System.out.println(subFolder2.getPath());
        System.out.println(subFolder3.getPath());

        System.out.println("\nChildren \"newRootFolder\":");
        System.out.println(newRootFolder.getChildrenString());
        System.out.println("\nChildren \"rootFolder\":");
        System.out.println(rootFolder.getChildrenString());

        Folder folder = new Folder("folder", newRootFolder, file2);
        System.out.println("\n" + folder.getName());
        System.out.println(file1.getPath());
        System.out.println(subFolder3.getPath());
        System.out.println(file2.getPath());

        System.out.println("\nChildren \"folder\":");
        System.out.println(folder.getChildrenString());

        System.out.println("\nChildren \"subFolder1\":");
        System.out.println(subFolder1.getChildrenString());
    }
}
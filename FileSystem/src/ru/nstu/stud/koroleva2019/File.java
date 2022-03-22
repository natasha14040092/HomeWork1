package ru.nstu.stud.koroleva2019;

public class File extends AbstractFileSystemNode{
    //root - имя папки в которой лежит файл
    //name включает в себя расширение файла

    File(){
        super();
        this.fileFlag = true;
    }

    File(String name){
        super(name);
        this.fileFlag = true;
    }

    File(String name, FileSystemNode root){
        super(name, root);
        this.fileFlag = true;
        ((Folder)root).getChildrenArray().add(this);
    }

    public String getFileExtension(){
        int dotIndex = this.getName().lastIndexOf('.');
        if (dotIndex == -1) return "";
        return this.getName().substring(dotIndex);
    }



}
package ru.nstu.stud.koroleva2019;

public class File extends AbstractFileSystemNode {
    //parent - имя папки в которой лежит файл,
    //name включает в себя расширение файла.

    File() {
        super();
        this.fileFlag = true;
    }

    File(String name) {
        super(name);
        this.fileFlag = true;
    }

    File(String name, FileSystemNode parent) {
        super(name, parent);
        this.fileFlag = true;
        if (this.getParentNode() != null) {
            ((Folder) parent).getChildrenArray().add(this);
        }
    }

    public String getFileExtension() {
        int dotIndex = this.getName().lastIndexOf('.');
        if (dotIndex == -1) return "";
        return this.getName().substring(dotIndex);
    }
}
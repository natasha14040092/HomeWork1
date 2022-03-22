package ru.nstu.stud.koroleva2019;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode {
    private final ArrayList<FileSystemNode> children =  new ArrayList<>();

    Folder(){
        super();
    }

    Folder(String name){
        super(name);
    }

    Folder(String name, FileSystemNode root){
        super(name, root);
        ((Folder)root).getChildrenArray().add(this);
    }

    Folder(String name, FileSystemNode ...  children){
        super(name);

        for (int i = 0; i < children.length; i++){
            AbstractFileSystemNode child = (AbstractFileSystemNode)children[i];
            Folder rootFolder = (Folder) child.getRootNode();
            if (rootFolder != null) {
                rootFolder.getChildrenArray().remove(child);
            }

            child.replace(this);
            this.children.add(children[i]);
        }
    }

    public ArrayList<FileSystemNode> getChildrenArray(){
        return children;
    }

    public String getChildrenString(){
        StringBuilder childrenString = new StringBuilder();
        for (FileSystemNode child : children){
            childrenString.append(child.getName());
            childrenString.append("; ");
        }
        return childrenString.toString();
    }

}
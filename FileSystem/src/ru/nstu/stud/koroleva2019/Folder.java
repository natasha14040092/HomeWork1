package ru.nstu.stud.koroleva2019;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode {
    private final ArrayList<FileSystemNode> children = new ArrayList<>();

    Folder() {
        super();
    }

    Folder(String name) {
        super(name);
    }

    Folder(String name, FileSystemNode parent) {
        super(name, parent);
        if (this.getParentNode() != null) {
            ((Folder) parent).getChildrenArray().add(this);
        }
    }

    Folder(String name, FileSystemNode... children) {
        super(name);

        for (FileSystemNode c : children) {
            this.children.add(c);

            if ((c.getClass() == File.class) || (c.getClass() == Folder.class)) {
                AbstractFileSystemNode child = (AbstractFileSystemNode) c;
                Folder parentFolder = (Folder) child.getParentNode();
                if (parentFolder != null) {
                    parentFolder.getChildrenArray().remove(child);
                }

                child.replace(this);
            }
        }
    }

    public ArrayList<FileSystemNode> getChildrenArray() {
        return children;
    }

    public String getChildrenString() {
        StringBuilder childrenString = new StringBuilder();
        for (FileSystemNode child : children) {
            childrenString.append(child.getName());
            childrenString.append("; ");
        }
        return childrenString.toString();
    }

}
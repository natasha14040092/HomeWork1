package ru.nstu.stud.koroleva2019;

public abstract class AbstractFileSystemNode implements FileSystemNode {
    private FileSystemNode parent;
    private String name;
    protected boolean fileFlag = false;

    AbstractFileSystemNode() {
        name = "untitled";
    }

    AbstractFileSystemNode(String name) {
        this.name = name;
    }

    AbstractFileSystemNode(String name, FileSystemNode parent) {
        if ((parent != null) && (parent.getClass() == File.class)) {
            System.out.println("File can't be the parent. Select parent = null");
            this.parent = null;
        } else
            this.parent = parent;
        this.name = name;
    }

    @Override
    public final FileSystemNode getParentNode() {
        return parent;
    }

    @Override
    public final String getPath() {
        FileSystemNode node = this;
        FileSystemNode parentNode;

        StringBuilder path = new StringBuilder();
        while ((parentNode = node.getParentNode()) != null) {
            path.insert(0, "\\" + node.getName());
            node = parentNode;
        }
        path.insert(0, node.getName());

        if (!fileFlag) path.append("\\");

        return path.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean getFileFlag() {
        return fileFlag;
    }

    public void rename(String newName) {
        name = newName;
    }

    public void replace(FileSystemNode newParent) {
        this.parent = newParent;
    }
}
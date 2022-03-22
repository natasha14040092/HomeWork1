package ru.nstu.stud.koroleva2019;

public abstract class AbstractFileSystemNode implements FileSystemNode{

    private FileSystemNode root;
    private String name;
    protected boolean fileFlag = false;

    AbstractFileSystemNode(){
        name = "untitled";
    }

    AbstractFileSystemNode(String name){
        this.name = name;
    }

    AbstractFileSystemNode(String name, FileSystemNode root) {
        if ((root != null) && (((AbstractFileSystemNode) root).getFileFlag()) ){
            System.out.println("File can't be the root. Select root = null");
            this.root = null;
        } else
            this.root = root;
        this.name = name;
    }

    @Override
    public final FileSystemNode getRootNode() {
        return root;
    }

    @Override
    public final String getPath() {
        FileSystemNode node = this;
        FileSystemNode rootNode;

        StringBuilder path = new StringBuilder();
        while ( (rootNode = node.getRootNode()) != null){
            path.insert(0,"\\" + node.getName());
            node = rootNode;
        }
        path.insert(0, node.getName());

        if (!fileFlag) path.append("\\");

        return path.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean getFileFlag(){
        return fileFlag;
    }

    public void rename(String newName){
        name = newName;
    }

    public void replace(FileSystemNode newRoot){
        this.root = newRoot;
    }
}
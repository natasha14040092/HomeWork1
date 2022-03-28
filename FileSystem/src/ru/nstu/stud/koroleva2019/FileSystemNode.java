package ru.nstu.stud.koroleva2019;

public interface FileSystemNode {
    FileSystemNode getParentNode();

    String getPath();

    String getName();
}
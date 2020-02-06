package com.company;

import java.io.*;

public class CharacterTreeSerialization {

    public static void main(String[] args) {
        // write your code here
        String inputFile = "";
        String outputFile = "";
        if (args.length == 3) {
            inputFile = args[1];
            outputFile = args[2];
            Tree tree = read(inputFile);
            tree.levelOrder();
            serialize(outputFile, tree);
        } else if (args.length == 2) {
            inputFile = args[1];
            Tree tree = deserialize(inputFile);
            tree.preOrder();
        }
    }

    private static Tree read(String file) {
        Tree tree = new Tree();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String separator = ",";
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(separator);
                for (String string : strings) {
                    tree.insert(string.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }

    private static void serialize(String fileName, Tree tree) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Tree deserialize(String fileName) {
        Tree tree = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            tree = (Tree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}

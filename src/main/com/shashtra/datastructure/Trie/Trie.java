package com.shashtra.datastructure.Trie;

import static com.shashtra.common.Constants.ALPHABET_SIZE;

/***************
 **   author: Hariom Singh
 **  Date: 15/03/22
 *****************/
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++)
            this.children[i] = null;
    }
}

public class Trie {
    TrieNode root;
    //TODO: Support more function in trie e.g. get all patterns which are matching with given prefix

    Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        String name1 = "hariomsingh";
        String name2 = "darkhacker";
        String name3 = "falanesingh";
        String name4 = "anothername";

        trie.insert(name1);
        trie.insert(name2);
        trie.insert(name3);
        System.out.println("is " + name2 + " present in trie? " + trie.search(name2));
        System.out.println("is " + name4 + " present in trie? " + trie.search(name4));

        trie.insert(name4);
        System.out.println("is " + name4 + " present in trie? " + trie.search(name4));

    }

    void insert(String key) {
        int length = key.length();
        int index;
        TrieNode temp = root;
        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }

    boolean search(String key) {
        int index;
        TrieNode temp = root;
        int length = key.length();
        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.isEndOfWord;
    }

}

package br.inf.ufes.pp2017_01;

import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Dictionary {
  private List<byte[]> wordList = new ArrayList<byte[]>();

  public void loadDictionary(String filePath) throws IOException {
    List<String> stringList = new ArrayList<String>();
    File file = new File(filePath);
    if(file.exists()){
      stringList = Files.readAllLines(file.toPath(), Charset.defaultCharset());
    }
    stringList.forEach( (string) -> {
      if (!string.contentEquals(""))
        wordList.add(string.getBytes());
    });
  }

  public List<byte[]> getWordList() {
    return wordList;
  }
}

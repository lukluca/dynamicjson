package com.lukluca.fileutility;

import android.content.Context;
import com.lukluca.dynamicjson.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by l.tagliabue on 03/03/2016.
 */
public class FileManager {
    private Field[] listOfRawFile;
    private ArrayList<Field> listOfRawJsonFile;
    private String[] nameOfJsonFiles;
    private  Context context;

    public FileManager(Context context) {
        this.context = context;
        listOfRawFile = R.raw.class.getFields();
        getListOfRawJsonFile();
    }



    public int getNumberOfJsonFile(){
        if (listOfRawJsonFile != null){
            return listOfRawJsonFile.size();
        }
        return 0;
    }

    private void getListOfRawJsonFile()  {
            if (listOfRawFile != null && context != null && listOfRawFile.length > 0){
                listOfRawJsonFile = new ArrayList<>();
                for (Field aListOfRawFile : listOfRawFile) {
                    if (aListOfRawFile.getName().toLowerCase().contains("json_".toLowerCase())) {
                        //TODO we need to know size of array.
                        listOfRawJsonFile.add(aListOfRawFile);
                    }
                }
            }
    }

    public String[] getNameOfJsonFiles() {
        if (listOfRawJsonFile != null && listOfRawJsonFile.size() > 0) {
            nameOfJsonFiles = new String[listOfRawJsonFile.size()];
            int val = 0;
            for (Field rawJsonFile : listOfRawJsonFile) {
                nameOfJsonFiles[val++] = rawJsonFile.getName().replace("json_","");

            }
        }
        return nameOfJsonFiles;
    }

}

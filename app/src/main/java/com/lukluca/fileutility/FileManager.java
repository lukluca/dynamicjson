package com.lukluca.fileutility;

import android.content.Context;
import com.lukluca.dynamicjson.R;
import java.lang.reflect.Field;

/**
 * Created by l.tagliabue on 03/03/2016.
 */
public class FileManager {

    private Field[] listOfRawFile;
    private  Field[] listOfRawJsonFile;
    private  Context context;

    public FileManager(Context context) {
        this.context = context;
        listOfRawFile = R.raw.class.getFields();
        listOfRawJsonFile = getListOfRawJsonFile();
    }



    public int getNumberOfJsonFile(){

        if (listOfRawJsonFile != null){
            return listOfRawJsonFile.length;
        }

        return 0;
    }

    private Field[] getListOfRawJsonFile()  {


            if (listOfRawFile != null && context != null){
                listOfRawJsonFile = new Field[]{};
                int val = 0;
                for (Field aListOfRawFile : listOfRawFile) {
                    if (aListOfRawFile.getName().toLowerCase().contains("json_".toLowerCase())) {
                        //TODO we need to know size of array.
                        listOfRawJsonFile[val] = aListOfRawFile;
                        val++;
                    }
                }
            }



        return listOfRawJsonFile;
    }

}

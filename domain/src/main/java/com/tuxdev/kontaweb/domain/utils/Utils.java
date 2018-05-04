package com.tuxdev.kontaweb.domain.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by j.sanchez.chaves on 4/27/2018.
 *
 * KONTA-pom
 */
public class Utils {

    public static Map<String,String> getValuesOfQuery(String query){
        String[] statements=query.split(",");
        String key;
        String value;
        String [] keyValue;
        Map<String,String> map=new HashMap<>();
        for(String statement:statements){
            keyValue=statement.split("\\|");
            key=keyValue[0];
            value=keyValue[1];
            if(!key.isEmpty()&&!value.isEmpty()){
                map.put(key,value);
            }
        }
        return map;
    }
}

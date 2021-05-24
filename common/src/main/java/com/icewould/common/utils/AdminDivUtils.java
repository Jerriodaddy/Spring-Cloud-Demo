package com.icewould.common.utils;

import com.google.gson.*;
import com.icewould.common.enums.AdminDivLevel;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wenzhe
 */
public class AdminDivUtils {
    private static AdminDivUtils instance;
    private JsonObject divRelation;


    private AdminDivUtils(){ }
    private static AdminDivUtils getInstance(){
        if(instance == null){
            init("classpath:pcas.json");
        }
        return instance;
    }
    public static void init(String filePath){
        try {
            File adminDivJsonFile = ResourceUtils.getFile(filePath);
            BufferedReader br = new BufferedReader(new FileReader(adminDivJsonFile));
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(br).getAsJsonObject();
            instance = new AdminDivUtils();
            instance.divRelation = jsonObj;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static boolean isValid(List<String> divChain){
        if(divChain.size() > AdminDivLevel.TOWN.getValue()+1){
            return false;
        }
        JsonElement curDivRelation = getInstance().divRelation;

        int curDivLevel = 0;
        for(String curDiv : divChain) {
            JsonObject bufDivRelation;
            if(curDivLevel == AdminDivLevel.PROVINCE.getValue()
            || curDivLevel == AdminDivLevel.CITY.getValue()
            || curDivLevel == AdminDivLevel.COUNTY.getValue()){
                bufDivRelation = curDivRelation.getAsJsonObject();
                if(!bufDivRelation.has(curDiv)){ return false; }
            }else if(curDivLevel == AdminDivLevel.TOWN.getValue()){
                Gson gson = new Gson();
                JsonArray bufDivRelationArray = curDivRelation.getAsJsonArray();
                JsonPrimitive bufJson = new JsonPrimitive(curDiv);
                return bufDivRelationArray.contains(bufJson);
            }else{
                return false;
            }
            curDivRelation = bufDivRelation.get(curDiv);
            curDivLevel++;
        }
        return true;
    }

    public static Set<String> getSub(List<String> divChain){
        if(divChain.size() > AdminDivLevel.COUNTY.getValue() + 1){
            return null;
        }
        JsonObject curDivRelation = getInstance().divRelation;

        boolean found = true;
        int curSubLevel = 1;
        for(String curDiv : divChain){
            JsonElement curSub = curDivRelation.get(curDiv);
            if(curSub.isJsonNull()){
                found = false;
                break;
            }
            if(curSubLevel == AdminDivLevel.TOWN.getValue()){
                HashSet<String> result = new HashSet<>();
                for(JsonElement element: curSub.getAsJsonArray()){
                    result.add(element.getAsString());
                }
                return result;
            }else{
                curDivRelation = curSub.getAsJsonObject();
            }
            curSubLevel++;
        }

        if(found){
            return curDivRelation.keySet();
        }
        return null;
    }

    public static JsonObject getAll(){
        return getInstance().divRelation.deepCopy();
    }
}

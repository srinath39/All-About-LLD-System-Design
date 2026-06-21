package com.LldUseCases.BookMyShow.Utils;

import java.util.UUID;

public class GenerateUniqueId {
    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}

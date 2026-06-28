package com.LldUseCase.WhatsApp.Utils;

import java.util.UUID;

public class GenerateUniqueId {
    public static String getUniqueUUID(){
        return UUID.randomUUID().toString();
    }
}

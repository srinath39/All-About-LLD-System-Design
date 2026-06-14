package com.SpringProjects.ParkingLoT.Enums;

public enum EnumSpotSize {
    SMALL(0),
    MEDIUM(1),
    LARGE(2);

    private int sizeId;

    EnumSpotSize(int sizeId){
        this.sizeId = sizeId;
    }
    public int getSizeId(){
        return sizeId;
    }

    public static EnumSpotSize getNextGreaterSpotSize(EnumSpotSize spotSize){
        int value=spotSize.getSizeId();
        return getSpotSizeById(++value);
    }

    public static EnumSpotSize getSpotSizeById(int spotSizeId){
        for(EnumSpotSize spotSize:EnumSpotSize.values()){
            if(spotSize.getSizeId()==spotSizeId){
                return spotSize;
            }
        }
        return null;
    }
}

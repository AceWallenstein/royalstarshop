package com.pinnoocle.royalstarshop.nets;

import android.content.Context;

public class Injection {

    public static DataRepository dataRepository(Context context){
        return DataRepository.getInstance(RemotDataSourceImpl.getInstance(context));
    }
}

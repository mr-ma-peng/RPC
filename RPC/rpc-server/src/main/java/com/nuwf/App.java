package com.nuwf;

import com.nuwf.servicecenter.ServerImpl;
import com.nuwf.servicecenter.server;
import com.nuwf.serviceimpl.ComPutingServices;
import com.nuwf.serviceimpl.ComPutingServicesImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App
{
    public static void main( String[] args ) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        server RPCserver = new ServerImpl();
        RPCserver.register(ComPutingServices.class, ComPutingServicesImpl.class);
        RPCserver.start();
    }
}

package org.javase;

public class MongoConnection implements Connection {
    @Override
    public void connectV2() {

    }

    @Override
    public  void close(){
        System.out.println("Closing Mongo....");
    }
}

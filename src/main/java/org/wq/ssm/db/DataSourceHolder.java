package org.wq.ssm.db;

public class DataSourceHolder{
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    public static void putDataSource(String name) {
        holder.set(name);
    }
    public static String getDataSouce() {
    	System.out.println(holder.get());
        return holder.get();
    }
}

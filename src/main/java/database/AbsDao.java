package database;

import model.IModel;
import model.Log;

public abstract class AbsDao<T extends IModel> implements IDao<T> {
    protected static String username = "";
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        AbsDao.username = username;
    }

    @Override
    public int insert(T data) {
        return Logging.insert(Log.insert(data, username));
    }

    @Override
    public int update(T data) {
        return 0;
    }

    @Override
    public int delete(T data) {
        return 0;
    }
    public int login(T data){
        return Logging.insert(Log.login(data, username));
    }
}

package database;

import model.IModel;

import java.util.ArrayList;

public interface IDao<T extends IModel> {
    int insert(T data);
    int update(T data);
    int delete(T data);
    ArrayList<T> selectAll();

}

package com.ostagram.models;

import java.util.List;

public interface IMessageListener<T> {


    public void onSuccessObject(T response);

    public void onSuccess(List<T> response);

    public void onError(String errorMessage);
}

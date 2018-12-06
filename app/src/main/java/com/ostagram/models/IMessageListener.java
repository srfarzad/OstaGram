package com.ostagram.models;

import java.util.List;

public interface IMessageListener<T> {


    public void onSuccess(List<T> response);

    public void onError(String errorMessage);
}

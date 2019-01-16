package com.ostagram.ui.Main;

import com.ostagram.models.IMessageListener;
import com.ostagram.models.Posts;

import java.util.List;

 public interface MainView {

 void setItem(List<Posts> list);
  void errorServer(String serverError);

}

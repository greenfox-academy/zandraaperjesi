package com.zandraa.perjesi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private boolean isUrgent;
  private boolean isDone;

  public Todo() {}

  public Todo(String s) {
    this.title = s;
    this.isDone = false;
    this.isUrgent = false;
  }

  public Todo(String s, boolean isDone, boolean isTrue) {
    this.title = s;
    this.isDone = isDone;
    this.isUrgent = isTrue;
  }

  @Override
  public String toString() {
    return this.title;
  }

  public String getIdd() {
    return String.valueOf(id);
  }

  public String getIsUrgent() {
    return String.valueOf(isUrgent);
  }

  public String getIsDone() {
    return String.valueOf(isDone);
  }
}

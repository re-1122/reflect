package com.koyomiji.reflect.setup;

public class Stopwatch {
  private long begin;
  private long end;

  public Stopwatch() {}

  public void start() { begin = System.currentTimeMillis(); }

  public void stop() { end = System.currentTimeMillis(); }

  public double getElapsedInSeconds() { return (end - begin) / 1000.0; }
}
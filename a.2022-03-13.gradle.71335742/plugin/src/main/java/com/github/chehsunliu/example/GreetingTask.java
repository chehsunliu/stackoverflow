package com.github.chehsunliu.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

public class GreetingTask extends DefaultTask {
  private String serviceVersion = "v1.0";

  @Option(option = "serviceVersion", description = "Configure service version")
  public void setServiceVersion(String serviceVersion) {
    this.serviceVersion = serviceVersion;
  }

  @Input
  public String getServiceVersion() {
    return this.serviceVersion;
  }

  @TaskAction
  public void task() {
    System.out.println(this.serviceVersion);
  }
}

/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.sonar.sslr.dsl.adapter;

public interface LoopBlockAdapter extends ControlFlowAdapter {

  public boolean shouldExecuteLoopBlockIteration();

  public void initLoopState();

}

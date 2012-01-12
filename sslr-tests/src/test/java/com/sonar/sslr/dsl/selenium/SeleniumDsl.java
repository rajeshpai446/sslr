/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.sonar.sslr.dsl.selenium;

import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.api.Rule;

import static com.sonar.sslr.dsl.DslTokenType.INTEGER;
import static com.sonar.sslr.dsl.DslTokenType.LITERAL;
import static com.sonar.sslr.impl.matcher.GrammarFunctions.Standard.o2n;

public class SeleniumDsl extends Grammar {

  public Rule translationUnit;
  public Rule command;
  public Rule openUrl;
  public Rule assertTitle;
  public Rule assertSize;

  public SeleniumDsl() {
    translationUnit.is(o2n(command));
    command.isOr(openUrl, assertTitle, assertSize);

    openUrl.is("open", LITERAL);
    assertTitle.is("assert", "that", "title", "is", LITERAL);
    assertSize.is("assert", "that", "size", "<", "=", INTEGER, "Ko");

  }

  @Override
  public Rule getRootRule() {
    return translationUnit;
  }
}
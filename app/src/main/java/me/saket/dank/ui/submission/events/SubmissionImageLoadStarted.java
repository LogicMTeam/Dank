package me.saket.dank.ui.submission.events;

import me.saket.dank.ui.UiEvent;

public class SubmissionImageLoadStarted implements UiEvent {

  public static SubmissionImageLoadStarted create() {
    return new SubmissionImageLoadStarted();
  }
}

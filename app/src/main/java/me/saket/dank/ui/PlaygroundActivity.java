package me.saket.dank.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.saket.dank.R;
import me.saket.dank.urlparser.RedditUserLink;
import me.saket.dank.di.Dank;
import me.saket.dank.ui.user.UserProfilePopup;
import me.saket.dank.urlparser.UrlParser;

public class PlaygroundActivity extends DankPullCollapsibleActivity {

  @Inject UrlParser urlParser;

  public static void start(Context context) {
    context.startActivity(new Intent(context, PlaygroundActivity.class));
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    Dank.dependencyInjector().inject(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_playground);
    ButterKnife.bind(this);
    findAndSetupToolbar();

    setupContentExpandablePage(ButterKnife.findById(this, R.id.playground_root));
    expandFromBelowToolbar();
  }

  @OnClick(R.id.playground_user_profile_popup)
  void onClickShowProfilePopup(Button button) {
    UserProfilePopup userProfilePopup = new UserProfilePopup(this);
    userProfilePopup.loadUserProfile((RedditUserLink) urlParser.parse("http://reddit.com/u/kn0thing"));
    userProfilePopup.showWithAnchor(button);
  }

  @OnClick(R.id.playground_menupopup)
  void onClickShowMenuPopup(Button button) {
    PopupMenu popupMenu = new PopupMenu(this, button);
    popupMenu.getMenu().add("Poop");
    popupMenu.getMenu().add("Poop");
    popupMenu.getMenu().add("Poop");
    popupMenu.show();
  }
}
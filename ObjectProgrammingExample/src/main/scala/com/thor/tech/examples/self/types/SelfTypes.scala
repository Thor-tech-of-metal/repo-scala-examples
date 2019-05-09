package com.thor.tech.examples.self.types

trait User {
  def username: String
}

///// Here the idea is that Tweeter is not related with User but it can access to User.username

trait Tweeter {
  this: User =>  // reassign this
    def tweet(tweetText: String) = s"$username: $tweetText"
}


class VerifiedTweeter(val userName : String) extends Tweeter with User {

  // We mixin User because Tweeter required it
  def username = s"real $userName"

}

<?php

class User extends BaseUser
{
  public function setPassword($value)
  {
    // MD5 encrypt all passwords
    parent::setPassword(md5($value));
  }

  public function getCurrentlyPlayingReadable()
  {
    if($this->getCurrentGameId())
      return $this->getCurrentGameId();
    else
      return "Not Playing";
  }
}

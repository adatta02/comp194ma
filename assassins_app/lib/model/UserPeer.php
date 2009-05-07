<?php

class UserPeer extends BaseUserPeer
{
  public static function getUsersRankedByBest()
  {
    $c=new Criteria();
    $c->addDescendingOrderByColumn(UserPeer::WINS);
    $c->addDescendingOrderByColumn(UserPeer::KILLS);
    return self::doSelect($c);
  }
}

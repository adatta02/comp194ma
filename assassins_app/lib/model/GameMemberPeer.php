<?php

class GameMemberPeer extends BaseGameMemberPeer
{
  public static function getMemberIdsInGame($game_id)
  {
    $c=new Criteria();
    $c->add(GameMemberPeer::GAME_ID,$game_id);
    $c->add(GameMemberPeer::IS_ACTIVE,true);
    $ar=array();
    foreach(self::doSelect($c) as $m)
    {
      $ar[]=$m->getUserId();
    }
    return $ar;
  }

  public static function setMemberInactive($user_id,$game_id)
  {
      $c=new Criteria();
      $c->add(GameMemberPeer::USER_ID,$user_id);
      $c->add(GameMemberPeer::GAME_ID,$game_id);
      
      $member=GameMemberPeer::doSelectOne($c);
      $member->setIsActive(false);
      $member->save();

  }

  public static function userHasPlayedGame($user_id,$game_id)
  {
     $c=new Criteria();
      $c->add(GameMemberPeer::USER_ID,$user_id);
      $c->add(GameMemberPeer::GAME_ID,$game_id);
      return self::doSelectOne($c);
    
  }

}

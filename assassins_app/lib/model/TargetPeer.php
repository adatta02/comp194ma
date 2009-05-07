<?php

class TargetPeer extends BaseTargetPeer
{
  public static function getTargetedMembersByIds($ids)
  {
    $c=new Criteria();
    $c->add(TargetPeer::TO_USER_ID,$ids,Criteria::IN);
    $arr=array();
    foreach(self::doSelect($c) as $target)
      $arr[]=$target->getToUserId();
  }
  public static function getTargetForUser($user)
  {
    $memberIDs=GameMemberPeer::getMemberIdsInGame($user->getCurrentGameId());
    $memberIDs=array_diff($memberIDs,array($user->getId()));
    $targetIDs=self::getTargetedMembersByIds($memberIDs);
    
    if(!is_array($memberIDs)||count($memberIDs)<1)
      return false;
    if(!is_array($targetIDs))
    {
      $targetID=array_shift($memberIDs);
      self::assignTarget($user->getId(),$targetID);
      return $targetID;
    }
    $possibleTargets=array_diff($memberIDs,$targetIDS);
    $targetID=array_shift($possibleTargets);
    self::assignTarget($user->getId(),$targetID);
    return $targetID;

  }
  public static function killTarget($from_user_id)
  {
    $c=new Criteria();
    $c->add(TargetPeer::FROM_USER_ID,$from_user_id);
    $target=self::doSelectOne($c);
    if($target)
    {
      
      $toUser=$target->getToUser();
      $toUser->setDeaths($toUser->getDeaths()+1);
      $toUser->setLosses($toUser->getLosses()+1);

      $c=new Criteria();
      $c->add(TargetPeer::FROM_USER_ID,$toUser->getId());
      $targ=self::doSelectOne($c);
      if($targ)
        $targ->delete();
      
      //Mark the user that is killed as inactive
      $c=new Criteria();
      $c->add(GameMemberPeer::USER_ID,$target->getToUserId());
      $c->add(GameMemberPeer::GAME_ID,$toUser->getCurrentGameId());
      
      $member=GameMemberPeer::doSelectOne($c);
      $member->setIsActive(false);
      $member->save();
      $toUser->setCurrentGameId(null);
      $toUser->save();
      $target->delete();
    }
    
  }
  public static function assignTarget($from_user_id,$to_user_id)
  {
    $target=new Target();
    $target->setFromUserId($from_user_id);
    $target->setToUserId($to_user_id);
    $target->save();
  }

  public static function userHasTarget($user_id)
  {
    $c=new Criteria();
    $c->add(TargetPeer::FROM_USER_ID,$user_id);
    
    if($target=TargetPeer::doSelectOne($c))
      return $target->getToUser();
    return false;
  }


}

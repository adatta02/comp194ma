<?php

/**
 * game actions.
 *
 * @package    assassins
 * @subpackage game
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 12479 2008-10-31s 10:54:40Z fabien $
 */
class gameActions extends sfActions
{
  public function executeCreate(sfWebRequest $request)
  {
    $user=UserPeer::retrieveByPk($request->getParameter('username'));
    if(!$user)
    {
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "Invalid username";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    $game=new Game();
    $game->setIsPublic($request->getParameter('public',0));
    $game->setStartTime(time());
    $game->setIsActive(true);
    $game->setLatitude($request->getParameter('latitude'));
    $game->setLongitude($request->getParameter('longitude'));
    $game->save();
    $gameMember=new GameMember();
    $gameMember->setUserId($user->getId());
    $gameMember->setGameId($game->getId());
    $gameMember->setIsActive(true);
    $gameMember->save();
    $user->setCurrentGameId($game->getId());
    $this->updateUserLocation($user,$request);
    $arr=array();
    $arr["result"] = true;
    $arr["message"] = "Game created, game number is ".$game->getId().".  When others join, you will be assigned a target";
    $this->renderText( json_encode($arr) );
    return sfView::NONE;
  }

  public function executeJoin(sfWebRequest $request)
  {
    $user=UserPeer::retrieveByPk($request->getParameter('username'));
    if(!$user)
    {
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "Invalid username";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    if($user->getCurrentGameId())
    {
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "You are already in a game";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    
    $this->updateUserLocation($user,$request);
    if(!$request->getParameter('game_id'))
    {
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "Invalid game number";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }

    $game=GamePeer::retrieveByPk($request->getParameter('game_id'));
    if(!$game){
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "Invalid game number";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;

    }
    if(GameMemberPeer::userHasPlayedGame($user->getId(),$game->getId()))
    {
      $arr=array();
      $arr["result"] = false;
      $arr["message"] = "You have already played in this game, start or join a different one!";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;

    }
    $gameMember=new GameMember();
    $gameMember->setUserId($user->getId());
    $gameMember->setGameId($game->getId());
    $gameMember->setIsActive(true);
    $gameMember->save();
    $user->setCurrentGameId($game->getId());
    $user->save();
    $arr=array();
    $arr["result"] = true;
    $arr["message"] = "You have joined game ".$game->getId();
    $this->renderText( json_encode($arr) );
    return sfView::NONE;

  }

  public function executeCheckStatus(sfWebRequest $request)
  {
    $user=UserPeer::retrieveByPk($request->getParameter('username'));
    $arr=array();
    if(!$user)
    {

      $arr["result"] = false;
      $arr["message"] = "Invalid username";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }

    $this->updateUserLocation($user,$request);

    //Are they inactive now? if so they are dead
    if(!$user->getCurrentGameId())
    {

      $arr["result"] = true;
      $arr["message"] = "You have been killed! You are no longer playing!";
      $arr["dead"]=true;
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    $target=TargetPeer::userHasTarget($user->getId());
    if(!$target)
    {
      if($targetUserID=TargetPeer::getTargetForUser($user))
      {
        $target=UserPeer::retrieveByPk($targetUserID);
        $arr['result']=true;
        $arr['message']="You've been assigned a target!";
        $arr['latitude']=$target->getLatitude();
        $arr['longitude']=$target->getLongitude();
	$this->renderText( json_encode($arr) );
	return sfView::NONE;
      }
    }
    else{
      $targetLat=$target->getLatitude();
      $targetLong=$target->getLongitude();
      $userLat=$user->getLatitude();
      $userLong=$user->getLongitude();
      
      $distanceBetweenUser=$this->calculateDistance($userLat,$userLong,$targetLat,$targetLong);

//echo "target".$targetLat." ".$targetLong." me".$userLat." ".$userLong." dist".$distanceBetweenUser;
      if($distanceBetweenUser<0.8)
      {
	$arr['result']=true;
	$arr['message']="You can kill your target! You are in range!";
        $arr['can_kill']=true;
        $arr['latitude']=$target->getLatitude();
        $arr['longitude']=$target->getLongitude();
	$this->renderText( json_encode($arr) );
	return sfView::NONE;
      }
      $arr['result']=true;
      $arr['message']=null;
      $arr['latitude']=$target->getLatitude();
      $arr['longitude']=$target->getLongitude();
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    $arr['result']=true;
    $arr['message']=null;
    $this->renderText( json_encode($arr) );
    return sfView::NONE;

  }
  public function executeKill(sfWebRequest $request)
  {
    $user=UserPeer::retrieveByPk($request->getParameter('username'));
    $arr=array();
    if(!$user)
    {

      $arr["result"] = false;
      $arr["message"] = "Invalid username";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    if(!$user->getCurrentGameId())
    {
      $arr["result"] = false;
      $arr["message"] = "You are dead, you cannot kill.";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
   
    }
    TargetPeer::killTarget($user->getId());
    $user->setKills($user->getKills()+1);
    $user->save();
    $arr["result"] = true;
    if(count(GameMemberPeer::getMemberIdsInGame($user->getCurrentGameId()))<2)
    {
      GameMemberPeer::setMemberInactive($user->getId(),$user->getCurrentGameId());
      $user->setWins($user->getWins()+1);
      $user->setCurrentGameId(null);
      $user->save();
      $arr["message"] = "You have won!  Game is over!";
      $arr["win"]=true;

    }
    else
    {
      $arr["message"] = "Target Killed, new one will be assigned soon!";
      $arr["win"]=false;
    }
    $this->renderText( json_encode($arr) );
    return sfView::NONE;
  }
  function calculateDistance($lat1,$lon1,$lat2,$lon2,$unit=null)
  {
    
    $theta = $lon1 - $lon2;
    $dist = sin(deg2rad($lat1)) * sin(deg2rad($lat2)) + cos(deg2rad($lat1)) * cos(deg2rad($lat2)) * cos(deg2rad($theta));
    $dist = acos($dist);
    $dist = rad2deg($dist);
    $miles = $dist * 60 * 1.1515;
    $unit = strtoupper($unit);
    
    if ($unit == "K") 
      return ($miles * 1.609344);
    else if ($unit == "N") 
      return ($miles * 0.8684);
    else 
      return $miles;
  }

  function updateUserLocation($user,$request)
  {
    $user->setLatitude($request->getParameter('latitude'));
    $user->setLongitude($request->getParameter('longitude'));
    $user->save();
  }
}

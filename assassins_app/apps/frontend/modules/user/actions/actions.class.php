<?php

/**
 * user actions.
 *
 * @package    assassins
 * @subpackage user
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 12479 2008-10-31 10:54:40Z fabien $
 */
class userActions extends sfActions
{

  public function executeSignup(sfWebRequest $request)
  {
    $arr = array();
    if($request->getParameter('username')&&$request->getParameter('password'))
    {
      $c=new Criteria();
      $c->add(UserPeer::ID,$request->getParameter('username'));
      // The name already taken?
      if(UserPeer::doSelectOne($c))
      {
	$arr["result"] = false;
	$arr["message"] = "Username Already Taken";
	$this->renderText( json_encode($arr) );
  	return sfView::NONE;
      }
      $user=new User();
      $user->setId($request->getParameter('username'));
      $user->setPassword($request->getParameter('password'));
      $user->setKills(0);
      $user->setDeaths(0);
      $user->setGamesPlayed(0);
      $user->setWins(0);
      $user->setLosses(0);
      $user->save();
      $arr["result"] = true;
      $arr["message"] = "Ok";
      $this->renderText( json_encode($arr) );
      return sfView::NONE;
    }
    $arr["result"] = false;
    $arr["message"] = "Please enter username and password";
    $this->renderText( json_encode($arr) );
    return sfView::NONE;
  }

  public function executeLogin(sfWebRequest $request)
  {
    $arr = array();
    if($request->hasParameter('username')&&$request->hasParameter('password'))
    {
      $c=new Criteria();
      $c->add(UserPeer::ID,$request->getParameter('username'));
      $c->add(UserPeer::PASSWORD,md5($request->getParameter('password')));
      if(UserPeer::doSelectOne($c))
      {
        $arr["result"] = true;
        $arr["message"] = "OK";
	$this->renderText( json_encode($arr) );
	return sfView::NONE;      
      }
    }
    $arr["result"] = false;
    $arr["message"] = "Username or password invalid";
    $this->renderText( json_encode($arr) );
    return sfView::NONE;

  }
  
}

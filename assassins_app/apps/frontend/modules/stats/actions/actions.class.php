<?php

/**
 * stats actions.
 *
 * @package    assassins
 * @subpackage stats
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: actions.class.php 12479 2008-10-31 10:54:40Z fabien $
 */
class statsActions extends sfActions
{
 /**
  * Executes index action
  *
  * @param sfRequest $request A request object
  */
  public function executeIndex(sfWebRequest $request)
  {
    $this->users=UserPeer::getUsersRankedByBest();
  }
}

<?php
// auto-generated by sfRoutingConfigHandler
// date: 2009/05/06 23:44:05
return array(
'user_signup' => new sfRoute('/user/signup', array (
  'module' => 'user',
  'action' => 'signup',
), array (
), array (
)),
'user_login' => new sfRoute('/user/login', array (
  'module' => 'user',
  'action' => 'login',
), array (
), array (
)),
'game_create' => new sfRoute('/game/create', array (
  'module' => 'game',
  'action' => 'create',
), array (
), array (
)),
'game_check_status' => new sfRoute('/game/checkStatus', array (
  'module' => 'game',
  'action' => 'checkStatus',
), array (
), array (
)),
'game_join' => new sfRoute('/game/join', array (
  'module' => 'game',
  'action' => 'join',
), array (
), array (
)),
'game_kill' => new sfRoute('/game/kill', array (
  'module' => 'game',
  'action' => 'kill',
), array (
), array (
)),
'homepage' => new sfRoute('/', array (
  'module' => 'default',
  'action' => 'index',
), array (
), array (
)),
'default_index' => new sfRoute('/:module', array (
  'action' => 'index',
), array (
), array (
)),
'default' => new sfRoute('/:module/:action/*', array (
), array (
), array (
)),
);

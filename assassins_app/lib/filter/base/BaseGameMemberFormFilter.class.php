<?php

require_once(sfConfig::get('sf_lib_dir').'/filter/base/BaseFormFilterPropel.class.php');

/**
 * GameMember filter form base class.
 *
 * @package    assassins
 * @subpackage filter
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: sfPropelFormFilterGeneratedTemplate.php 15484 2009-02-13 13:13:51Z fabien $
 */
class BaseGameMemberFormFilter extends BaseFormFilterPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'user_id'   => new sfWidgetFormPropelChoice(array('model' => 'User', 'add_empty' => true)),
      'game_id'   => new sfWidgetFormPropelChoice(array('model' => 'Game', 'add_empty' => true)),
      'is_active' => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
    ));

    $this->setValidators(array(
      'user_id'   => new sfValidatorPropelChoice(array('required' => false, 'model' => 'User', 'column' => 'id')),
      'game_id'   => new sfValidatorPropelChoice(array('required' => false, 'model' => 'Game', 'column' => 'id')),
      'is_active' => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
    ));

    $this->widgetSchema->setNameFormat('game_member_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'GameMember';
  }

  public function getFields()
  {
    return array(
      'id'        => 'Number',
      'user_id'   => 'ForeignKey',
      'game_id'   => 'ForeignKey',
      'is_active' => 'Boolean',
    );
  }
}

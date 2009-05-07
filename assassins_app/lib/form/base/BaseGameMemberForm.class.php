<?php

/**
 * GameMember form base class.
 *
 * @package    assassins
 * @subpackage form
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: sfPropelFormGeneratedTemplate.php 15484 2009-02-13 13:13:51Z fabien $
 */
class BaseGameMemberForm extends BaseFormPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'        => new sfWidgetFormInputHidden(),
      'user_id'   => new sfWidgetFormPropelChoice(array('model' => 'User', 'add_empty' => true)),
      'game_id'   => new sfWidgetFormPropelChoice(array('model' => 'Game', 'add_empty' => true)),
      'is_active' => new sfWidgetFormInputCheckbox(),
    ));

    $this->setValidators(array(
      'id'        => new sfValidatorPropelChoice(array('model' => 'GameMember', 'column' => 'id', 'required' => false)),
      'user_id'   => new sfValidatorPropelChoice(array('model' => 'User', 'column' => 'id', 'required' => false)),
      'game_id'   => new sfValidatorPropelChoice(array('model' => 'Game', 'column' => 'id', 'required' => false)),
      'is_active' => new sfValidatorBoolean(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('game_member[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'GameMember';
  }


}

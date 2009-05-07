<?php

/**
 * User form base class.
 *
 * @package    assassins
 * @subpackage form
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: sfPropelFormGeneratedTemplate.php 15484 2009-02-13 13:13:51Z fabien $
 */
class BaseUserForm extends BaseFormPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'              => new sfWidgetFormInputHidden(),
      'password'        => new sfWidgetFormInput(),
      'kills'           => new sfWidgetFormInput(),
      'deaths'          => new sfWidgetFormInput(),
      'games_played'    => new sfWidgetFormInput(),
      'wins'            => new sfWidgetFormInput(),
      'losses'          => new sfWidgetFormInput(),
      'current_game_id' => new sfWidgetFormPropelChoice(array('model' => 'Game', 'add_empty' => true)),
      'latitude'        => new sfWidgetFormInput(),
      'longitude'       => new sfWidgetFormInput(),
    ));

    $this->setValidators(array(
      'id'              => new sfValidatorPropelChoice(array('model' => 'User', 'column' => 'id', 'required' => false)),
      'password'        => new sfValidatorString(array('max_length' => 36, 'required' => false)),
      'kills'           => new sfValidatorInteger(array('required' => false)),
      'deaths'          => new sfValidatorInteger(array('required' => false)),
      'games_played'    => new sfValidatorInteger(array('required' => false)),
      'wins'            => new sfValidatorInteger(array('required' => false)),
      'losses'          => new sfValidatorInteger(array('required' => false)),
      'current_game_id' => new sfValidatorPropelChoice(array('model' => 'Game', 'column' => 'id', 'required' => false)),
      'latitude'        => new sfValidatorString(array('max_length' => 45, 'required' => false)),
      'longitude'       => new sfValidatorString(array('max_length' => 45, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('user[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'User';
  }


}

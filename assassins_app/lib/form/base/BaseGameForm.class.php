<?php

/**
 * Game form base class.
 *
 * @package    assassins
 * @subpackage form
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: sfPropelFormGeneratedTemplate.php 15484 2009-02-13 13:13:51Z fabien $
 */
class BaseGameForm extends BaseFormPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'             => new sfWidgetFormInputHidden(),
      'start_time'     => new sfWidgetFormDateTime(),
      'end_time'       => new sfWidgetFormDateTime(),
      'active_players' => new sfWidgetFormInput(),
      'latitude'       => new sfWidgetFormInput(),
      'longitude'      => new sfWidgetFormInput(),
      'is_active'      => new sfWidgetFormInputCheckbox(),
      'is_public'      => new sfWidgetFormInputCheckbox(),
    ));

    $this->setValidators(array(
      'id'             => new sfValidatorPropelChoice(array('model' => 'Game', 'column' => 'id', 'required' => false)),
      'start_time'     => new sfValidatorDateTime(array('required' => false)),
      'end_time'       => new sfValidatorDateTime(array('required' => false)),
      'active_players' => new sfValidatorInteger(array('required' => false)),
      'latitude'       => new sfValidatorString(array('max_length' => 45, 'required' => false)),
      'longitude'      => new sfValidatorString(array('max_length' => 45, 'required' => false)),
      'is_active'      => new sfValidatorBoolean(array('required' => false)),
      'is_public'      => new sfValidatorBoolean(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('game[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'Game';
  }


}

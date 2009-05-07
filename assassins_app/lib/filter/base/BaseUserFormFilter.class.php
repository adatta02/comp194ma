<?php

require_once(sfConfig::get('sf_lib_dir').'/filter/base/BaseFormFilterPropel.class.php');

/**
 * User filter form base class.
 *
 * @package    assassins
 * @subpackage filter
 * @author     Setfive Consulting, LLC <contact@setfive.com>
 * @version    SVN: $Id: sfPropelFormFilterGeneratedTemplate.php 15484 2009-02-13 13:13:51Z fabien $
 */
class BaseUserFormFilter extends BaseFormFilterPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'password'        => new sfWidgetFormFilterInput(),
      'kills'           => new sfWidgetFormFilterInput(),
      'deaths'          => new sfWidgetFormFilterInput(),
      'games_played'    => new sfWidgetFormFilterInput(),
      'wins'            => new sfWidgetFormFilterInput(),
      'losses'          => new sfWidgetFormFilterInput(),
      'current_game_id' => new sfWidgetFormPropelChoice(array('model' => 'Game', 'add_empty' => true)),
      'latitude'        => new sfWidgetFormFilterInput(),
      'longitude'       => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'password'        => new sfValidatorPass(array('required' => false)),
      'kills'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'deaths'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'games_played'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'wins'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'losses'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'current_game_id' => new sfValidatorPropelChoice(array('required' => false, 'model' => 'Game', 'column' => 'id')),
      'latitude'        => new sfValidatorPass(array('required' => false)),
      'longitude'       => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('user_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'User';
  }

  public function getFields()
  {
    return array(
      'id'              => 'Text',
      'password'        => 'Text',
      'kills'           => 'Number',
      'deaths'          => 'Number',
      'games_played'    => 'Number',
      'wins'            => 'Number',
      'losses'          => 'Number',
      'current_game_id' => 'ForeignKey',
      'latitude'        => 'Text',
      'longitude'       => 'Text',
    );
  }
}

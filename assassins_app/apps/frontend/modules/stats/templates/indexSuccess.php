<div id="logo" align="center">
<?php echo image_tag('logo.jpg');?>
<br />
<h2>Assassins Stats!</h2>
<p>Real time!</p>

<table border=1>
<tr><th>User</th><th>Wins</th><th>Losses</th><th>Kills</th><th>Deaths</th><th>Currently Playing</th></tr>
<?php
if(is_array($users))
{
  foreach($users as $user)
    echo "<tr><td>".$user->getId()."</td><td>".$user->getWins()."</td><td>".$user->getLosses()."</td><td>".$user->getKills()."</td><td>".$user->getDeaths()."</td><td>".$user->getCurrentlyPlayingReadable()."</td></tr>";

}
?>
</table>
</div>
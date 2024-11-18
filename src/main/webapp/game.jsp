<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quest Game</title>
</head>
<body>
<h1>Quest Game</h1>

<p>Health: ${game.player.health}</p>
<p>Level: ${game.player.level}</p>

<c:if test="${game.isGameOver()}">
    <h2>Game Over! You lost.</h2>
</c:if>

<form action="game" method="post">
    <button type="submit" name="action" value="attack" ${game.isGameOver() ? 'disabled' : ''}>Attack</button>
    <button type="submit" name="action" value="levelUp" ${game.isGameOver() ? 'disabled' : ''}>Level Up</button>
    <button type="submit" name="action" value="restart">Restart Game</button>
</form>
</body>
</html>

# Object Oriented Design (1): Board Game

## OOP Structure

The high level design of the whole project is based on the following components:

* **Main.java** - A main enterance for the game.
* **AbstractBoard.java** - An abstract class for extendibility purpose.
* **Player.java** - A player class includes the required properties and methods.
* **GameRule.java** - An interface includes general rules of board game for extendibility purpose.
* **GameMode.java** - A game mode class provides the basic mode menu for users.

```
├─constants # general state and static constants
├─coordinate # class for each individual cell and coordinate
├─game_list # list of different games
│  ├─order_and_chaos # includes game board and game rule
│  └─tic_tac_toe
└─generic_setting # abstract class and interface design for general case
```

## Installing

To compile the program:

```
javac Main.java
```

To run the program:

```
java Main
```

## Getting Started

```
1. Simple NxN Tic Tac Toe
2. Order and Chaos
3. Stay tuned ......
4. EXIT

Enter 1~9 to choose the game from the list: (e.g. 1)
```

#### - Sample of NxM Tic Tac Toe

```
Enter the size of the board (e.g. 3x3): 
3x3
```

```
Enter your desired nick name (e.g. Mike):
Beck

Enter your desired nick name (e.g. Mike): 
Ted
```

```
X will play first.

Player Beck Enter your move (e.g. 1~9): 5

Player Ted Enter your move (e.g. 1~9): 2
```

Each cell has a corresponding number, simplly enter **1 ~ 9** can allow the user to move the the correct position.
To play the game again, type **(Y/N)** into the terminal or command.

#### - Sample of Order and Chaos

```
Enter your desired nick name (e.g. Mike):
Beck

Enter your desired nick name (e.g. Mike): 
Ted
```

```
Order will play first.

Player Beck Enter the Piece you want to place (e.g. X or O):
X

Player Beck Enter your move (e.g. 1~36):
1

Player Ted Enter the Piece you want to place (e.g. X or O):
O

Player Ted Enter your move (e.g. 1~36):
2
```
Each cell has a corresponding number, simplly enter a number (depends on how big the board is) can allow the user to move the the correct position.
```
                                     _=_
                                   q(-_-)p
                                   '_) (_`
                                   /__/  \
                                 _(<_   / )_
                                (__\_\_|_/__)
                                (__\_\_|_/__)
  ______ _        _  _            _       __        ______ __    _  __  __       __ 
 (   /  /_|(__/  / )/_| /  /|/|  /_| /| )/  )  /__/(_ (_  /__)  / )/  )/  )//| )/ _ 
__) (  (  | /   (__(  |(__/   | (  |/ |//(_/  /  ) /__/__/     (__(__//(_/(/ |/(__) 
====================================================================================
.------------------------.-------------------.------------------.------------------.
|        ########        |        WIN        |       LOSE       |       DRAW       |
:------------------------+-------------------+------------------+------------------:
|        PLAYER X        |         9         |         0        |         0        |
:------------------------+-------------------+------------------+------------------:
|        PLAYER O        |         1         |         6        |         0        |
'------------------------'-------------------'------------------'------------------'
```

### Prerequisites

```
Java SE 8
```

## Authors

**Yizhou Mao** - *Initial work* - [BECK'S BLOG](https://www.maoyizhou.com)
